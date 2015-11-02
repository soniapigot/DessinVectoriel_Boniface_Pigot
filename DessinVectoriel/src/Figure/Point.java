package figure;

import outils.Crayon;

public class Point implements IChemin{
	
	private int abscisse;
	private int ordonnee;
	
	public Point(int abscisse, int ordonnee) {
		super();
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}
	public int getAbscisse() {
		return abscisse;
	}
	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}
	public int getOrdonnee() {
		return ordonnee;
	}
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
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
