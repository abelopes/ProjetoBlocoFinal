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
    
}
