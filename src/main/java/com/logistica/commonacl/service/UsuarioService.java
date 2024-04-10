package com.logistica.commonacl.service;


import com.logistica.commonacl.entity.Usuario;
import com.logistica.commonacl.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {


    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login);

        if(usuario == null){
            logger.error("No exixte el usuario en el sistema");
            throw  new UsernameNotFoundException("No exixte el usuario en el sistema");
        }


        List<GrantedAuthority> authorityList = usuario.getRoles()
                .stream()
                .map(role->new SimpleGrantedAuthority(role.getDescripcion()))
                .peek(authority -> logger.info("Rol> "+ authority.getAuthority()))
                .collect(Collectors.toList());
        return new User(usuario.getLogin(), usuario.getClave(), true, true, true, true, authorityList);
    }
    
    @Transactional(readOnly = true)
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

}
