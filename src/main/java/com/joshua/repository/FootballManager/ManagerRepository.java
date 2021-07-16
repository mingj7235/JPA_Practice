package com.joshua.repository.FootballManager;

import com.joshua.domain.FootballManager.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findByManagerName (String managerName);
}
