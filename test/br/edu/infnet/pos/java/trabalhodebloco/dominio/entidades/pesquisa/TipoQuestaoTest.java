package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TipoQuestaoTest {

    @Test
    public void osValoresDaEnumDevemSerCorretos() {
        assertEquals(TipoQuestao.values().length, 2);
        assertEquals("Likert", TipoQuestao.LIKERT.getDescricao());
        assertEquals("Textual", TipoQuestao.TEXTUAL.getDescricao());
    }

}
