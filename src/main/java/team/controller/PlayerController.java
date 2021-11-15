package team.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dto.request.PlayerRequestDto;
import team.dto.response.PlayerResponseDto;
import team.mappper.PlayerMapper;
import team.model.Player;
import team.service.PlayerService;
import team.service.TeamService;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;
    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerController(PlayerService playerService,
                            TeamService teamService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.teamService = teamService;
        this.playerMapper = playerMapper;
    }

    @GetMapping("/{id}")
    public PlayerResponseDto get(@PathVariable Long id) {
        return playerMapper.mapToDto(playerService.get(id));
    }

    @GetMapping("/all")
    public List<PlayerResponseDto> getAll() {
        return playerService.getAll().stream()
                .map(playerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public PlayerResponseDto create(@RequestBody PlayerRequestDto requestDto) {
        return playerMapper.mapToDto(playerService
                .add(playerMapper.mapToModel(requestDto)));
    }

    @PutMapping("/{id}")
    public PlayerResponseDto update(
            @PathVariable Long id, @RequestBody PlayerRequestDto requestDto) {
        Player player = playerMapper.mapToModel(requestDto);
        player.setId(id);
        return playerMapper.mapToDto(playerService
                .update(player));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(playerService.get(id));
    }

    @GetMapping("/inject")
    public List<PlayerResponseDto> inject() {
        Player cristianoRonaldo = new Player("Cristiano", "Ronaldo", 36, 123,
                teamService.get(1L));
        playerService.add(cristianoRonaldo);
        Player lionelMessi = new Player("Lionel", "Messi", 34, 100,
                teamService.get(1L));
        playerService.add(lionelMessi);
        Player ikerCasillas = new Player("Iker", "Casillas", 40, 75,
                teamService.get(2L));
        playerService.add(ikerCasillas);
        return getAll();
    }
}
