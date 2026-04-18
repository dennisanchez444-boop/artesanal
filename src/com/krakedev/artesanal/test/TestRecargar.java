package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {

	public static void main(String[] args) {
		Maquina rub = new Maquina("Pilsener", "Cerveza rub", 0.02);
		System.out.println("------ESTADO INICIAL------");
		rub.imprimir();
		System.out.println("------RECARGA 1------");
		boolean resultado = rub.recargarCerveza(3000);
		System.out.println("¿Se recargo correcatamente?" + resultado);
		rub.imprimir();
		System.out.println("------RECARGA 2------");
		boolean resultado2 = rub.recargarCerveza(2000);
		System.out.println("¿Se recargo correcatamente?" + resultado2);
		rub.imprimir();
		System.out.println("------RECARGA 3------");
		boolean resultado3 = rub.recargarCerveza(2900);
		System.out.println("¿Se recargo correcatamente?" + resultado3);
		rub.imprimir();
	}

}
