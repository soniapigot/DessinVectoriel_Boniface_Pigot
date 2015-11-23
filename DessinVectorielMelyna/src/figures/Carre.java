package figures;

import java.awt.Graphics2D;

import graphics2DInterpretation.Bibliotheque;
import outils.Crayon;
import outils.Point;

public class Carre implements IChemin{
	
	private Point p;
	private int cote;
	
	public Carre(Point p, int cote) {
		
		this.p = p;
		this.cote = cote;
	}
	public Point getP() {
		return p;
	}
	public void setP(Point p) {
		this.p = p;
	}
	public int getCote() {
		return cote;
	}
	public void setCote(int cote) {
		this.cote = cote;
	}
	@Override
	public String dessinerSVG(Crayon crayon) {
		return "rect x=\"" + this.getP().getAbscisse() + "\" y=\"" + this.getP().getOrdonnee() + "\" width =\"" + this.getCote() + "\" height =\"" + this.getCote() + "\" stroke=\"" + crayon.getCouleur() + "\" stroke-width=\"" + crayon.getEpaisseurTrait() + "\" ";
		
	}
	@Override
	public void dessinerJAVA(Graphics2D g, Crayon crayon) {
		Bibliotheque.createCarre(g, this, crayon);
		
	}
	@Override
	public void remplirJAVA(Graphics2D g, Crayon crayon) {
		Bibliotheque.fillCarre(g, this, crayon);
		
	}
	

}
