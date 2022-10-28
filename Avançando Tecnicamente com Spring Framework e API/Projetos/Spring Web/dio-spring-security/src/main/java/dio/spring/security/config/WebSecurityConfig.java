package dio.spring.security.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity //habilitando segrança de forma manual
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityDatabaseService securityService;

    //autenticação de um gerenciador de autenticações que vai usar o securityService
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll() // define que, para o método de login, só será aceito métodos do tipo POST
                .antMatchers("/managers").hasAnyRole("MANAGERS") // define que se for acessar a rota mangers precisa estar autenticado como na role managers
                .antMatchers("/users").hasAnyRole("USERS", "MANAGERS")
                .anyRequest().authenticated().and()
                .httpBasic(); // usa um cliente HTTP sem exigir tela de login. No Insomnia ele vai pedir essa autenticação na aba "Auth"
                //.formLogin(); // utilizado para autenticação basica atraves de um form de login
    }

    //Geração de acessos em memória, remover quando lidar com autenticação em banco
/*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}123456")
                .roles("USERS")
                .and()
                .withUser("admin")
                .password("{noop}master")
                .roles("MANAGERS");
    }
 */
}
