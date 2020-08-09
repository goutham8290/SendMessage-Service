package com.sendmessage.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.sendmessage.Utility.MessageMapper;
import com.sendmessage.repository.dto.Message;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MessageRepository {

    final MongoCollection<Document> messageCollection;

    public MessageRepository(MongoCollection<Document> message) {
        this.messageCollection = message;
    }




     public Message saveMessage(Message message){
         final Document saveMessage = new Document("to", message.getTo())
                 .append("from", message.getFrom()).append("message",message.getMessage());

         messageCollection.insertOne(saveMessage);
         return message;
        }


    public List<Message> getAll() {
        final MongoCursor<Document> messages = messageCollection.find().iterator();
        final List<Message> donutsFind = new ArrayList<>();
        try {
            while (messages.hasNext()) {
                final Document donut = messages.next();
                donutsFind.add(MessageMapper.map(donut));
            }
        } finally {
            messages.close();
        }
        return donutsFind;
    }

}
