package social.market.storage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import social.market.storage.model.Category;
import social.market.storage.model.Product;
import social.market.storage.model.User;
import social.market.storage.repository.CategoryRepository;
import social.market.storage.repository.ProductRepository;
import social.market.storage.repository.interfaces.IUserRepository;
import social.market.storage.repository.UserRepository;

import java.util.List;


public class Main {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


    public static void main(String[] args) {

        Main main = new Main();
        main.testBean();
    }

    public void testBean() {
        System.out.println(context);
        IUserRepository userRepository = context.getBean(UserRepository.class);
        User user = userRepository.findByLoginAndPass("usr", "usr");
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        List<Product> products = productRepository.getUserProducts(user);
        for(Product product : products){
            System.out.println(product);
        }
                /*
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        Category category = categoryRepository.getUserRootCategory(user);
        System.out.println(category);
        List<Category> children = category.getChildren();
        for (Category cat : children) {
            System.out.println(cat);
        }*/

    }


}
