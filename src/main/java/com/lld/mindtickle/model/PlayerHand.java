package com.lld.mindtickle.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PlayerHand {
    @Id
    private Long id;

    @OneToOne
    private Card playedCard;

    @ManyToOne
    private Player player;

    public PlayerHand(Card playedCard, Player player) {
        this.playedCard = playedCard;
        this.player = player;
    }

    public PlayerHand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Card getPlayedCard() {
        return playedCard;
    }

    public void setPlayedCard(Card playedCard) {
        this.playedCard = playedCard;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
