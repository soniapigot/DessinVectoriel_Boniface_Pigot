package figures;

import java.awt.Graphics2D;

import graphics2DInterpretation.Bibliotheque;
import outils.Crayon;
import outils.Point;

public class Rectangle implements IChemin{
	
	private Point p;
	private int longueur;
	private int hauteur;
	public Rectangle(Point p, int longueur, int hauteur) {
		super();
		this.p = p;
		this.longueur = longueur;
		this.hauteur = hauteur;
	}
	public Point getP() {
		return p;
	}
	public void setP(Point p) {
		this.p = p;
	}
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	@Override
	public String dessinerSVG(Crayon crayon) {
		return "rect x=\"" + this.getP().getAbscisse() + "\" y=\"" + this.getP().getOrdonnee() + "\" width =\"" + this.getLongueur() + "\" height =\"" + this.getHauteur() + "\" stroke=\"" + crayon.getCouleur() + "\" stroke-width=\"" + crayon.getEpaisseurTrait() + "\" ";
		
	}
	@Override
	public void dessinerJAVA(Graphics2D g, Crayon crayon) {
		Bibliotheque.createRect(g, this, crayon);
		
	}
	@Override
	public void remplirJAVA(Graphics2D g, Crayon crayon) {
		Bibliotheque.fillRect(g, this, crayon);
		
	}

}
