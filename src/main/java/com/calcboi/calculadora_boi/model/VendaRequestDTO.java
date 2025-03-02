package com.calcboi.calculadora_boi.model;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class VendaRequestDTO {
    @Min(0)
    private int bois;

    @Min(0)
    private int bandas;

    @Min(0)
    private int dianteiros;

    @Min(0)
    private int traseiros;

    public VendaRequestDTO() {
    }
}
