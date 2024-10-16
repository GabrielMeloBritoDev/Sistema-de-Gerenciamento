package com.Projeto.Final.controller;

import com.Projeto.Final.model.UsuarioModel;
import com.Projeto.Final.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody UsuarioModel usuarioModel) {
        UsuarioModel novoUsuario = usuarioService.criarUsuario(usuarioModel);
        return ResponseEntity.ok(novoUsuario);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable Long usuarioId) {
        return usuarioService.deletarUsuario(usuarioId);
    }

}
