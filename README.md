# Dessin Vectoriel


## Installation du projet

Pour utiliser le projet de dessin vectoriel, veuillez suivre les instructions ci-dessous :

1. Ouvrir Eclipse
2. Importer le projet en cliquant sur File -> Import
3. Dans la fenêtre qui s'ouvre, sélectionner Existing Project Into Workspace, puis cliquer sur Next
4. Cocher Select Archive File puis rechercher l'archive du projet dans vos dossiers en cliquant sur Browse : sélectionner dessinVectoriel-Boniface-Pigot.zip
5. Cliquer sur Finish : le projet se trouve maintenant installé dans votre environnement de développement


##Creation d'un dessin

Ce projet vous permet de créer un dessin vectoriel. Pour cela, vous allez devoir suivre quelques règles d'utilisation.


Pour créer un dessin, vous devez vous rendre dans la classe Builder située dans le package main.

Cette classe contient une méthode Builder() qui est le constructeur, comme mentionné précédemment. Vous allez pouvoir rédiger un script de dessin au sein de cette méthode.

A la suite de la ligne :

		// initialisation de l'instance
		this.dessins = new HashMap<String, DessinComposite>();

vous pouvez commencer à écrire.

Vous aurez besoin de créer une nouvelle instance de DessinBuilder pour créer un dessin :

	DessinBuilder dessinBuilder = new DessinBuilder();

Ainsi qu'une instance de FormeBuilder pour ajouter des formes au dessin :

	FormeBuilder formeBuilder = new FormeBuilder();

Vous aurez également besoin d'une instance de CrayonBuilder qui servira à créer des crayons de différentes couleurs et épaisseurs pour colorier vos formes :

	CrayonBuilder crayonBuilder = new CrayonBuilder();

Puis, selon les figures que vous voulez dessiner, il vous faudra créer les Builders correspondants. Par exemple pour dessiner un Carre : 

	CarreBuilder carreBuilder = new CarreBuilder();

Ensuite, il suffit d'appeler les méthodes que vous avez à disposition sur chaque instance. Par exemple, en écrivant "dessinBuilder.", 3 méthodes utiles pour construire le dessin vous seront proposées :

 - ajouterDessin(DessinComposite dessin)
 - ajouterEtiquette(Etiquette etiquette)
 - ajouterForme(Forme forme)

Si vous souhaitez ajouter une forme par exemple, vous prendrez en argument votre instance de FormeBuilder pour contruire une forme de la même façon, en choisisant les fonctions proposées par 'formeBuilder.'

Ce chaînage permet de construire pas à pas une instance complète de DessinBuilder, avec tous ces attributs instanciés.

Exemple : 

	dessinBuilder.ajouterForme(formeBuilder
				.ajouterChemin(carreBuilder.choisirPointOrigine(300, 300).choisirLongueurCote(100).creerCarre())
				.ajouterCrayonContour(crayonBuilder.choisirEpaisseur(1).choisirCouleur(Couleurs.black).creerCrayon())
				.ajouterCrayonRemplir(crayonBuilder.choisirEpaisseur(3).choisirCouleur(Couleurs.blue).creerCrayon())
				.creerForme());

Pour creer un véritable objet de type DessinComposite, il suffit d'appeler sur ce dessinBuilder la méthode creerDessin() :

	DessinComposite d1 = dessinBuilder.creerDessin();

Enfin, pour que ce dessins puisse être interprété par le programme et affiché sur votre écran, il faut l'ajouter à l'instance de la classe Builder, qui est une HashMap<String, DessinComposite> contenant tous les dessins qu'on souhaite afficher, avec leur noms :

	this.dessins.put("MonDessin1", d1);

### Les opérateurs de contrôle

Le script est écrit par défaut en mode séquence, autrement dit vos instructions seront exécutées les unes à la suite des autres.

En revanche, pour faciliter la création de dessins, il existe deux classes faisant office de bibliothèques, et permettant de coder des méthodes contrôlant une suite d'instructions.

- Boucle.java : cette classe contient un exemple de méthode permettant de répéter n fois la construction d'un cercle dont le centre ne change pas mais le diamètre augmente. Ainsi, dans le script, il suffit de creer une instance de la classe Boucle, et d'appeler la fonction : cela évite la répétition de code pour dessiner n cercles qui se ressemblent .

		// exemple d'utilisation de la classe Boucle
		Boucle b = new Boucle(3, new FormeBuilder());
		Crayon crayonContour = crayonBuilder.choisirCouleur(Couleurs.blue).choisirEpaisseur(2).creerCrayon();
		Crayon crayonRemplir = crayonBuilder.choisirCouleur(Couleurs.red).choisirEpaisseur(2).creerCrayon();
		dessinBuilder2 = b.creerCerclesConcentriques(500, 200, 10, 10, crayonContour, crayonRemplir, dessinBuilder2);

- Alternative.java : cette classe contient, quant à elle, un exemple de méthode permettant d'exécuter une instruction, si une condition est vérifiée. Ici, la méthode remplit un carré avec une couleur particulière, selon la couleur de son contour.
Dans le script de l'utilisateur, on y fera appel comme suit : 

		// Exemple d'utilisation de la classe Alternative
		Alternative a = new Alternative(d1);
		d1 = a.remplirFormeEnFonctionDeSonContour(0, Couleurs.black, Couleurs.orange);

Ces deux classes peuvent donc être complétées si l'on souhaite rajouter de nouvelles méthodes contrôlant l'exécution des instructions.


## Mode d'emploi pour afficher les dessins ##

Vous allez choisir l'interprétation que vous souhaitez compiler: création d'un fichier SVG ou sous Graphics2D. Pour cela, dans le package main ouvrez la classe Main, vous verez alors une méthode main dans laquelle vous allez pouvoir choisir l'interprétation. Une variable 'interpretation' est déclarée dans la méthode main. Une valeur lui est assignée, soit "svg" pour avoir une interprétation en SVG soit "graphics2D". Ainsi il vous suffit de commenter l'interprétation que vous ne voulez pas à l'aide de deux slash, comme ceci: //. 

		b.evaluate("svg");
		//b.evaluate("java");

Vous pouvez alors lancer le projet comme suit: 

1. clic droit sur la classe main 
2. Run As -> Java Application.


Si vous avez choisi une interprétation en SVG, faites un clic droit sur le projet et choisissez Refresh. Dans votre projet, un dossier fichierSVG existe. Si vous l'ouvrez, vos dessins avec les noms que vous leurs avez donnés apparaîtront. Pour les ouvrir double-cliquez dessus et il s'ouvriront avec votre navigateur par défaut.

Si vous avez choisi une interprétation avec Graphics2D, alors vos fichiers s'ouvriront au lancement de l'application. Si vous souhaitez modifier vos dessins, n'oubliez pas de les fermer avant.


## Règles de base ##

- Ne jamais supprimer dessinVide.svg dans le dossier fichierSVG.
- Choississez bien l'ordre dans lequel vous dessinez vos formes dans votre dessin. Si vous dessinez un carré, puis un cercle rempli plus gros que le carré et au même endroit que le carré, alors le carré ne sera plus visible sur votre dessin, il sera recouvert par le cercle.

##Contacts

sonia.pigot@etudiant.mines-nantes.fr

melyna.boniface@etudiant.mines-nantes.fr