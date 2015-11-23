package graphics2DInterpretation;

import java.io.IOException;
import java.util.HashMap;

import patronComposite.DessinComposite;

public class JAVA{

	//Parcourt de la HashMap cr�� dans le builder et cr�ation d'une fen�tre pour chaque dessin
	public void interpret(HashMap<String, DessinComposite> dessins) throws IOException {
	    //On parcourt sur tous les dessins composites cr�� par l'utilisateur
		for (HashMap.Entry<String, DessinComposite> entry: dessins.entrySet()) {
			@SuppressWarnings("unused")
			Fenetre fen = new Fenetre(entry);
		}
	}

}
