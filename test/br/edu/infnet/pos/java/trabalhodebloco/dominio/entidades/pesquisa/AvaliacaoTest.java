package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import br.edu.infnet.pos.java.trabalhodebloco.test.util.TesteEntidade;
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

}
