package local.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
@EnableWebSecurity
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        /*
         * Não necessita estar autenticado para executar requisição em '/teste',
         * mas precisa para executar qualquer outra requisição.
         * API REST não criará sessão no servidor, ou seja, não manterá estado de nada.
         * Cross site desabilitado -> javascript injection
         */
        http.authorizeRequests()
                .antMatchers("/unidades").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.stateless(true);
    }
}



