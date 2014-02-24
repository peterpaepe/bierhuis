package be.bierhuis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.bierhuis.valueobjects.Adres;

@Entity
@Table(name="brouwers")
public class Brouwer implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue
	private long brouwerNr;
	private String naam;
	@Embedded
	private Adres adres;
	private BigDecimal omzet;
	@OneToMany(mappedBy="brouwer")
	@OrderBy("naam")
	private Set<Bier> bieren;
	
	protected Brouwer() {
	}

	public Brouwer(String naam, Adres adres, BigDecimal omzet, Set<Bier> bieren) {
		this.naam = naam;
		this.adres = adres;
		this.omzet = omzet;
		this.bieren = bieren;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public BigDecimal getOmzet() {
		return omzet;
	}

	public void setOmzet(BigDecimal omzet) {
		this.omzet = omzet;
	}

	public Set<Bier> getBieren() {
		return Collections.unmodifiableSet(bieren);
	}

	public void addBier(Bier bier) {
		bieren.add(bier);
		if(bier!=null && bier.getBrouwer() != this){
			bier.setBrouwer(this);
		}
	}	
}