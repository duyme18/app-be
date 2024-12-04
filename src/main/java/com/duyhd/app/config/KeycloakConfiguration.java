package com.duyhd.app.config;

import lombok.val;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.GroupsResource;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import static org.keycloak.OAuth2Constants.CLIENT_CREDENTIALS;

@Configuration
public class KeycloakConfiguration {

    @Autowired
    Environment env;

    @Bean
    public Keycloak getKeycloak() {
        return Keycloak.getInstance(
                env.getProperty("keycloak.server-url"),
                env.getProperty("keycloak.realm"),
                env.getProperty("keycloak.username"),
                env.getProperty("keycloak.password"),
                env.getProperty("keycloak.resource"),
                env.getProperty("keycloak.credentials.secret")
        );
    }
}

