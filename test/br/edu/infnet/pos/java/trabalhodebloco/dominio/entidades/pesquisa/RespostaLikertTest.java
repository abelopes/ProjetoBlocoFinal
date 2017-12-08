package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RespostaLikertTest {

    private RespostaLikert respostaLikert;

    @Before
    public void setUp() {
        respostaLikert = new RespostaLikert();
    }

    @After
    public void tearDown() {
        respostaLikert = null;
    }

    @Test
    public void respostaInicializadaNaoPodeTerValorNull() {
        assertNotNull(respostaLikert.getValor());
    }

    @Test
    public void aoInicializarDeveSerNaoSeiAvaliar() {
        assertEquals(EscalaLikert.NAO_SEI_AVALIAR, respostaLikert.getValor());
    }

    @Test
    public void deveSerPossivelAlterarOValor() {
        respostaLikert.setValor(EscalaLikert.DISCORDO);
        assertEquals(EscalaLikert.DISCORDO, respostaLikert.getValor());
    }

}
