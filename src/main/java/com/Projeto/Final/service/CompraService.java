package com.Projeto.Final.service;

import com.Projeto.Final.model.CompraModel;
import com.Projeto.Final.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public boolean compraPodeSerFiada(Long clienteId) {
        List<CompraModel> compraModel = compraRepository.findByClienteIdAndTipoAndStatus(clienteId, "FIADA", "PENDENTE");
        return compraModel.stream()
                .noneMatch(compraModel1 -> {
                    long meses = ChronoUnit.MONTHS.between(compraModel1.getDataCompra(), LocalDate.now());
                    return meses > 5;
                });
    }
}
