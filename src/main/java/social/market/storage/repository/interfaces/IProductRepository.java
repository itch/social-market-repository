package social.market.storage.repository.interfaces;

import social.market.storage.model.Product;
import social.market.storage.model.User;

import java.util.List;


public interface IProductRepository {
    public List<Product> getUserProducts(User user);
    public void save(Product product);
    public void delete(Product product);
    public void update(Product product);
}