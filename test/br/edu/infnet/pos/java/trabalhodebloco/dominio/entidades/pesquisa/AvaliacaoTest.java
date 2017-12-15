package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import br.edu.infnet.pos.java.trabalhodebloco.test.util.TesteEntidade;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Resposta resposta = new RespostaLikert();
        resposta.setId(ID_RESPOSTA);
        List<Resposta> respostas = new ArrayList<>();
        respostas.add(resposta);
        avaliacao.setRespostas(respostas);
        assertEquals(ID_RESPOSTA, avaliacao.getRespostas().get(0).getId());
    }

    @Test
    public void deveTerInicio() {
        final LocalDate dataHoraInicio = LocalDate.now();
        avaliacao.setInicio(dataHoraInicio);
        assertEquals(dataHoraInicio, avaliacao.getInicio());
    }

    @Test
    public void deveTerFim() {
        final LocalDate fim = LocalDate.now();
        avaliacao.setFim(fim);
        assertEquals(fim, avaliacao.getFim());
    }

    @Test
    public void deveTerObjetivo() {
        final String objetivo = "Este é o objetivo da avaliação";
        avaliacao.setObjetivo(objetivo);
        assertEquals(objetivo, avaliacao.getObjetivo());
    }

    @Test
    public void deveTerOUmCodigoAlfanumerico() {
        final String codigoAlfanumerico = "A2FASDFAS2DAFJGJ";
        avaliacao.setCodigoAlfanumerico(codigoAlfanumerico);
        assertEquals(codigoAlfanumerico, avaliacao.getCodigoAlfanumerico());
    }

    @Test
    public void umaAvaliacaoPodeTerTopicos() {
        final Integer ID_TOPICO = 656773;
        Topico topico = new Topico();
        topico.setId(ID_TOPICO);
        List<Topico> topicos = new ArrayList<>();
        topicos.add(topico);
        avaliacao.setTopicos(topicos);
        assertEquals(ID_TOPICO, avaliacao.getTopicos().get(0).getId());
    }
}
