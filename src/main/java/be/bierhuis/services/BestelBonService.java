package be.bierhuis.services;

import be.bierhuis.dao.BestelBonDAO;
import be.bierhuis.entities.BestelBon;

public class BestelBonService {
	private final BestelBonDAO bestelbonDAO = new BestelBonDAO();
	public void create(BestelBon bestelBon) {
		bestelbonDAO.beginTransaction();
		bestelbonDAO.create(bestelBon);
		bestelbonDAO.commit();
	}
}
