package be.bierhuis.services;

import be.bierhuis.dao.BrouwerDAO;
import be.bierhuis.entities.Brouwer;
import be.bierhuis.util.BrouwerInfo;

public class BrouwerService {
	private final BrouwerDAO brouwerDAO = new BrouwerDAO();
	public Brouwer read(long brouwerNr){
		return brouwerDAO.read(brouwerNr);
	}
	public Iterable<BrouwerInfo> findAll(){
		return brouwerDAO.findAll();
	}
}
