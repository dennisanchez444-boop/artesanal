package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {

    @Test
    public void llenarMaquina() {
        Maquina rub = new Maquina("Pilsener", "Buena Calidad", 0.02, 8000);
        rub.llenarmaquina();
        assertEquals(7900, rub.getCapacidadActual(),0.0001);
    }
}