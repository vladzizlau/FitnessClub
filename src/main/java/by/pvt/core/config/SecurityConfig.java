package by.pvt.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SecurityConfig{


    @Bean
    public PasswordEncoder passwordEncoderByCrypt() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure (HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).httpBasic(Customizer.withDefaults()).authorizeHttpRequests(authorize -> authorize

                .requestMatchers( HttpMethod.POST,"/shop/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST, "/akbedit/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST, "/bodypartedit/**").hasAuthority("Admin")
                .requestMatchers( "/caredit/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST, "/carlampedit/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST, "/engineedit/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST, "/brandtires/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST, "/brandakb/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST, "/tireedit/**").hasAuthority("Admin")
                .requestMatchers("/u/**").hasAuthority("Admin")
                .requestMatchers("/new/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/prod/**").authenticated());
        return http.build();
    }

}