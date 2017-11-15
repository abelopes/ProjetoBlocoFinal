package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModuloTest {
    
    private Modulo modulo;
    
    @Before
    public void setUp() {
        modulo = new Modulo();
    }

    @Test
    public void toStringDeveRetornarONomeDoModulo() {
        final String nome = "Nome do Módulo";
        modulo.setNome(nome);
        assertEquals(nome, modulo.toString());
    }
}
