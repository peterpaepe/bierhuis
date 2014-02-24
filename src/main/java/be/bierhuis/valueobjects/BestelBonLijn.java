package be.bierhuis.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import be.bierhuis.entities.Bier;

@Embeddable
public class BestelBonLijn implements Serializable {
	private static final long serialVersionUID=1L;
	
	@ManyToOne(fetch=FetchType.LAZY)	
	@JoinColumn(name="BierNr")
	private Bier bier;
	
	private long aantal;

	public BestelBonLijn() {
	}

	public BestelBonLijn(Bier bier, long aantal) {
		this.bier = bier;
		this.aantal = aantal;
	}

	public long getAantal() {
		return aantal;
	}

	public void setAantal(long aantal) {
		this.aantal = aantal;
	}

	public Bier getBier() {
		return bier;
	}
	
	public BigDecimal getTotalBestelbonlijn(){
		return getBier().getPrijs().multiply(new BigDecimal(this.getAantal()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bier == null) ? 0 : bier.hashCode());
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
		BestelBonLijn other = (BestelBonLijn) obj;
		if (bier == null) {
			if (other.bier != null)
				return false;
		} else if (!bier.equals(other.bier))
			return false;
		return true;
	}
}