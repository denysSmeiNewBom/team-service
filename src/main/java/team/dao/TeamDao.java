package team.dao;

import java.util.List;
import java.util.Optional;
import team.model.Team;

public interface TeamDao extends GenericDao {
    Optional<Team> get(Long id);

    List<Team> getAll();
}
