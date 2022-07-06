package app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApplicationContext context;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                ////.antMatchers("/kotiki/admin/**").hasAuthority("ADMIN")
                .antMatchers("/**").authenticated()
                .and().httpBasic()
                .and().csrf().disable()
                .formLogin().permitAll();
        /*
                .and()
                .formLogin();
        http.csrf().disable();*/
    }
/*
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder){
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

    private AuthenticationProvider authenticationProvider(){
        PreAuthenticatedAuthenticationProvider authenticationProvider = new PreAuthenticatedAuthenticationProvider();
        authenticationProvider.setPreAuthenticatedUserDetailsService(new PreAuthenticatedGrantedAuthoritiesUserDetailsService());
        return authenticationProvider;
    }
*/

    @Bean
    @Override
    public UserDetailsService userDetailsService() {


        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        System.out.println(passwordEncoder().encode("password100"));
        manager.createUser(User.withUsername("admin").password(passwordEncoder().encode("password100")).roles("ADMIN").build());
        manager.createUser(User.withUsername("user").password(passwordEncoder().encode("password100")).roles("USER").build());
        return manager;
       // passwordEncoder().encode("password100")
/*

        DataSource dataSource= (DataSource) context.getBean(DataSource.class);
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_name as username, password as password, 1 as enabled from users where user_name=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_name as username, case when upper(user_name) like 'ADMIN%' then 'ROLE_ADMIN' else 'ROLE_USER' end as authority from users where user_name=?");

        System.out.println(passwordEncoder().encode("mikamika"));
        return jdbcUserDetailsManager;
*/
    }


}