package com.nouhoun.springboot.jwt.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig {

    private final PasswordEncoder passwordEncoder;
    private final JwtAccessTokenConverter accessTokenConverter;


    public AuthorizationServerConfig(PasswordEncoder passwordEncoder, JwtAccessTokenConverter accessTokenConverter) {
        this.passwordEncoder = passwordEncoder;
        this.accessTokenConverter = accessTokenConverter;
    }

    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        RegisteredClient registeredClient = RegisteredClient.withId("client")
                .clientId("client")
                .clientSecret(passwordEncoder.encode("secret"))
                .clientAuthenticationMethod(org.springframework.security.oauth2.server.authorization.client.RegisteredClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(org.springframework.security.oauth2.server.authorization.config.ClientSettings.builder().requireAuthorizationConsent(false).build().authorizationGrantTypes().iterator().next())
                .scope("message.read")
                .tokenSettings(TokenSettings.builder().accessTokenTimeToLive(Duration.ofSeconds(3600)).build())
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(false).build())
                .build();
        return new InMemoryRegisteredClientRepository(registeredClient);
    }



    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder().build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


}