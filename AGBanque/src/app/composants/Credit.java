package app.composants;

import java.time.LocalDateTime;

//1.3.3 Création des classes Virement, Credit, Debit
public class Credit extends Flux {

	public Credit() {
		super();
	}

	public Credit(String commentaire, String identifiant, double montant, int numero_compte_cible, boolean effectue,
			LocalDateTime date_flux) {
		super();
		this.commentaire = commentaire;
		this.identifiant = identifiant;
		this.montant = montant;
		this.numero_compte_cible = numero_compte_cible;
		this.effectue = effectue;
		this.date_flux = date_flux;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getNumero_compte_cible() {
		return numero_compte_cible;
	}

	public void setNumero_compte_cible(int numero_compte_cible) {
		this.numero_compte_cible = numero_compte_cible;
	}

	public boolean isEffectue() {
		return effectue;
	}

	public void setEffectue(boolean effectue) {
		this.effectue = effectue;
	}

	public LocalDateTime getDate_flux() {
		return date_flux;
	}

	public void setDate_flux(LocalDateTime date_flux) {
		this.date_flux = date_flux;
	}

	@Override
	public String toString() {
		return "Crédit [commentaire=" + commentaire + ", identifiant=" + identifiant + ", montant=" + montant
				+ ", numero_compte_cible=" + numero_compte_cible + ", effectue=" + effectue + ", date_flux=" + date_flux
				+ "]";
	}
}
