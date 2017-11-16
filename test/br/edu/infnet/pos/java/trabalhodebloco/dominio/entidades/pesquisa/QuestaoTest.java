package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import br.edu.infnet.pos.java.trabalhodebloco.test.util.TesteEntidade;
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
}
