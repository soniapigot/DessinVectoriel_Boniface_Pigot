package main;

import figure.IChemin;
import outils.Crayon;
import outils.Position;

public interface IDessin {

	public void dessiner (IChemin chemin, Crayon crayon); // on dessine le chemin à l'aide du crayon dans le dessin d
	public void remplir (IChemin chemin, Crayon crayon); // on remplit le chemin (fermé) à l'aide du crayon dans le dessin d
	public void inserer (IDessin d1, IDessin d2); // on insère d2 dans d1
	public void etiqueter (IDessin d, Position p, String s); // on étiquette le message s dans le dessin d à la position p
}
