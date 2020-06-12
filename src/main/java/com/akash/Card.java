package com.akash;

import java.util.Objects;

/**
 * POJO to represent of a card in a deck
 */
public final class Card {

    /**
     * Suite of the card, one of the values from {@link Suite}
     */
    private final Suite cardSuite;

    /**
     * Face value of the card, one of the values from {@link FaceValue}
     */
    private final FaceValue faceValue;

    // Parameterized constructor to take in the args
    public Card(Suite cardSuite, FaceValue faceValue) {
        this.faceValue = Objects.requireNonNull(faceValue);
        this.cardSuite = Objects.requireNonNull(cardSuite);
    }

    /**
     * Getter for card suite
     * @return
     */
    public Suite getCardSuite() {
        return cardSuite;
    }

    /**
     * Getter for face value
     * @return
     */
    public FaceValue getFaceValue() {
        return faceValue;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardSuite=" + cardSuite +
                ", faceValue=" + faceValue +
                '}';
    }
}
