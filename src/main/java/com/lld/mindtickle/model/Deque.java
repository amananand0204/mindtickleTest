package com.lld.mindtickle.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Deque {
    @Id
    private Long id;

    @OneToMany
    private Set<Card> cards = new HashSet<>();


    //Implement Iterator Pattern to distribute cards
    public boolean isEmpty(){
        return cards.isEmpty();
    }

    public Card getNextCard(){
        Card card = cards.stream().findFirst().get();
        cards.remove(card);
        return card;
    }

    public Deque() {
        //add all the cards of the suite in cards

    }
}
