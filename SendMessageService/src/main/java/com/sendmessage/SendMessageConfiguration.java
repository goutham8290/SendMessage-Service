package com.sendmessage;

import com.sendmessage.configuration.MongoDBConnectionConfig;
import io.dropwizard.Configuration;


public class SendMessageConfiguration extends Configuration {

    /**
     * The data configuration for MongoDB.
     */

    private MongoDBConnectionConfig mongoDBConnectionConfig;

    public MongoDBConnectionConfig getMongoDBConnectionConfig() {
        return mongoDBConnectionConfig;
    }

    public void setMongoDBConnectionConfig(MongoDBConnectionConfig mongoDBConnectionConfig) {
        this.mongoDBConnectionConfig = mongoDBConnectionConfig;
    }
}
