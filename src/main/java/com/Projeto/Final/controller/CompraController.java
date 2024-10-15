package com.Projeto.Final.controller;

import com.Projeto.Final.Exception.CompraNaoPermitidaException;  // Importando a exceção
import com.Projeto.Final.model.CompraModel;
import com.Projeto.Final.repository.ClienteRepository;
import com.Projeto.Final.repository.CompraRepository;
import com.Projeto.Final.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes/{clienteId}/compras")
public class CompraController {

    @Autowired
    CompraRepository compraRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CompraService compraService;

    @PostMapping("/fiada")
    public ResponseEntity<CompraModel> criarCompra(@PathVariable Long clienteId, @RequestBody CompraModel compraModel) {
        return clienteRepository.findById(clienteId)
                .map(clienteModel -> {
                    if (compraModel.getTipo().equals("FIADA") && !compraService.compraPodeSerFiada(clienteId)) {
                        throw new CompraNaoPermitidaException("Compra fiada não permitida. O cliente possui compras pendentes com mais de 5 meses.");
                    }
                    compraModel.setCliente(clienteModel);
                    return ResponseEntity.ok(compraRepository.save(compraModel));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{compraId}/pagar")
    public  ResponseEntity<CompraModel> pagarCompra(@PathVariable Long CompraId){
        return compraRepository.findById(CompraId)
                .map(compraModel -> {
                    compraModel.setStatus("PAGA");
                    return ResponseEntity.ok(compraRepository.save(compraModel));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
