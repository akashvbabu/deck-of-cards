package com.akash;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO to represent a deck of cards
 */
public final class CardDeck {

    private List<Card> cards;

    // Initialize the deck of cards
    public CardDeck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    // Fill the deck with cards of all suites
    private void initializeDeck() {
        for (Suite suite: Suite.values()) {
            for (FaceValue faceValue: FaceValue.values()) {
                Card cardToInsertIntoDeck = new Card(suite, faceValue);
                cards.add(cardToInsertIntoDeck);
            }
        }
    }

    /**
     * Deal a card from the deck. I have assumed I will always deal the top card on the deck
     * @return
     */
    public Card dealOneCard() {
        // if we have more cards on the deck, deal it, else throw an illegal state exception since we can't deal more
        // cards
        if (!cards.isEmpty()) {
            return cards.remove(0); // always draw top of the deck
        } else {
            throw new IllegalStateException("Cannot deal anymore cards, since there are no more cards in the deck");
        }
    }

    /**
     * Shuffle the deck on hand
     */
    public void shuffle() {
        // Can't shuffle something non existent
        if (cards.isEmpty()) {
            throw new IllegalStateException("Cannot shuffle an empty deck");
        }

        /* LOGIC to shuffle deck
           1. Get two random cards
           2. Swap their positions
           3. Do this for all cards in the deck
         */
        for (int i = 0; i < cards.size(); i++) {
            int positionCardA = getRandomNumber(cards.size());
            int positionCardB = getRandomNumber(cards.size());
            Card cardA = cards.get(positionCardA);
            Card cardB = cards.get(positionCardB);
            cards.set(positionCardB, cardA);
            cards.set(positionCardA, cardB);
        }
    }

    /**
     * Peek the top of the deck
     * @return
     */
    public Card peekTopCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Cannot peek an empty deck");
        }

        return cards.get(0);
    }

    /**
     * WARNING: This is a pseudorandom number generator, there is a possibility this will generate the same number more
     * than once
     * @return
     */
    private int getRandomNumber(int sizeOfDeck) {
        return (int) (Math.random() * sizeOfDeck);
    }
}
