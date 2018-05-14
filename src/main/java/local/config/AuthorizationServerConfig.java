package local.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // Autenticação da aplicação
                // Outro usuário poderia ser criado para uma aplicação mobile que acesse a API, por exemplo
                .withClient("web")
                .secret("{noop}w3b")
                .scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token") // Habilitado o refresh token
                .accessTokenValiditySeconds(60 * 60) // Tempo de expiração do token
                .refreshTokenValiditySeconds(60 * 60 * 12); // Tempo de expiração para o refresh token
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore())
                .accessTokenConverter(acessTokenConverter())
                .reuseRefreshTokens(false) // Para não expirar o refresh token
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }


    @Bean
    public JwtAccessTokenConverter acessTokenConverter() {
        JwtAccessTokenConverter access = new JwtAccessTokenConverter();
        access.setSigningKey("senac2018");
        return access;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(acessTokenConverter());
    }


}
