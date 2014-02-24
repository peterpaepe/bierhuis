package be.bierhuis.dao;

import javax.persistence.EntityManager;

import be.bierhuis.filters.BierHuisFilter;

public abstract class AbstractDAO {

	public AbstractDAO() {
		super();
	}

	protected EntityManager getEntityManager() {
		return BierHuisFilter.getEntityManager();
	}

	public void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public void commit() {
		getEntityManager().getTransaction().commit();
	}

	public void rollback() {
		getEntityManager().getTransaction().rollback();
	}

}