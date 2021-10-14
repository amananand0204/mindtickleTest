package com.lld.mindtickle.repository;

import com.lld.mindtickle.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
