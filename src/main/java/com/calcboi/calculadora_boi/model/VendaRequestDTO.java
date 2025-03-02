package com.calcboi.calculadora_boi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class VendaRequestDTO {

    @Min(0)
    @Schema(description = "Quantidade de bois vendidos", example = "1")
    private int bois;

    @Min(0)
    @Schema(description = "Quantidade de bandas vendidas", example = "2")
    private int bandas;

    @Min(0)
    @Schema(description = "Quantidade de dianteiros vendidos", example = "3")
    private int dianteiros;

    @Min(0)
    @Schema(description = "Quantidade de traseiros vendidos", example = "4")
    private int traseiros;

    public VendaRequestDTO() {
    }
}