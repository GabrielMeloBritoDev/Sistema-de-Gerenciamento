package com.Projeto.Final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsuarioModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Usuarioid;
    private String nome;
    private String email;
    private String senha;
    private String  funcao; // Aqui é funcionario ou gerente. Depois colocar apenas um tipo de usuário.

    public Long getUsuarioid() {
        return Usuarioid;
    }

    public void setUsuarioid(Long usuarioid) {
        Usuarioid = usuarioid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
