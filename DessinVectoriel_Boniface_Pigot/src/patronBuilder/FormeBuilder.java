package patronBuilder;

import figures.IChemin;
import outils.Couleurs;
import outils.Crayon;
import outils.Forme;


// Cette classe permet de construire étape par étape une instance de Forme
public class FormeBuilder {

	private IChemin chemin;
	private Crayon crayonContour = new Crayon(3, Couleurs.black);
	private Crayon crayonRemplir = new Crayon(3, Couleurs.none);
	
	// Retourne l'instance de Forme instanciée avec tous ses attributs
	public Forme creerForme(){
		return new Forme(this.chemin, this.crayonContour, this.crayonRemplir);
	}
	
	// Retourne l'instance de FormeBuilder avec son attribut chemin instancié
	public FormeBuilder ajouterChemin(IChemin chemin){
		this.chemin = chemin;
		return this;
	}
	
	// Retourne l'instance de FormeBuilder avec son attribut crayonContour instancié
	public FormeBuilder ajouterCrayonContour(Crayon crayonContour){
		this.crayonContour = crayonContour;
		return this;
	}
	
	// Retourne l'instance de FormeBuilder avec son attribut crayonRemplir instancié
	// L'utilisateur peut choisir un crayon pour remplir sa forme
	// S'il donne null comme argument, la couleur est instanciée par défaut à TRANSPARENT
	public FormeBuilder ajouterCrayonRemplir(Crayon crayonRemplir){
		if(crayonRemplir == null){
			this.crayonRemplir = new Crayon(1, Couleurs.none);
		}
		this.crayonRemplir = crayonRemplir;
		return this;
	}
	
	
	
	
	
	
}
