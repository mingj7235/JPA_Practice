package com.joshua.repository.ManyToOne;

import com.joshua.domain.ManyToOne.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
