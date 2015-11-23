#PROJET D'ARCHITECTURE LOGICIELLE
#Un langage de dessin vectoriel
#*PIGOT Sonia - BONIFACE Mélyna*

##Définition du langage de dessin

### Le Patron Builder

Le langage de dessin est directement embarqué dans le langage JAVA, afin de faciliter l'écriture d'un script pour l'utilisateur. Le script est donc représenté par du code JAVA, en suivant le patron Builder.
Ce patron est défini comme suit :

- Une classe Builder est implémentée pour chaque objet que l'utilisateur a besoin de créer. Ces classes sont stockées dans le package patronBuilder du projet. On y trouve par exemple une classe CarreBuilder, DessinBuilder, FormeBuilder.

- Au sein de ces classes, on retrouve les mêmes attributs que ceux des classes représentant les objets qu'on souhaite construire. Par exemple, la classe CarreBuilder contient les mêmes instances de classe que Carre :
	


	    public class Carre implements IChemin{
		private Point p;
    	private int cote;

		public class CarreBuilder {
		private Point p;
		private int cote;

- En revanche, les méthodes sont différentes: le but des classes Builder est de permettre à l'utilisateur d'appliquer des fonctions intuitives à l'objet Builder pour contruire finalement un véritable objet. Prenons l'exemple de la construction d'un carre : 

		



		public class CarreBuilder {

		private Point p;
		private int cote;
	
		// Retourne l'instance de Carre instanciée avec tous ses attributs
		public Carre creerCarre(){
			return new Carre(this.p, this.cote);
		}
	
		// Retourne l'instance de CarreBuilder avec son attribut Point p instancié
		public CarreBuilder choisirPointOrigine(int abscisse, int ordonnee){
			this.p = new Point(abscisse, ordonnee);
			return this;
		}
	
		// Retourne l'instance de CarreBuilder avec son attribut longueur instancié
		public CarreBuilder choisirLongueurCote(int cote){
			this.cote = cote;
			return this;
		}
		}
	

En pratique, on voit que l'utilisateur pourra appeler sur son instance de CarreBuilder 3 méthodes :

- choisirPointOrigine(int abscisse, int ordonnee) : cette méthode permet d'instancier l'attribut Point p et retourne l'instance de CarreBuilder qui a donc son attribut p instancié

- choisirLongueurCote(int cote) : cette méthode permet d'instancier l'attribut int cote et retourne également l'instance de CarreBuilder qui a son attribut cote instancié

- creerCarre() : cette méthode sera appelé sur l'instance de CarreBuilder, une fois que l'utilisateur aura instancié les 2 attributs. Elle crée un nouveau Carre avec les attribut p et cote instanciés précédemment et le retourne, afin que l'utilisateur puisse l'utiliser par la suite dans le script (pour créer une forme par exemple).


Cette utilisation du patron Builder facilite grandement l'écriture du script par l'utilisateur, puisqu'il a seulement besoin de contruire un Builder, puis les fonctions applicables à ce Builder lui sont proposées automatiquement à la suite les unes des autres. 


### Rédaction du script
Ce script est ainsi rédigé dans le constructeur de la classe Builder, qui se trouve dans le package main.

Cette classe a pour instance une HashMap<String, DessinComposite> qui contient tous les dessins créés dans le script par l'utilisateur, et qui sera utilisée par les interpréteur pour afficher ces dessins. C'est pourquoi il est nécessaire de construire pas à pas cette HashMap dans le constructeur de la classe Builder.

- La première étape d'initialiation de l'instance est codée par défaut : 

		public Builder () {

		// initialisation de l'instance
		this.dessins = new HashMap<String, DessinComposite>();

La liste de dessins est une liste vide qu'il faut maintenant remplir en créant des dessins.

- Exemple de construction d'un dessin grâce au patron Builder :


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

		// renvoit le dessinComposite 1
		DessinComposite d1 = dessinBuilder.creerDessin();

		// Ajouter les dessins créés dans la liste des dessins à afficher, en leur donnant un nom
		this.dessins.put("MonDessin1", d1);


L'utilisateur crée au début du script toutes les instances de Builder dont il aura besoin : ici, il souhaite dessiner un carré et un cercle, en utilisant des crayons, ce qui donnera une forme (une Forme étant un triplet IChemin chemin, Crayon crayonContour, Crayon crayonRemplir). L'utilisateur crée donc un CarreBuilder, un CercleBuilder, un CrayonBuilder, un FormeBuilder et bien entendu un DessinBuilder.

Ensuite, il construit progressivement son dessin en instanciant les attributs de DessinBuilder, en appelant les fonctions qu'il a à disposition.

Pour finir, il fait appelle à la fonction creerDessin() sur l'objet dessinBuilder, qui renvoit un objet DessinComposite, qu'il faut ajouter à la HashMap contenant les dessins à afficher, en lui donnant un nom.


### Les opérateurs de contrôle

Le script est écrit par défaut en mode séquence, autrement dit les instructions seront exécutées les unes à la suite des autres dans le constructeur de la classe Builder.java.

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





##Interprétations du langage

##Architecture logicielle

### Schéma général : diagramme des classes

### Principes modulaires et patrons de conception

Pour réaliser ce projet, différents principes modulaires ont été suivis.

### Extension du langage et ajout d'interprétations

##Guide d'utilisation

### Installation du projet

Pour utiliser le projet de dessin vectoriel, veuillez suivre les instructions ci-dessous :

1. Ouvrir Eclipse
2. Importer le projet en cliquant sur File -> Import
3. Dans la fenêtre qui s'ouvre, sélectionner Existing Project Into Workspace, puis cliquer sur Next
4. Cocher Select Archive File puis rechercher l'archive du projet dans vos dossiers en cliquant sur Browse : sélectionner dessinVectoriel-Boniface-Pigot.zip
5. Cliquer sur Finish : le projet se trouve maintenant installé dans votre environnement de développement

### Mode d'emploi pour afficher les dessins ##

Vous allez choisir l'interprétation que vous souhaitez compiler: création d'un fichier SVG ou sous Graphics2D. Pour cela, dans le package main ouvrez la classe Main, vous verez alors une méthode main dans laquelle vous allez pouvoir choisir l'interprétation. Une variable 'interpretation' est déclarée dans la méthode main. Une valeur lui est assignée, soit "svg" pour avoir une interprétation en SVG soit "graphics2D". Ainsi il vous suffit de commenter l'interprétation que vous ne voulez pas à l'aide de deux slash, comme ceci: //. 

		b.evaluate("svg");
		//b.evaluate("java");

Vous pouvez alors lancer le projet comme suit: 

1. clic droit sur la classe main 
2. Run As -> Java Application.


Si vous avez choisi une interprétation en SVG, faites un clic droit sur le projet et choisissez Refresh. Dans votre projet, un dossier fichierSVG existe. Si vous l'ouvrez, vos dessins avec les noms que vous leurs avez donnés apparaîtront. Pour les ouvrir double-cliquez dessus et il s'ouvriront avec votre navigateur par défaut.

Si vous avez choisi une interprétation avec Graphics2D, alors vos fichiers s'ouvriront au lancement de l'application. Si vous souhaitez modifier vos dessins, n'oubliez pas de les fermer avant.


### Règles de base ##

- Ne jamais supprimer dessinVide.svg dans le dossier fichierSVG.
- Choississez bien l'ordre dans lequel vous dessinez vos formes dans votre dessin. Si vous dessinez un carré, puis un cercle rempli plus gros que le carré et au même endroit que le carré, alors le carré ne sera plus visible sur votre dessin, il sera recouvert par le cercle.




