package figure;

import outils.Crayon;

public interface IChemin {
	
	public void dessiner (Crayon crayon); // on dessine le chemin à l'aide du crayon dans le dessin d
	public void remplir (Crayon crayon); // on remplit le chemin (fermé) à l'aide du crayon dans le dessin d

}
