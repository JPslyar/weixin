package org.sylar.weixin.talk.common.util;

import java.util.Date;

import org.sylar.weixin.talk.service.tuling.TulingApiProcess;
import org.sylar.weixin.talk.web.message.Image;
import org.sylar.weixin.talk.web.message.ReceiveEntity;
import org.sylar.weixin.talk.web.message.ReplyEntity;

public class ReplyProcessController {
   public static ReplyEntity produceReplyByReceive(ReceiveEntity receive){
	   ReplyEntity reply = new ReplyEntity();
	   if("event".equals(receive.getMsgType())&&"subscribe".equals(receive.getEvent())){
			reply.setContent(SysContants.SUBSCRIBE_MSG);
			reply.setCreateTime(Long.toString((new Date().getTime())));
			reply.setFromUserName(SysContants.SYS_ID);
			reply.setToUserName(receive.getFromUserName());
			reply.setMsgType("text");
		}else if("event".equals(receive.getMsgType())&&"unsubscribe".equals(receive.getEvent())){
			reply.setContent("您已取消对“百娱杂谈”关注");
			reply.setCreateTime(Long.toString((new Date().getTime())));
			reply.setFromUserName(SysContants.SYS_ID);
			reply.setToUserName(receive.getFromUserName());
			reply.setMsgType("text");
		}else if("text".equals(receive.getMsgType())){
		   TulingApiProcess process = new TulingApiProcess();
		   String replyContent = process.getTulingResult(receive.getContent());
		   reply.setContent(replyContent);
		   reply.setCreateTime(Long.toString((new Date().getTime())));
		   reply.setFromUserName(SysContants.SYS_ID);
		   reply.setToUserName(receive.getFromUserName());
		   reply.setMsgType("text");
		}else if("image".equals(receive.getMsgType())){
		   reply.setCreateTime(Long.toString((new Date().getTime())));
		   reply.setImage(new Image(receive.getMediaId()));
		   reply.setFromUserName(SysContants.SYS_ID);
		   reply.setToUserName(receive.getFromUserName());
		   reply.setMsgType("image");
		}
	   return reply;
   }
}
