package com.lanzgaborno;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private CardStack playerDeck;
    private CardStack discardPile;
    private Card[] playerHand;      // Array for player's hand
    private int handSize;           // Track how many cards in hand
    private Random random;
    private Scanner scanner;
    private int turnNumber;

    // Card names for the 30-card deck
    private static final String[] CARD_NAMES = {
            "Flare Blitz", "Icicle Spear", "Volt Tackle", "Wish",
            "Protect", "Hydro Pump", "Toxic", "Aerial Ace",
            "Swords Dance", "Hi Jump Kick"
    };

    public Main() {
        playerDeck = new CardStack("Player Deck");
        discardPile = new CardStack("Discard Pile");
        playerHand = new Card[20];  // Max 20 cards in hand
        handSize = 0;
        random = new Random();
        scanner = new Scanner(System.in);
        turnNumber = 1;

        initializeDeck();
    }

    private void initializeDeck() {
        System.out.println("generating 30 cards...\n");

        for (int i = 0; i < 30; i++) {
            // Pick a random card name
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
        System.out.println(">>> COMMAND: Draw " + numCards + " card(s)");

        int drawn = 0;
        for (int i = 0; i < numCards; i++) {
            if (playerDeck.isEmpty()) {
                System.out.println("  ! Deck is empty, cannot draw more cards!");
                break;
            }

            if (handSize >= playerHand.length) {
                System.out.println("  ! Hand is full, cannot draw more cards!");
                break;
            }

            Card card = playerDeck.pop();
            playerHand[handSize] = card;
            handSize++;
            drawn++;
            System.out.println("  + Drew: " + card);
        }

        if (drawn > 0) {
            System.out.println("  Total drawn: " + drawn);
        }
    }

    // Discard x cards from hand
    private void discardCards() {
        if (handSize == 0) {
            System.out.println("->COMMAND: Discard cards");
            System.out.println("  ! No cards in hand to discard!");
            return;
        }

        int numCards = random.nextInt(5) + 1; // 1 to 5
        System.out.println("->COMMAND: Discard " + numCards + " card(s)");

        int discarded = 0;
        for (int i = 0; i < numCards; i++) {
            if (handSize == 0) {
                System.out.println("  ! No more cards in hand to discard!");
                break;
            }

            // Remove from front of hand (index 0)
            Card card = playerHand[0];
            discardPile.push(card);

            // Shift all cards left
            for (int j = 0; j < handSize - 1; j++) {
                playerHand[j] = playerHand[j + 1];
            }
            playerHand[handSize - 1] = null;
            handSize--;

            discarded++;
            System.out.println("  - Discarded: " + card);
        }

        if (discarded > 0) {
            System.out.println("  Total discarded: " + discarded);
        }
    }

    // Retrieve x cards from discard pile
    private void retrieveFromDiscard() {
        if (discardPile.isEmpty()) {
            System.out.println("->COMMAND: Retrieve from discard pile");
            System.out.println("  ! Discard pile is empty!");
            return;
        }

        int numCards = random.nextInt(5) + 1; // 1 to 5
        System.out.println("->COMMAND: Retrieve " + numCards + " card(s) from discard pile");

        int retrieved = 0;
        for (int i = 0; i < numCards; i++) {
            if (discardPile.isEmpty()) {
                System.out.println("  ! No more cards in discard pile!");
                break;
            }

            if (handSize >= playerHand.length) {
                System.out.println("  ! Hand is full, cannot retrieve more cards!");
                break;
            }

            Card card = discardPile.pop();
            playerHand[handSize] = card;
            handSize++;
            retrieved++;
            System.out.println("  + Retrieved: " + card);
        }

        if (retrieved > 0) {
            System.out.println("  Total retrieved: " + retrieved);
        }
    }

    // Display game state
    private void displayGameState() {
        System.out.println("\n========================================");
        System.out.println("             GAME STATE"                  );
        System.out.println("========================================");

        // Player's hand
        System.out.println("\nCards in Hand (" + handSize + "):");
        if (handSize == 0) {
            System.out.println("  (empty)");
        } else {
            for (int i = 0; i < handSize; i++) {
                System.out.println("  " + (i + 1) + ". " + playerHand[i]);
            }
        }

        // Deck info
        System.out.println("\nPlayer Deck: " + playerDeck.size() + " cards remaining");

        // Discard pile info
        System.out.println("Discard Pile: " + discardPile.size() + " cards");

        System.out.println("========================================\n");
    }

    // Check if game is over
    private boolean isGameOver() {
        return playerDeck.isEmpty();
    }

    // Main game loop
    public void play() {
        System.out.println("=========================================");
        System.out.println("        DEFINITELY NOT POKEMON TCG       ");
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
        System.out.println("                GAME OVER!"                );
        System.out.println("=========================================");
        System.out.println("Total turns played: " + turnNumber);
        System.out.println("Final hand size: " + handSize);
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