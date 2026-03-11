package com.gradify.models;

import java.time.LocalDateTime;

public class Document {
    private static int counter = 1;
    
    private int id;
    private String title;
    private User owner;
    private int upvotes;
    private LocalDateTime uploadedAt;

    public Document(String title, User owner) {
        this.id = counter++;
        this.title = title;
        this.owner = owner;
        this.upvotes = 0;
        this.uploadedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getOwner() {
        return owner;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void upvote() {
        this.upvotes++;
        this.owner.addScore(10); // Reward owner with 10 points
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Owner: " + owner.getUsername() + " | Upvotes: " + upvotes;
    }
}
