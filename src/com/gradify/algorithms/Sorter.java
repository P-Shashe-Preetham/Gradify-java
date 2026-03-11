package com.gradify.algorithms;

import com.gradify.models.User;
import java.util.List;

public class Sorter {

    /**
     * Sorts a List of Users by their score in descending order using Quick Sort.
     */
    public static void quickSortByScoreDescending(List<User> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        quickSort(list, 0, list.size() - 1);
    }

    private static void quickSort(List<User> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private static int partition(List<User> list, int low, int high) {
        User pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Descending order: User score > Pivot score
            if (list.get(j).getScore() > pivot.getScore()) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static void swap(List<User> list, int i, int j) {
        User temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
