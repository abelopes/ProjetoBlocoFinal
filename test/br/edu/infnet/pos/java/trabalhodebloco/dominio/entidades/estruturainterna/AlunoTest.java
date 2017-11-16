package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import br.edu.infnet.pos.java.trabalhodebloco.test.util.TesteEntidade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlunoTest extends TesteEntidade {
    
    private Aluno aluno;
    
    @Before
    public void setUp() {
        aluno = new Aluno();
    }
    
    @After
    public void tearDown() {
        aluno = null;
    }
    
    @Test
    public void deveValidarID() {
        super.deveValidarOID(aluno);
    }
    
}
