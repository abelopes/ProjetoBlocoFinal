package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import br.edu.infnet.pos.java.trabalhodebloco.test.util.TesteEntidade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Resposta;
import java.util.List;
import java.util.ArrayList;
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
    
    @Test
    public void umAlunoPodeResponderNPerguntas() {
        final Integer ID_RESPOSTA = 53;
        Resposta resposta = new Resposta();
        resposta.setId(ID_RESPOSTA);
        List<Resposta> respostas = new ArrayList<>();
        respostas.add(resposta);
        aluno.setRespostas(respostas);
        final Integer primeira = 0;
        assertEquals(ID_RESPOSTA, aluno.getRespostas().get(primeira).getId());
    }
    
    
}
