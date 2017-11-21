/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporario.bean;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Avaliacao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bruce Notario
 */
@Stateless
public class AvaliacaoFacade extends AbstractFacade<Avaliacao> {

    @PersistenceContext(unitName = "ProjetoBloco4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvaliacaoFacade() {
        super(Avaliacao.class);
    }
    
}
