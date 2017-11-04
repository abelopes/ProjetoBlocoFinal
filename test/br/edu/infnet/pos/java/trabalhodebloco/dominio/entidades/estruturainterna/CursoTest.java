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

    @Test
    public void oMetodoEqualsDeveConsiderarOsIdsDasEntidades() {
        final Integer ID_A = 42;
        Curso a = new Curso();
        a.setId(ID_A);

        final Integer ID_B = 42;
        Curso b = new Curso();
        b.setId(ID_B);

        assertTrue(a.equals(b));
    }
    
    @Test
    public void oMetodoEqualsDeveRetornarFalseQuandoUmObjetoNuloForPassado() {
        assertFalse(new Curso().equals(null));        
    }
    
    @Test
    public void oMetodoEqualsDeveRetornarFalseQuandoUmObjetoPassadoNaoForCurso() {
        assertFalse(new Curso().equals(new Object()));
    }

}
