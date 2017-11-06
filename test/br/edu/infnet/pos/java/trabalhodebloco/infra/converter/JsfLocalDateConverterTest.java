package br.edu.infnet.pos.java.trabalhodebloco.infra.converter;

import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JsfLocalDateConverterTest {

    private JsfLocalDateConverter converter;

    @Before
    public void setUp() {
        converter = new JsfLocalDateConverter();
    }

    @After
    public void tearDown() {
        converter = null;
    }

    @Test
    public void deveConverter12Set1985ParaLocalDate() {
        Object dataConvertida = converter.getAsObject(null, null, "12/09/1985");
        assertNotNull(dataConvertida);
        assertTrue(dataConvertida instanceof LocalDate);
        assertEquals(LocalDate.of(1985, Month.SEPTEMBER, 12), dataConvertida);
    }
    
    @Test
    public void deveAceitarStringVaziaAoConverter() {
        assertNull(converter.getAsObject(null, null, ""));
    }

    @Test
    public void deveConverterLocalDateParaString12Set1985() {
        String stringEsperada = converter.getAsString(null, null, LocalDate.of(1985, Month.SEPTEMBER, 12));
        assertNotNull(stringEsperada);
        assertEquals("12/09/1985", stringEsperada);
    }

}
