package patronBuilder;

import figures.Carre;
import outils.Point;

//Cette classe permet de construire �tape par �tape une instance de Carre
public class CarreBuilder {
	
	private Point p;
	private int cote;
	
	// Retourne l'instance de Carre instanci�e avec tous ses attributs
	public Carre creerCarre(){
		return new Carre(this.p, this.cote);
	}
	
	// Retourne l'instance de CarreBuilder avec son attribut Point p instanci�
	public CarreBuilder choisirPointOrigine(int abscisse, int ordonnee){
		this.p = new Point(abscisse, ordonnee);
		return this;
	}
	
	// Retourne l'instance de CarreBuilder avec son attribut longueur instanci�
	public CarreBuilder choisirLongueurCote(int cote){
		this.cote = cote;
		return this;
	}
	


}
