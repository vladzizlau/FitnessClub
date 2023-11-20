//package by.pvt.core.config;
//
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan("by.pvt.core")
//@PropertySource("app.properties")
//@EnableJpaRepositories("by.pvt.core.repository")
//public class HibernateConfig {
//    @Value("${server.url}")
//    private String url;
//    @Value("${server.driver}")
//    private String driver;
//    @Value("${server.username}")
//    private String username;
//    @Value("${server.password}")
//    private String pass;
//
//    @Value("${hibernate.hbm2ddl.auto}")
//    private String h_Auto;
//    @Value("${hibernate.show_sql}")
//    private String show_sql;
//    @Value("${hibernate.format_sql}")
//    private String format_sql;
//    @Value("${hibernate.dialect}")
//    private String dialect;
//    @Value("${server.packagesToScan}")
//    private String packagesToScan;
//
//
//    @Bean
//    public DataSource getDataSource() {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setDriverClassName(driver);
//        hikariConfig.setJdbcUrl(url);
//        hikariConfig.setUsername(username);
//        hikariConfig.setPassword(pass);
//        return new HikariDataSource(hikariConfig);
//    }
//
//    @Bean
//    public Properties hiberProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", h_Auto);
//        properties.setProperty("hibernate.show_sql", show_sql);
//        properties.setProperty("hibernate.format_sql", format_sql);
//        properties.setProperty("hibernate.dialect", dialect);
//        return properties;
//    }
//
////    @Bean
////    public SessionFactory sessionFactory() throws Exception{
////        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
////        localSessionFactoryBean.setPackagesToScan(packagesToScan);
////        localSessionFactoryBean.setDataSource(dataSource());
////        localSessionFactoryBean.setHibernateProperties(hiberProperties());
////        localSessionFactoryBean.afterPropertiesSet();
////        return localSessionFactoryBean.getObject();
////    }
//
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        localContainerEntityManagerFactoryBean.setDataSource(getDataSource());
//        localContainerEntityManagerFactoryBean.setJpaProperties(hiberProperties());
//        localContainerEntityManagerFactoryBean.setPackagesToScan(packagesToScan);
//        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        return localContainerEntityManagerFactoryBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return transactionManager;
//    }
//
//
//}
