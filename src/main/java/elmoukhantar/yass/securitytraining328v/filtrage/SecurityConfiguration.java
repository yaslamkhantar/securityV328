package elmoukhantar.yass.securitytraining328v.filtrage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {
            (requests.anyRequest()).authenticated();
        });
        http.sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));// pour cacher les cokies

       // http.formLogin(Customizer.withDefaults()); showing payload
       http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();
    }
}
