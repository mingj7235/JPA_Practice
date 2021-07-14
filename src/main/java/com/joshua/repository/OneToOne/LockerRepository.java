package com.joshua.repository.OneToOne;

import com.joshua.domain.OneToOne.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Long> {
}
