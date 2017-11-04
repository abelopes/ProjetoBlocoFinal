package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.enums.Sexo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlunoControllerTest {

    private AlunoController controller;

    @Before
    public void setUp() {
        controller = new AlunoController();
    }

    @After
    public void tearDown() {
        controller = null;
    }

    @Test
    public void deveRetornarOsSexosPermitodosAAlunos() {
        assertArrayEquals(Sexo.values(), controller.getSexos());
    }
}
