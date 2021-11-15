package team.dao.impl;

import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.dao.AbstractDao;
import team.dao.TeamDao;
import team.exception.DataProcessingException;
import team.model.Team;

@Repository
public class TeamDaoImpl extends AbstractDao implements TeamDao {
    public TeamDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<Team> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Team> query = session.createQuery("FROM Team t "
                    + "WHERE t.id =:id", Team.class);
            return Optional.ofNullable(query.setParameter("id", id).getSingleResult());
        } catch (Exception e) {
            throw new DataProcessingException("Cannot find team with id : " + id, e);
        }
    }

    @Override
    public List<Team> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Team> query = session.createQuery("FROM Team t ", Team.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot get all teams", e);
        }
    }
}
