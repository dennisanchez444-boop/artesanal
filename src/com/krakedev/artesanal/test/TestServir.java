package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		Maquina rub = new Maquina("Pilsener", "Cerveza rub", 0.02,8000);
		System.out.println("------ESTADO INICIAL------");
		rub.imprimir();
		System.out.println("------LLENANDO MAQUINA------");
		rub.llenarmaquina();
		rub.imprimir();
		System.out.println("------SERVIR 1000ML------");
		double valor=rub.servirCerveza(1000);
		System.out.println("Valor a pagar: "+valor);
		System.out.println("------SERVIR 2000ML------");
		valor =rub.servirCerveza(2000);
		System.out.println("Valor a pagar: "+valor);
		
		valor =rub.servirCerveza(6000);
		System.out.println("Valor a pagar: "+valor);
		
		rub.imprimir();
	}

}
