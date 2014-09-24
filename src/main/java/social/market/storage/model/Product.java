package social.market.storage.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




@Entity
@NamedQueries({
        @NamedQuery(name = Product.findUserProducts, query = "SELECT p FROM Product p WHERE  p.user =:user ")
})
public class Product implements Serializable {
    public final static String findUserProducts = "Product.findUserProducts";

   public Product (){
        categories = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne
    private User user;
    @ManyToMany(mappedBy = "products",fetch=FetchType.EAGER)
    private List<Category> categories;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }



}
