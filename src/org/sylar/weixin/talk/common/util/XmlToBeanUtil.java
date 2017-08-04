package org.sylar.weixin.talk.common.util;

import java.util.HashMap;
import java.util.Map;

import org.sylar.weixin.talk.web.message.ReceiveEntity;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
/**
 * @author JIANGPENG
 * @date 2014-8-26
 * 
 * */
public class XmlToBeanUtil {
	
  public static Object getBeanFromXml(String xml,Map<String,Class> aliasMap){
	    Object obj = null;
	    if(StringHelper.isNotNull(xml) && aliasMap != null){
	    		XStream xstream = new XStream(new DomDriver());
	    		for (String key : aliasMap.keySet()) {
	    			xstream.alias(key, aliasMap.get(key));
				}
	    		obj = xstream.fromXML(xml);
	    }
	    return obj;
   }
  
  public static Object getReceiceFromXml(String xml){
	  Map<String,Class> aliasParamMap = new HashMap<String, Class>();
	  aliasParamMap.put("xml", ReceiveEntity.class);
	  return getBeanFromXml(xml,aliasParamMap);
  }
  
  public static void main(String[] args) {
	StringBuffer xml = new StringBuffer();
	xml.append("<xml>");
	xml.append("<ToUserName><![CDATA[toUser]]></ToUserName>");
	xml.append("<FromUserName><![CDATA[fromUser]]></FromUserName> ");
	xml.append("<CreateTime>1348831860</CreateTime>");
	xml.append("<MsgType><![CDATA[text]]></MsgType>");
	xml.append("<Content><![CDATA[this is a test]]></Content>");
	xml.append("<MsgId>1234567890123456</MsgId>");
    xml.append("</xml>);");
    ReceiveEntity re = (ReceiveEntity)getReceiceFromXml(xml.toString());													
	System.out.println(re.getContent()+re.getCreateTime());														
															
}
  
  
}
