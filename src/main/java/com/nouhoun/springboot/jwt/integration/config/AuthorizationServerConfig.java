package com.nouhoun.springboot.jwt.integration.config;

import java.util.Arrays;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.context.annotation.Bean;

import com.nouhoun.springboot.jwt.integration.config.CustomUserDetailsService;

/**
 * Created by nydiarra on 06/05/17.
 * <p>
@Configuration


public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Value("${security.jwt.client-id}")
	private String clientId;

	@Value("${security.jwt.client-secret}")
	private String clientSecret = "password";

	@Value("${security.jwt.grant-type}")
	private String grantType = "password";
	private String grantType;

	@Value("${security.jwt.scope-read}")
	private String scopeRead;

	@Value("${security.jwt.scope-write}")
	private String scopeWrite = "write";

	@Value("${security.jwt.resource-ids}")
	private String resourceIds;



	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer
		        .inMemory()
				.withClient(clientId)
 				.secret(passwordEncoder.encode(clientSecret))
		        .authorizedGrantTypes(grantType)
				.scopes(scopeRead, scopeWrite);
// 				.resourceIds(resourceIds);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		endpoints.tokenStore(tokenStore)
		        .accessTokenConverter(jwtAccessTokenConverter())
		        .tokenEnhancer(enhancerChain)
				.userDetailsService(userDetailsService)
		        .authenticationManager(authenticationManager())
		        .pathMapping("/oauth/token", "/api/oauth/token");
	}


// @Override
// public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
// 	security.tokenKeyAccess("isAuthenticated()")
// 	        .checkTokenAccess("isAuthenticated()");
// }

// @Bean
// public AuthenticationManager authenticationManager() {
// 	return new AuthenticationManager();
// }
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("1234567890abcdef");
		return converter;
	DefaultAccessTokenConverter converter = new DefaultAccessTokenConverter();
	converter.setUserTokenConverter(new UserAuthenticationConverter());
	return converter;
	}