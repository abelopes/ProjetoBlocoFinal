package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Resposta;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.RespostaLikert;
import br.edu.infnet.pos.java.trabalhodebloco.test.util.TesteEntidade;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TurmaTest extends TesteEntidade {

    private Turma turma;

    @Before
    public void setUp() {
        turma = new Turma();
    }

    @After
    public void tearDown() {
        turma = null;
    }

    @Test
    public void deveValidarID() {
        super.deveValidarOID(turma);
    }

    @Test
    public void aTurmaPodeTerUmaListaDeRespostasAssociadas() {
        final Integer ID_RESPOSTA = 2342;
        List<Resposta> respostas = new ArrayList<>();
        Resposta resposta = new RespostaLikert();
        resposta.setId(ID_RESPOSTA);
        respostas.add(resposta);
        turma.setRespostas(respostas);
        assertEquals(ID_RESPOSTA, turma.getRespostas().get(0).getId());
    }

}
