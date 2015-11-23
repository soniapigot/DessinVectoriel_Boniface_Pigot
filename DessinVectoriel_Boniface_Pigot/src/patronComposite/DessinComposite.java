package patronComposite;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import figures.IChemin;
import graphics2DInterpretation.Bibliotheque;
import outils.Crayon;
import outils.Etiquette;
import outils.Forme;

public class DessinComposite implements IDessin{

	private ArrayList<IDessin> listeDessin;
	private ArrayList<Forme> listeForme;
	private ArrayList<Etiquette> listeEtiquete;
	
	public DessinComposite() {
		super();
	}
	
	//constructeur
	public DessinComposite(ArrayList<IDessin> listeDessin, ArrayList<Forme> listeForme, ArrayList<Etiquette> listeEtiquete) {
		super();
		this.listeDessin = listeDessin;
		this.listeForme = listeForme;
		this.listeEtiquete = listeEtiquete;
	}

	//Accesseurs
	
	public ArrayList<IDessin> getListeDessin() {
		return listeDessin;
	}

	public void setListeDessin(ArrayList<IDessin> listeDessin) {
		this.listeDessin = listeDessin;
	}

	public ArrayList<Forme> getListeForme() {
		return listeForme;
	}
	
	public void setListeForme(ArrayList<Forme> listeForme) {
		this.listeForme = listeForme;
	}

	public ArrayList<Etiquette> getListeEtiquete() {
		return listeEtiquete;
	}


	public void setListeEtiquete(ArrayList<Etiquette> listeEtiquete) {
		this.listeEtiquete = listeEtiquete;
	}

	//Méthode qui dessine en SVG une forme, la méthode dessinerSVG de chaque classe héritant de IChemin revoie un String étant la ligne ajouter au fichier SVG pour créer le chemin
	@Override
	public String dessinerSVG(IChemin chemin, Crayon crayon) {
		return chemin.dessinerSVG(crayon);	
	}

	//Méthode qui remplit chaque chemin en SVG
	@Override
	public String remplirSVG(Crayon crayon) {
		return  "fill=\"" + crayon.getCouleur() + "\"";
	}
	
	//Méthode qui appelle la méthode dessinerJAVA de chaque classe héritant de IChemin qui construit la forme en Graphics2D à l'aide d'une bibliotheque
	@Override
	public void dessinerJAVA(Graphics2D g, IChemin chemin, Crayon crayon) {
		chemin.dessinerJAVA(g, crayon);	
	}
	
	//Méthode qui appelle la méthode remplirJAVA de chaque classe héritant de IChemin qui remplit la forme en Graphics2D à l'aide d'une bibliotheque
	@Override
	public void remplirJAVA(Graphics2D g, IChemin chemin, Crayon crayon) {
		chemin.remplirJAVA(g, crayon);
	}

	//Méthode qui créer une Etiquette en SVG
	@Override
	public String etiqueterSVG(Etiquette e) {
		return "x=\""+ e.getPoint().getAbscisse() + "\" y=\"" + e.getPoint().getOrdonnee() + "\" stroke=\"" + e.getCrayon().getCouleur() + "\"  stroke-width=\"" + e.getCrayon().getEpaisseurTrait() + "\"";
	}
	
	//Méthode qui créer une Etiquette en Graphics2D	
	@Override
	public void etiqueterJAVA(Graphics2D g, Etiquette e, Crayon crayon) {
	    Font font = new Font("Courier", Font.BOLD, crayon.getEpaisseurTrait()*10);
	    g.setFont(font);
	    g.setColor(Bibliotheque.couleurs(crayon.getCouleur()));          
	    g.drawString(e.getEtiquete(), e.getPoint().getAbscisse(), e.getPoint().getOrdonnee());
		
	}
}
