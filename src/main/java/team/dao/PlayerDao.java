package team.dao;

import java.util.List;
import java.util.Optional;
import team.model.Player;

public interface PlayerDao extends GenericDao {
    Optional<Player> get(Long id);

    List<Player> getAll();
}
