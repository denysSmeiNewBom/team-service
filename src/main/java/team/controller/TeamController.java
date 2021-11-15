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
import team.dto.request.TeamRequestDto;
import team.dto.response.TeamResponseDto;
import team.mappper.TeamMapper;
import team.model.Team;
import team.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    /*@Autowired
    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }*/

    @GetMapping("/{id}")
    public TeamResponseDto get(@PathVariable Long id) {
        return teamMapper.mapToDto(teamService.get(id));
    }

    @GetMapping("/all")
    public List<TeamResponseDto> getAll() {
        return teamService.getAll().stream()
                .map(teamMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public TeamResponseDto create(@RequestBody TeamRequestDto requestDto) {
        return teamMapper.mapToDto(teamService
                .add(teamMapper.mapToModel(requestDto)));
    }

    @PutMapping("/{id}")
    public TeamResponseDto update(
            @PathVariable Long id, @RequestBody TeamRequestDto requestDto) {
        Team peam = teamMapper.mapToModel(requestDto);
        peam.setId(id);
        return teamMapper.mapToDto(teamService
                .update(peam));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teamService.delete(teamService.get(id));
    }

    @GetMapping("/inject")
    public List<TeamResponseDto> inject() {
        Team manchesterUnited = new Team("Manchester United F.C.", 0.03, 1_000_000_500L);
        teamService.add(manchesterUnited);
        Team karpatyFK = new Team("FC Karpaty Lviv", 0.01, 500L);
        teamService.add(karpatyFK);
        return getAll();
    }
}
