package team.service;

import java.util.List;
import team.model.Team;

public interface TeamService {
    Team add(Team team);

    Team get(Long id);

    List<Team> getAll();

    Team update(Team team);

    void delete(Team team);
}
