package com.calcboi.calculadora_boi.model;

import lombok.Data;

@Data
public class EstoqueRequestDTO {
    private int bois;
    private int bandas;
    private int dianteiros;
    private int traseiros;
    private Boi venda;

    public EstoqueRequestDTO(){}
}
