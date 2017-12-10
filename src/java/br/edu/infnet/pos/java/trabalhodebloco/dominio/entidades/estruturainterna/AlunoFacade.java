/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 00175142
 */
@Stateless
public class AlunoFacade extends AbstractFacade<Aluno> {

    @PersistenceContext(unitName = "ProjetoBloco4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlunoFacade() {
        super(Aluno.class);
    }
    
    public List<String> findAllEmailAlunoByModulo(Integer idModulo) {
        String sql = "SELECT P.EMAIL FROM PESSOA AS P JOIN TURMA_ALUNO AS TA ON P.ID = TA.ID_ALUNO" +
                " JOIN TURMA_MODULO AS TM ON TA.ID_TURMA = TM.ID_TURMA WHERE TM.ID_MODULO = " + idModulo;
        return getEntityManager().createNativeQuery(sql).getResultList();
    }
}
