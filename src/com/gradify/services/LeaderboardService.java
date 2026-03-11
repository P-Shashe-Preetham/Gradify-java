package com.gradify.services;

import com.gradify.models.User;
import com.gradify.algorithms.Sorter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LeaderboardService {

    public void displayLeaderboard(Collection<User> users) {
        if (users == null || users.isEmpty()) {
            System.out.println("No users available for the leaderboard.");
            return;
        }

        // Convert the Collection to an ArrayList so QuickSort can handle elements by index
        List<User> listToSort = new ArrayList<>(users);

        Sorter.quickSortByScoreDescending(listToSort);

        System.out.println("--- Global Leaderboard ---");
        int rank = 1;
        for (User user : listToSort) {
            System.out.println(rank + ". " + user.getUsername() + " - Score: " + user.getScore());
            rank++;
        }
        System.out.println("--------------------------");
    }
}

