package com.gradify.models;

import java.time.LocalDateTime;

public class Message {
    private User sender;
    private String receiverUsername; // "GLOBAL" for global chat, or username for direct
    private String content;
    private LocalDateTime sentAt;

    public Message(User sender, String receiverUsername, String content) {
        this.sender = sender;
        this.receiverUsername = receiverUsername;
        this.content = content;
        this.sentAt = LocalDateTime.now();
    }

    public User getSender() {
        return sender;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public String getContent() {
        return content;
    }

    public boolean isGlobal() {
        return "GLOBAL".equalsIgnoreCase(receiverUsername);
    }

    @Override
    public String toString() {
        if (isGlobal()) {
            return "[GLOBAL] " + sender.getUsername() + ": " + content;
        } else {
            return "[DIRECT -> " + receiverUsername + "] " + sender.getUsername() + ": " + content;
        }
    }
}
