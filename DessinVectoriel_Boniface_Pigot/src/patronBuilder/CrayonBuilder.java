package patronBuilder;

import outils.Couleurs;
import outils.Crayon;

//Cette classe permet de construire étape par étape une instance de Crayon
public class CrayonBuilder {
	
	private int epaisseurTrait;
	private Couleurs couleur;
	
	// Retourne l'instance de Crayon instanciée avec tous ses attributs
	public Crayon creerCrayon(){
		return new Crayon(this.epaisseurTrait, this.couleur);
	}
	
	// Retourne l'instance de CrayonBuilder avec son attribut epaisseurTrait instancié
	public CrayonBuilder choisirEpaisseur(int epaisseur){
		this.epaisseurTrait = epaisseur;
		return this;
	}
	
	// Retourne l'instance de CrayonBuilder avec son attribut couleur instancié
	public CrayonBuilder choisirCouleur(Couleurs couleur){
		this.couleur = couleur;
		return this;
	}

}
