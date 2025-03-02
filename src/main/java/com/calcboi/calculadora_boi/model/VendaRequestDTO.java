package com.calcboi.calculadora_boi.model;

import lombok.Data;

@Data
public class VendaRequestDTO {
    private int bois;
    private int bandas;
    private int dianteiros;
    private int traseiros;

    public VendaRequestDTO() {
    }
}
