package com.lld.mindtickle.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer currentNumber;

    //add suite of this round

    @OneToMany
    private Set<PlayerHand> playerHands = new HashSet<>();

    @ManyToOne
    private Game game;


    public PlayerHand playHand(Player player){
        Card card = player.playerHand(this);
        PlayerHand playerHand = new PlayerHand(card, player);
        playerHands.add(playerHand);
        return playerHand;
    }

    public Player playRound(){
        while(playerHands.size() < 4){
            playHand(getNextPlayer());
        }

        return determineWinner();
    }

    public Player determineWinner(){
        return playerHands.stream().findAny().get().getPlayer();
    }

    public Player getNextPlayer(){
        return game.getPlayerTurn();
    }

    public Round(Integer currentNumber, Set<PlayerHand> playerHands, Game game) {
        this.currentNumber = currentNumber;
        this.playerHands = playerHands;
        this.game = game;
    }

    public Round() {
    }
}
