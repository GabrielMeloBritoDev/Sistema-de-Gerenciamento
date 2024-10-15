package com.Projeto.Final.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ClienteId;
    private String nome;
    private String endereco;
    private String numero;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<CompraModel> compras;

    public Long getClienteId() {
        return ClienteId;
    }

    public void setClienteId(Long clienteId) {
        ClienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<CompraModel> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraModel> compras) {
        this.compras = compras;
    }
}
