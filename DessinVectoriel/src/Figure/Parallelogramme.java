package figure;

import outils.Crayon;

public class Parallelogramme implements IChemin{
	
	// l'angle défini est celui entre les deux segments
	private Segment segment1;
	private Segment segment2;
	private double angle;
	
	public Parallelogramme(Segment segment1, Segment segment2, double angle) {
		super();
		this.segment1 = segment1;
		this.segment2 = segment2;
		this.angle = angle;
	}

	public Segment getSegment1() {
		return segment1;
	}

	public void setSegment1(Segment segment1) {
		this.segment1 = segment1;
	}

	public Segment getSegment2() {
		return segment2;
	}

	public void setSegment2(Segment segment2) {
		this.segment2 = segment2;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public void dessiner(Crayon crayon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remplir(Crayon crayon) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
