package org.sylar.weixin.talk.common.util;

import java.util.Arrays;

public class ConnectWeiXinUtil {
  public static String buildConnect(String token ,String signature,String timestamp,String nonce,String echostr){
	  System.out.println("***************************************");
	  System.out.println("token=   "+token);
	  System.out.println("signature=   "+signature);
	  System.out.println("timestamp=   "+timestamp);
	  System.out.println("nonce=   "+nonce);
	  System.out.println("echostr=   "+echostr);
	  System.out.println("***************************************");
	  
	  String reSignature = null;
	  String reString = "";
		try {
		String[] str = { token, timestamp, nonce };
		Arrays.sort(str);
		String bigStr = str[0] + str[1] + str[2];
		reSignature = DecriptUtil.SHA1(bigStr).toLowerCase();
		} catch (Exception e) {
		e.printStackTrace();
		}
		if (null != reSignature && reSignature.equals(signature)) {
			reString = echostr;
		} else {
			reString ="error request! the request is not from weixin server";
		}
		return reString;
  }
}
