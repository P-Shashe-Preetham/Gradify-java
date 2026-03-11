package com.gradify.services;

import com.gradify.models.Document;
import com.gradify.models.User;
import com.gradify.datastructures.DoublyLinkedList;
import com.gradify.algorithms.Searcher;

public class DocumentService {
    private DoublyLinkedList<Document> documents;

    public DocumentService() {
        this.documents = new DoublyLinkedList<>();
    }

    public void uploadDocument(String title, User uploader) {
        Document newDoc = new Document(title, uploader);
        documents.add(newDoc);
        System.out.println("Document '" + title + "' uploaded successfully! ID: " + newDoc.getId());
    }

    public void listDocuments() {
        if (documents.isEmpty()) {
            System.out.println("No documents available.");
            return;
        }
        System.out.println("--- Available Documents ---");
        for (Document doc : documents) {
            System.out.println(doc);
        }
        System.out.println("---------------------------");
    }

    public void searchDocument(String title) {
        Document foundDoc = Searcher.linearSearchByTitle(documents, title);
        if (foundDoc != null) {
            System.out.println("Document Found: " + foundDoc);
        } else {
            System.out.println("No document found with title: " + title);
        }
    }

    public boolean upvoteDocument(int docId) {
        for (Document doc : documents) {
            if (doc.getId() == docId) {
                doc.upvote();
                System.out.println("Document ID " + docId + " upvoted successfully!");
                return true;
            }
        }
        System.out.println("Document with ID " + docId + " not found.");
        return false;
    }
}

