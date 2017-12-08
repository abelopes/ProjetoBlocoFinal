package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EscalaLikertTest {

    @Test
    public void quantidadeDeOpcoesDeveSerACorreta() {
        assertEquals(6, EscalaLikert.values().length);
    }

    @Test
    public void valoresDevemSerCorretos() {
        assertEquals("Concordo totalmente", EscalaLikert.CONCORDO_TOTALMENTE.getDescricao());
        assertEquals("Concordo", EscalaLikert.CONCORDO.getDescricao());
        assertEquals("Não concordo nem discordo", EscalaLikert.NAO_CONCORDO_NEM_DISCORDO.getDescricao());
        assertEquals("Discordo", EscalaLikert.DISCORDO.getDescricao());
        assertEquals("Discordo totalmente", EscalaLikert.DISCORDO_TOTALMENTE.getDescricao());
        assertEquals("Não sei avaliar", EscalaLikert.NAO_SEI_AVALIAR.getDescricao());
    }

}
