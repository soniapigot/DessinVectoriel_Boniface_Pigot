package graphics2DInterpretation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JPanel;

import figures.IChemin;
import outils.Etiquette;
import outils.Forme;
import patronComposite.DessinComposite;
import patronComposite.IDessin;
 
public class Panneau extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Entry<String, DessinComposite> entry;
	DessinComposite dessin;
	
	public Panneau(Entry<String, DessinComposite> entry, DessinComposite dessin) {
		this.entry =  entry;
		this.dessin = dessin;
	}    
  
  public void paintComponent(Graphics g) {
		//Ensemble des Formes (composé de Chemin, crayon pour contour, crayon pour remplir)
		 ArrayList<Forme> listeForme = entry.getValue().getListeForme();
		 
	     //Ensemble des Etiquetes
		 ArrayList<Etiquette> listeEtiquette = entry.getValue().getListeEtiquete();
		 
	     //Liste des dessins insérés
	     ArrayList<IDessin> listeDessin = entry.getValue().getListeDessin();
		     
	     //On parcourt toutes les formes du dessin et on regarde quelle est le chemin, et les crayons utilisés
	     for(Forme f: listeForme) {
	    	 IChemin c = f.getChemin();
	       	 entry.getValue().dessinerJAVA((Graphics2D) g, c, f.getCrayonContour());
	       	 entry.getValue().remplirJAVA((Graphics2D) g, c, f.getCrayonRemplir());
	     }
	     
	     for(Etiquette e: listeEtiquette) {
	    	 entry.getValue().etiqueterJAVA((Graphics2D) g, e, e.getCrayon());
	     }
	     
	     for(IDessin dessin: listeDessin) {
	    	 this.inserer(g, (DessinComposite) dessin);
	     }
  }
  
  public void inserer(Graphics g, DessinComposite d) {
		//Ensemble des Formes (composé de Chemin, crayon pour contour, crayon pour remplir)
		 ArrayList<Forme> listeForme = d.getListeForme();
		 
	     //Ensemble des Etiquetes
		 ArrayList<Etiquette> listeEtiquette = d.getListeEtiquete();
		 
	     //Liste des dessins insérés
	     ArrayList<IDessin> listeDessin = d.getListeDessin();
		     
	     //On parcourt toutes les formes du dessin et on regarde quelle est le chemin, et les crayons utilisés
	     for(Forme f: listeForme) {
	    	 IChemin c = f.getChemin();
	       	 d.dessinerJAVA((Graphics2D) g, c, f.getCrayonContour());
	       	 d.remplirJAVA((Graphics2D) g, c, f.getCrayonRemplir());
	     }
	     
	     for(Etiquette e: listeEtiquette) {
	    	 d.etiqueterJAVA((Graphics2D) g, e, e.getCrayon());
	     }
	     
	     for(IDessin dessin: listeDessin) {
	    	 this.inserer(g, (DessinComposite) dessin);
	     }
	     
	     
  }

  
}
