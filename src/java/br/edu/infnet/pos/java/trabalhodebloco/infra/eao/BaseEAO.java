package br.edu.infnet.pos.java.trabalhodebloco.infra.eao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public abstract class BaseEAO<T> {

	private Class<T> tipoEntidade;
	private EntityManagerFactory emf;

	protected EntityManager em;

	{
		emf = Persistence.createEntityManagerFactory("ProjetoBloco4PU");
		em = emf.createEntityManager();
	}

	public List<T> findAll() {
		String sql = String.format("SELECT e FROM %s e", tipoEntidade.getName());
		TypedQuery<T> query = em.createQuery(sql, tipoEntidade);
		return query.getResultList();
	}

	public void deleteAll() {
		String sql = String.format("DELETE FROM %s", tipoEntidade.getName());
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.createQuery(sql).executeUpdate();
			transaction.commit();
		} catch (Throwable e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public BaseEAO(Class<T> tipoEntidade) {
		this.tipoEntidade = tipoEntidade;
	}

	@Override
	protected void finalize() throws Throwable {
		em.close();
		emf.close();
		super.finalize();
	}

	public void save(T entidade) {
		// TODO Implementar teste se entidade j� existe antes de usar persist ou merge
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(entidade);
			transaction.commit();
		} catch (Throwable e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public T findById(Integer idEntidade) {
		return em.find(tipoEntidade, idEntidade);
	}

}
