/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logistica.commonacl.auth;

import com.logistica.commonacl.entity.Usuario;
import com.logistica.commonacl.repository.UsuarioRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 *
 * @author feyin
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    
    
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        // Obtén los detalles del usuario y añade la información que necesitas
        
        Usuario usuario = (Usuario) usuarioRepository.findByLogin(authentication.getName());                 
        // Puedes añadir más atributos del usuario aquí

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
