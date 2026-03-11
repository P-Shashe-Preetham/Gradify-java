package com.gradify.services;

import com.gradify.models.Message;
import com.gradify.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChatService {
    private List<Message> globalMessages;
    private List<Message> directMessages;

    public ChatService() {
        this.globalMessages = new ArrayList<>();
        this.directMessages = new ArrayList<>();
    }

    public void sendGlobalMessage(User sender, String content) {
        Message msg = new Message(sender, "GLOBAL", content);
        globalMessages.add(msg);
        System.out.println("Global message sent!");
    }

    public void viewGlobalChat() {
        if (globalMessages.isEmpty()) {
            System.out.println("No global messages yet.");
            return;
        }
        System.out.println("--- Global Chat ---");
        for (Message msg : globalMessages) {
            System.out.println(msg);
        }
        System.out.println("-------------------");
    }

    public void sendDirectMessage(User sender, String receiverUsername, String content) {
        if (sender.getUsername().equals(receiverUsername)) {
            System.out.println("You cannot send a message to yourself.");
            return;
        }
        Message msg = new Message(sender, receiverUsername, content);
        directMessages.add(msg);
        System.out.println("Direct message sent to " + receiverUsername + "!");
    }

    public void viewDirectMessages(User currentUser) {
        List<Message> userMessages = directMessages.stream()
                .filter(msg -> msg.getReceiverUsername().equals(currentUser.getUsername()) || 
                               msg.getSender().getUsername().equals(currentUser.getUsername()))
                .collect(Collectors.toList());

        if (userMessages.isEmpty()) {
            System.out.println("No direct messages available for you.");
            return;
        }
        System.out.println("--- Direct Messages ---");
        for (Message msg : userMessages) {
            System.out.println(msg);
        }
        System.out.println("-----------------------");
    }
}
