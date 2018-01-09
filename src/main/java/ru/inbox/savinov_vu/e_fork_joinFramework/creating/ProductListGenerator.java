package main.java.ru.inbox.savinov_vu.e_fork_joinFramework.creating;

import java.util.ArrayList;
import java.util.List;

public class ProductListGenerator {
    public List<Product> generate(int size) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setName("product-" + i);
            product.setPrice(10);
            products.add(product);
        }
        return products;
    }
}

