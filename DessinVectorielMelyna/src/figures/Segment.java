package figures;

import java.awt.Graphics2D;

import graphics2DInterpretation.Bibliotheque;
import outils.Crayon;
import outils.Point;

public class Segment implements IChemin{

	private Point point1;
	private Point point2;
	
	public Segment(Point point1, Point point2) {
		super();
		this.point1 = point1;
		this.point2 = point2;
	}
	public Point getPoint1() {
		return point1;
	}
	public void setPoint1(Point point1) {
		this.point1 = point1;
	}
	public Point getPoint2() {
		return point2;
	}
	public void setPoint2(Point point2) {
		this.point2 = point2;
	}
	@Override
	public String dessinerSVG(Crayon crayon) {
		System.out.println(this.getPoint1().getAbscisse());
		System.out.println(crayon.getEpaisseurTrait());
		return "line x1=\"" + this.getPoint1().getAbscisse() + "\" x2=\"" + this.getPoint2().getAbscisse() + "\" y1=\"" + this.getPoint1().getOrdonnee() + "\" y2=\"" + this.getPoint2().getOrdonnee() + "\" stroke=\"" + crayon.getCouleur() + "\" stroke-width=\"" + crayon.getEpaisseurTrait() + "\" ";
		
	}
	@Override
	public void dessinerJAVA(Graphics2D g, Crayon crayon) {
		Bibliotheque.createSegment(g, this, crayon);
		
	}
	@Override
	public void remplirJAVA(Graphics2D g, Crayon crayon) {
		//On ne peut pas remplir un segment
	}
	
	
	
}
