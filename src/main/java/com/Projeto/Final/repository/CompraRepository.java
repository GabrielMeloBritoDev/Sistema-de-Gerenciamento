package com.Projeto.Final.repository;

import com.Projeto.Final.model.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompraRepository  extends JpaRepository<CompraModel, Long> {
    List<CompraModel> findByCliente_IdAndTipoAndStatus(Long id, String tipo, String status);
    List<CompraModel> findAllByDataCompraBetween(LocalDate inicio, LocalDate fim);
}

