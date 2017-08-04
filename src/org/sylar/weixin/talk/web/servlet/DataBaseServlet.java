package org.sylar.weixin.talk.web.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sylar.weixin.talk.common.util.DecriptUtil;




public class DataBaseServlet extends HttpServlet{
	private static String url = "jdbc:mysql://sqld.duapp.com:4050/VtCoXlVXNHSZFKgAXdXb";
	private static String userName = "yknFxdgGDzuqH7QnwuCGzKa8";
	private static String userPwd = "VbUGYVRjRCmfMWp07GxZGdx1HI9M9xSY";
	private static Connection conn = null;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
     public static Connection getConnection(){
		try {
			conn = (Connection) DriverManager.getConnection(url, userName, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    	 return conn;
     }
	
     
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doGet(req, resp);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String con = getConnection().toString();
		request.setAttribute("con",con);
		request.getRequestDispatcher("/index.jsp").forward(request,response); 
		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		String signature = request.getParameter("signature");
//		String timestamp = request.getParameter("timestamp");
//		String nonce = request.getParameter("nonce");
//		String echostr = request.getParameter("echostr");
//		String reSignature = null;
//		try {
//		String[] str = { "sylar", timestamp, nonce };
//		Arrays.sort(str);
//		String bigStr = str[0] + str[1] + str[2];
//		reSignature = DecriptUtil.SHA1(bigStr).toLowerCase();
//		} catch (Exception e) {
//		e.printStackTrace();
//		}
//		if (null != reSignature && reSignature.equals(signature)) {
//		//请求来自微信
//		out.print(echostr);
//		} else {
//		out.print("error request! the request is not from weixin server");
//		}
//		out.flush();
//		out.close();
		
		
	}
}
