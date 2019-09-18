package app.composants;

public class Client {
	//**************1.1.1Création de la classe Client**************
	String nom;
	String prenom;
	private static int cpt_client = 1;
	int numero_client; 
	
	public Client() {
		super();
	}
	
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		numero_client = cpt_client++;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNumero_client() {
		return numero_client;
	}

	public void setNumero_client(int numero_client) {
		this.numero_client = numero_client;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", numero_client=" + numero_client + "]";
	}
	
	
	

}
