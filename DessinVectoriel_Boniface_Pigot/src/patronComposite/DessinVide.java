package patronComposite;

import java.awt.Graphics2D;

import figures.IChemin;
import outils.Crayon;
import outils.Etiquette;

public class DessinVide implements IDessin {

	@Override
	public String dessinerSVG(IChemin chemin, Crayon crayon) {
		return null;

	}

	
	@Override
	public void dessinerJAVA(Graphics2D g, IChemin chemin, Crayon crayon) {
		

	}

	@Override
	public void remplirJAVA(Graphics2D g, IChemin chemin, Crayon crayon) {
		

	}

	@Override
	public String remplirSVG(Crayon crayon) {
		
		return null;
	}


	@Override
	public String etiqueterSVG(Etiquette e) {
		return null;
		
	}


	@Override
	public void etiqueterJAVA(Graphics2D g, Etiquette e, Crayon crayon) {
		
		
	}

}
