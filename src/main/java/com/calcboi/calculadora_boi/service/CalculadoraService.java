package com.calcboi.calculadora_boi.service;

import com.calcboi.calculadora_boi.model.Boi;
import org.springframework.stereotype.Service;

import static java.lang.Math.abs;

@Service
public class CalculadoraService {
    private int calcularBandas(int dianteiros, int traseiros) {
        if (dianteiros == 0 || traseiros == 0) {
            return 0;
        }

        if (dianteiros == traseiros) {
            return dianteiros; // Se são iguais, cada par forma 1 banda
        }

        int diferenca = Math.abs(dianteiros - traseiros);
        return (dianteiros + traseiros - diferenca) / 2;
    }

    public Boi calcularVendas(int bois, int bandas, int dianteiros, int traseiros) {
        Boi boi = new Boi();

        // tratamento de bandas e bois
        bandas += calcularBandas(dianteiros, traseiros);

        if (bandas > 2) {
            if (bandas % 2 == 0) {
                bois += bandas / 2;
                bandas = 0;
            } else {
                bois += (int) bandas/2;
                bandas = 1;
            }
        }

        // Tratamento da sobra de dianteiros e traseiros
        // Zeram pq eu já os considerei bandas no metodo de calcular bandas
        if (dianteiros == traseiros) {
            dianteiros = traseiros = 0;
        }

        if (dianteiros > traseiros) {
            dianteiros = dianteiros - traseiros;
            traseiros = 0;
        } else {
            traseiros = traseiros - dianteiros;
            dianteiros = 0;
        }

        boi.setBois(bois);
        boi.setBandas(bandas);
        boi.setDianteiros(dianteiros);
        boi.setTraseiros(traseiros);

        return boi;
    }

    public Boi calcularSobra(int estoqueBois, int estoqueBandas, int estoqueDianteiros, int estoqueTraseiros, Boi boiVendas) {
        if (boiVendas == null) {
            throw new IllegalArgumentException("Os dados da venda não podem ser nulos.");
        }

        int estoqueTotalDianteiros = estoqueBois * 2 + estoqueBandas + estoqueDianteiros;
        int estoqueTotalTraseiros = estoqueBois * 2 + estoqueBandas + estoqueTraseiros;

        int vendaTotalDianteiros = boiVendas.getBois() * 2 + boiVendas.getBandas() + boiVendas.getDianteiros();
        int vendaTotalTraseiros = boiVendas.getBois() * 2 + boiVendas.getBandas() + boiVendas.getTraseiros();

        return calcularVendas(0, 0, (estoqueTotalDianteiros-vendaTotalDianteiros), (estoqueTotalTraseiros-vendaTotalTraseiros));
    }
}
