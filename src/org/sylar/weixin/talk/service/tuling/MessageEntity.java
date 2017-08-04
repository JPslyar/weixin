package org.sylar.weixin.talk.service.tuling;

import org.sylar.weixin.talk.common.util.StringHelper;


public class MessageEntity {
    private String  text;
    private String  code;
    private String  url;
    private MessageDetail detail;
    
    
	public MessageEntity() {
		super();
		detail = new  MessageDetail();
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public MessageDetail getDetail() {
		return detail;
	}

	public void setDetail(MessageDetail detail) {
		this.detail = detail;
	}

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		if(StringHelper.isNotNull(text)){
			str.append(text);
		}
		if(StringHelper.isNotNull(url)){
			str.append(url);
		}
		if(detail!=null){
			str.append(detail.toString());
		}
		return str.toString();
		
	}
    
}
