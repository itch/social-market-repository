package social.market.storage.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity

@NamedQueries({
        @NamedQuery(name = Category.findAllCategories, query = "SELECT c FROM Category c "),
        @NamedQuery(name = Category.findUserRootCategory, query = "SELECT c FROM Category c WHERE  c.parent.id = 0 AND c.user =:user "),
        @NamedQuery(name = Category.findUserCategories, query = "SELECT c FROM Category c WHERE  c.user =:user ")
})
public class Category implements Serializable {
    public final static String findUserRootCategory = "Category.findUserRootCategory";
    public final static String findUserCategories = "Category.findUserCategories";
    public final static String findAllCategories = "Category.findAllCategories";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne
    private User user;

    @OneToMany(mappedBy="parent",fetch=FetchType.EAGER)
    private List<Category> children = new LinkedList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parent;


    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "product_category", joinColumns = {
            @JoinColumn(name = "Categories_id")}, inverseJoinColumns = {
            @JoinColumn(name = "Product_id")})
    private List<Product> products;

    public Category(){
        products = new ArrayList<>();
    }



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

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}