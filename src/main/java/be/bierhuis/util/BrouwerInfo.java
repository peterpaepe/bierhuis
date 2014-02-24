package be.bierhuis.util;

public class BrouwerInfo {
	private final long brouwerNr;
	private final String naam;
	private final String gemeente;

	public BrouwerInfo(long brouwerNr, String naam, String gemeente) {
		this.brouwerNr = brouwerNr;
		this.naam = naam;
		this.gemeente = gemeente;
	}

	public long getBrouwerNr() {
		return brouwerNr;
	}

	public String getNaam() {
		return naam;
	}

	public String getGemeente() {
		return gemeente;
	}
	
}
