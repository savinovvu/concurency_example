package main.java.ru.inbox.savinov_vu.e_fork_joinFramework.creating;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ProductListGenerator productListGenerator = new ProductListGenerator();
        List<Product> products = productListGenerator.generate(10000);
        Task task = new Task(products, 0, products.size(), 0.20);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        System.out.println("===================Main=====================");
        do {
            System.out.println("Main: thread count " + pool.getActiveThreadCount());
            System.out.println("Main: Thread steal " + pool.getStealCount());
            System.out.println("Main: Paralelism " + pool.getParallelism());
            TimeUnit.MILLISECONDS.sleep(5);
        } while (!task.isDone());
        pool.shutdown();
        if (task.isCompletedNormally()) {
            System.out.printf("Main: the process has completed normally.\n");
        }
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getPrice() != 12) {
                System.out.printf("Product %s: %f\n",
                        product.getName(), product.getPrice());
            }

        }
        System.out.println("Main: End of the program.\n");
    }
}
