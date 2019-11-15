package edu.csumb.fall19.cst438.webstore.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.csumb.fall19.cst438.webstore.model.Product;
@Component
public class ProductDBSeeder implements CommandLineRunner{
    @Autowired
    ProductRepository productRepo;

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product("Joker", 2019, "Forever alone in a crowd, failed comedian Arthur Fleck seeks connection as he walks the streets of Gotham City. Arthur wears two masks -- the one he paints for his day job as a clown, and the guise he projects in a futile attempt to feel like he's part of the world around him. Isolated, bullied and disregarded by society, Fleck begins a slow descent into madness as he transforms into the criminal mastermind known as the Joker.", "https://i.pinimg.com/474x/3d/d1/7a/3dd17a1dba5b7b0431a20ea5a971c982.jpg", 19.99, 3, "https://www.youtube.com/embed/t433PEQGErc");
        Product p2 = new Product("Birds Of Prey", 2019, "After splitting with the Joker, Harley Quinn joins superheroes Black Canary, Huntress and Renee Montoya to save a young girl from an evil crime lord, Black Mask in Gotham City.", "https://www.joblo.com/assets/images/joblo/posters/2019/10/birds_of_prey_ver2_xlg.jpg", 19.99, 2, "https://www.youtube.com/embed/YjpsGw7YlU8");
        Product p3 = new Product("Jungle Cruise", 2019, "Set during the early 20th century, a riverboat captain named Frank takes a scientist and her brother on a mission into a jungle to find the Tree of Life which is believed to possess healing powers. All the while, the trio must fight against dangerous wild animals and a competing German expedition.","https://www.joblo.com/assets/images/joblo/posters/2019/10/jungle-cruise-poster.jpg", 19.99, 3, "https://www.youtube.com/embed/ydnzilTiBcY");
        
        
        //delete db data
        productRepo.deleteAll();
        //add db seeds
        List<Product> products = Arrays.asList(p1,p2,p3);
        productRepo.saveAll(products);

    }
    
}