package com.joshua.service;

import com.joshua.domain.FootballManager.Manager;
import com.joshua.domain.FootballManager.Player;
import com.joshua.domain.FootballManager.Position;
import com.joshua.domain.FootballManager.Team;
import com.joshua.dto.FootballManager.manager.ManagerResponseDtd;
import com.joshua.dto.FootballManager.manager.ManagerSaveRequestDto;
import com.joshua.dto.FootballManager.player.PlayerResponseDto;
import com.joshua.dto.FootballManager.player.PlayerSaveRequestDto;
import com.joshua.dto.FootballManager.player.PlayerUpdateRequestDto;
import com.joshua.dto.FootballManager.team.TeamResponseDto;
import com.joshua.dto.FootballManager.team.TeamSaveRequestDto;
import com.joshua.dto.FootballManager.team.TeamUpdateRequestDto;
import com.joshua.repository.FootballManager.ManagerRepository;
import com.joshua.repository.FootballManager.PlayerRepository;
import com.joshua.repository.FootballManager.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManyToOne_Service {
    private final EntityManager em;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final ManagerRepository managerRepository;

    @Transactional
    public void savePlayer (PlayerSaveRequestDto requestDto) {
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

        player.setPlayerName(requestDto.getPlayerName());
        player.setTeam(teamRepository.findById(requestDto.getTeam_id()).get());

        playerRepository.save(player);
    }

    @Transactional
    public void saveTeam (TeamSaveRequestDto requestDto) {
        Team team = requestDto.toEntity();
        team.setManager(managerRepository.findById(requestDto.getManager_id())
            .orElseThrow( () -> new IllegalArgumentException("메니저 없음")));
        teamRepository.save(team);
    }

    @Transactional
    public void updateTeam (Long id, TeamUpdateRequestDto requestDto) {

        Team team = teamRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("팀이없어요"));
        team.setTeamName(requestDto.getTeamName());
        team.setManager(managerRepository.findById(requestDto.getManager_id())
              .orElseThrow(() -> new IllegalArgumentException("매니저가 없어요")));
    }

    @Transactional
    public TeamResponseDto findPlayersByTeam (Long id) {
        Team team = teamRepository.findById(id).get();
        List<Player> players = team.getPlayers();
        String result = "";
        for (int i = 0; i < players.size(); i ++) {
            String player = team.getPlayers().get(i).getPlayerName();
            if (i == players.size()-1) {
                result += player + "";

            } else {
                result += player + ",";
            }
        }
        System.out.println(team.getTeamName() + "팀의 선수들 :" + result);
//        for (Player player : team.getPlayers()) {
//            System.out.println(team.getTeamName() + "의 선수들 : " + player.getPlayerName());
//        }
        return new TeamResponseDto(team);
    }
    @Transactional
    public void deleteTeam (Long id) {
        Team team = teamRepository.findById(id).get();
        teamRepository.delete(team);
    }

    @Transactional
    public void deletePlayer (Long id) {
        Player player = playerRepository.findById(id).get();
        playerRepository.delete(player);
    }

    @Transactional
    public void saveManager (ManagerSaveRequestDto requestDto) {
        Manager manager = requestDto.toEntity();
        //set을 할 수가 없다! owner가 아니니까! 당연하다!
//        manager.setTeam(teamRepository.findById(requestDto.getTeam_id())
//            .orElseThrow(() -> new IllegalArgumentException("팀이없슴")));

        managerRepository.save(manager);
    }

    @Transactional
    public ManagerResponseDtd findManager (Long id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 감독이 없습니다."));
        return new ManagerResponseDtd(manager);
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
