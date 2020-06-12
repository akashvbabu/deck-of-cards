package com.akash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link Card}
 */
public final class CardTest {

    @Test
    public void cardCreatedSuccessfully() {
        Card card = new Card(Suite.CLUBS, FaceValue.ACE);
        assertThat(card.getCardSuite()).isEqualTo(Suite.CLUBS);
        assertThat(card.getFaceValue()).isEqualTo(FaceValue.ACE);
    }

    @Test
    public void cardFailsCreationOnNullSuite() {
        assertThatThrownBy(() -> new Card(null, FaceValue.ACE))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void cardFailsCreationOnNullFaceValue() {
        assertThatThrownBy(() -> new Card(Suite.CLUBS, null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void cardFailsCreationOnNullSuiteAndFaceValue() {
        assertThatThrownBy(() -> new Card(null, null))
                .isInstanceOf(NullPointerException.class);
    }
}
