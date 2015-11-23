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

##Interprétations du langage

Les interprétations choisis pour ce projet sont: SVG, Graphics2D. Le patron interpréteur pour implémenter ces deux interprétations. Pour cela, une méthode evaluate a été coder dans la classe Builder afin d'évaluer l'interprétation. Cette méthode appelle la méthode interpret de la classe SVG si l'interprétation SVG a été choisi ou la méthode interpret de la classe JAVA si l'interprétation Graphics2D a été choisi. Ces méthodes prennent en argument la HashMap de DessinComposite créée précédement.

###SVG

Un fichier dessinVide.svg se situe dans le dossier fichierSVG à la racine du projet. Ce fichier est seulement constitué de la balise d'ouverture pour configurer un fichier SVG. 

La méthode interpret de la classe SVG fait pour chaque dessin dans la HashMap de DessinComposite:

- un copie du contenu de dessinVide.svg dans un nouveau fichier SVG enregistré avec le nom que l'utilisateur a donné au dessin. 
- appelle la fonction TexteSVG prenant pour argument le titre du dessin, le dessin en cours dans la boucle et un booléan assigné à true afin de signifier que ce dessin n'est pas un dessin inséré dans un autre dessin.

La fonction TexteSVG quant à elle, parcourt le dessin, c'est-à-dire qu'elle parcourt la liste de Forme du dessin, la liste d'Etiquette du dessin et la liste de IDessin du dessin pris en argument. La liste de IDessin représentant la liste de dessin insérés dans le dessin. Durant ce parcourt, le fichier SVG créé par la fonction interpret est rempli. 

En effet, la fonction dessinerSVG est appeler pour construire les figures. La fonction etiqueterSVG est appeler pour construire des etiquettes. Ces fonctions renvoient un String qui va être écrit dans le fichier SVG grâce à un FileWriter. Par exemple la création d'une Etiquette sous SVG se fait comme-ci: 

Dans la méthode TexteSVG:

		  	for(Etiquette e: listeEtiquette) {
			 texte = "\r\n <text " + dessin.etiqueterSVG(e) + ">" + e.getEtiquete() + "</text>";
			 writer.write(texte,0,texte.length());
		 }

Où dessin est le dessin pris en argument de la fonction et writer est le FileWriter.

La méthode etiqueterSVG quant à elle est situé dans la classe DessinComposite dont l'architecture sera précisé dans le paragraphe suivant: 

	public String etiqueterSVG(Etiquette e) {
		return "x=\""+ e.getPoint().getAbscisse() + "\" y=\"" + e.getPoint().getOrdonnee() + "\" stroke=\"" + e.getCrayon().getCouleur() + "\"  stroke-width=\"" + e.getCrayon().getEpaisseurTrait() + "\"";
	}

En effet une Etiquette est composée d'un Point et a une crayon ayant une couleur et une épaisseur.

Le parcourt de la liste de dessin est quant à lui traité différent des deux précédentes liste. La liste de dessin rappel la fonction TexteSVG pour parcourir les dessins insérer et ajouter les formes, étiquettes et dessins insérés du dessin inséré de la liste de dessin inséré. Cependant, pour notifié que c'est un dessin inséré, le boolean sera false. En effet, si la fonction est appliqué à un dessin inséré alors la balise de fin de fichier SVG ne doit pas être ajouté. C'est pourquoi à la fin de la méthodé TexteSVG, pour inséré cette balise, le boolean est vérifié.

Le dessin SVG est alors fini et se situe dans fichierSVG. L'utilisateur peut le lancer dans son navigateur par défaut.


###Graphics2D

La méthode interpret de la classe SVG fait pour chaque dessin dans la HashMap de DessinComposite la création d'une Fenetre qui sera la fenêtre de dessin prenant pour argument la HashMap de DessinComposite créé dans le Builder.

Dans la classe Fenetre héritant de JFrame, une fenêtre est créé grâce au constructeur de la façon suivante:

- avec un titre étant le nom du dessin
- étant à la taille de l'écran
- soit visible
- fermant l'application lorsque la fenêtre est fermée
- créé un Panneau à l'intérieur de la fenêtre grâce à un constructeur de Panneau.

Un Panneau est une classe qui hérite de JPanel et qui a une instance de type Entry. 

Lorsque la Fenetre est créé, la méthode paintComponant de Panneau est automatiquement appelée. Cette méthode parcourt l'instance créé grâce au constructeur de Panneau dans le constructeur de Fenetre. Cette instance a donc été initialisée avec l'ensemble des DessinComposite de la HashMap. Ainsi comme, dans l'interprétation SVG, la liste de Forme et la liste d'étiquettes sont parcourues. Par exemple pour une liste de Forme:

    	for(Forme f: listeForme) {
	    	 IChemin c = f.getChemin();
	       	 entry.getValue().dessinerJAVA((Graphics2D) g, c, f.getCrayonContour());
	       	 entry.getValue().remplirJAVA((Graphics2D) g, c, f.getCrayonRemplir());
	     }

Il y a un appel aux méthodes dessinerJAVA et remplirJAVA qui sont dans DessinComposite et qui font appel à la classe static Bibliotheque contenant toutes les méthodes pour remplir ou dessiner des formes ou des etiquettes en Graphics2D. Un exemple de création de carré est le suivant:

    public static void createCarre(Graphics g, Carre car, Crayon crayon) {
	    Font font = new Font("Courier", Font.BOLD, crayon.getEpaisseurTrait()*10);
	    g.setFont(font);
		g.setColor(couleurs(crayon.getCouleur()));
		g.drawRect(car.getP().getAbscisse(), car.getP().getOrdonnee(), car.getCote(), car.getCote());
	}

Ainsi le dessin vectoriel est créé au lancement de l'application.

##Architecture logicielle

##Guide d'utilisation






