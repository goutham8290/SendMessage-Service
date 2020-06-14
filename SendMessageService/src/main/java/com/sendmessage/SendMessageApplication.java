package com.sendmessage;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMessageApplication extends Application<SendMessageConfiguration> {


    private static Logger LOGGER = LoggerFactory.getLogger(SendMessageApplication.class);

    public static void main(String[] args) throws Exception {

        new SendMessageApplication().run(args);
        LOGGER.info("Application Start");
    }

    public void run(SendMessageConfiguration sendMessageConfiguration, Environment environment) throws Exception {

        LOGGER.info(  sendMessageConfiguration.getDefaultName());
        LOGGER.info("Application Start");

    }
}
