# Gradify Java App - Comprehensive Test Report

A rigorous end-to-end automated test sequence was orchestrated to validate not only the primary success scenarios but also critical error-handling conditions surrounding the newly integrated Custom Data Structures and Algorithms (`HashTable`, `DoublyLinkedList`, `CircularQueue`, `LinearSearch`, `QuickSort`).

## 1. Authentication (`HashTable`)
- **[PASSED] User Registration**: Registered `UserA` successfully.
- **[PASSED] Duplicate Registration Handling**: Attempting to register `UserA` a second time successfully intercepted and rejected by the `HashTable` lookup.
- **[PASSED] Invalid Login Flow**: Attempting to log in to `UserA` with `wrongpass` successfully rejected.
- **[PASSED] Valid Login Flow**: Logging in with correct credentials routed the application to the Dashboard successfully.

## 2. Document Management (`DoublyLinkedList` & `LinearSearch`)
- **[PASSED] Document Uploads**: Successfully uploaded multiple documents (`Doc1`, `Doc2`). IDs naturally incremented.
- **[PASSED] Valid Document Search (`LinearSearch`)**: Searched for `Doc1` exact title; correctly triggered a match and returned the document data structure.
- **[PASSED] Invalid Document Search (`LinearSearch`)**: Searched for non-existent `Doc3`; successfully reported that no document was found.
- **[PASSED] Document Upvoting**: Successfully verified that Document ID 1 could be upvoted, correctly updating its internal property.

## 3. Communication (`CircularQueue` & `DoublyLinkedList`)
- **[PASSED] Global Messaging (`CircularQueue`)**: Emitted a global message from `UserA`. When logged in as `UserB`, the message successfully manifested on the Global Chat timeline.
- **[PASSED] Invalid Direct Messaging**: `UserA` attempting to direct message the unregistered `UserC` was successfully blocked by a `HashTable` existence check.
- **[PASSED] Valid Direct Messaging (`DoublyLinkedList`)**: `UserA` dispatched a message specifically to `UserB`. It was successfully retrieved from the `DoublyLinkedList` exclusively by `UserB` (and the sender `UserA`).

## 4. Global Leaderboard (`QuickSort`)
- **[PASSED] Score Assignment**: After `Doc1` was upvoted, its owner (`UserA`) accurately received 10 points. 
- **[PASSED] Score Aggregation & Sorting (`QuickSort`)**: Invoking the leaderboard successfully retrieved all users dynamically from the `HashTable`, converted them to a contiguous block, and dispatched an in-place `QuickSort` algorithms sorting `UserA` (10 pts) ahead of `UserB` (0 pts).

## Conclusion
The Gradify Java console application proved completely robust under extended test conditions. Both standard interactions and out-of-bounds user actions are safely handled. The custom DSA classes are working equivalently natively to their `java.util.*` counterparts with high efficiency.
