package patronBuilder;

import figures.Cercle;
import outils.Point;

//Cette classe permet de construire étape par étape une instance de Cercle
public class CercleBuilder {
	
	private Point centre;
	private int diametre;
	
	
	// Retourne l'instance de Cercle instanciée avec tous ses attributs
	public Cercle creerCercle(){
		return new Cercle(this.centre, this.diametre);
	}
	
	// Retourne l'instance de CercleBuilder avec son attribut centre instancié
	public CercleBuilder choisirCentre(int abscisse, int ordonnee){
		this.centre = new Point(abscisse, ordonnee);
		return this;
	}
	
	// Retourne l'instance de CercleBuilder avec son attribut diametre instancié
	public CercleBuilder choisirDiametre(int diametre){
		this.diametre = diametre;
		return this;
	}

}
