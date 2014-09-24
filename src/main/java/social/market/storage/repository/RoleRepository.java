package social.market.storage.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import social.market.storage.model.Role;
import social.market.storage.repository.interfaces.IRoleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by x-ray on 07.08.2014.
 */

@Repository
public class RoleRepository implements IRoleRepository {

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
    public List getAllRoles() {
        TypedQuery<Role> query = getEntityManager().createNamedQuery(Role.ALL, Role.class);
        List<Role> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    @Transactional
    public void save(Role role) {
        getEntityManager().persist(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        getEntityManager().remove(role);
    }

    @Override
    @Transactional
    public void update(Role role) {
        getEntityManager().merge(role);
    }
}
