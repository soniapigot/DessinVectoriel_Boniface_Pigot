package figures;

import java.awt.Graphics2D;

import graphics2DInterpretation.Bibliotheque;
import outils.Crayon;
import outils.Point;

public class Cercle implements IChemin{
	
	private Point centre;
	private int diametre;
	
	public Cercle(Point centre, int diametre) {
		super();
		this.centre = centre;
		this.diametre = diametre;
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	public int getDiametre() {
		return diametre;
	}

	public void setDiametre(int diametre) {
		this.diametre = diametre;
	}

	@Override
	public String dessinerSVG(Crayon crayon) {
		return "circle cx=\"" + this.getCentre().getAbscisse() + "\" cy=\"" + this.getCentre().getOrdonnee() + "\" r=\"" + this.getDiametre() + "\" stroke=\"" + crayon.getCouleur() + "\" stroke-width=\"" + crayon.getEpaisseurTrait() + "\" " ;
		
	}

	@Override
	public void dessinerJAVA(Graphics2D g, Crayon crayon) {
		Bibliotheque.createCercle(g, this, crayon);
		
	}
	@Override
	public void remplirJAVA(Graphics2D g, Crayon crayon) {
		Bibliotheque.fillCercle(g, this, crayon);
		
	}
	
	

}
