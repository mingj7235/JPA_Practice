package com.joshua.repository.ManyToOne;

import com.joshua.domain.ManyToOne.Player;
import com.joshua.domain.ManyToOne.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByPosition (Position position);
    Optional<Player> findByPlayerName (String playerName);
}
