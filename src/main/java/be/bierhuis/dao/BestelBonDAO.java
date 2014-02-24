package be.bierhuis.dao;

import be.bierhuis.entities.BestelBon;

public class BestelBonDAO extends AbstractDAO{
	public void create(BestelBon bestelBon) {
		getEntityManager().persist(bestelBon);
	}
}
