package elmoukhantar.yass.securitytraining328v.filtrage;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
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
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User.withUsername("hajar").password("{noop}lunix").roles("USER").build();
        UserDetails admin1= User.withUsername("souad").password("{noop}solaris").roles("ADMIN").build();
        UserDetails user3= User.withUsername("taha").password("xpppsjz").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user1, admin1, user3);
    }
}
