package graphics2DInterpretation;

import java.io.IOException;
import java.util.HashMap;

import patronComposite.DessinComposite;

public class JAVA{

	public void interpret(HashMap<String, DessinComposite> dessins) throws IOException {

	    //On parcourt sur tous les dessins composites créé par l'utilisateur
		for (HashMap.Entry<String, DessinComposite> entry: dessins.entrySet()) {
			@SuppressWarnings("unused")
			Fenetre fen = new Fenetre(entry);
		}
	}

}
