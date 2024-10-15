package com.Projeto.Final.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;


@Entity
public class CompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CompraId;



    private String descricao;
    private double valor;
    private LocalDate dataCompra;
    private String status; // Pedente ou está paga fela
    private String tipo; // Fiada ou não

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private ClienteModel clienteModel;

    public ClienteModel getCliente() {
        return clienteModel;
    }

    public void setCliente(ClienteModel cliente) {
        this.clienteModel = cliente;
    }

    public Long getCompraId() {
        return CompraId;
    }

    public void setCompraId(Long compraId) {
        CompraId = compraId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
