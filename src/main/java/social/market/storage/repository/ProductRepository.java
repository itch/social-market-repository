package social.market.storage.repository;

import org.eclipse.persistence.annotations.ReadOnly;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import social.market.storage.model.Product;
import social.market.storage.model.User;
import social.market.storage.repository.interfaces.IProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by x-ray on 07.08.2014.
 */

@Repository
public class ProductRepository implements IProductRepository {

    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getUserProducts(User user) {
        TypedQuery<Product> query = getEntityManager().createNamedQuery(Product.findUserProducts, Product.class);
        query.setParameter("user", user);
        List<Product> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    @Transactional
    public void save(Product product) {
        getEntityManager().persist(product);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        getEntityManager().remove(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        getEntityManager().merge(product);
    }


}
