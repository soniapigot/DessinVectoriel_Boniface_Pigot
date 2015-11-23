package figures;

import java.awt.Graphics2D;

import outils.Crayon;

public interface IChemin {
	
	public String dessinerSVG (Crayon crayon); // on dessine le chemin à l'aide du crayon dans le dessin d
	public void dessinerJAVA (Graphics2D g, Crayon crayon); // on dessine le chemin à l'aide du crayon dans le dessin d
	public void remplirJAVA (Graphics2D g, Crayon crayon); // on remplit le chemin (fermé) à l'aide du crayon dans le dessin d

}
