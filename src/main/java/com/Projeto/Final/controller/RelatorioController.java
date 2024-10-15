package com.Projeto.Final.controller;

import com.Projeto.Final.model.CompraModel;
import com.Projeto.Final.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private CompraRepository compraRepository;
    @GetMapping("mensal")
    public ResponseEntity<List<CompraModel>> gerarRelatorio(@RequestParam String papel){
        if(!papel.equals("GERENTE")){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        LocalDate inicioMes = LocalDate.now().withDayOfMonth(1);
        LocalDate fimMes = inicioMes.withDayOfMonth(inicioMes.lengthOfMonth());

        List<CompraModel> compramodel = compraRepository.findAllByDataCompraBetween(inicioMes, fimMes);
        return  ResponseEntity.ok(compramodel);

    }

}
