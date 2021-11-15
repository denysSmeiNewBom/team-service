package team.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import team.dao.AbstractDao;
import team.dao.PlayerDao;
import team.exception.DataProcessingException;
import team.model.Player;

@Repository
public class PlayerDaoImpl extends AbstractDao implements PlayerDao {
    public PlayerDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<Player> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Player.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get a player by id: " + id, e);
        }
    }

    @Override
    public List<Player> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Player> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Player.class);
            criteriaQuery.from(Player.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all players", e);
        }
    }
}
