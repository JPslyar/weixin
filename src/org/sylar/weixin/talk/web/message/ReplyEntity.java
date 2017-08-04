package org.sylar.weixin.talk.web.message;


public class ReplyEntity {
	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	private String MsgType;
	private Image Image;
	private Voice Voice;
	private String Title;
	private String Description;
	private Video Video;
	private Music Music;
	private String Content;
	private Articles Articles;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public Image getImage() {
		return Image;
	}
	public void setImage(Image image) {
		Image = image;
	}
	public Voice getVoice() {
		return Voice;
	}
	public void setVoice(Voice voice) {
		Voice = voice;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Video getVideo() {
		return Video;
	}
	public void setVideo(Video video) {
		Video = video;
	}
	public Music getMusic() {
		return Music;
	}
	public void setMusic(Music music) {
		Music = music;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Articles getArticles() {
		return Articles;
	}
	public void setArticles(Articles articles) {
		Articles = articles;
	}
	
	
}
