package be.bierhuis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bieren")
public class Bier implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue
	private long bierNr;
	private String naam;
	private BigDecimal alcohol;
	private BigDecimal prijs;
	
//	@ManyToOne(fetch=FetchType.LAZY)
	@OneToOne
	@JoinColumn(name="SoortNr")
	private Soort soort;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BrouwerNr")	
	private Brouwer brouwer;

	protected Bier() {
	}

	public Bier(String naam, BigDecimal alcohol, BigDecimal prijs) {
		this.naam = naam;
		this.alcohol = alcohol;
		this.prijs = prijs;
	}
	
	public long getBierNr() {
		return bierNr;
	}

	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public BigDecimal getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(BigDecimal alcohol) {
		this.alcohol = alcohol;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	public Soort getSoort() {
		return soort;
	}
	public void setSoort(Soort soort) {
		this.soort = soort;
	}
	public Brouwer getBrouwer() {
		return brouwer;
	}
	public void setBrouwer(Brouwer brouwer) {
		this.brouwer = brouwer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bier other = (Bier) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
	
}
