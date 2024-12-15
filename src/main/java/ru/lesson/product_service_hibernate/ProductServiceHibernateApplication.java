package ru.lesson.product_service_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.lesson.product_service_hibernate.entity.Product;
import ru.lesson.product_service_hibernate.repository.ProductRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class ProductServiceHibernateApplication {

    public static void main(String[] args) {
      var context =  SpringApplication.run(ProductServiceHibernateApplication.class, args);

       ProductRepository productRepository =
               context.getBean("productRepository", ProductRepository.class);


       Product product = new Product();
//       product.setName("cola-Rus");
//      product.setPrice(1929.5);
//        product.setCreate_at(LocalDate.now());
//       productRepository.save(product);

        productRepository.updateById(4,"milk",20.0);






    }

}
