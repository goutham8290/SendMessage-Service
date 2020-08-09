package com.sendmessage.Utility;


import com.sendmessage.repository.dto.Message;
import org.bson.Document;
import org.eclipse.jetty.util.StringUtil;

public class MessageMapper {


    public static Message map(final Document messageDocument){
        final Message message = new Message();
        message.setTo(messageDocument.getString("to"));
        message.setFrom(messageDocument.getString("from"));
        message.setId(messageDocument.getObjectId("_id") != null ? messageDocument.getObjectId("_id").toString() : "");
        message.setMessage(messageDocument.getString("message"));
        return message;
    }
}
