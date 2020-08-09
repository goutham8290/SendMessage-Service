package com.sendmessage.repository.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sendmessage.Utility.ObjectIdSerializer;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable {

   // @JsonSerialize(using = ObjectIdSerializer.class)
    private String id;

    @NotNull
    private String from;

    @NotNull
    private String to;

    @NotNull
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return Objects.equals(id, message1.id) &&
                Objects.equals(from, message1.from) &&
                Objects.equals(to, message1.to) &&
                Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, message);
    }
}
