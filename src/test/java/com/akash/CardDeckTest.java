package com.akash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link CardDeck}
 */
public final class CardDeckTest {

    private static final int DECK_SIZE = 52;
    private CardDeck cardDeck;

    @BeforeEach
    public void setUp() {
        cardDeck = new CardDeck();
    }
    /**
     * We cannot truly test deck shuffling as we could end up with the exact same deck as before even
     * after shuffling which is possibility
     */
    @Test
    public void deckShuffledSuccessfully() {
        cardDeck.shuffle();
        Card shuffledCardFromTop = cardDeck.peekTopCard();
        assertThat(shuffledCardFromTop.getCardSuite()).isIn(Suite.values());
        assertThat(shuffledCardFromTop.getFaceValue()).isIn(FaceValue.values());
    }

    @Test
    public void deckShuffleWorksSuccessfullyWithIntermittentCardDealings() {
        // deal a card
        Card cardBeforeShuffling = cardDeck.dealOneCard();
        assertThat(cardBeforeShuffling.getCardSuite()).isIn(Suite.values());
        assertThat(cardBeforeShuffling.getFaceValue()).isIn(FaceValue.values());
        // shuffle
        cardDeck.shuffle();
        // deal a card
        Card cardAfterShuffling = cardDeck.dealOneCard();
        assertThat(cardAfterShuffling.getCardSuite()).isIn(Suite.values());
        assertThat(cardAfterShuffling.getFaceValue()).isIn(FaceValue.values());
        // shuffle
        cardDeck.shuffle();
        cardDeck.shuffle();
        Card cardAfterShufflingMultipleTimes = cardDeck.dealOneCard();
        assertThat(cardAfterShufflingMultipleTimes.getCardSuite()).isIn(Suite.values());
        assertThat(cardAfterShufflingMultipleTimes.getFaceValue()).isIn(FaceValue.values());
    }

    @Test
    public void deckShuffleThrowsExceptionOnEmptyDeck() {
        // deal all the cards
        for (int i = 0;i < DECK_SIZE; i++) {
            cardDeck.dealOneCard();
        }
        assertThatThrownBy(() -> cardDeck.shuffle())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Cannot shuffle an empty deck");
    }

    @Test
    public void deckDealsCardSuccessfully() {
        CardDeck cardDeck = new CardDeck();
        Card dealtCard = cardDeck.dealOneCard();
        assertThat(dealtCard.getCardSuite()).isIn(Suite.values());
        assertThat(dealtCard.getFaceValue()).isIn(FaceValue.values());
    }

    @Test
    public void deckThrowsExceptionOnDealingFromEmptyDeck() {
        // Deal all the cards and empty the deck
        for (int i = 0; i < DECK_SIZE; i++) {
            cardDeck.dealOneCard();
        }
        assertThatThrownBy(() -> cardDeck.dealOneCard())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Cannot deal anymore cards, since there are no more cards in the deck");
    }

    @Test
    public void peekDeckSuccessOnNonEmptyDeck() {
        Card peekedCard = cardDeck.peekTopCard();
        assertThat(peekedCard.getCardSuite()).isIn(Suite.values());
        assertThat(peekedCard.getFaceValue()).isIn(FaceValue.values());
    }

    @Test
    public void peekDeckThrowsExceptionOnEmptyDeck() {
        for (int i = 0; i < DECK_SIZE; i++) {
            cardDeck.dealOneCard();
        }
        assertThatThrownBy(() -> cardDeck.peekTopCard())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Cannot peek an empty deck");
    }
}
