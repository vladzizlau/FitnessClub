package by.pvt.core.config;

import by.pvt.core.domain.Offer;
import by.pvt.core.domain.Office;
import by.pvt.core.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;


public class HibernateJavaConfig {
    private final static StandardServiceRegistryBuilder standardServiceRegistryBuilder;
    private final static Configuration configuration;

    static {
        Properties properties = new Properties();

        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.use_sql_comments", "true");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");

        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/fitnessclub");
        properties.setProperty("hibernate.connection.username", "postgres");
        properties.setProperty("hibernate.connection.password", "sa");

        configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Office.class);
        configuration.addAnnotatedClass(Offer.class);
        configuration.setProperties(properties);
        standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        standardServiceRegistryBuilder.applySettings(properties);

    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
        return sessionFactory;
    }
}