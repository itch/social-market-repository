package social.market.storage.repository.interfaces;

import social.market.storage.model.Category;
import social.market.storage.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface ICategoryRepository {
    public List getAllCategory();
    public Category getUserRootCategory(User user);
    public List<Category> getUserCategories(User user);
    public void save(Category category);
    public void delete(Category category);
    public void update(Category category);
}
