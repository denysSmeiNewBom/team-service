package team.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.dao.TeamDao;
import team.model.Team;
import team.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamDao teamDao;

    @Autowired
    public TeamServiceImpl(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Override
    public Team add(Team team) {
        return (Team) teamDao.add(team);
    }

    @Override
    public Team get(Long id) {
        return teamDao.get(id).get();
    }

    @Override
    public List<Team> getAll() {
        return teamDao.getAll();
    }

    @Override
    public Team update(Team team) {
        return (Team) teamDao.update(team);
    }

    @Override
    public void delete(Team team) {
        teamDao.delete(team);
    }
}
