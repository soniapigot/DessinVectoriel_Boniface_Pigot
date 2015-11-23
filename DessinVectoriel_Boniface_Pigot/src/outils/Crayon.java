package outils;

public class Crayon {

	private int epaisseurTrait;
	private Couleurs couleur;
	
	public Crayon(int epaisseurTrait, Couleurs couleur) {
		super();
		this.epaisseurTrait = epaisseurTrait;
		this.couleur = couleur;
	}
	public int getEpaisseurTrait() {
		return epaisseurTrait;
	}
	public void setEpaisseurTrait(int epaisseurTrait) {
		this.epaisseurTrait = epaisseurTrait;
	}
	public Couleurs getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleurs couleur) {
		this.couleur = couleur;
	}
	
}
