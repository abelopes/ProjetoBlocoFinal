package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import br.edu.infnet.pos.java.trabalhodebloco.test.util.TesteEntidade;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestaoTest extends TesteEntidade {

    private Questao questao;

    @Before
    public void setUp() {
        questao = new Questao();
    }

    @After
    public void tearDown() {
        questao = null;
    }

    @Test
    public void deveValidarOID() {
        super.deveValidarOID(questao);
    }
    
    @Test
    public void umaQuestaoPodeTerVariasRespostasAssociadas() {
        final Integer ID_RESPOSTA = 9937837;
        Resposta resposta = new Resposta();
        resposta.setId(ID_RESPOSTA);
        List<Resposta> respostas = new ArrayList<>();
        respostas.add(resposta);
        questao.setRespostas(respostas);
        assertEquals(ID_RESPOSTA, questao.getRespostas().get(0).getId());
    }
}
