package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ModuloFacade extends AbstractFacade<Modulo> {

    @PersistenceContext(unitName = "ProjetoBloco4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModuloFacade() {
        super(Modulo.class);
    }

    public List<Modulo> buscarModulosPorIdAluno(Integer idAluno) {
        return em.createNamedQuery("Modulo.buscarModulosPorIdAluno", Modulo.class).getResultList();
    }

}
