package com.Projeto.Final.repository;

import com.Projeto.Final.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long > {

    UsuarioModel findByEmail(String email);
}
