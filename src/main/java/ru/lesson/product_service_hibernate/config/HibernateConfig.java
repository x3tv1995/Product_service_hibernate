package ru.lesson.product_service_hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.lesson.product_service_hibernate.entity.Product;

@Configuration
public class HibernateConfig {

    @Bean
    public SessionFactory sessionFactory() {
        return  new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    @Bean
    public Session hibernateSession() {
        return sessionFactory().openSession();
    }
}
