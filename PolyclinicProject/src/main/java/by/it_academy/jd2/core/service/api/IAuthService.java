package by.it_academy.jd2.core.service.api;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;

public interface IAuthService extends UserDetailsService
        , OAuth2AuthorizedClientService {

    @Override
    default <T extends OAuth2AuthorizedClient> T loadAuthorizedClient(String clientRegistrationId, String principalName){
        return null;
    }

    @Override
    default void removeAuthorizedClient(String clientRegistrationId, String principalName){

    }
}
