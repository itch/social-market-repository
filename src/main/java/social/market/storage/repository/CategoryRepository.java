package social.market.storage.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import social.market.storage.model.Category;
import social.market.storage.model.User;
import social.market.storage.repository.interfaces.ICategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
@EnableTransactionManagement
public class CategoryRepository implements ICategoryRepository {


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
    public List getAllCategory() {
        TypedQuery<Category> query = getEntityManager().createNamedQuery(Category.findAllCategories, Category.class);
        List<Category> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    @Transactional
    public Category getUserRootCategory(User user) {
        TypedQuery<Category> query = getEntityManager().createNamedQuery(Category.findUserRootCategory, Category.class);
        query.setParameter("user", user);
        List<Category> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    @Transactional
    public List<Category> getUserCategories(User user) {
        TypedQuery<Category> query = getEntityManager().createNamedQuery(Category.findUserCategories, Category.class);
        query.setParameter("user", user);
        List<Category> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    @Transactional
    public void save(Category category) {
        getEntityManager().persist(category);
    }

    @Override
    @Transactional
    public void delete(Category category) {
        getEntityManager().remove(category);
    }

    @Override
    @Transactional
    public void update(Category category) {
        getEntityManager().merge(category);
    }
}
