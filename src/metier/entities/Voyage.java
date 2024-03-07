package metier.entities;

import java.io.Serializable;

public class Voyage implements Serializable{
	private Long idVoyage;
	private String nomVoyage;
	private double prix;
	
	public Voyage() {
		super();
	}
	public Voyage(String nomVoyage, double prix) {
		super();
		this.nomVoyage = nomVoyage;
		this.prix = prix;
	}
	public Long getIdVoyage() {
		return idVoyage;
	}
	public void setIdVoyage(Long idVoyage) {
		this.idVoyage = idVoyage;
	}
	public String getNomVoyage() {
		return nomVoyage;
	}
	public void setNomVoyage(String nomVoyage) {
		this.nomVoyage = nomVoyage;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Voyage [idVoyage=" + idVoyage + ", nomVoyage=" + nomVoyage + ", prix=" + prix + "]";
	}
	
	
	
}

