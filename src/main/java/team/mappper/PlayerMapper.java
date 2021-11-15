package team.mappper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.dto.request.PlayerRequestDto;
import team.dto.response.PlayerResponseDto;
import team.model.Player;
import team.service.TeamService;

@Component
public class PlayerMapper {
    private TeamService teamService;

    @Autowired
    public PlayerMapper(TeamService teamService) {
        this.teamService = teamService;
    }

    public Player mapToModel(PlayerRequestDto playerRequest) {
        Player newPlayer = new Player();
        newPlayer.setName(playerRequest.getName());
        newPlayer.setSurname(playerRequest.getSurname());
        newPlayer.setAge(playerRequest.getAge());
        newPlayer.setExperience(playerRequest.getExperience());
        newPlayer.setTeam(teamService.get(playerRequest.getTeamId()));
        return newPlayer;
    }

    public PlayerResponseDto mapToDto(Player player) {
        PlayerResponseDto playerResponseDto = new PlayerResponseDto();
        playerResponseDto.setId(player.getId());
        playerResponseDto.setName(player.getName());
        playerResponseDto.setSurname(player.getSurname());
        playerResponseDto.setAge(player.getAge());
        playerResponseDto.setExperience(player.getExperience());
        playerResponseDto.setTeamId(player.getTeam().getId());
        return playerResponseDto;
    }
}
