package patronBuilder;

import figures.Segment;
import outils.Point;

//Cette classe permet de construire �tape par �tape une instance de Segment
public class SegmentBuilder {
	
	private Point point1;
	private Point point2;
	
	// Retourne l'instance de Segment instanci�e avec tous ses attributs
	public Segment creerSegment(){
		return new Segment(this.point1, this.point2);
	}
	
	// Retourne l'instance de SegmentBuilder avec son attribut point1 instanci�
	public SegmentBuilder choisirPoint1(int abscisse, int ordonnee){
		this.point1 = new Point(abscisse, ordonnee);
		return this;
	}
	
	// Retourne l'instance de SegmentBuilder avec son attribut point2 instanci�
	public SegmentBuilder choisirPoint2(int abscisse, int ordonnee){
		this.point2 = new Point(abscisse, ordonnee);
		return this;
	}

}
