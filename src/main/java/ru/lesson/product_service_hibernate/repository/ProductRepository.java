package ru.lesson.product_service_hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import ru.lesson.product_service_hibernate.entity.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public class ProductRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    private Session session;


    public ProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Product product) {
        session.beginTransaction();
        session.persist(product);
        session.getTransaction().commit();
    }

    public Product getByID(long id) {
        try (Session session = sessionFactory.openSession()) {
            Product product = session.get(Product.class, id);
            if (product == null) {
                System.out.println("Product with ID " + id + " not found");
                return null;
                
            }
            return product;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void delete(long id) {
        session.beginTransaction();
        session.delete(getByID(id));
        session.getTransaction().commit();
    }


    //getByID deleteById updateById

    public void updateById(long id, String product, double price) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Product existingProduct = session.get(Product.class, id);

            if (existingProduct != null) {
                // 2. Delete the existing record
                existingProduct.setPrice(price);
                existingProduct.setName(product);
                existingProduct.setCreate_at(LocalDate.now());

                session.persist(existingProduct);


            } else {
                System.out.println("Product with ID " + id + " not found");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
