package br.edu.infnet.pos.java.trabalhodebloco.dominio.enums;

import org.junit.Test;
import static org.junit.Assert.*;

public class SexoTest {

    @Test
    public void deveRetornarADescricaoDosItens() {
        assertEquals("Masculino", Sexo.MASCULINO.getDescricao());
        assertEquals("Feminino", Sexo.FEMININO.getDescricao());
    }

    @Test
    public void deveTerUmNumeroFixoDeSexos() {
        assertEquals(2, Sexo.values().length);
    }

}
