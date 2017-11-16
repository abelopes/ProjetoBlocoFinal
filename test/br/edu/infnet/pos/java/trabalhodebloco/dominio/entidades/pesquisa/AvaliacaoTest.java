package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import br.edu.infnet.pos.java.trabalhodebloco.test.util.TesteEntidade;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AvaliacaoTest extends TesteEntidade {

    private Avaliacao avaliacao;

    @Before
    public void setUp() {
        avaliacao = new Avaliacao();
    }

    @After
    public void tearDown() {
        avaliacao = null;
    }

    @Test
    public void deveValidarOID() {
        super.deveValidarOID(avaliacao);
    }
    
    @Test
    public void umaAvaliacaoPodeTerVariasRespostas() {
        final Integer ID_RESPOSTA = 3772934;
        Resposta resposta = new Resposta();
        resposta.setId(ID_RESPOSTA);
        List<Resposta> respostas = new ArrayList<>();
        respostas.add(resposta);
        avaliacao.setRespostas(respostas);
        assertEquals(ID_RESPOSTA, avaliacao.getRespostas().get(0).getId());
    }

    @Test
    public void umaAvaliacaoPodeTerVariasQuestoesPropostas() {
        final Integer ID_QUESTAO = 656773;
        Questao questao = new Questao();
        questao.setId(ID_QUESTAO);
        List<Questao> questoes = new ArrayList<>();
        questoes.add(questao);
        avaliacao.setQuestoes(questoes);
        assertEquals(ID_QUESTAO, avaliacao.getQuestoes().get(0).getId());
    }
}
