package com.wave.entities;

/**
 *
 * @author dibyajyotimishra
 */
public class Message {
    private String messageReaction;
    private String messageContent;
    private String type;
    private String cssClass;

    public Message(String messageReaction, String messageContent, String type, String cssClass) {
        this.messageReaction = messageReaction;
        this.messageContent = messageContent;
        this.type = type;
        this.cssClass = cssClass;
    }

    public String getMessageReaction() {
        return messageReaction;
    }
    

    public String getMessageContent() {
        return messageContent;
    }

    public String getCssClass() {
        return cssClass;
    }

    public String getType() {
        return type;
    }

    public void setMessageReaction(String messageReaction) {
        this.messageReaction = messageReaction;
    }
    
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public void setType(String type) {
        this.type = type;
    }
}
