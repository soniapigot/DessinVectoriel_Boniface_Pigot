package patronBuilder;

import outils.Couleurs;
import outils.Crayon;
import outils.Etiquette;
import outils.Point;

//Cette classe permet de construire étape par étape une instance de Etiquette
public class EtiquetteBuilder {
	
	private Point point;
	private String etiquette;
	private Crayon crayon;
	
	// Retourne l'instance de Etiquette instanciée avec tous ses attributs
	public Etiquette creerEtiquette(){
		return new Etiquette(this.point, this.etiquette, this.crayon);
	}
	
	// Retourne l'instance de EtiquetteBuilder avec son attribut point instancié
	public EtiquetteBuilder choisirPoint(int abscisse, int ordonnee){
		this.point = new Point(abscisse, ordonnee);
		return this;
	}
	
	// Retourne l'instance de EtiquetteBuilder avec son attribut etiquette instancié
	public EtiquetteBuilder choisirTexte(String texte){
		this.etiquette = texte;
		return this;
	}
	
	// Retourne l'instance de EtiquetteBuilder avec son attribut crayon instancié
		public EtiquetteBuilder choisirCrayon(int epaisseur, Couleurs couleur){
			CrayonBuilder crayonBuilder = new CrayonBuilder();
			this.crayon = crayonBuilder.choisirEpaisseur(epaisseur).choisirCouleur(couleur).creerCrayon();
			return this;
		}

}
