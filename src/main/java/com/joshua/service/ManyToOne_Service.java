package com.joshua.service;

import com.joshua.domain.ManyToOne.Player;
import com.joshua.domain.ManyToOne.Position;
import com.joshua.domain.ManyToOne.Team;
import com.joshua.dto.ManyToOne.*;
import com.joshua.repository.ManyToOne.PlayerRepository;
import com.joshua.repository.ManyToOne.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class ManyToOne_Service {
    private final EntityManager em;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public void savePlayer (PlayerSaveRequestDto requestDto) {
//        Team liverpool = new Team();
//        liverpool.setTeamName("Liverpool");
//        em.persist(liverpool);
//
//        Team manU = new Team ();
//        manU.setTeamName("Manchester United");
//        em.persist(manU);

        Player entity = requestDto.toEntity();
        entity.setTeam(teamRepository.findById(requestDto.getTeam_id()).
                orElseThrow( () -> new IllegalArgumentException("해당하는 팀이없어요") ));
        playerRepository.save(entity);
    }

    @Transactional
    public PlayerResponseDto findPlayerById (Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("해당 선수 없음"));
        System.out.println(player.getPlayerName());
        return new PlayerResponseDto (player);
    }
    @Transactional
    public PlayerResponseDto findPlayerByPostion (Position position) {
        Player player = playerRepository.findByPosition(position).get();

        return new PlayerResponseDto(player);
    }

    @Transactional
    public PlayerResponseDto findPlayerByName (String name) {
        Player player = playerRepository.findByPlayerName(name)
                .orElseThrow( () -> new IllegalArgumentException("해당선수업슴"));

        return new PlayerResponseDto(player);
    }

    @Transactional
    public void updatePlayer (Long id, PlayerUpdateRequestDto requestDto) {

        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당선수없음"));

        player.setPlayerName(requestDto.getName());
        player.setTeam(teamRepository.findById(requestDto.getTeam_id()).get());

        playerRepository.save(player);
    }

    @Transactional
    public void saveTeam (TeamSaveRequestDto requestDto) {
        Team team = requestDto.toEntity();
        teamRepository.save(team);
    }

    @Transactional
    public TeamResponseDto findPlayersByTeam (Long id) {
        Team team = teamRepository.findById(id).get();

        for (Player player : team.getPlayers()) {
            System.out.println(team.getTeamName() + "의 선수들 : " + player.getPlayerName());
        }

        return new TeamResponseDto(team);
    }


//    @Transactional
//    public void test () {
//        Member member = new Member();
//        Date date = new Date();
//        member.setName("김민재");
//        member.setDate(date);
//        member.setTime(date);
//        member.setTimestamp(date);
//        em.persist(member);
//    }
//
//    @Transactional
//    public void manyToOne () {
//        Team team = new Team();
//        team.setTeamName("TeamTest");
//        em.persist(team);
//
//        User user = new User();
//        user.setUserName("UserTest");
//
//        //양쪽 객체 둘다에게 데이터를 저장해야한다.
//        //user와 team의 양방향 설정
//        user.setTeam(team);
//        team.getUsers().add(user);
//
//        em.persist(user);
//    }
//
//    public void manyToOneFind () {
//        User user = em.find(User.class, 1L);
//        Team team = em.find(Team.class, 1L);
//
//        System.out.println(user.getUserName());
//        System.out.println(user.getTeam().getTeamName());
//
//        System.out.println(team.getUsers().get(0).getUserName());
//    }


}
