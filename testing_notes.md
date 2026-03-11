# Test Results and Notes

A complete end-to-end test sequence was performed on the `Main.java` CLI, which is now powered entirely by Custom Data Structures and Algorithms!

## Data Structure Utilization Confirmed
- **AuthService**: Operates using a custom `HashTable` with separate chaining instead of `HashMap`.
- **DocumentService**: Backed by a custom generic `DoublyLinkedList` instead of `ArrayList`.
- **ChatService**: Retains global messages efficiently rolling over via a `CircularQueue`, and personal messages using `DoublyLinkedList`.
- **LeaderboardService**: Aggregates the `HashTable` entries and dynamically invokes a custom `QuickSort` descending algorithm.

## Test Sequence
1. Registered user `Alice`.
2. Registered user `Bob`.
3. Logged in as `Alice`.
4. Uploaded "My First Document" (ID: 1).
5. Uploaded "Another interesting PDF" (ID: 2).
6. **(NEW)** Searched for a document using an incorrect title "xyz" -> Properly indicated not found.
7. **(NEW)** Searched for "My First Document" -> Successfully retrieved via `LinearSearch`!
8. Sent a Global chat message: "Hello world from Alice!".
9. Sent Direct Message to `Bob`: "Hi Bob!".
10. Viewed Global Chat successfully.
11. Viewed Direct Messages successfully.
12. Logged out as `Alice`.
13. Logged in as `Bob`.
14. Viewed Global Chat (saw Alice's message).
15. Viewed Direct Messages (saw Alice's DM).
16. Sent Direct Message to `Alice`.
17. Viewed all Custom Documents.
18. Upvoted Document ID: 1.
19. Looked at Global Leaderboard - Alice's score correctly reflected as 10 from the upvote, leveraging `QuickSort`.
20. Logged out as `Bob`.
21. Exited the program.

## Conclusion
The migration from default `java.util.*` API objects to internally managed Data Structures and Algorithms was a total success. Memory and search capabilities function identically from a user standpoint, demonstrating the correct operational behavior of `DoublyLinkedList`, `CircularQueue`, `HashTable`, `LinearSearch`, and `QuickSort`.
