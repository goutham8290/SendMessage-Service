package com.sendmessage.Utility;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.sendmessage.Utility.MessageMapper;
import org.bson.Document;

public class MongoDBConnectorUtil {
    public static void main(String[] args) {





        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://user:user@sendmessage-node1-vuqpa.azure.mongodb.net/sample_airbnb?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);

        MongoDatabase database = mongoClient.getDatabase("sample_airbnb");

        MongoCursor<Document> messages = database.getCollection("sample_airbnb").find().iterator();



        try {
            while (messages.hasNext()) {
                final Document donut = messages.next();
                System.out.println(donut);
            }
        } finally {
            messages.close();
        }


    }


}
