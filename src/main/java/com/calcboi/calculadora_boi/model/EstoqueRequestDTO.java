package com.calcboi.calculadora_boi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class EstoqueRequestDTO {

    @Min(0)
    @Schema(description = "Quantidade de bois em estoque", example = "1")
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

    @Schema(description = "Venda total que vai subtrair do estoque", example = "4")
    private Boi venda;

    public EstoqueRequestDTO(){
    }
}
