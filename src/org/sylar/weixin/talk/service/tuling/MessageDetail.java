package org.sylar.weixin.talk.service.tuling;

import org.sylar.weixin.talk.common.util.StringHelper;

public class MessageDetail {
	
	/**
	 * code 状态码 
	 * text 提示语 
	 * name 酒店名称 
	 * price 价格 
	 * satisfaction 满意度 
	 * count 数量 
	 * detailurl 
	 * 详情地址 
	 * icon 图标地址 
	 ***/
	private String name;
	private String price;
	private String icon;
	private String detailurl;
	private String number;
	private String info;
	private String satisfaction;
	private String count;
	private String flight;
	private String route;
	private String starttime;
	private String endtime;
	private String state;
	private String trainnum;
	private String start;
	private String terminal;
	private String article;
	private String source;
	private String author;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDetailurl() {
		return detailurl;
	}
	public void setDetailurl(String detailurl) {
		this.detailurl = detailurl;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTrainnum() {
		return trainnum;
	}
	public void setTrainnum(String trainnum) {
		this.trainnum = trainnum;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		if(StringHelper.isNotNull(name)){
			res.append("名称:"+name+"\n");
		}
		if(StringHelper.isNotNull(author)){
			res.append("作者:"+author+"\n");
		}
		if(StringHelper.isNotNull(article)){
			res.append("标题:"+article+"\n");
		}
		if(StringHelper.isNotNull(price)){
			res.append("价格:"+price+"\n");
		}
		if(StringHelper.isNotNull(source)){
			res.append("来源:"+source+"\n");
		}
		if(StringHelper.isNotNull(info)){
			res.append("详情:"+article+"\n");
		}
		if(StringHelper.isNotNull(trainnum)){
			res.append("车次:"+trainnum+"\n");
		}
		if(StringHelper.isNotNull(satisfaction)){
			res.append("满意度:"+satisfaction+"\n");
		}
		if(StringHelper.isNotNull(start)){
			res.append("起始站:"+start+"\n");
		}
		if(StringHelper.isNotNull(terminal)){
			res.append("终点站:"+terminal+"\n");
		}
		if(StringHelper.isNotNull(flight)){
			res.append("航班:"+flight+"\n");
		}
		if(StringHelper.isNotNull(route)){
			res.append("航班路线:"+route+"\n");
		}
		if(StringHelper.isNotNull(starttime)){
			res.append("起始时间:"+starttime+"\n");
		}
		if(StringHelper.isNotNull(endtime)){
			res.append("到达时间:"+endtime+"\n");
		}
		if(StringHelper.isNotNull(number)){
			res.append("彩票号码:"+number+"\n");
		}
		if(StringHelper.isNotNull(state)){
			res.append("航班状态:"+state+"\n");
		}
		if(StringHelper.isNotNull(count)){
			res.append("数量:"+count+"\n");
		}
		if(StringHelper.isNotNull(detailurl)){
			res.append("详情地址:"+detailurl+"\n");
		}
		return res.toString();
	}
	
}
