package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestConsumiCliente {

	@Test
	public void probarConsumo() {
		Maquina maquinaA = new Maquina("Pilsener", "Rubia", 0.002, 8000);

		Negocio barDeMoe = new Negocio("Bar de Moe", maquinaA);
		
		Cliente cliente = new Cliente("Sanchez","123456");
		
		barDeMoe.cargarMaquinaA();

		barDeMoe.consumirCervezaMaquinaA(cliente, 100);

		assertEquals(7800, maquinaA.getCapacidadActual(),0.0001);
		assertEquals(0.2,cliente.getTotalConsumido(),0.0001);
		
		barDeMoe.consumirCervezaMaquinaA(cliente, 200);
		assertEquals(7600, maquinaA.getCapacidadActual(),0.0001);
		assertEquals(0.6,cliente.getTotalConsumido(),0.0001);
	}
}
