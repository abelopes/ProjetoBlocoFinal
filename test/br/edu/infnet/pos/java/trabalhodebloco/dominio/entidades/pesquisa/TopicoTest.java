package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import br.edu.infnet.pos.java.trabalhodebloco.test.util.TesteEntidade;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TopicoTest extends TesteEntidade {

    private Topico topico;

    @Before
    public void setUp() {
        topico = new Topico();
    }

    @After
    public void tearDown() {
        topico = null;
    }

    @Test
    public void deveValidarOID() {
        super.deveValidarOID(topico);
    }

    @Test
    public void deveTerUmTexto() {
        final String TEXTO_QUESTAO = "Avaliação geral da Pós-Graduação:";
        topico.setTexto(TEXTO_QUESTAO);
        assertEquals(TEXTO_QUESTAO, topico.getTexto());
    }

    @Test
    public void deveTerUmaAvaliacaoAssociada() {
        final Integer ID_AVALIACAO = 49234;
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(ID_AVALIACAO);
        topico.setAvaliacao(avaliacao);
        assertEquals(ID_AVALIACAO, topico.getAvaliacao().getId());
    }

    @Test
    public void deveTerVariasQuestoesPropostas() {
        final Integer ID_QUESTAO = 656773;
        Questao questao = new Questao();
        questao.setId(ID_QUESTAO);
        List<Questao> questoes = new ArrayList<>();
        questoes.add(questao);
        topico.setQuestoes(questoes);
        assertEquals(ID_QUESTAO, topico.getQuestoes().get(0).getId());
    }

}
