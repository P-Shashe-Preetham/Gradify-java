package com.gradify;

import com.gradify.services.AuthService;
import com.gradify.services.ChatService;
import com.gradify.services.DocumentService;
import com.gradify.services.LeaderboardService;
import com.gradify.models.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        DocumentService documentService = new DocumentService();
        ChatService chatService = new ChatService();
        LeaderboardService leaderboardService = new LeaderboardService();

        System.out.println("=========================================");
        System.out.println("  Welcome to Gradify (Java Console App)  ");
        System.out.println("=========================================");

        boolean running = true;

        while (running) {
            if (!authService.isUserLoggedIn()) {
                System.out.println("\n--- Main Menu (Not Logged In) ---");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        System.out.print("Enter username: ");
                        String regUser = scanner.nextLine().trim();
                        System.out.print("Enter password: ");
                        String regPass = scanner.nextLine().trim();
                        authService.register(regUser, regPass);
                        break;
                    case "2":
                        System.out.print("Enter username: ");
                        String loginUser = scanner.nextLine().trim();
                        System.out.print("Enter password: ");
                        String loginPass = scanner.nextLine().trim();
                        authService.login(loginUser, loginPass);
                        break;
                    case "3":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                User currentUser = authService.getLoggedInUser();
                System.out.println("\n--- Dashboard (" + currentUser.getUsername() + ") ---");
                System.out.println("1. Upload new Document");
                System.out.println("2. View All Documents");
                System.out.println("3. Search Document by Title");
                System.out.println("4. Upvote a Document");
                System.out.println("5. Send Global Message");
                System.out.println("6. View Global Chat");
                System.out.println("7. Send Direct Message");
                System.out.println("8. View Direct Messages");
                System.out.println("9. View Leaderboard");
                System.out.println("10. Logout");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        System.out.print("Enter document title: ");
                        String title = scanner.nextLine().trim();
                        documentService.uploadDocument(title, currentUser);
                        break;
                    case "2":
                        documentService.listDocuments();
                        break;
                    case "3":
                        System.out.print("Enter exact document title to search: ");
                        String searchTitle = scanner.nextLine().trim();
                        documentService.searchDocument(searchTitle);
                        break;
                    case "4":
                        System.out.print("Enter document ID to upvote: ");
                        try {
                            int docId = Integer.parseInt(scanner.nextLine().trim());
                            documentService.upvoteDocument(docId);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid numeric ID.");
                        }
                        break;
                    case "5":
                        System.out.print("Enter your message to Global Chat: ");
                        String globalMsg = scanner.nextLine().trim();
                        chatService.sendGlobalMessage(currentUser, globalMsg);
                        break;
                    case "6":
                        chatService.viewGlobalChat();
                        break;
                    case "7":
                        System.out.print("Enter recipient username: ");
                        String receiver = scanner.nextLine().trim();
                        if (authService.getUser(receiver) == null) {
                            System.out.println("User does not exist.");
                        } else {
                            System.out.print("Enter message: ");
                            String dmMessage = scanner.nextLine().trim();
                            chatService.sendDirectMessage(currentUser, receiver, dmMessage);
                        }
                        break;
                    case "8":
                        chatService.viewDirectMessages(currentUser);
                        break;
                    case "9":
                        leaderboardService.displayLeaderboard(authService.getAllUsers());
                        break;
                    case "10":
                        authService.logout();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
        scanner.close();
    }
}
