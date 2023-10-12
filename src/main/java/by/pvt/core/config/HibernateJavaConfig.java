package by.pvt.core.config;

import by.pvt.core.domain.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;


public class HibernateJavaConfig {
    private final static StandardServiceRegistryBuilder standardServiceRegistryBuilder;
    private final static Configuration configuration;

    static {
        Properties properties = new Properties();

        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.use_sql_comments", "true");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");

        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/fitnessclub");
        properties.setProperty("hibernate.connection.username", "postgres");
        properties.setProperty("hibernate.connection.password", "sa");
        // Подключение КЭШа 2-ого уровня
        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
        properties.setProperty("hibernate.cache.use_query_cache", "true");
        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
        //----
        configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(PremiumUser.class);
        configuration.addAnnotatedClass(Visits.class);
        configuration.addAnnotatedClass(Guest.class);
        configuration.addAnnotatedClass(Workers.class);
        configuration.addAnnotatedClass(Adress.class);
        configuration.addAnnotatedClass(Office.class);
        configuration.addAnnotatedClass(Offer.class);
        configuration.addAnnotatedClass(OfficeSubSelect.class);
        configuration.addAnnotatedClass(Posts.class);
        configuration.setProperties(properties);
        standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        standardServiceRegistryBuilder.applySettings(properties);

    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
        return sessionFactory;
    }
}