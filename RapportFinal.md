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


L'utilisateur crée au début du script toutes les instances de Builder dont il aura besoin : ici, il souhaite dessiner un carré et un cercle, en utilisant des crayons, ce qui donnera une forme (une Forme étant un triplet IChemin chemin, Crayon crayonContour, Crayon crayonRemplir). L'utilisateur






##Interprétations du langage

##Architecture logicielle

##Guide d'utilisation






