package main;

import java.io.IOException;
import java.util.HashMap;

import graphics2DInterpretation.JAVA;
import patronBuilder.*;
import patronComposite.DessinComposite;
import operateursDeControle.Alternative;
import operateursDeControle.Boucle;
import outils.*;
import svgInterpretation.SVG;

// Cette classe permet à l'utilisateur de composer un ou plusieurs dessins.
// Elle renvoit une instance de Builder, dont l'attribut est une HashMap 
// répertoriant chaque dessin que l'utilisateur souhaite afficher à l'écran
// associé à un nom 
public class Builder {

	private HashMap<String, DessinComposite> dessins;

	// Ce constructeur sert à instancier dessins
	// C'est ici que l'utilisateur peut écrire son script de dessins en utilisant
	// des instances des builders pour les objets qu'ils veut créer.
	public Builder () {

		// initialisation de l'instance
		this.dessins = new HashMap<String, DessinComposite>();

		// creation 1er dessin
		DessinBuilder dessinBuilder = new DessinBuilder();
		FormeBuilder formeBuilder = new FormeBuilder();
		CarreBuilder carreBuilder = new CarreBuilder();
		CercleBuilder cercleBuilder = new CercleBuilder();
		CrayonBuilder crayonBuilder = new CrayonBuilder();
		
		dessinBuilder.ajouterForme(formeBuilder
				.ajouterChemin(carreBuilder.choisirPointOrigine(300, 300).choisirLongueurCote(100).creerCarre())
				.ajouterCrayonContour(crayonBuilder.choisirEpaisseur(1).choisirCouleur(Couleurs.black).creerCrayon())
				.ajouterCrayonRemplir(crayonBuilder.choisirEpaisseur(3).choisirCouleur(Couleurs.blue).creerCrayon())
				.creerForme());

		dessinBuilder.ajouterForme(formeBuilder
				.ajouterChemin(cercleBuilder.choisirCentre(150,200).choisirDiametre(100).creerCercle())
				.ajouterCrayonRemplir(crayonBuilder.choisirEpaisseur(1).choisirCouleur(Couleurs.red).creerCrayon())
				.ajouterCrayonRemplir(crayonBuilder.choisirEpaisseur(3).choisirCouleur(Couleurs.purple).creerCrayon())
				.creerForme());


		// creation 2e dessin
		
		DessinBuilder dessinBuilder2 = new DessinBuilder();
		SegmentBuilder segmentBuilder = new SegmentBuilder();
		EtiquetteBuilder etiquetteBuilder = new EtiquetteBuilder();

		dessinBuilder2.ajouterEtiquette(etiquetteBuilder
				.choisirPoint(100, 500)
				.choisirTexte("etiquette")
				.choisirCrayon(3, Couleurs.green)
				.creerEtiquette());

		// exemple d'utilisation de la classe Boucle
		Boucle b = new Boucle(3, new FormeBuilder());
		Crayon crayonContour = crayonBuilder.choisirCouleur(Couleurs.blue).choisirEpaisseur(2).creerCrayon();
		Crayon crayonRemplir = crayonBuilder.choisirCouleur(Couleurs.red).choisirEpaisseur(2).creerCrayon();
		dessinBuilder2 = b.creerCerclesConcentriques(500, 200, 10, 10, crayonContour, crayonRemplir, dessinBuilder2);

		dessinBuilder2.ajouterForme(formeBuilder
				.ajouterChemin(segmentBuilder.choisirPoint1(100,350).choisirPoint2(100,400).creerSegment())
				.ajouterCrayonContour(crayonBuilder.choisirEpaisseur(1).choisirCouleur(Couleurs.black).creerCrayon())
				.ajouterCrayonRemplir(crayonBuilder.choisirEpaisseur(3).choisirCouleur(Couleurs.blue).creerCrayon())
				.creerForme());
		
		DessinComposite d2 = dessinBuilder2.creerDessin();

		// rajoute d2 à la liste des dessins de d1
		dessinBuilder.ajouterDessin(d2);

		// renvoit le dessinComposite 1
		DessinComposite d1 = dessinBuilder.creerDessin();
		
		// Exemple d'utilisation de la classe Alternative
		Alternative a = new Alternative(d1);
		d1 = a.remplirFormeEnFonctionDeSonContour(0, Couleurs.black, Couleurs.orange);

		// Ajouter les dessins créés dans la liste des dessins à afficher, en leur donnant un nom
		this.dessins.put("MonDessin1", d1);
		this.dessins.put("MonDessin2", d2);

	}
	// Interprète le script donné par l'utilisateur en utilisant les objets java 
	// créés et stockés dans la HashMap dessins
	public void evaluate(String formatAffichage) throws IOException {
		if (formatAffichage.equals("svg")) {
			SVG r = new SVG();
			r.interpret(dessins);
		}
		else {
			JAVA i = new JAVA();
			i.interpret(dessins);
		}


	}

}
