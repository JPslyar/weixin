package org.sylar.weixin.talk.web.message;

import java.util.List;

public class Articles {
  private List<ArticleItem> items ;

public Articles() {
	super();
}

public Articles(List<ArticleItem> items) {
	super();
	this.items = items;
}

public List<ArticleItem> getItems() {
	return items;
}

public void setItems(List<ArticleItem> items) {
	this.items = items;
}
  
  
  
  
}
