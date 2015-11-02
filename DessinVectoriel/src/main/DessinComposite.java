package main;

import java.util.ArrayList;

import figure.IChemin;
import outils.Crayon;
import outils.Position;

public class DessinComposite implements IDessin{

	private ArrayList<IDessin> listeDessin;
	private ArrayList<IChemin> listeChemin;
	
	public DessinComposite() {
		super();
	}
	

	public DessinComposite(ArrayList<IDessin> listeDessin, ArrayList<IChemin> listeChemin) {
		super();
		this.listeDessin = listeDessin;
		this.listeChemin = listeChemin;
	}

	public ArrayList<IDessin> getListeDessin() {
		return listeDessin;
	}



	public void setListeDessin(ArrayList<IDessin> listeDessin) {
		this.listeDessin = listeDessin;
	}



	public ArrayList<IChemin> getListeChemin() {
		return listeChemin;
	}

	public void setListeChemin(ArrayList<IChemin> listeChemin) {
		this.listeChemin = listeChemin;
	}

	public void sequence(){
	// TODO	
	}

	public void alternative(){
	//TODO
	}
	
	public void boucle(){
	//TODO
	}

	@Override
	public void dessiner(IChemin chemin, Crayon crayon) {
		chemin.dessiner(crayon);	
	}

	@Override
	public void remplir(IChemin chemin, Crayon crayon) {
		chemin.remplir(crayon);
		
	}

	@Override
	public void inserer(IDessin d1, IDessin d2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void etiqueter(IDessin d, Position p, String s) {
		// TODO Auto-generated method stub
		
	}
}
