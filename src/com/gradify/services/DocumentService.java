package com.gradify.services;

import com.gradify.models.Document;
import com.gradify.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DocumentService {
    private List<Document> documents;

    public DocumentService() {
        this.documents = new ArrayList<>();
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

    public boolean upvoteDocument(int docId) {
        Optional<Document> documentOpt = documents.stream()
                .filter(doc -> doc.getId() == docId)
                .findFirst();

        if (documentOpt.isPresent()) {
            Document doc = documentOpt.get();
            doc.upvote();
            System.out.println("Document ID " + docId + " upvoted successfully!");
            return true;
        } else {
            System.out.println("Document with ID " + docId + " not found.");
            return false;
        }
    }
}
