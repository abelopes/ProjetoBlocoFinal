package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlocoTest {

    private Bloco bloco;

    @Before
    public void setUp() {
        bloco = new Bloco();
    }

    @Test
    public void toStringDeveRetornarONome() {
        final String nome = "Nome do Bloco X";
        bloco.setNome(nome);
        assertEquals(nome, bloco.toString());
    }

    @Test
    public void blocosComMesmoIdSaoOMesmoBloco() {
        final Integer ID_BLOCO = 42;

        Bloco blocoA = new Bloco();
        blocoA.setId(ID_BLOCO);

        Bloco blocoB = new Bloco();
        blocoB.setId(ID_BLOCO);

        assertTrue(blocoA.equals(blocoB));
    }

    @Test
    public void deveTestarOTipoDoObjetoNoEquals() {
        assertFalse(bloco.equals(new Object()));
    }

    @Test
    public void equalsRetornaFalseParaNull() {
        assertFalse(bloco.equals(null));
    }
}
