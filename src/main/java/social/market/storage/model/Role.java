package social.market.storage.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = Role.ALL, query = "SELECT r FROM Role r")})
public class Role  implements Serializable {
    public Role() {
    }

    public final static String ALL = "Role.all";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    private String roledesc;
    private String rolename;



    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoledesc() {
        return this.roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;
        if (roledesc != null ? !roledesc.equals(role.roledesc) : role.roledesc != null) return false;
        if (rolename != null ? !rolename.equals(role.rolename) : role.rolename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roledesc != null ? roledesc.hashCode() : 0);
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roledesc='" + roledesc + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}