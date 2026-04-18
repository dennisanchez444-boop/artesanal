package com.krakedev.artesanal.test.JUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {
   @Test
	public void testRecargaExistoso() {
		Maquina rub = new Maquina("Pilsener", "Buena Calidad", 0.02, 8000);
		boolean recargar = rub.recargarCerveza(3000);
		assertTrue(recargar);
		assertEquals(3000, rub.getCapacidadActual(),0.0001);
	}
   
   @Test
   public void testRecargaFallidaPorDesvorde() {
	   Maquina negra = new Maquina("Club", "cerveza fría", 0.03, 8000);

	   negra.recargarCerveza(7000);

	   boolean resultado =negra.recargarCerveza(1000);

	   assertTrue(resultado);
	   assertEquals(3000, negra.getCapacidadActual(), 0.0001);
	}
}
