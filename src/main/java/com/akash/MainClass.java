package com.akash;

/**
 * Main Runner
 */
public class MainClass {
    public static void main(String[] args) {
        // EXAMPLE USAGE
        CardDeck cardDeck = new CardDeck();
        cardDeck.shuffle();
        for(int i = 0; i < 52; i++) {
            System.out.println(cardDeck.dealOneCard());
        }
    }
}
