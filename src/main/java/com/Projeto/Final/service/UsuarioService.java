package com.Projeto.Final.service;

import com.Projeto.Final.model.UsuarioModel;
import com.Projeto.Final.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioModel usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(usuario.getFuncao())
                .build();
    }

    public UsuarioModel criarUsuario(UsuarioModel usuarioModel) {
        usuarioModel.setSenha(passwordEncoder.encode(usuarioModel.getSenha()));
        return usuarioRepository.save(usuarioModel);
    }

    public Optional<UsuarioModel> buscarPorId(Long usuarioId) {
        return usuarioRepository.findById(usuarioId);
    }


    public ResponseEntity<Object> deletarUsuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
