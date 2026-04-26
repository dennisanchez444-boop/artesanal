package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes;
	private int ultimoCodigo = 100;

	public NegocioMejorado() {
		this.maquinas = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}

	public ArrayList<Cliente> getCliente() {
		return clientes;
	}

	public void setCliente(ArrayList<Cliente> cliente) {
		this.clientes = cliente;
	}

	public String generarCodigo() {
		int numero = (int) (Math.random() * 100) + 1;
		return "M-" + numero;
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public boolean agregarMaquina(String nombre, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();
		Maquina maquinaRecuperada = recuperarMaquina(codigo);
		if (maquinaRecuperada == null) {
			Maquina maquina = new Maquina(codigo, nombre, descripcion, precioPorMl);
			maquinas.add(maquina);
			return true; 
		}
		return false;
	}

	public void cargarMaquinas() {
		for (int i = 0; i < maquinas.size(); i++) {
			maquinas.get(i).llenarMaquina();
		}
	}

	public Maquina recuperarMaquina(String codigo) {
		for (int i = 0; i < maquinas.size(); i++) {
			if (maquinas.get(i).getCodigo().equals(codigo)) {
				return maquinas.get(i);
			}
		}
		return null;
	}

	public void registrarCliente(String nombre, String cedula) {
		Cliente cliente = new Cliente(nombre, cedula);
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo++;
		clientes.add(cliente);
	}

	public Cliente buscarClientePorCedula(String cedula) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCedula().equals(cedula)) {
				return clientes.get(i);
			}
		}
		return null;
	}

	public Cliente buscarClientePorCodigo(int codigo) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCodigo() == codigo) {
				return clientes.get(i);
			}
		}
		return null;
	}

	public void consumirCerveza(int codigoC, String codigoM, double cantidad) {
		Maquina maquinaR = recuperarMaquina(codigoM);
		Cliente clienteR = buscarClientePorCodigo(codigoC);

		if (maquinaR != null && clienteR != null) {
			double valorCerveza = maquinaR.servirCerveza(cantidad);
			registrarConsumo(codigoC, valorCerveza);
		}
	}

	public void registrarConsumo(int codigo, double valor) {
		Cliente cliente = buscarClientePorCodigo(codigo);

		cliente.setTotalConsumido(valor + cliente.getTotalConsumido());
	}

	public double consultarValorVendido() {
		double totalVendido = 0;
		for (int i = 0; i < clientes.size(); i++) {
			totalVendido += clientes.get(i).getTotalConsumido();
		}
		return totalVendido;
	}
}