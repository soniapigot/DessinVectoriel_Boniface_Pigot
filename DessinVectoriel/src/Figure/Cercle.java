package figure;

import outils.Crayon;

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
	public void dessiner(Crayon crayon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remplir(Crayon crayon) {
		// TODO Auto-generated method stub
		
	}
	
	

}