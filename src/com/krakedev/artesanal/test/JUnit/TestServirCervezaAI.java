package com.krakedev.artesanal.test.JUnit;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

import static org.junit.jupiter.api.Assertions.*;

public class TestServirCervezaAI {

    private static final double TOLERANCIA = 0.0001;

    /**
     * Caso: la máquina tiene suficiente cerveza.
     * Se debe servir correctamente, descontar del stock
     * y retornar el valor a pagar.
     */
    @Test
    void testServirConStockSuficiente() {
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.5, 1000);
        maquina.recargarCerveza(500); // dejamos capacidadActual en 500

        double pago = maquina.servirCerveza(200);

        assertEquals(100.0, pago, TOLERANCIA); // 200 * 0.5
        assertEquals(300.0, maquina.getCapacidadActual(), TOLERANCIA);
    }

    /**
     * Caso: no hay suficiente cerveza.
     * No debe servir nada, no cambia el stock y retorna 0.
     */
    @Test
    void testNoSirvePorFaltaDeStock() {
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.5, 1000);
        maquina.recargarCerveza(100);

        double pago = maquina.servirCerveza(200);

        assertEquals(0.0, pago, TOLERANCIA);
        assertEquals(100.0, maquina.getCapacidadActual(), TOLERANCIA);
    }

    /**
     * Caso: se sirve exactamente toda la cerveza disponible.
     * El stock debe quedar en 0.
     */
    @Test
    void testServirCantidadExacta() {
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.5, 1000);
        maquina.recargarCerveza(300);

        double pago = maquina.servirCerveza(300);

        assertEquals(150.0, pago, TOLERANCIA);
        assertEquals(0.0, maquina.getCapacidadActual(), TOLERANCIA);
    }

    /**
     * Caso: se solicita servir 0 ml.
     * No debe modificar el estado y retorna 0.
     */
    @Test
    void testServirCero() {
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.5, 1000);
        maquina.recargarCerveza(400);

        double pago = maquina.servirCerveza(0);

        assertEquals(0.0, pago, TOLERANCIA);
        assertEquals(400.0, maquina.getCapacidadActual(), TOLERANCIA);
    }

    /**
     * Caso: usando el segundo constructor.
     * Verifica comportamiento correcto con capacidad máxima por defecto (10000).
     */
    @Test
    void testConstructorSinCapacidadMaxima() {
        Maquina maquina = new Maquina("IPA", "Amarga", 0.8);
        maquina.recargarCerveza(500);

        double pago = maquina.servirCerveza(200);

        assertEquals(160.0, pago, TOLERANCIA); // 200 * 0.8
        assertEquals(300.0, maquina.getCapacidadActual(), TOLERANCIA);
    }

    /**
     * Caso: intentar servir más de lo disponible después de varias operaciones.
     * Valida que el estado se mantenga correcto.
     */
    @Test
    void testIntentoExcederStock() {
        Maquina maquina = new Maquina("Stout", "Oscura", 1.0, 1000);
        maquina.recargarCerveza(250);

        maquina.servirCerveza(100); // queda 150
        double pago = maquina.servirCerveza(200); // no alcanza

        assertEquals(0.0, pago, TOLERANCIA);
        assertEquals(150.0, maquina.getCapacidadActual(), TOLERANCIA);
    }
}