package com.lld.mindtickle.bootstrap;

import com.lld.mindtickle.model.Deque;
import com.lld.mindtickle.model.Game;
import com.lld.mindtickle.model.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrapper implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Deque deque = new Deque();
        //add all cards to deque
        Game game = new Game();
        game.setDeque(deque);
        game.getPlayers().add(new Player("somePlayer"));
        //add 3 more players
        game.playGame();
    }
}
