package com.gradify.services;

import com.gradify.models.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderboardService {

    public void displayLeaderboard(Collection<User> users) {
        if (users == null || users.isEmpty()) {
            System.out.println("No users available for the leaderboard.");
            return;
        }

        List<User> sortedUsers = users.stream()
                .sorted((u1, u2) -> Integer.compare(u2.getScore(), u1.getScore())) // Descending order
                .collect(Collectors.toList());

        System.out.println("--- Global Leaderboard ---");
        int rank = 1;
        for (User user : sortedUsers) {
            System.out.println(rank + ". " + user.getUsername() + " - Score: " + user.getScore());
            rank++;
        }
        System.out.println("--------------------------");
    }
}
