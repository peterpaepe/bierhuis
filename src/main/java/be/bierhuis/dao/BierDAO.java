package be.bierhuis.dao;

import javax.persistence.TypedQuery;

import be.bierhuis.entities.Bier;

public class BierDAO extends AbstractDAO{
	public Bier read(long bierNr){
		return getEntityManager().find(Bier.class, bierNr);
	}
	public long findAantalBieren(){
		TypedQuery<Long> query = getEntityManager().createNamedQuery("Bier.findAantalBieren", Long.class);
		return query.getSingleResult();
	}
}
