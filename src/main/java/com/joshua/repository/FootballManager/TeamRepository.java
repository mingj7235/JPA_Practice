package com.joshua.repository.FootballManager;

import com.joshua.domain.FootballManager.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
