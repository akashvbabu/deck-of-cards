[![Build Status](https://travis-ci.org/akashvbabu/deck-of-cards.svg?branch=master)](https://travis-ci.org/akashvbabu/deck-of-cards)

### A java application to deal a poker style deck of cards

Deck has Four Suites: HEARTS, DIAMONDS, CLUBS, SPADES.

Face Value of Cards are From Ace to Queen.

Deck has a total of 52 cards with 13 cards from each suite.

The deck provides 3 operations:
* Shuffling
* Dealing a card
* Peeking the top card

To run tests
```java
mvn clean verify
```

Example usage of Deck
```java
CardDeck cardDeck = new CardDeck();
// Deal a card
cardDeck.dealOneCard();
// Shuffle the deck
cardDeck.shuffle();
// Peek the top card of the deck
cardDeck.peekTopCard();
```
