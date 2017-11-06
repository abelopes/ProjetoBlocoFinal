package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProfessorTest {

    private Professor professor;

    @Before
    public void setUp() {
        professor = new Professor();
    }

    @After
    public void tearDown() {
        professor = null;
    }

    @Test
    public void toStringDeveRetornarONomeDoProfessor() {
        String nomeProfessor = "Chimbinha John Lenon";
        professor.setNome(nomeProfessor);
        assertEquals(nomeProfessor, professor.toString());
    }

    @Test
    public void equalsDeveConsiderarOIdDoProfessor() {
        final Integer ID_ESPERADO = 42;

        Professor a = new Professor();
        a.setId(ID_ESPERADO);

        Professor b = new Professor();
        b.setId(ID_ESPERADO);

        assertTrue(a.equals(b));
    }

    @Test
    public void equalsDeveConsiderarNull() {
        assertFalse(professor.equals(null));
    }

    @Test
    public void equalsDeveConsiderarOTipoDaClasse() {
        assertFalse(professor.equals(new Object()));
    }

    @Test
    public void equalsDeveConsiderarOTipoDaClassePessoa() {
        final Integer ID_ESPERADO = 12;
        professor.setId(ID_ESPERADO);
        assertFalse(professor.equals(new Pessoa() {
            @Override
            public Integer getId() {
                return ID_ESPERADO;
            }
        }));
    }

}
