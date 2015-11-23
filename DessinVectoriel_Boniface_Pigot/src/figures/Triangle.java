package figures;

import java.awt.Graphics2D;

import graphics2DInterpretation.Bibliotheque;
import outils.Crayon;
import outils.Point;

public class Triangle implements IChemin {
	
	private Point p1;
	private Point p2;
	private Point p3;
	
	public Triangle(Point p1, Point p2, Point p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Point getP3() {
		return p3;
	}

	public void setP3(Point p3) {
		this.p3 = p3;
	}

	@Override
	public String dessinerSVG(Crayon crayon) {
		return "polygon points=\"" + this.getP1().getAbscisse() + "," + this.getP1().getOrdonnee() + " " + this.getP2().getAbscisse() + "," + this.getP2().getOrdonnee() + " " + this.getP3().getAbscisse() + "," + this.getP3().getOrdonnee() + "\" stroke=\"" + crayon.getCouleur() + "\" stroke-width=\"" + crayon.getEpaisseurTrait() + "\" ";
		
	}
	@Override
	public void dessinerJAVA(Graphics2D g, Crayon crayon) {
		Bibliotheque.createTriangle(g, this, crayon);
		
	}
	@Override
	public void remplirJAVA(Graphics2D g, Crayon crayon) {
		Bibliotheque.fillTriangle(g, this, crayon);		
	}

}
