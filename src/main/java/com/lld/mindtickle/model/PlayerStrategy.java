package com.lld.mindtickle.model;

import java.util.ArrayList;

public class PlayerStrategy {
    public Card playerHand(ArrayList<Card> cards, Round round){
        // look at the round already played hands
        // look at round current suite
        // get best card
        Card  card = cards.get(0);
        cards.remove(0);
        return card;
    }
}
