package com.sendmessage;

import com.sendmessage.repository.MessageRepository;
import com.sendmessage.repository.dto.Message;
import com.sendmessage.resource.MessageResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMessageApplication extends Application<SendMessageConfiguration> {


    private static Logger LOGGER = LoggerFactory.getLogger(SendMessageApplication.class);

    public static void main(String[] args) throws Exception {
        new SendMessageApplication().run(args);
    }



    public void run(SendMessageConfiguration sendMessageConfiguration, Environment environment) throws Exception {
        LOGGER.info("Application Start");

        final MongoDBFactoryConnection mongoDBManagerConn = new MongoDBFactoryConnection(sendMessageConfiguration.getMongoDBConnectionConfig());

        MessageRepository repo = new MessageRepository(mongoDBManagerConn.createClient().getDatabase(sendMessageConfiguration.getMongoDBConnectionConfig().getDatabase()).getCollection("message"));

        MessageResource resource = new MessageResource(repo);
        environment.jersey().register(resource);
        LOGGER.info("Application Started");
    }
}
