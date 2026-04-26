package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.*;

public class TestNegocioMJUnit {

    private NegocioMejorado negocio;

    @BeforeEach
    public void setUp() {
        negocio = new NegocioMejorado();
    }

    // ============================
    // generarCodigo()
    // ============================
    @Test
    public void testGenerarCodigoFormato() {
        String codigo = negocio.generarCodigo();
        assertNotNull(codigo);
        assertTrue(codigo.startsWith("M-"));
    }

    // ============================
    // setMaquinas / getMaquinas
    // ============================
    @Test
    public void testSetGetMaquinas() {
        ArrayList<Maquina> lista = new ArrayList<>();
        lista.add(new Maquina("M-1", "Test", "Desc", 1.0));

        negocio.setMaquinas(lista);

        assertEquals(1, negocio.getMaquinas().size());
    }

    // ============================
    // setCliente / getCliente
    // ============================
    @Test
    public void testSetGetClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente("Dennis", "123"));

        negocio.setCliente(lista);

        assertEquals(1, negocio.getCliente().size());
    }

    // ============================
    // agregarMaquina()
    // ============================
    @Test
    public void testAgregarMaquina() {
        boolean res = negocio.agregarMaquina("Pilsener", "Rubia", 0.5);

        assertTrue(res);
        assertEquals(1, negocio.getMaquinas().size());
    }

    // ============================
    // cargarMaquinas()
    // ============================
    @Test
    public void testCargarMaquinas() {
        negocio.agregarMaquina("Pilsener", "Rubia", 1.0);
        negocio.agregarMaquina("Club", "Negra", 1.5);

        negocio.cargarMaquinas();

        for (Maquina m : negocio.getMaquinas()) {
            assertTrue(m.getCapacidadActual() > 0);
        }
    }

    // ============================
    // recuperarMaquina()
    // ============================
    @Test
    public void testRecuperarMaquina() {
        negocio.agregarMaquina("Pilsener", "Rubia", 1.0);

        String codigo = negocio.getMaquinas().get(0).getCodigo();

        Maquina m = negocio.recuperarMaquina(codigo);

        assertNotNull(m);
    }

    @Test
    public void testRecuperarMaquinaNull() {
        Maquina m = negocio.recuperarMaquina("NO-EXISTE");
        assertNull(m);
    }

    // ============================
    // registrarCliente()
    // ============================
    @Test
    public void testRegistrarCliente() {
        negocio.registrarCliente("Dennis", "123");

        Cliente c = negocio.getCliente().get(0);

        assertEquals("Dennis", c.getNombre());
        assertEquals(100, c.getCodigo());
    }

    // ============================
    // buscarClientePorCedula()
    // ============================
    @Test
    public void testBuscarClientePorCedula() {
        negocio.registrarCliente("Dennis", "123");

        Cliente c = negocio.buscarClientePorCedula("123");

        assertNotNull(c);
    }

    @Test
    public void testBuscarClientePorCedulaNull() {
        assertNull(negocio.buscarClientePorCedula("000"));
    }

    // ============================
    // buscarClientePorCodigo()
    // ============================
    @Test
    public void testBuscarClientePorCodigo() {
        negocio.registrarCliente("Dennis", "123");

        Cliente c = negocio.buscarClientePorCodigo(100);

        assertNotNull(c);
    }

    @Test
    public void testBuscarClientePorCodigoNull() {
        assertNull(negocio.buscarClientePorCodigo(999));
    }

    // ============================
    // registrarConsumo()
    // ============================
    @Test
    public void testRegistrarConsumoAcumulado() {
        negocio.registrarCliente("Dennis", "123");

        negocio.registrarConsumo(100, 50);
        negocio.registrarConsumo(100, 30);

        Cliente c = negocio.buscarClientePorCodigo(100);

        assertEquals(80, c.getTotalConsumido());
    }

    // ============================
    // consumirCerveza()
    // ============================
    @Test
    public void testConsumirCervezaCorrecto() {
        negocio.agregarMaquina("Pilsener", "Rubia", 1.0);
        negocio.registrarCliente("Dennis", "123");

        Maquina m = negocio.getMaquinas().get(0);
        m.llenarMaquina();

        negocio.consumirCerveza(100, m.getCodigo(), 100);

        Cliente c = negocio.buscarClientePorCodigo(100);

        assertTrue(c.getTotalConsumido() > 0);
    }

    @Test
    public void testConsumirCervezaSinMaquina() {
        negocio.registrarCliente("Dennis", "123");

        assertDoesNotThrow(() -> {
            negocio.consumirCerveza(100, "XXX", 50);
        });
    }

    @Test
    public void testConsumirCervezaSinCliente() {
        negocio.agregarMaquina("Pilsener", "Rubia", 1.0);

        Maquina m = negocio.getMaquinas().get(0);
        m.llenarMaquina();

        assertDoesNotThrow(() -> {
            negocio.consumirCerveza(999, m.getCodigo(), 50);
        });
    }

    // ============================
    // consultarValorVendido()
    // ============================
    @Test
    public void testConsultarValorVendidoVacio() {
        assertEquals(0, negocio.consultarValorVendido());
    }

    @Test
    public void testConsultarValorVendidoConDatos() {
        negocio.registrarCliente("Dennis", "123");
        negocio.registrarCliente("Juan", "456");

        negocio.registrarConsumo(100, 40);
        negocio.registrarConsumo(101, 60);

        double total = negocio.consultarValorVendido();

        assertEquals(100, total);
    }
}