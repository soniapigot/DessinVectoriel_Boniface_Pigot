package patronBuilder;

import figures.Triangle;
import outils.Point;

//Cette classe permet de construire �tape par �tape une instance de Triangle
public class TriangleBuilder {
	
	private Point p1;
	private Point p2;
	private Point p3;
	
	// Retourne l'instance de Triangle instanci�e avec tous ses attributs
	public Triangle creerTriangle(){
		return new Triangle(this.p1, this.p2, this.p3);
	}
	
	// Retourne l'instance de TriangleBuilder avec son attribut p1 instanci�
	public TriangleBuilder choisirPoint1(int abscisse, int ordonnee){
		this.p1 = new Point(abscisse, ordonnee);
		return this;
		
	}
	
	// Retourne l'instance de TriangleBuilder avec son attribut p2 instanci�
	public TriangleBuilder choisirPoint2(int abscisse, int ordonnee){
		this.p2 = new Point(abscisse, ordonnee);
		return this;
		
	}
	
	// Retourne l'instance de TriangleBuilder avec son attribut p3 instanci�
	public TriangleBuilder choisirPoint3(int abscisse, int ordonnee){
		this.p3 = new Point(abscisse, ordonnee);
		return this;
		
	}

}
