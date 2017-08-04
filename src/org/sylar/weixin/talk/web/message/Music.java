package org.sylar.weixin.talk.web.message;

public class Music {

  private String Title;
  private String Description;
  private String MusicUrl;
  private String HQMusicUrl;
  private String ThumbMediaId;
  
public Music() {
	super();
}
public Music(String title, String description, String musicUrl,
		String hQMusicUrl, String thumbMediaId) {
	super();
	Title = title;
	Description = description;
	MusicUrl = musicUrl;
	HQMusicUrl = hQMusicUrl;
	ThumbMediaId = thumbMediaId;
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
public String getMusicUrl() {
	return MusicUrl;
}
public void setMusicUrl(String musicUrl) {
	MusicUrl = musicUrl;
}
public String getHQMusicUrl() {
	return HQMusicUrl;
}
public void setHQMusicUrl(String hQMusicUrl) {
	HQMusicUrl = hQMusicUrl;
}
public String getThumbMediaId() {
	return ThumbMediaId;
}
public void setThumbMediaId(String thumbMediaId) {
	ThumbMediaId = thumbMediaId;
}

  
}
