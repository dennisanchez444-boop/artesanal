package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		Maquina rub = new Maquina("Club","Cerveza de calidad",0.02,8000);
		rub.imprimir();

		rub.llenarmaquina();
		
		rub.imprimir();
		
		Maquina negra = new Maquina("Pilsaner","Alta calidad",0.03);
		negra.imprimir();
		negra.llenarmaquina();
		negra .imprimir();
	}

}
