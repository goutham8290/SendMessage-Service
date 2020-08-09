package com.sendmessage.resource;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sendmessage.repository.MessageRepository;
import com.sendmessage.repository.dto.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Api(value = "SendMessage",tags = {"Message"})
@Path("v1")
public class MessageResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageResource.class);

    private MessageRepository repo;

    public MessageResource(final MessageRepository repository){
        this.repo = repository;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save (@ApiParam(value = "Message") @NotNull final Message message){
        repo.saveMessage(message);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages()
    {
        List<Message> data =   repo.getAll();

        return data;
    }
}
