package be.bierhuis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="soorten")
public class Soort implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue
	private long soortNr;
	private String naam;
	
	public Soort() {
	}
	
	public Soort(String naam) {
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
}