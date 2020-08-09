package com.sendmessage;

import com.mongodb.*;

import com.mongodb.client.MongoClients;
import com.sendmessage.configuration.Credentials;
import com.sendmessage.configuration.MongoDBConnectionConfig;
import com.sendmessage.configuration.Seed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class MongoDBFactoryConnection {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBFactoryConnection.class);


    /** The configuration for connect to MongoDB Server.*/
    private MongoDBConnectionConfig mongoDBConnectionConfig;


    public MongoDBFactoryConnection(final MongoDBConnectionConfig mongoDBConnectionConfig) {
        this.mongoDBConnectionConfig = mongoDBConnectionConfig;
    }


    public MongoClient createClient() {
        LOGGER.info("Creating mongoDB client....");



       // final MongoClientURI uri = new MongoClientURI("mongodb+srv://user:user@sendmessage-node1-vuqpa.azure.mongodb.net/messages?retryWrites=true&w=majority");

       // MongoClient mongoClient = new com.mongodb.MongoClient(uri);

      //  return mongoClient;

      /*  final Credentials configCredentials = mongoDBConnectionConfig.getCredentials();
        final MongoCredential credential = MongoCredential.createCredential(configCredentials.getUsername(),mongoDBConnectionConfig.getDatabase(),configCredentials.getPassword());
        final MongoClient client = MongoClients.create( MongoClientSettings.builder()
                .credential(credential)
                .applyToClusterSettings(builder -> builder.hosts(getServers())).build());*/





    }

    private List<ServerAddress> getServers() {
        final List<Seed> seeds = mongoDBConnectionConfig.getSeeds();
        return seeds.stream()
                .map(seed -> {
                    final ServerAddress serverAddress = new ServerAddress(seed.getHost(), seed.getPort());
                    return serverAddress;
                })
                .collect(Collectors.toList());
    }

}
