package be.bierhuis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import be.bierhuis.valueobjects.Adres;
import be.bierhuis.valueobjects.BestelBonLijn;

@Entity
@Table(name="bestelbonnen")
public class BestelBon implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue
	private long bonNr;
	private String naam;
	@Embedded
	private Adres adres;

	@ElementCollection
	@CollectionTable(name="bestelbonlijnen", joinColumns=@JoinColumn(name="BonNr"))
	private Set<BestelBonLijn> bestelbonlijnen;
	
	public BestelBon() {
		this.bestelbonlijnen = new HashSet<>();
	}
	public BestelBon(Set<BestelBonLijn> bestelbonlijnen) {
		this.bestelbonlijnen = bestelbonlijnen;
	}
	public BestelBon(String naam, Adres adres,
			Set<BestelBonLijn> bestelbonlijnen) {
		this.naam = naam;
		this.adres = adres;
		this.bestelbonlijnen = bestelbonlijnen;
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
	public long getBonNr() {
		return bonNr;
	}
	public Set<BestelBonLijn> getBestelbonlijnen() {
		return Collections.unmodifiableSet(bestelbonlijnen);
	}
	public void addBestelbonlijnen(BestelBonLijn bestelbonlijn) {
		this.bestelbonlijnen.add(bestelbonlijn);
	}
	public BigDecimal getTotalPrice(){
		BigDecimal totalPrice = BigDecimal.ZERO;
		for(BestelBonLijn bestelbonlijn : bestelbonlijnen){
			totalPrice = totalPrice.add(bestelbonlijn.getTotalBestelbonlijn());
		}
		return totalPrice;
	}
	
}




















