package operateursDeControle;

import java.util.ArrayList;

import patronBuilder.CercleBuilder;
import patronBuilder.DessinBuilder;
import patronBuilder.FormeBuilder;
import figures.Cercle;
import outils.Forme;
import outils.Crayon;

public class Boucle {
	
	private int n;
	private FormeBuilder formeBuilder;
	
	
	
	public Boucle(int n, FormeBuilder formeBuilder) {
		super();
		this.n = n;
		this.formeBuilder = formeBuilder;
	}



	// Cette méthode permet de creer des cercles concentriques.
	// L'utilisateur a seulement besoin d'indiquer en argument les coordonnees 
	// du centre, le diamètre du cercle initial (le plus petit), et le pas d'incrémentation
	public DessinBuilder creerCerclesConcentriques(int abs, int ord, int diametreInitial, int incrementation, Crayon crayonContour, Crayon crayonRemplir, DessinBuilder dessinBuilder){
		ArrayList<Forme> listeForme = new ArrayList<Forme>();
		CercleBuilder cercleBuilder = new CercleBuilder();	
		
		for(int i=diametreInitial+n*incrementation; i>=diametreInitial/n; i=i- incrementation){
			Cercle c = cercleBuilder.choisirCentre(abs, ord).choisirDiametre(i).creerCercle();
			listeForme.add(this.formeBuilder.ajouterChemin(c).ajouterCrayonContour(crayonContour).ajouterCrayonRemplir(crayonRemplir).creerForme());
		}
		
		for(Forme f: listeForme){
			dessinBuilder.ajouterForme(f);	
		}
		
		return dessinBuilder;
	}

}
