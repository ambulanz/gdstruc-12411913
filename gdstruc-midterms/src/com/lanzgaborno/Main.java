package com.lanzgaborno;

import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    private CardStack playerDeck;
    private CardStack discardPile;
    private LinkedList<Card> playerHand;
    private Random random;
    private Scanner scanner;
    private int turnNumber;

    private static final String[] CARD_NAMES = {
            "Flare Blitz", "Icicle Spear", "Volt Tackle", "Wish",
            "Protect", "Hydro Pump", "Toxic", "Aerial Ace",
            "Swords Dance", "Hi Jump Kick"
    };

    public Main() {
        playerDeck = new CardStack("Player Deck");
        discardPile = new CardStack("Discard Pile");
        playerHand = new LinkedList<Card>();
        random = new Random();
        scanner = new Scanner(System.in);
        turnNumber = 1;

        initializeDeck();
    }

    private void initializeDeck() {
        System.out.println("generating cards...\n");

        for (int i = 0; i < 30; i++) {
            String cardName = CARD_NAMES[random.nextInt(CARD_NAMES.length)];
            Card card = new Card(cardName);
            playerDeck.push(card);
        }
    }

    private void executeRandomCommand() {
        int commandType = random.nextInt(3);

        switch (commandType) {
            case 0:
                drawCards();
                break;
            case 1:
                discardCards();
                break;
            case 2:
                retrieveFromDiscard();
                break;
        }
    }

    private void drawCards() {
        int numCards = random.nextInt(5) + 1; // 1 to 5
        System.out.println("->SELECTED COMMAND: Draw " + numCards + " card(s)");

        int drawn = 0;
        for (int i = 0; i < numCards; i++) {
            if (playerDeck.isEmpty()) {
                System.out.println("  ! Deck is empty, cannot draw more cards!");
                break;
            }

            Card card = playerDeck.pop();
            playerHand.add(card);
            drawn++;
            System.out.println("  + Drew: " + card);
        }

        if (drawn > 0) {
            System.out.println("  Total drawn: " + drawn);
        }
    }

    private void discardCards() {
        if (playerHand.isEmpty()) {
            System.out.println("->SELECTED COMMAND: Discard cards");
            System.out.println("  ! No cards in hand to discard!");
            return;
        }

        int numCards = random.nextInt(5) + 1; // 1 to 5
        System.out.println("->SELECTED COMMAND: Discard " + numCards + " card(s)");

        int discarded = 0;
        for (int i = 0; i < numCards; i++) {
            if (playerHand.isEmpty()) {
                System.out.println("  ! No more cards in hand to discard!");
                break;
            }

            Card card = playerHand.removeFirst();
            discardPile.push(card);
            discarded++;
            System.out.println("  - Discarded: " + card);
        }

        if (discarded > 0) {
            System.out.println("  Total discarded: " + discarded);
        }
    }

    private void retrieveFromDiscard() {
        if (discardPile.isEmpty()) {
            System.out.println("->SELECTED COMMAND: Retrieve from discard pile");
            System.out.println("  ! Discard pile is empty!");
            return;
        }

        int numCards = random.nextInt(5) + 1; // 1 to 5
        System.out.println("->SELECTED COMMAND: Retrieve " + numCards + " card(s) from discard pile");

        int retrieved = 0;
        for (int i = 0; i < numCards; i++) {
            if (discardPile.isEmpty()) {
                System.out.println("  ! No more cards in discard pile!");
                break;
            }

            Card card = discardPile.pop();
            playerHand.add(card);
            retrieved++;
            System.out.println("  + Retrieved: " + card);
        }

        if (retrieved > 0) {
            System.out.println("  Total retrieved: " + retrieved);
        }
    }

    private void displayGameState() {
        System.out.println("\n========================================");
        System.out.println("CURRENT GAME STATE");
        System.out.println("========================================");

        // Player's hand
        System.out.println("\nCards in Hand (" + playerHand.size() + "):");
        if (playerHand.isEmpty()) {
            System.out.println("  (empty)");
        } else {
            for (int i = 0; i < playerHand.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + playerHand.get(i));
            }
        }

        // Deck info
        System.out.println("\nPlayer Deck: " + playerDeck.size() + " cards remaining");

        // Discard pile info
        System.out.println("Discard Pile: " + discardPile.size() + " cards");

        System.out.println("========================================\n");
    }

    private boolean isGameOver() {
        return playerDeck.isEmpty();
    }

    // Main game loop
    public void play() {
        System.out.println("=========================================");
        System.out.println("         DEFINITELY POKEMON TCG          ");
        System.out.println("=========================================");
        System.out.println("Press ENTER to start...");
        scanner.nextLine();

        while (!isGameOver()) {
            System.out.println("\n");
            System.out.println("==========================================");
            System.out.println("              TURN " + turnNumber);
            System.out.println("==========================================\n");

            executeRandomCommand();
            displayGameState();

            if (isGameOver()) {
                break;
            }

            System.out.print("Press ENTER for next turn...");
            scanner.nextLine();

            turnNumber++;
        }

        System.out.println("\n=========================================");
        System.out.println("              GAME OVER!");
        System.out.println("=========================================");
        System.out.println("Total turns played: " + turnNumber);
        System.out.println("Final hand size: " + playerHand.size());
        System.out.println("Cards in discard pile: " + discardPile.size());
        System.out.println("\nYou are the Pokemon Champion!");

        scanner.close();
    }

    // main method
    public static void main(String[] args) {
        Main game = new Main();
        game.play();
    }
}