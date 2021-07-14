package com.joshua.repository.OneToOne;

import com.joshua.domain.OneToOne.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
