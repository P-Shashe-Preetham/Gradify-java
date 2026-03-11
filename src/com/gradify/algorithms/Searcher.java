package com.gradify.algorithms;

import com.gradify.datastructures.DoublyLinkedList;
import com.gradify.models.Document;

public class Searcher {

    /**
     * Performs a Linear Search on a DoublyLinkedList of Documents to match the title exactly.
     * @return the first matching Document or null if not found.
     */
    public static Document linearSearchByTitle(DoublyLinkedList<Document> documents, String searchTitle) {
        if (documents == null || documents.isEmpty()) {
            return null;
        }

        for (Document doc : documents) {
            if (doc.getTitle().equalsIgnoreCase(searchTitle)) {
                return doc;
            }
        }
        return null;
    }
}
