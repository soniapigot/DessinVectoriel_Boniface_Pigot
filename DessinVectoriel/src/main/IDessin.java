package main;

import Figure.IChemin;
import Figure.Position;

public interface IDessin {

	public void dessiner (IDessin d, IChemin chemin, Crayon crayon); // on dessine le chemin � l'aide du crayon dans le dessin d
	public void remplir (IDessin d, IChemin chemin, Crayon crayon); // on remplit le chemin (ferm�) � l'aide du crayon dans le dessin d
	public void inserer (IDessin d1, IDessin d2); // on ins�re d2 dans d1
	public void etiqueter (IDessin d, Position p, String s); // on �tiquette le message s dans le dessin d � la position p
}
