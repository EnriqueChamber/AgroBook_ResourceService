package es.agrobook.api.configuration;

import org.springframework.context.annotation.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http.cors(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            ).formLogin(conf -> conf
                //.loginPage("/login")
                .loginProcessingUrl("/generate-token")
                //.defaultSuccessUrl("/")
                //.failureUrl("/login")
            );
            /*.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .oauth2Client(Customizer.withDefaults())
			.formLogin(Customizer.withDefaults());*/
        return http.build();
    }

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}