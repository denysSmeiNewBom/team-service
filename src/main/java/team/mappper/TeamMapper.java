package team.mappper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.dto.request.TeamRequestDto;
import team.dto.response.TeamResponseDto;
import team.model.Team;
import team.service.PlayerService;

@Component
public class TeamMapper {
    private final PlayerService playerService;

    @Autowired
    public TeamMapper(PlayerService playerService) {
        this.playerService = playerService;
    }

    public TeamResponseDto mapToDto(Team team) {
        TeamResponseDto teamResponseDto = new TeamResponseDto();
        teamResponseDto.setId(team.getId());
        teamResponseDto.setName(team.getName());
        teamResponseDto.setBudged(team.getBudged());
        teamResponseDto.setCommission(team.getCommission());
        return teamResponseDto;
    }

    public Team mapToModel(TeamRequestDto teamRequestDto) {
        Team team = new Team();
        team.setName(teamRequestDto.getName());
        team.setBudged(teamRequestDto.getBudged());
        team.setCommission(teamRequestDto.getCommission());
        return team;
    }
}
