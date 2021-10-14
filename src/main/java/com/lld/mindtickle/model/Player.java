package com.lld.mindtickle.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Suite suiteForCurrentRound;

    @OneToOne
    private PlayerStrategy playerStrategy = new PlayerStrategy();

//    @OneToMany
//    private Set<PlayerHand> playerHands = ;

    @ManyToMany
    private ArrayList<Card> cards = new ArrayList<>();

    public Card playerHand(Round round){

        Card card = playerStrategy.playerHand(this.cards, round);
        if(suiteForCurrentRound == null){
            suiteForCurrentRound = card.getSuite();
        }

        return card;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerStrategy getPlayerStrategy() {
        return playerStrategy;
    }

    public void setPlayerStrategy(PlayerStrategy playerStrategy) {
        this.playerStrategy = playerStrategy;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
