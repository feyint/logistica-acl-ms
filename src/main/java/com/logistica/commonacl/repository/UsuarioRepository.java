package com.logistica.commonacl.repository;

import com.logistica.commonacl.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
   public Usuario findByLogin(String login);

   public List<Usuario> findAll();


}