package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RespostaTextualTest {

    private RespostaTextual respostaTextual;

    @Before
    public void setUp() {
        respostaTextual = new RespostaTextual();
    }

    @After
    public void tearDown() {
        respostaTextual = null;
    }

    @Test
    public void aoInicializarValorNaoPodeSerNull() {
        assertNotNull(respostaTextual.getValor());
    }

    @Test
    public void aoInicializarValorDeveSerVazio() {
        assertEquals("", respostaTextual.getValor());
    }
    
    @Test
    public void deveSerPossivelAlterarOValor() {
        final String VALOR_RESPOSTA = "novo valor da resposta";
        respostaTextual.setValor(VALOR_RESPOSTA);
        assertEquals(VALOR_RESPOSTA, respostaTextual.getValor());
    }

}
