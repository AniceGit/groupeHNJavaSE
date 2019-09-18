package app.composants;

public abstract class Compte {
	//**********************1.2.1 Création de la classe Compte
	protected String libelle;
	protected double solde;
	protected static int cpt_compte = 1;
	protected int numero_compte=cpt_compte++;
	protected Client client = new Client();
	
	//1.3.2 Creation de flux
	protected Flux flux ;
	

	public Compte() {
		super();
		
	}


	public Compte(String libelle, Client client, double solde) {
		super();
		this.libelle = libelle;
		this.client = client;
		this.solde = solde;
	}
	
	public Compte(String libelle, int numero_compte) {
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


	public void setSolde(Flux flux) {
		//this.flux = flux;
		if(flux.getClass().getName()=="app.composants.Credit") {
			this.solde+=flux.getMontant();
		}else if(flux.getClass().getName()=="app.composants.Debit") {
			this.solde-=flux.getMontant();
		}else {
			if(this.numero_compte==flux.getNumero_compte_cible()) {
				this.solde+=flux.getMontant();
				System.out.println(flux.getCompte_emetteur().toString());
				flux.getCompte_emetteur().setSoldeEmetteur(flux.getCompte_emetteur().getSolde() - flux.getMontant());
			}
		}
	}
	public void setSoldeEmetteur (double solde) {
		this.solde=solde;
	}
	
	public void setSolde(double i) {

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
