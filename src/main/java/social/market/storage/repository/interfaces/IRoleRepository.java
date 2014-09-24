package social.market.storage.repository.interfaces;

import social.market.storage.model.Role;
import java.util.List;


public interface IRoleRepository {
    public List getAllRoles();
    public void save(Role role);
    public void delete(Role role);
    public void update(Role role);
}