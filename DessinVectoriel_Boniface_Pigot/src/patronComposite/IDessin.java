package patronComposite;

import java.awt.Graphics2D;

import figures.IChemin;
import outils.Crayon;
import outils.Etiquette;

public interface IDessin {

	public String dessinerSVG (IChemin chemin, Crayon crayon); // on dessine le chemin � l'aide du crayon dans le dessin d
	public String remplirSVG (Crayon crayon); // on remplit le chemin (ferm�) � l'aide du crayon dans le dessin d
	public void dessinerJAVA (Graphics2D g, IChemin chemin, Crayon crayon); // on dessine le chemin � l'aide du crayon dans le dessin d
	public void remplirJAVA (Graphics2D g, IChemin chemin, Crayon crayon); // on remplit le chemin (ferm�) � l'aide du crayon dans le dessin d
	public String etiqueterSVG(Etiquette e); // on �tiquette le message s � la position p
	public void etiqueterJAVA (Graphics2D g, Etiquette e, Crayon crayon); // on �tiquette le message s � la position p
	
}
