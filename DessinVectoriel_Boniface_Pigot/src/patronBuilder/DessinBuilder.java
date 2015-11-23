package patronBuilder;

import java.util.ArrayList;

import outils.Etiquette;
import outils.Forme;
import patronComposite.DessinComposite;
import patronComposite.IDessin;


////Cette classe permet de construire étape par étape une instance de DessinComposite
public class DessinBuilder {
	
	private ArrayList<IDessin> listeDessin = new ArrayList<IDessin>();
	private ArrayList<Forme> listeForme = new ArrayList<Forme>();
	private ArrayList<Etiquette> listeEtiquette = new ArrayList<Etiquette>();
	


	// Retourne l'instance de DessinComposite instanciée avec tous ses attributs
	public DessinComposite creerDessin(){
		return new DessinComposite(this.listeDessin, this.listeForme, this.listeEtiquette);
	}

	
	// Retourne l'instance de DessinBuilder avec son attribut listeForme instancié
	public DessinBuilder ajouterForme(Forme forme){
		this.listeForme.add(forme);
		return this;
	}
	
	// Retourne l'instance de DessinBuilder avec son attribut listeDessin instancié
	public DessinBuilder ajouterDessin(DessinComposite dessin){
		this.listeDessin.add(dessin);
		return this;
	}
	
	// Retourne l'instance de DessinBuilder avec son attribut listEtiquette instancié
	public DessinBuilder ajouterEtiquette(Etiquette etiquette){
		this.listeEtiquette.add(etiquette);
		return this;
	}
	
	
	
}
