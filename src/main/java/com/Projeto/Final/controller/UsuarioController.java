package com.Projeto.Final.controller;

import com.Projeto.Final.model.UsuarioModel;
import com.Projeto.Final.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioModel criarUsuario(@RequestBody UsuarioModel usuarioModel) {
        return usuarioService.criarUsuario(usuarioModel);  // Usa o serviço que criptografa a senha
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioModel> buscarUsuario(@PathVariable Long usuarioId) {
        return usuarioService.buscarPorId(usuarioId)
                .map(usuarioModel -> ResponseEntity.ok(usuarioModel))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable Long usuarioId) {
        return usuarioService.deletarUsuario(usuarioId);
    }
}
