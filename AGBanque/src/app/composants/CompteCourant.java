package app.composants;

//1.2.2 Création des classes CompteCourant et CompteEpargne
public class CompteCourant extends Compte {
	
	public CompteCourant() {
		super();
	}


	public CompteCourant(String libelle, Client client, double solde) {
		super();
		this.libelle = libelle;
		this.client = client;
		this.solde = solde;
	}
	
	public CompteCourant(String libelle, int numero_compte) {
		this.libelle=libelle;
		this.numero_compte=numero_compte;
	}
	
	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	public int getNumero_compte() {
		return numero_compte;
	}


	public void setNumero_compte(int numero_compte) {
		this.numero_compte = numero_compte;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Compte [libelle=" + libelle + ", solde=" + solde + ", numero_compte=" + numero_compte + ", client="
				+ client + "]";
	}

}
