package com.joshua.repository.ManyToOne;

import com.joshua.domain.ManyToOne.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
