package com.lanzgaborno;

import java.util.Random;
import java.util.Scanner;

public class MainMatchmakingSystem {
    private LinkedQueue playerQueue;
    private Random random;
    private int gamesCreated;
    private int PLAYERS_PER_GAME = 5;
    private int TOTAL_GAMES_NEEDED = 10;

    public MainMatchmakingSystem() {
        playerQueue = new LinkedQueue();
        random = new Random();
        gamesCreated = 0;
    }

    public void addPlayers() {
        int numPlayers = random.nextInt(7) + 1; // 1 to 7 players
        System.out.println("\n>>> " + numPlayers + " player(s) joining queue...");

        for (int i = 0; i < numPlayers; i++) {
            Player newPlayer = new Player("User" + random.nextInt(1000));
            playerQueue.enqueue(newPlayer);
            System.out.println("  + " + newPlayer + " joined");
        }
    }

    public void startGameAttempt() {
        while (playerQueue.size() >= PLAYERS_PER_GAME && gamesCreated < TOTAL_GAMES_NEEDED) {
            startGame();
        }
    }

    private void startGame() {
        gamesCreated++;
        System.out.println("\n*** GAME " + gamesCreated + " STARTING ***");
        System.out.println("PLAYERS MATCHED");

        for (int i = 0; i < PLAYERS_PER_GAME; i++) {
            Player player = playerQueue.dequeue();
            System.out.println("  -> " + player);
        }

        System.out.println("*** Game has loaded! Welcome to Summoners Rift! ***\n");
    }

    public boolean isComplete() {
        return gamesCreated >= TOTAL_GAMES_NEEDED;
    }

    public void displayStatus() {
        System.out.println("\n--- Matchmaking Status ---");
        System.out.println("Games created: " + gamesCreated + "/" + TOTAL_GAMES_NEEDED);
        System.out.println("Players in queue: " + playerQueue.size());
        System.out.println("--------------------------\n");
    }

    // MAIN MATCHMAKING SYSTEM CODEe
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int turn = 1;

        while (!isComplete()) {
            System.out.println("\n========== TURN " + turn + " ==========");

            addPlayers();
            playerQueue.printQueue();
            startGameAttempt();
            displayStatus();

            if (!isComplete()) {
                System.out.print("Press ENTER for next turn...");
                scanner.nextLine();
            }

            turn++;
        }

        System.out.println("\n=================================");
        System.out.println("  ALL GAMES CREATED! COMPLETE!");
        System.out.println("=================================");
        System.out.println("Total turns: " + (turn - 1));

        scanner.close();
    }

    public static void main(String[] args) {
        MainMatchmakingSystem system = new MainMatchmakingSystem();
        system.run();
    }
}