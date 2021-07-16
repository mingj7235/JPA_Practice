package com.joshua.service.FootballManager;

import com.joshua.domain.FootballManager.Manager;
import com.joshua.dto.FootballManager.manager.ManagerResponseDto;
import com.joshua.dto.FootballManager.manager.ManagerSaveRequestDto;
import com.joshua.dto.FootballManager.manager.ManagerUpdateRequestDto;
import com.joshua.repository.FootballManager.ManagerRepository;
import com.joshua.repository.FootballManager.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class Manager_Service {
    public final ManagerRepository managerRepository;
    public final TeamRepository teamRepository;

    @Transactional
    public void saveManager (ManagerSaveRequestDto requestDto) {
        Manager manager = requestDto.toEntity();
//        manager.setTeam(teamRepository.findById(requestDto.getTeam_id())
//                .orElseThrow(() -> new IllegalArgumentException("팀이 없슈")));
        managerRepository.save(manager);
    }

    @Transactional
    public void updateManager (Long id, ManagerUpdateRequestDto requestDto) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("매니저 없슴"));

        manager.setManagerName(requestDto.getManagerName());
        manager.setManagerAge(requestDto.getManagerAge());

    }

    @Transactional
    public void deleteManager (Long id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("매니저 없슴"));
        managerRepository.delete(manager);
    }

    @Transactional
    public ManagerResponseDto findManager (Long id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("매니저 없슴"));

        return new ManagerResponseDto(manager);
    }

}
