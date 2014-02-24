package be.bierhuis.dao;

import javax.persistence.TypedQuery;

import be.bierhuis.entities.Brouwer;
import be.bierhuis.util.BrouwerInfo;

public class BrouwerDAO extends AbstractDAO{
	public Brouwer read(long brouwerNr){
		return getEntityManager().find(Brouwer.class, brouwerNr);
	}

	public Iterable<BrouwerInfo> findAll(){
		TypedQuery<BrouwerInfo> query = getEntityManager().createNamedQuery("Brouwer.findAll", BrouwerInfo.class);
		return query.getResultList();
	}
}
