package org.sylar.weixin.talk.web.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.sylar.weixin.talk.common.util.BeanToXmlUtil;
import org.sylar.weixin.talk.common.util.ConnectWeiXinUtil;
import org.sylar.weixin.talk.common.util.ReplyProcessController;
import org.sylar.weixin.talk.common.util.XmlToBeanUtil;
import org.sylar.weixin.talk.web.message.ReceiveEntity;
import org.sylar.weixin.talk.web.message.ReplyEntity;

/**
 * 
 * @author JIANGPENG
 * 
 */
public class MessageProcessServlet extends HttpServlet {
        Logger logger = Logger.getLogger(MessageProcessServlet.class);
	   @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    		throws ServletException, IOException {

			String result = "";
			StringBuffer sb = new StringBuffer();
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");  
			PrintWriter out = response.getWriter();
			InputStream is = request.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			br.close();
			isr.close();
			is.close();
			//获取请求xml
			String xml = sb.toString();
			//将请求xml转换为Java类
			ReceiveEntity receive = (ReceiveEntity)XmlToBeanUtil.getReceiceFromXml(xml);
			//对请求进行逻辑处理生成响应的实体类
			ReplyEntity reply = ReplyProcessController.produceReplyByReceive(receive);
		    //将响应实体转换为xml
			result = BeanToXmlUtil.messageToXml(reply);
			out.print(result);	
			logger.info("回复成功");
			out.flush();
			out.close();
	    }
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String result = "";
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			if (echostr != null && echostr.length() > 1) {
				result = ConnectWeiXinUtil.buildConnect("sylar", signature, timestamp, nonce, echostr);
				logger.info("校验成功");
			} else {
				result = "error";
				logger.info("校验失败");
			}
			out.print(result);	
			out.flush();
			out.close();
		}
}
