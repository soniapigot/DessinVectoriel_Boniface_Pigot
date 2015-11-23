package operateursDeControle;

import patronComposite.DessinComposite;
import outils.Forme;
import outils.Couleurs;
import outils.Crayon;

public class Alternative {

	private DessinComposite dessin;

	public Alternative(DessinComposite dessin) {
		super();
		this.dessin = dessin;
	}
	
	public DessinComposite remplirFormeEnFonctionDeSonContour(int forme, Couleurs couleurContour, Couleurs couleurRemplir){
		Forme f = dessin.getListeForme().get(forme);
		if(f.getCrayonContour().getCouleur().equals(couleurContour)){
			f.setCrayonRemplir(new Crayon(3, couleurRemplir));
		}
		else {
			f.setCrayonRemplir(new Crayon(3, Couleurs.none));
		}
		return this.dessin;
		
	}
	
	
	
}
