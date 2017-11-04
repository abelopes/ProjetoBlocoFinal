package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CursoTest {

    private Curso curso;

    @Before
    public void setUp() {
        curso = new Curso();
    }

    @After
    public void tearDown() {
        curso = null;
    }

    @Test
    public void toStringDeveRetornarONomeDoCurso() {
        final String NOME_VALIDO = "Sistemas de Informação";
        curso.setNome(NOME_VALIDO);
        assertEquals(NOME_VALIDO, curso.toString());
    }

}
