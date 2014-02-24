package be.bierhuis.services;

import be.bierhuis.dao.BierDAO;
import be.bierhuis.entities.Bier;

public class BierService {
	private final BierDAO bierDAO = new BierDAO();
	public Bier read(long bierNr){
		return bierDAO.read(bierNr);
	}
	public long findAantalBieren(){		
		return bierDAO.findAantalBieren();
	}
}
