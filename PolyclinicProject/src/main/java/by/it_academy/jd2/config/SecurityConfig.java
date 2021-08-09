package by.it_academy.jd2.config;

import by.it_academy.jd2.core.service.AuthService;
import by.it_academy.jd2.core.service.api.IAuthService;
import by.it_academy.jd2.storage.api.people.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IUserRepository userRepository;

    @Bean
    public IAuthService userDetailsService() {
        return new AuthService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin()
                .defaultSuccessUrl("/profile", true)
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .and().exceptionHandling()
                .and().authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/about_us").permitAll()
                .antMatchers("/contact").permitAll()
                .antMatchers("/disease").permitAll()
                .antMatchers("/departments").permitAll()
                .antMatchers("/index.jsp").permitAll()
                .antMatchers("/users").hasAnyRole("ADMIN", "DOCTOR")
                .antMatchers("/passports").hasAnyRole("ADMIN", "DOCTOR")
                .antMatchers("/address").hasAnyRole("ADMIN", "DOCTOR")
                .anyRequest().authenticated()
        ;
    }

}
