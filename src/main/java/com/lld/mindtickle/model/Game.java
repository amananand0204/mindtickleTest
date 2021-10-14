package com.lld.mindtickle.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private Integer currentRoundNumber = 0;

    private Integer lastRoundWinner = 0;

    private Integer currentPlayerNumber = 0;

    @OneToOne
    private Deque deque = new Deque();

    @OneToMany(cascade = CascadeType.ALL)
    private ArrayList<Player> players = new ArrayList<>();

    @OneToMany
    private Set<Round> rounds = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCurrentRoundNumber() {
        return currentRoundNumber;
    }

    public void setCurrentRoundNumber(Integer currentRoundNumber) {
        this.currentRoundNumber = currentRoundNumber;
    }

    public Integer getLastRoundWinner() {
        return lastRoundWinner;
    }

    public void setLastRoundWinner(Integer lastRoundWinner) {
        this.lastRoundWinner = lastRoundWinner;
    }

    public Integer getCurrentPlayerNumber() {
        return currentPlayerNumber;
    }

    public void setCurrentPlayerNumber(Integer currentPlayerNumber) {
        this.currentPlayerNumber = currentPlayerNumber;
    }

    public Deque getDeque() {
        return deque;
    }

    public void setDeque(Deque deque) {
        this.deque = deque;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Set<Round> getRounds() {
        return rounds;
    }

    public void setRounds(Set<Round> rounds) {
        this.rounds = rounds;
    }

    public Player getLastWinner(){
        return players.get(lastRoundWinner);
    }

    public Player getPlayerTurn(){
        Integer currentTurn = currentPlayerNumber++;
        return players.get(currentTurn);
    }

    public void DistributeCards(){
        int currentPlayer = 0;
        while(!deque.isEmpty()){
            players.get(currentPlayer).getCards().add(deque.getNextCard());
            ++currentPlayer;

            if(currentPlayer >= 4){
                currentPlayer = 0;
            }
        }
    }

    public void playRound(){
        Round round = new Round();
        Player player = round.playRound();
        System.out.println(player.getName() + "won the round");
        rounds.add(round);
    }

    public void playGame(){
        while(rounds.size() < 13){
            playRound();
        }
    }

    public Game(String description, Deque deque) {
        this.description = description;
        this.deque = deque;
    }

    //Implement builder pattern to create game class properly
    public Game() {
    }
}
