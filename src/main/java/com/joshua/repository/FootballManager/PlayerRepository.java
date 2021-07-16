package com.joshua.repository.FootballManager;

import com.joshua.domain.FootballManager.Player;
import com.joshua.domain.FootballManager.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByPosition (Position position);
    Optional<Player> findByPlayerName (String playerName);
    Optional<Player> deleteByPlayerName (String playerName);
}
