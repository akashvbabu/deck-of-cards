package com.akash;

/**
 * available face values of cards
 */
public enum FaceValue {
    ACE("ACE"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    KING("KING"),
    QUEEN("QUEEN"),
    JACK("JACK");

    private final String faceValue;

    FaceValue(String faceValue) {
        this.faceValue = faceValue;
    }

    public String getFaceValue() {
        return faceValue;
    }
}
