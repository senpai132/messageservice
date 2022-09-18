package com.DevOps2022.messageservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("message")
public class Message {
    /*@Transient
    public static final String SEQUENCE_NAME = "message_sequence";*/

    @Id
    private String id;
    
    private String sender;
    private String receiver;
    private String content;
    private Date timeSent;
    private int isRead;

    public Message() {
        this.isRead = 0;
        this.timeSent = new Date();
    }

    public Message(String id, String sender, String receiver, String content, Date timeSent, int isRead) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timeSent = timeSent;
        this.isRead = isRead;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getTimeSent() {
        return timeSent;
    }
    public void setTimeSent(Date timeSent) {
        this.timeSent = timeSent;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    
    
}
