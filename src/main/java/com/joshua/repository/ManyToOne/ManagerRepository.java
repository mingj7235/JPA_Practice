package com.joshua.repository.ManyToOne;

import com.joshua.domain.ManyToOne.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
