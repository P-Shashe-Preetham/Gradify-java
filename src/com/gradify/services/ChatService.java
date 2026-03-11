package com.gradify.services;

import com.gradify.models.Message;
import com.gradify.models.User;
import com.gradify.datastructures.CircularQueue;
import com.gradify.datastructures.DoublyLinkedList;

public class ChatService {
    private CircularQueue<Message> globalMessages;
    private DoublyLinkedList<Message> directMessages;

    public ChatService() {
        this.globalMessages = new CircularQueue<>(100); // Store last 100 global messages
        this.directMessages = new DoublyLinkedList<>();
    }

    public void sendGlobalMessage(User sender, String content) {
        Message msg = new Message(sender, "GLOBAL", content);
        globalMessages.enqueue(msg);
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
        boolean hasMessages = false;
        System.out.println("--- Direct Messages ---");
        for (Message msg : directMessages) {
            if (msg.getReceiverUsername().equals(currentUser.getUsername()) || 
                msg.getSender().getUsername().equals(currentUser.getUsername())) {
                System.out.println(msg);
                hasMessages = true;
            }
        }
        if (!hasMessages) {
            System.out.println("No direct messages available for you.");
        }
        System.out.println("-----------------------");
    }
}

