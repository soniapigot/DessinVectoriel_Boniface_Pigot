package figure;

import outils.Crayon;

public class Polygone implements IChemin{

	// nous nous limiterons à un pentagone
	private Segment segmentDeBase;
	private int nombreSegments;
	
	public Polygone(Segment segmentDeBase, int nombreSegments) {
		super();
		this.segmentDeBase = segmentDeBase;
		this.nombreSegments = nombreSegments;
	}

	public Segment getSegmentDeBase() {
		return segmentDeBase;
	}

	public void setSegmentDeBase(Segment segmentDeBase) {
		this.segmentDeBase = segmentDeBase;
	}

	public int getNombreSegments() {
		return nombreSegments;
	}

	public void setNombreSegments(int nombreSegments) {
		this.nombreSegments = nombreSegments;
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
