package com.joshua.repository.boardPractice;

import com.joshua.domain.boardPractice.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
