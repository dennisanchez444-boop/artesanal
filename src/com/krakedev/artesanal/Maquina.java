package com.krakedev.artesanal;

public class Maquina {
	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMaxima;
	private double capacidadActual;

	public Maquina(String nombreCerveza, String descripcion, double precioPorMl, double capacidadMaxima) {
		super();
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = capacidadMaxima;
		this.capacidadActual = 0;
	}

	public Maquina(String nombreCerveza, String descripcion, double precioPorMl) {
		super();
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = 10000;
		this.capacidadActual = 0;
	}

	public void llenarmaquina() {
		this.capacidadActual = this.capacidadMaxima - 100;
	}

	public boolean recargarCerveza(double cantidad) {
		double limitePermitido;
		limitePermitido = capacidadMaxima - 100;

		if (capacidadActual + cantidad <= limitePermitido) {
			capacidadActual = capacidadActual + cantidad;
			return true;
		} else {
			return false;
		}
	}

	public double servirCerveza(double cantidad) {

		if (capacidadActual >= cantidad) {
			capacidadActual = capacidadActual - cantidad;
			double valor;
			valor = cantidad * precioPorMl;
			return valor;
		} else {
			return 0;
		}
	}

	public void imprimir() {
		String mensaje;
		mensaje = "Nombre cerveza:" + nombreCerveza + ", Descripcion: " + descripcion + ", Precio por Ml: "
				+ precioPorMl + ", Capacidad Maxima: " + capacidadMaxima + ", Cantidad Actual: " + capacidadActual;
		System.out.println(mensaje);
	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public double getCapacidadActual() {
		return capacidadActual;
	}
}
