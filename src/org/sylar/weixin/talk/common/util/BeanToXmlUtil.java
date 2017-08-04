package org.sylar.weixin.talk.common.util;

import java.util.List;

import org.sylar.weixin.talk.web.message.ArticleItem;
import org.sylar.weixin.talk.web.message.ReplyEntity;

public class BeanToXmlUtil {

	public static String messageToXml(ReplyEntity reply) {
		String result = "";
		if ("text".equals(reply.getMsgType())) {
			result = textMessageToXml(reply);
		} else if ("image".equals(reply.getMsgType())) {
			result = imageMessageToXml(reply);
		} else if ("voice".equals(reply.getMsgType())) {
			result = voiceMessageToXml(reply);
		} else if ("video".equals(reply.getMsgType())) {
			result = videoMessageToXml(reply);
		} else if ("music".equals(reply.getMsgType())) {
			result = musicMessageToXml(reply);
		} else if ("news".equals(reply.getMsgType())) {
			result = newsMessageToXml(reply);
		}
		return result;
	}

	public static String textMessageToXml(ReplyEntity reply) {
		StringBuffer xml = new StringBuffer();
		xml.append("<xml>");
		xml.append("<ToUserName><![CDATA[" + reply.getToUserName()
				+ "]]></ToUserName>");
		xml.append("<FromUserName><![CDATA[" + reply.getFromUserName()
				+ "]]></FromUserName>");
		xml.append("<CreateTime>" + reply.getCreateTime() + "</CreateTime>");
		xml.append("<MsgType><![CDATA[text]]></MsgType>");
		xml.append("<Content><![CDATA[" + reply.getContent() + "]]></Content>");
		xml.append("</xml>");
		return xml.toString();
	}

	public static String imageMessageToXml(ReplyEntity reply) {
		StringBuffer xml = new StringBuffer();
		xml.append("<xml>");
		xml.append("<ToUserName><![CDATA[" + reply.getToUserName()
				+ "]]></ToUserName>");
		xml.append("<FromUserName><![CDATA[" + reply.getFromUserName()
				+ "]]></FromUserName>");
		xml.append("<CreateTime>" + reply.getCreateTime() + "</CreateTime>");
		xml.append("<MsgType><![CDATA[image]]></MsgType>");
		xml.append("<Image>");
		xml.append("<MediaId><![CDATA[" + reply.getImage().getMediaId()
				+ "]]></MediaId>");
		xml.append("</Image>");
		xml.append("</xml>");
		return xml.toString();
	}

	public static String voiceMessageToXml(ReplyEntity reply) {
		StringBuffer xml = new StringBuffer();
		xml.append("<xml>");
		xml.append("<ToUserName><![CDATA[" + reply.getToUserName()
				+ "]]></ToUserName>");
		xml.append("<FromUserName><![CDATA[" + reply.getFromUserName()
				+ "]]></FromUserName>");
		xml.append("<CreateTime>" + reply.getCreateTime() + "</CreateTime>");
		xml.append("<MsgType><![CDATA[voice]]></MsgType>");
		xml.append("<Voice>");
		xml.append("<MediaId><![CDATA[" + reply.getVoice().getMediaId()
				+ "]]></MediaId>");
		xml.append("</Voice>");
		xml.append("</xml>");
		return xml.toString();
	}

	public static String videoMessageToXml(ReplyEntity reply) {
		StringBuffer xml = new StringBuffer();
		xml.append("<xml>");
		xml.append("<ToUserName><![CDATA[" + reply.getToUserName()
				+ "]]></ToUserName>");
		xml.append("<FromUserName><![CDATA[" + reply.getFromUserName()
				+ "]]></FromUserName>");
		xml.append("<CreateTime>" + reply.getCreateTime() + "</CreateTime>");
		xml.append("<MsgType><![CDATA[video]]></MsgType>");
		xml.append("<Video>");
		xml.append("<MediaId><![CDATA[" + reply.getVideo().getMediaId()
				+ "]]></MediaId>");
		xml.append("<Title><![CDATA[" + reply.getVideo().getTitle()
				+ "]]></Title>");
		xml.append("<Description><![CDATA[" + reply.getVideo().getDescription()
				+ "]]></Description>");
		xml.append("</Video>");
		xml.append("</xml>");
		return xml.toString();
	}

	public static String musicMessageToXml(ReplyEntity reply) {
		StringBuffer xml = new StringBuffer();
		xml.append("<xml>");
		xml.append("<ToUserName><![CDATA[" + reply.getToUserName()
				+ "]]></ToUserName>");
		xml.append("<FromUserName><![CDATA[" + reply.getFromUserName()
				+ "]]></FromUserName>");
		xml.append("<CreateTime>" + reply.getCreateTime() + "</CreateTime>");
		xml.append("<MsgType><![CDATA[music]]></MsgType>");
		xml.append("<Music>");
		xml.append("<MediaId><![CDATA[" + reply.getMusic().getMusicUrl()
				+ "]]></MediaId>");
		xml.append("<Title><![CDATA[" + reply.getMusic().getTitle()
				+ "]]></Title>");
		xml.append("<Description><![CDATA[" + reply.getMusic().getDescription()
				+ "]]></Description>");
		xml.append("<HQMusicUrl><![CDATA[" + reply.getMusic().getHQMusicUrl()
				+ "]]></HQMusicUrl>");
		xml.append("<ThumbMediaId><![CDATA["
				+ reply.getMusic().getThumbMediaId() + "]]></ThumbMediaId>");
		xml.append("</Music>");
		xml.append("</xml>");
		return xml.toString();
	}

	public static String newsMessageToXml(ReplyEntity reply){
	  StringBuffer xml = new StringBuffer();
	  int count = reply.getArticles().getItems().size();
	  List<ArticleItem> articles = reply.getArticles().getItems();
	  xml.append("<xml>");
	  xml.append("<ToUserName><![CDATA["+reply.getToUserName()+"]]></ToUserName>");
	  xml.append("<FromUserName><![CDATA["+reply.getFromUserName()+"]]></FromUserName>");
	  xml.append("<CreateTime>"+reply.getCreateTime()+"</CreateTime>");
	  xml.append("<MsgType><![CDATA[news]]></MsgType>");
	  xml.append("<ArticleCount>"+count+"</ArticleCount>");
	  xml.append("<Articles>");
	  for (ArticleItem articleItem : articles) {
		  xml.append("<item>");
	      xml.append("<Title><![CDATA["+articleItem.getTitle()+"]]></Title> ");
		  xml.append("<Description><![CDATA["+articleItem.getDescription()+"]]></Description>");
		  xml.append("<PicUrl><![CDATA["+articleItem.getPicUrl()+"]]></PicUrl>");
		  xml.append("<Url><![CDATA["+articleItem.getUrl()+"]]></Url>");
		  xml.append("</item>");
	  }
      xml.append("</Articles>");
	  xml.append("</xml>");
	  return xml.toString();
  }
}
