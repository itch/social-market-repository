package social.market.storage.repository.interfaces;

import social.market.storage.model.User;

import java.util.List;


public interface IUserRepository {
    public User findByLoginAndPass(String login, String password);
    public List<User> findAll();
    public void save(User user);
    public void delete(User user);
    public void update(User user);
}