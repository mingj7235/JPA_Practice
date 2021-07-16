package com.joshua.service.FootballManager;

import com.joshua.domain.FootballManager.Player;
import com.joshua.dto.FootballManager.player.PlayerResponseDto;
import com.joshua.dto.FootballManager.player.PlayerSaveRequestDto;
import com.joshua.dto.FootballManager.player.PlayerUpdateRequestDto;
import com.joshua.repository.FootballManager.PlayerRepository;
import com.joshua.repository.FootballManager.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class Player_Service {
    public final PlayerRepository playerRepository;
    public final TeamRepository teamRepository;

    @Transactional
    public void savePlayer (PlayerSaveRequestDto requestDto) {
        Player player = requestDto.toEntity();
        player.setTeam(teamRepository.findById(requestDto.getTeam_id())
            .orElseThrow( () -> new IllegalArgumentException("팀이 없슴")));
        playerRepository.save(player);
    }

    @Transactional
    public void updatePlayer (Long id, PlayerUpdateRequestDto requestDto) {
        Player player = playerRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("찾는 선수가 없슈"));
        player.setPlayerName(requestDto.getPlayerName());
        player.setPlayerAge(requestDto.getPlayerAge());
        player.setTeam(teamRepository.findById(requestDto.getTeam_id())
                .orElseThrow(() -> new IllegalArgumentException("찾는 팀이 없슈")));
    }

    @Transactional
    public void deletePlayer (Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 선수 없음"));
        playerRepository.delete(player);
    }

    public PlayerResponseDto findPlayer (Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 선수 없음"));
        return new PlayerResponseDto(player);
    }
 }
