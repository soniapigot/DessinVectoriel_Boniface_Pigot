package patronComposite;

import java.awt.Graphics2D;

import figures.IChemin;
import outils.Crayon;
import outils.Etiquette;

public interface IDessin {

	public String dessinerSVG (IChemin chemin, Crayon crayon); // on dessine le chemin à l'aide du crayon dans le dessin d
	public String remplirSVG (Crayon crayon); // on remplit le chemin (fermé) à l'aide du crayon dans le dessin d
	public void dessinerJAVA (Graphics2D g, IChemin chemin, Crayon crayon); // on dessine le chemin à l'aide du crayon dans le dessin d
	public void remplirJAVA (Graphics2D g, IChemin chemin, Crayon crayon); // on remplit le chemin (fermé) à l'aide du crayon dans le dessin d
	public String etiqueterSVG(Etiquette e); // on étiquette le message s à la position p
	public void etiqueterJAVA (Graphics2D g, Etiquette e, Crayon crayon); // on étiquette le message s à la position p
	
}
