package team.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.dao.PlayerDao;
import team.model.Player;
import team.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerDao playerDao;

    @Autowired
    public PlayerServiceImpl(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Override
    public Player add(Player player) {
        return (Player) playerDao.add(player);
    }

    @Override
    public Player get(Long id) {
        return playerDao.get(id).get();
    }

    @Override
    public List<Player> getAll() {
        return playerDao.getAll();
    }

    @Override
    public Player update(Player player) {
        return (Player) playerDao.update(player);
    }

    @Override
    public void delete(Player player) {
        playerDao.delete(player);
    }
}
