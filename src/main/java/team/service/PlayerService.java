package team.service;

import java.util.List;
import team.model.Player;

public interface PlayerService {
    Player add(Player player);

    Player get(Long id);

    List<Player> getAll();

    Player update(Player player);

    void delete(Player player);
}
