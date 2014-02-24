package be.bierhuis.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adres implements Serializable {
	private static final long serialVersionUID=1L;
	
	private String straat;
	private String huisNr;
	private int postcode;
	private String gemeente;

	protected Adres() {
	}

	public Adres(String straat, String huisNr, int postcode,
			String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public int getPostcode() {
		return postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	@Override
	public String toString() {
		return "Adres [straat=" + straat + ", huisNr=" + huisNr + ", postcode="
				+ postcode + ", gemeente=" + gemeente + "]";
	}
}
