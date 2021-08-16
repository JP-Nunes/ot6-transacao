package com.ot6.transacao.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests(request -> {
                    request
                        .antMatchers(HttpMethod.GET, "/transactions/*")
                            .hasAuthority("SCOPE_transactions:read")
                        .anyRequest().authenticated();
                }).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
