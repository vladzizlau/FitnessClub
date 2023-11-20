package by.pvt.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan("by.pvt.core")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("by.pvt.core.repository")
@EnableSpringDataWebSupport
@EntityScan("by.pvt.core")
public class SpringConfig implements WebMvcConfigurer {
    @Autowired
    private ApplicationContext applicationContext;



}
