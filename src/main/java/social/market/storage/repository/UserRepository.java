package social.market.storage.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import social.market.storage.model.User;
import social.market.storage.repository.interfaces.IUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {


    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public User findByLoginAndPass(String login, String password) {
        TypedQuery<User> query = getEntityManager().createNamedQuery(User.findByLoginAndPass, User.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<User> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }


    @Override
    @Transactional
    public void save(User user) {
        getEntityManager().persist(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        getEntityManager().remove(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        getEntityManager().merge(user);
    }

    @Override
    @Transactional
    public List<User> findAll(){
        TypedQuery<User> query = getEntityManager().createNamedQuery(User.findAll, User.class);
        List<User> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
