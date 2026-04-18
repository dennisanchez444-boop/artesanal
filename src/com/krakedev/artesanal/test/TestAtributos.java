package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		Maquina rub = new Maquina("Pilsener","Cerveza rub",0.02);
		rub.imprimir();

		rub.setNombreCerveza("Golden Ale");
		rub.setDescripcion("Cerveza con mas aroma");
		rub.imprimir();
	}

}
