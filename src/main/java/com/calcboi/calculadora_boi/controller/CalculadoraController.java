package com.calcboi.calculadora_boi.controller;

import com.calcboi.calculadora_boi.model.Boi;
import com.calcboi.calculadora_boi.model.VendaRequestDTO;
import com.calcboi.calculadora_boi.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping("/calcular-venda")
    public ResponseEntity<Boi> calcularVenda(@RequestBody VendaRequestDTO vendaRequestDTO) {
        Boi resultado = calculadoraService.calcularVendas(
                vendaRequestDTO.getBois(),
                vendaRequestDTO.getBandas(),
                vendaRequestDTO.getDianteiros(),
                vendaRequestDTO.getTraseiros()
        );
        return ResponseEntity.ok(resultado);
    }
}
