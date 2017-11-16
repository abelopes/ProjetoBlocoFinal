package br.edu.infnet.pos.java.trabalhodebloco.test.util;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.util.Entidade;

import static org.junit.Assert.*;

public abstract class TesteEntidade {
    
    public void deveValidarOID(Entidade entidade) {
        deveSerPossivelAlterarOID(entidade);
    }
 
    private void deveSerPossivelAlterarOID(Entidade entidade) {
        final Integer ID = 42;
        entidade.setId(ID);
        assertEquals(ID, entidade.getId());
    }
    
}
