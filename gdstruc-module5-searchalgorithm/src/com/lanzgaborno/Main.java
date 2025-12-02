package com.lanzgaborno;

import java.util.Random;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        int numbers[] = {60, 33, 12, 64, 17, 105, -53, 63, 69, 200, 531, 37, 68, 42, 36};

        System.out.println(lanzGoGamblingSearch(numbers, 105));
        System.out.println(lanzGoGamblingSearch(numbers, 37));
        System.out.println(lanzGoGamblingSearch(numbers, 420)); // Value not within array
    }

    public static int lanzGoGamblingSearch(int[] input, int value) {
        Random random = new Random();
        HashSet<Integer> checked = new HashSet<Integer>();
        int gamblingCounter = 1;
        while (checked.size() < input.length) {
            int randomIndex = random.nextInt(input.length);

            if (checked.contains(randomIndex)) {
                System.out.println("Aw Dang It! Keep Gambling");
                gamblingCounter++;
                continue;
            }

            checked.add(randomIndex);

            if (input[randomIndex] == value) {
                System.out.println("\nJACKPOT! WE FOUND IT! AFTER " + gamblingCounter + " TRIES!");
                System.out.println("The Value you are looking for is in position: ");
                return randomIndex;
            }
        }

        return -1;
    }
}