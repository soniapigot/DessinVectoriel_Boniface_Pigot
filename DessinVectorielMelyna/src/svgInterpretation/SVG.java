package svgInterpretation;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import outils.Etiquette;
import outils.Forme;
import patronComposite.DessinComposite;
import patronComposite.IDessin;

public class SVG {
	
	//M�thode permettant la copie d'un fichier source a une certaine destination
	public static boolean copyFile(File source, File dest){
		try{
			// Declaration et ouverture des flux
			java.io.FileInputStream sourceFile = new java.io.FileInputStream(source);
			try{
				java.io.FileOutputStream destinationFile = null;
				try{
					destinationFile = new FileOutputStream(dest);
					// Lecture par segment de 0.5Mo 
					byte buffer[] = new byte[512 * 1024];
					int nbLecture;
					while ((nbLecture = sourceFile.read(buffer)) != -1){
						destinationFile.write(buffer, 0, nbLecture);
					}
				} finally {
					destinationFile.close();
				}
			} finally {
				sourceFile.close();
			}
		} catch (IOException e){
			e.printStackTrace();
			return false; // Erreur
		}
		return true; // R�sultat OK  
	}
	
	
	//M�thode qui interpr�te l'ensemble des dessins
	public void interpret(HashMap<String, DessinComposite> dessins) throws IOException {
		//Fichier svg vide
		File finit = new File("fichierSVG/dessinVide.svg");
		
		//On parcourt sur tous les dessins composites cr�� par l'utilisateur
		for (HashMap.Entry<String, DessinComposite> entry: dessins.entrySet()) {
			
			//Pour chaque dessin cr�er par l'utilisateur on copie le fichier svg vide sur le bureau de l'utilisateur afin de le remplir ensuite
			copyFile(finit,new File("fichierSVG/" + entry.getKey() + ".svg"));
			
			this.TexteSVG(entry.getKey(), entry.getValue(), true);
			
		}
	}
	
	public String TexteSVG(String nomDuDessin, IDessin dessin, Boolean b) {
		FileWriter writer = null;
		String texte = "";
		try{
			writer = new FileWriter("fichierSVG/" + nomDuDessin + ".svg", true);
			
		     //Ensemble des Formes (compos� de Chemin, crayon pour contour, crayon pour remplir)
		     ArrayList<Forme> listeForme = ((DessinComposite) dessin).getListeForme();
		     
		     //Ensemble des Etiquetes
		     ArrayList<Etiquette> listeEtiquette = ((DessinComposite) dessin).getListeEtiquete();
		     
		     //Liste des dessins ins�r�s
		     ArrayList<IDessin> listeDessin = ((DessinComposite) dessin).getListeDessin();
		     
		     //On parcourt toutes les formes du dessin et on regarde quelle est le chemin, et les crayons utilis�s
		     for(Forme f: listeForme) {
		    	 texte = "\r\n <" + dessin.dessinerSVG(f.getChemin(), f.getCrayonContour()) + dessin.remplirSVG(f.getCrayonRemplir()) + "/>";
		    	 writer.write(texte,0,texte.length());
		     }
		     
		     //On parcourt toutes les etiquettes du dessin et on regarde quelle est le message, et les crayons utilis�s
		     for(Etiquette e: listeEtiquette) {
		    	 texte = "\r\n <text " + dessin.etiqueterSVG(e) + ">" + e.getEtiquete() + "</text>";
	    		 writer.write(texte,0,texte.length());
		     }
		     
		     //On parcourt la liste des dessins ins�r�s et on l'ins�re au dessin
		     for(IDessin d: listeDessin) {
		    	 texte = "\r\n " + this.TexteSVG(nomDuDessin, d, false);
		    	 writer.write(texte,0,texte.length());
		     }
		     
		     if (b == true) {
			     //On finit le script SVG par la balise finale
			     String texteSVG = "\r\n </svg>";
			     writer.write(texteSVG,0,texteSVG.length());
		     }
		     
		}catch(IOException ex){
		    ex.printStackTrace();
		}finally{
		  if(writer != null){
		     try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
		}
		return texte;
	}
	
}