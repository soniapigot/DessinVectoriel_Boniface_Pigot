package patronBuilder;

import figures.Rectangle;
import outils.Point;

//Cette classe permet de construire �tape par �tape une instance de Rectangle
public class RectangleBuilder {
	
	private Point p;
	private int longueur;
	private int hauteur;
	
	// Retourne l'instance de Rectangle instanci�e avec tous ses attributs
	public Rectangle creerRectangle(){
		return new Rectangle(this.p, this.longueur, this.hauteur);
	}
	
	// Retourne l'instance de RectangleBuilder avec son attribut Point p instanci�
	public RectangleBuilder choisirPoint(int abscisse, int ordonnee){
		this.p = new Point(abscisse, ordonnee);
		return this;
	}
	
	// Retourne l'instance de RectangleBuilder avec son attribut longueur instanci�
	public RectangleBuilder choisirLongueur(int longueur){
		this.longueur = longueur;
		return this;
	}
	
	// Retourne l'instance de RectangleBuilder avec son attribut hauteur instanci�
	public RectangleBuilder choisirHauteur(int hauteur){
		this.hauteur = hauteur;
		return this;
	}

}
