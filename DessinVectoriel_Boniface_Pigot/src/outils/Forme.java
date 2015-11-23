package outils;

import figures.IChemin;

public class Forme {
	
	private IChemin chemin;
	private Crayon crayonContour;
	private Crayon crayonRemplir;
	
	public Forme(IChemin chemin, Crayon crayonContour, Crayon crayonRemplir) {
		super();
		this.chemin = chemin;
		this.crayonContour = crayonContour;
		this.crayonRemplir = crayonRemplir;
	}

	public IChemin getChemin() {
		return chemin;
	}

	public void setChemin(IChemin chemin) {
		this.chemin = chemin;
	}

	public Crayon getCrayonContour() {
		return crayonContour;
	}

	public void setCrayonContour(Crayon crayonContour) {
		this.crayonContour = crayonContour;
	}

	public Crayon getCrayonRemplir() {
		return crayonRemplir;
	}

	public void setCrayonRemplir(Crayon crayonRemplir) {
		this.crayonRemplir = crayonRemplir;
	}
	
	

}
