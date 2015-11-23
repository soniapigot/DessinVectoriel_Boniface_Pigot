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
Les interprétations choisies pour ce projet sont: SVG, Graphics2D. Le patron interpréteur est choisi pour implémenter ces deux interprétations. Pour cela, une méthode evaluate a été codée dans la classe Builder afin d'évaluer l'interprétation. Cette méthode appelle la méthode interpret de la classe SVG si l'interprétation SVG a été choisi ou la méthode interpret de la classe JAVA si l'interprétation Graphics2D a été choisie. Ces méthodes prennent en argument la HashMap de DessinComposite créée précédement.


###SVG

Un fichier dessinVide.svg se situe dans le dossier fichierSVG à la racine du projet. Ce fichier est seulement constitué de la balise d'ouverture pour configurer un fichier SVG. 

La méthode interpret de la classe SVG fait pour chaque dessin dans la HashMap de DessinComposite:

- une copie du contenu de dessinVide.svg dans un nouveau fichier SVG enregistré avec le nom que l'utilisateur a donné au dessin. 
- appelle la fonction TexteSVG prenant pour argument le titre du dessin, le dessin en cours dans la boucle et un booléan assigné à true afin de signifier que ce dessin n'est pas un dessin inséré dans un autre dessin.

La fonction TexteSVG quant à elle, parcourt le dessin, c'est-à-dire qu'elle parcourt la liste de Forme du dessin, la liste d'Etiquette du dessin et la liste de IDessin du dessin pris en argument. La liste de IDessin représentant la liste de dessin insérés dans le dessin. Durant ce parcours, le fichier SVG créé par la fonction interpret est rempli. 

En effet, la fonction dessinerSVG est appelée pour construire les figures. La fonction etiqueterSVG est appelée pour construire des étiquettes. Ces fonctions renvoient un String qui va être écrit dans le fichier SVG grâce à un FileWriter. Par exemple la création d'une Etiquette sous SVG se fait comme-ci: 

Dans la méthode TexteSVG:

		  	for(Etiquette e: listeEtiquette) {
			 texte = "\r\n <text " + dessin.etiqueterSVG(e) + ">" + e.getEtiquete() + "</text>";
			 writer.write(texte,0,texte.length());
		 }

Où dessin est le dessin pris en argument de la fonction et writer est le FileWriter.

La méthode etiqueterSVG quant à elle est située dans la classe DessinComposite dont l'architecture sera précisée dans le paragraphe suivant: 

	public String etiqueterSVG(Etiquette e) {
		return "x=\""+ e.getPoint().getAbscisse() + "\" y=\"" + e.getPoint().getOrdonnee() + "\" stroke=\"" + e.getCrayon().getCouleur() + "\"  stroke-width=\"" + e.getCrayon().getEpaisseurTrait() + "\"";
	}

En effet une Etiquette est composée d'un Point et a un crayon ayant une couleur et une épaisseur.

Le parcours de la liste de dessin est quant à lui traité différemment des deux précédentes listes. La liste de dessin rappelle la fonction TexteSVG pour parcourir les dessins insérés et ajouter les formes, étiquettes et dessins insérés du dessin inséré de la liste de dessin inséré. Cependant, pour notifier que c'est un dessin inséré, le boolean sera false. En effet, si la fonction est appliquée à un dessin inséré alors la balise de fin de fichier SVG ne doit pas être ajoutée. C'est pourquoi à la fin de la méthode TexteSVG, pour insérer cette balise, le boolean est vérifié.

Le dessin SVG est alors fini et se situe dans fichierSVG. L'utilisateur peut le lancer dans son navigateur par défaut.


###Graphics2D

La méthode interpret de la classe SVG fait pour chaque dessin dans la HashMap de DessinComposite la création d'une Fenetre qui sera la fenêtre de dessin prenant pour argument la HashMap de DessinComposite créée dans le Builder.

Dans la classe Fenetre héritant de JFrame, une fenêtre est créée grâce au constructeur de la façon suivante:

- avec un titre étant le nom du dessin
- étant à la taille de l'écran
- soit visible
- fermant l'application lorsque la fenêtre est fermée
- créé un Panneau à l'intérieur de la fenêtre grâce à un constructeur de Panneau.

Un Panneau est une classe qui hérite de JPanel et qui a une instance de type Entry. 

Lorsque la Fenetre est créée, la méthode paintComponant de Panneau est automatiquement appelée. Cette méthode parcourt l'instance créée grâce au constructeur de Panneau dans le constructeur de Fenetre. Cette instance a donc été initialisée avec l'ensemble des DessinComposite de la HashMap. Ainsi comme, dans l'interprétation SVG, la liste de Forme et la liste d'étiquettes sont parcourues. Par exemple pour une liste de Forme:

    	for(Forme f: listeForme) {
	    	 IChemin c = f.getChemin();
	       	 entry.getValue().dessinerJAVA((Graphics2D) g, c, f.getCrayonContour());
	       	 entry.getValue().remplirJAVA((Graphics2D) g, c, f.getCrayonRemplir());
	     }

Il y a un appel aux méthodes dessinerJAVA et remplirJAVA qui sont dans DessinComposite et qui font appel à la classe static Bibliotheque contenant toutes les méthodes pour remplir ou dessiner des formes ou des étiquettes en Graphics2D. Un exemple de création de carré est le suivant:

    public static void createCarre(Graphics g, Carre car, Crayon crayon) {
	    Font font = new Font("Courier", Font.BOLD, crayon.getEpaisseurTrait()*10);
	    g.setFont(font);
		g.setColor(couleurs(crayon.getCouleur()));
		g.drawRect(car.getP().getAbscisse(), car.getP().getOrdonnee(), car.getCote(), car.getCote());
	}

Ainsi le dessin vectoriel est créé au lancement de l'application.

##Architecture logicielle

### Schéma général : diagramme des classes

Nos diagrammes sont stockés dans le dossier 'architecture', au sein du projet java.

### Principes modulaires et patrons de conception

Pour réaliser ce projet, différents principes modulaires ont été suivis.

#### *Patron composite*
Dans un premier temps, nous avons adopté le patron composite pour représenter un dessin.
Ce patron est consitué de 3 éléments :

- une interface IDessin
- une classe d'implémentation DessinVide
- une classe d'implémentation DessinComposite 

La classe DessinComposite implémente l'interface et les méthodes de IDessin en prenant 3 arguments :

	public class DessinComposite implements IDessin{

	private ArrayList<IDessin> listeDessin;
	private ArrayList<Forme> listeForme;
	private ArrayList<Etiquette> listeEtiquete;

En effet, un dessin composite contient des formes, des étiquettes mais aussi potentiellement d'autres dessins qui pourraient être inséré à l'intérieur. 

C'est pourquoi nous avons choisi le patron composite pour représenter ces objets : un dessin peut être soit vide, soit composé d'autres dessins lui-même.

#### *Patron Builder*

Pour représenter le script de langage, nous avons opté pour le patron Builder, décrit plus en détails précédemment dans le paragraphe "Définition du langage de dessin".
Ce patron permet d'embarquer directement le langage de dessin dans le langage JAVA, sans passer par une interface graphique, ou bien une interaction avec l'utilisateur dans la console. Ce dernier utilise des méthodes pré-codées lui permettant de construire des objets, mais ces méthodes restent compréhensibles et le chaînage permis par le patron Builder permet une construction instinctive et facile, même lorsqu'on ne sait pas programmer en JAVA.

#### *Patron Interpreteur*

Nous avons choisi d'utiliser ce patron pour interpréter le script de dessin écrit par l'utilisateur. En effet, ayant 2 interprétations possibles, il nous paraissait judicieux de créer la classe Builder qui possède un constructeur, où l'on crée les dessins en faisant appel au patron Builder lui-même. Puis une méthode evaluate interprète le dessin construit selon l'interprétation choisie par l'utilisateur dans la classe Main.
Ce sera soit la méthode interpret de la classe SVG, soit celle de la classe JAVA qui sera donc appelé sur la liste des dessins créés dans le script.

Nous aurions également pu utiliser le patron visiteur pour interpréter le script. Celui-ci nous aurait permis de "visiter" la HashMap de dessins crées dans le script progressivement, en passant à travers toutes les classes et instances utilisées à l'intérieur. Cependant, comme nous n'avions que 2 interprétations à implémenter, c'est pourquoi le patron interpreteur étaient plus adapté dans ce cas là. En revanche, avec beaucoup d'interprétations, nous aurions privilégié le patron Visiteur.


### Extension du langage et ajout d'interprétations

Pour étendre le langage, on peut facilement ajouter de nouvelles méthodes dans les classes Boucle et Alternative. Si l'on souhaite ajouter de nouvelles figures, il faut implémenter une classe la représentant, sans oublier sa classe Builder associée.

Pour ajouter une nouvelle interprétation, il faudrait, dans un nouveau package, implémenter cette interprétation, puis ajouter les méthodes dessinerNouvelleInterpretation(..) et remplirNouvelleInterpretation(...) dans la classe DessinComposite ainsi que des les classes du package figure qui représentes les formes possibles.  

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




