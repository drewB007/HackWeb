package cap.ddg.hack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/","/index","/event/**","/home/**","/bootstrap/**", "/css/**", "/js/**", "/font-awesome/**" ,"/resources/static/**", "/static/bootstrap/**", "/static/js/**", "/webjars/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .logoutSuccessUrl("/login?logout")
                    .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("team1").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("team2").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("team3").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("team4").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("team5").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("team5").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("team6").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("team7").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("team8").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("team9").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("team10").password("password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("admins").password("password").roles("USER");


    }
}
