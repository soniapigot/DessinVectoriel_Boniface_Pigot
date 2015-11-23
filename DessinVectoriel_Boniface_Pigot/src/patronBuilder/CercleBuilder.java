package patronBuilder;

import figures.Cercle;
import outils.Point;

//Cette classe permet de construire �tape par �tape une instance de Cercle
public class CercleBuilder {
	
	private Point centre;
	private int diametre;
	
	
	// Retourne l'instance de Cercle instanci�e avec tous ses attributs
	public Cercle creerCercle(){
		return new Cercle(this.centre, this.diametre);
	}
	
	// Retourne l'instance de CercleBuilder avec son attribut centre instanci�
	public CercleBuilder choisirCentre(int abscisse, int ordonnee){
		this.centre = new Point(abscisse, ordonnee);
		return this;
	}
	
	// Retourne l'instance de CercleBuilder avec son attribut diametre instanci�
	public CercleBuilder choisirDiametre(int diametre){
		this.diametre = diametre;
		return this;
	}

}
