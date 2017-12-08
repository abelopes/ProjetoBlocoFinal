package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TipoQuestaoTest {

    @Test
    public void osValoresDaEnumDevemSerCorretos() {
        assertEquals(2, TipoQuestao.values().length);
        assertEquals("Likert", TipoQuestao.LIKERT.getDescricao());
        assertEquals("Textual", TipoQuestao.TEXTUAL.getDescricao());
    }

}
