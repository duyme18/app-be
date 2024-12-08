//package com.duyhd.app.config;
//
//import lombok.val;
//import org.keycloak.OAuth2Constants;
//import org.keycloak.admin.client.Keycloak;
//import org.keycloak.admin.client.KeycloakBuilder;
//import org.keycloak.admin.client.resource.GroupsResource;
//import org.keycloak.admin.client.resource.RealmResource;
//import org.keycloak.admin.client.resource.UsersResource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import static org.keycloak.OAuth2Constants.CLIENT_CREDENTIALS;
//
//@Configuration
//public class KeycloakConfiguration {
//
//    @Value("${keycloak.server-url}")
//    private String serverUrl;
//
//    @Value("${keycloak.realm}")
//    private String realm;
//
//    @Value("${keycloak.username}")
//    private String username;
//
//    @Value("${keycloak.password}")
//    private String password;
//
//    @Value("${keycloak.resource}")
//    private String resource;
//
//    @Value("${keycloak.credentials.secret}")
//    private String credentialsSecret;
//
//    @Bean
//    public Keycloak getKeycloak() {
//        val keycloak = KeycloakBuilder.builder()
//                .serverUrl(serverUrl)
//                .grantType(OAuth2Constants.PASSWORD)
//                .realm("master")
//                .clientId("admin-cli")
//                .username("admin")
//                .password("admin")
//                .build();
//        keycloak.tokenManager().getAccessToken();
//
//        return keycloak;
//    }
//
//    @Bean
//    public UsersResource usersResource(final Keycloak keycloak) {
//        return keycloak.realm(realm).users();
//    }
//
//    @Bean
//    public GroupsResource groupResource(final Keycloak keycloak) {
//        return keycloak.realm(realm).groups();
//    }
//}
//
