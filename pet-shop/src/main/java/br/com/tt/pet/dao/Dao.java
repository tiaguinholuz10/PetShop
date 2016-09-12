package br.com.tt.pet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Dao<T> implements IDao<T> {

	private EntityManager em;
	private final Class<T> type;

	public Dao(Class<T> type) {

		super();
		this.type = type;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pet-shop");
		em = emf.createEntityManager();

	}

	public void salvar(T t) {

		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();

	}

	public T buscar(Long id) {

		return em.find(type, id);

	}

	public List<T> consultar() {

		String sql = "SELECT t From " + type.getName() + " t";
		TypedQuery<T> query = em.createQuery(sql, type);
		return query.getResultList();

	}

	public void excluir(Long id) {

		em.getTransaction().begin();
		em.remove(buscar(id));
		em.getTransaction().commit();

	}

}
