package com.joshua.repository.ManyToOne;

import com.joshua.domain.ManyToOne.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findByName (String managerName);
}
