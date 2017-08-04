package org.sylar.weixin.talk.service.tuling;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sylar.weixin.talk.common.util.StringHelper;
import org.sylar.weixin.talk.common.util.SysContants;


/**
 * 调用图灵机器人api接口，获取智能回复内容
 *
 */
public class TulingApiProcess {
	/**
	 * 调用图灵机器人api接口，获取智能回复内容，解析获取自己所需结果
	 * @param content
	 * @return
	 */
	public String getTulingResult(String content){
		/** 此处为图灵api接口，参数key需要自己去注册申请，先以11111111代替 */
		String apiUrl = SysContants.TULING_INTERFACE_URL;
		String param = "";
		try {
			param = apiUrl+URLEncoder.encode(content,"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //将参数转为url编码
		
		/** 发送httpget请求 */
		HttpGet request = new HttpGet(param);
		String result = "";
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(request);
			if(response.getStatusLine().getStatusCode()==200){
				result = EntityUtils.toString(response.getEntity());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/** 请求失败处理 */
		if(null==result){
			return "对不起，你说的话真是太高深了……";
		}
		MessageEntity entity = putMessageIntoEntity(result);
		
		result = entity.toString().replace("图灵", SysContants.SYS_ROBIT_NAME);
	 
		return result;
	}
	
	
	public MessageEntity putMessageIntoEntity(String result){
		  MessageEntity entity = new MessageEntity();
		  try {
			JSONObject json = new JSONObject(result);
			JSONObject listJson = null;
			String list = "";
			int code = json.getInt("code");
			switch (code) {
			case 100000://文本类数据 
				entity.setCode(json.getInt("code")+"");
				entity.setText(json.getString("text"));
				break;
			case 200000://网址类数据
				entity.setCode(json.getInt("code")+"");
				entity.setText(json.getString("text"));
				String url = json.getString("url");
				entity.setUrl(url);
				break;
			case 301000://小说 
				entity.setCode(json.getInt("code")+"");
				entity.setText(json.getString("text"));
				list = json.getJSONArray("list").toString();
				listJson = new JSONObject(list.substring(1, list.length()-1));
				entity.getDetail().setName((listJson.getString("name")));
				entity.getDetail().setAuthor((listJson.getString("author")));
				entity.getDetail().setDetailurl((listJson.getString("detailurl")));
				entity.getDetail().setIcon((listJson.getString("icon")));
				break;
			case 302000://新闻
				entity.setCode(json.getInt("code")+"");
				result = json.getString("text");
				list = json.getJSONArray("list").toString();
				listJson = new JSONObject(list.substring(1, list.length()-1));
				entity.getDetail().setArticle((listJson.getString("article")));
				entity.getDetail().setSource((listJson.getString("source")));
				entity.getDetail().setDetailurl((listJson.getString("detailurl")));
				entity.getDetail().setIcon((listJson.getString("icon")));
				break;
			case 303000:
				entity.setCode(json.getInt("code")+"");
				result = json.getString("text");
				break;
			case 304000://应用、软件、下载
				entity.setCode(json.getInt("code")+"");
				result = json.getString("text");
				list = json.getJSONArray("list").toString();
				listJson = new JSONObject(list.substring(1, list.length()-1));
				entity.getDetail().setName((listJson.getString("name")));
				entity.getDetail().setCount((listJson.getString("count")));
				entity.getDetail().setDetailurl((listJson.getString("detailurl")));
				entity.getDetail().setIcon((listJson.getString("icon")));
				break;
			case 305000://列车
				entity.setCode(json.getInt("code")+"");
				result = json.getString("text");
				list = json.getJSONArray("list").toString();
				listJson = new JSONObject(list.substring(1, list.length()-1));
				entity.getDetail().setTerminal((listJson.getString("terminal")));
				entity.getDetail().setStart((listJson.getString("start")));
				entity.getDetail().setTerminal((listJson.getString("terminal")));
				entity.getDetail().setStarttime((listJson.getString("starttime")));
				entity.getDetail().setEndtime((listJson.getString("endtime")));
				entity.getDetail().setDetailurl((listJson.getString("detailurl")));
				entity.getDetail().setIcon((listJson.getString("icon")));
				break;
			case 306000://航班
				entity.setCode(json.getInt("code")+"");
				result = json.getString("text");
				list = json.getJSONArray("list").toString();
				listJson = new JSONObject(list.substring(1, list.length()-1));
				entity.getDetail().setFlight((listJson.getString("flight")));
				entity.getDetail().setRoute((listJson.getString("route")));
				entity.getDetail().setStarttime((listJson.getString("starttime")));
				entity.getDetail().setEndtime((listJson.getString("endtime")));
				entity.getDetail().setState((listJson.getString("state")));
				entity.getDetail().setDetailurl((listJson.getString("detailurl")));
				entity.getDetail().setIcon((listJson.getString("icon")));
				break;
			case 307000://团购
				entity.setCode(json.getInt("code")+"");
				result = json.getString("text");
				list = json.getJSONArray("list").toString();
				listJson = new JSONObject(list.substring(1, list.length()-1));
				entity.getDetail().setName((listJson.getString("name")));
				entity.getDetail().setPrice((listJson.getString("price")));
				entity.getDetail().setInfo((listJson.getString("info")));
				entity.getDetail().setCount((listJson.getString("count")));
				entity.getDetail().setDetailurl((listJson.getString("detailurl")));
				entity.getDetail().setIcon((listJson.getString("icon")));
				break;
			case 308000://优惠
				entity.setCode(json.getInt("code")+"");
				result = json.getString("text");
				list = json.getJSONArray("list").toString();
				listJson = new JSONObject(list.substring(1, list.length()-1));
				entity.getDetail().setName((listJson.getString("name")));
				entity.getDetail().setInfo((listJson.getString("info")));
				entity.getDetail().setDetailurl((listJson.getString("detailurl")));
				entity.getDetail().setIcon((listJson.getString("icon")));
				break;
			case 309000://酒店
				entity.setCode(json.getInt("code")+"");
				result = json.getString("text");
				list = json.getJSONArray("list").toString();
				listJson = new JSONObject(list.substring(1, list.length()-1));
				entity.getDetail().setName((listJson.getString("name")));
				entity.getDetail().setPrice((listJson.getString("price")));
				entity.getDetail().setSatisfaction((listJson.getString("satisfaction")));
				entity.getDetail().setCount((listJson.getString("count")));
				entity.getDetail().setDetailurl((listJson.getString("detailurl")));
				entity.getDetail().setIcon((listJson.getString("icon")));
				break;
			case 310000://彩票
				entity.setCode(json.getInt("code")+"");
				result = json.getString("text");
				list = json.getJSONArray("list").toString();
				listJson = new JSONObject(list.substring(1, list.length()-1));
				entity.getDetail().setDetailurl((listJson.getString("detailurl")));
				entity.getDetail().setIcon((listJson.getString("icon")));
				entity.getDetail().setNumber((listJson.getString("number")));
				entity.getDetail().setInfo((listJson.getString("info")));
				break;
			case 311000://价格
				entity.setCode(json.getInt("code")+"");
				result = json.getString("text");
				list = json.getJSONArray("list").toString();
				listJson = new JSONObject(list.substring(1, list.length()-1));
				entity.getDetail().setName((listJson.getString("name")));
				entity.getDetail().setPrice((listJson.getString("price")));
				entity.getDetail().setDetailurl((listJson.getString("detailurl")));
				entity.getDetail().setIcon((listJson.getString("icon")));
				break;
			case 312000://餐厅
				entity.setCode(json.getInt("code")+"");
				result = json.getString("text");
				list = json.getJSONArray("list").toString();
				listJson = new JSONObject(list.substring(1, list.length()-1));
				entity.getDetail().setName((listJson.getString("name")));
				entity.getDetail().setPrice((listJson.getString("price")));
				entity.getDetail().setDetailurl((listJson.getString("detailurl")));
				entity.getDetail().setIcon((listJson.getString("icon")));
				break;
			default:
				break;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}
}



