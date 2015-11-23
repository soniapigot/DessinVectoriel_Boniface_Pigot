package graphics2DInterpretation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import figures.Carre;
import figures.Cercle;
import figures.Rectangle;
import figures.Segment;
import figures.Triangle;
import outils.Crayon;
import outils.Couleurs;

public class Bibliotheque {
	
	public static Color couleurs(Couleurs c) {
		Color color = Color.black;
		switch (c) {
			case black: color = Color.black; break;
			case red: color = Color.red; break;
			case blue: color = Color.blue; break;
			case yellow: color = Color.yellow; break;
			case green: color = Color.green; break;
			case pink: color = Color.pink; break;
			case purple: color = Color.magenta; break;
			case orange: color = Color.orange; break;
			case white: color = Color.white; break;
			case grey: color = Color.gray; break;
			case transparent: color = null; break;
		}
		return color;
	}
	
	public static void createCarre(Graphics g, Carre car, Crayon crayon) {
	    Font font = new Font("Courier", Font.BOLD, crayon.getEpaisseurTrait()*10);
	    g.setFont(font);
		g.setColor(couleurs(crayon.getCouleur()));
		g.drawRect(car.getP().getAbscisse(), car.getP().getOrdonnee(), car.getCote(), car.getCote());
	}
	
	public static void createCercle(Graphics g, Cercle c, Crayon crayon) {
	    Font font = new Font("Courier", Font.BOLD, crayon.getEpaisseurTrait()*10);
	    g.setFont(font);
		g.setColor(couleurs(crayon.getCouleur()));
		g.drawOval(c.getCentre().getAbscisse()-c.getDiametre()/2, c.getCentre().getOrdonnee()-c.getDiametre()/2, c.getDiametre(), c.getDiametre());
	}
	
	public static void createRect(Graphics g, Rectangle r, Crayon crayon) {
	    Font font = new Font("Courier", Font.BOLD, crayon.getEpaisseurTrait()*10);
	    g.setFont(font);
		g.setColor(couleurs(crayon.getCouleur()));
		g.drawRect(r.getP().getAbscisse(), r.getP().getOrdonnee(), r.getLongueur(), r.getHauteur());
	}
	
	public static void createSegment(Graphics g, Segment s, Crayon crayon) {
	    Font font = new Font("Courier", Font.BOLD, crayon.getEpaisseurTrait()*10);
	    g.setFont(font);
		g.setColor(couleurs(crayon.getCouleur()));
		g.drawLine(s.getPoint1().getAbscisse(), s.getPoint1().getOrdonnee(), s.getPoint2().getAbscisse(), s.getPoint2().getOrdonnee());
	}
	
	public static void createTriangle(Graphics g, Triangle t, Crayon crayon) {
	    Font font = new Font("Courier", Font.BOLD, crayon.getEpaisseurTrait()*10);
	    g.setFont(font);
		g.setColor(couleurs(crayon.getCouleur()));
		int[] tabAbscisses = new int[3];
		tabAbscisses[0] = t.getP1().getAbscisse();
		tabAbscisses[1] = t.getP2().getAbscisse();
		tabAbscisses[2] = t.getP3().getAbscisse();
		int[] tabOrdonnees = new int[3];
		tabOrdonnees[0] = t.getP1().getOrdonnee();
		tabOrdonnees[1] = t.getP2().getOrdonnee();
		tabOrdonnees[2] = t.getP3().getOrdonnee();
		Polygon p = new Polygon(tabAbscisses,tabOrdonnees,3);
		g.drawPolygon(p);
	}
	
	public static void fillCarre(Graphics2D g, Carre car, Crayon crayon) {
		g.setPaint(couleurs(crayon.getCouleur()));
		g.fillRect(car.getP().getAbscisse(), car.getP().getOrdonnee(), car.getCote(), car.getCote());
	}
	
	public static void fillCercle(Graphics2D g, Cercle c, Crayon crayon) {
		g.setPaint(couleurs(crayon.getCouleur()));
		g.fillOval(c.getCentre().getAbscisse()-c.getDiametre()/2, c.getCentre().getOrdonnee()-c.getDiametre()/2, c.getDiametre(), c.getDiametre());
	}
	
	public static void fillRect(Graphics2D g, Rectangle r, Crayon crayon) {
		g.setPaint(couleurs(crayon.getCouleur()));
		g.fillRect(r.getP().getAbscisse(), r.getP().getOrdonnee(), r.getLongueur(), r.getHauteur());
	}
	
	public static void fillTriangle(Graphics2D g, Triangle t, Crayon crayon) {
		g.setPaint(couleurs(crayon.getCouleur()));
		int[] tabAbscisses = new int[3];
		tabAbscisses[0] = t.getP1().getAbscisse();
		tabAbscisses[1] = t.getP2().getAbscisse();
		tabAbscisses[2] = t.getP3().getAbscisse();
		int[] tabOrdonnees = new int[3];
		tabOrdonnees[0] = t.getP1().getOrdonnee();
		tabOrdonnees[1] = t.getP2().getOrdonnee();
		tabOrdonnees[2] = t.getP3().getOrdonnee();
		Polygon p = new Polygon(tabAbscisses,tabOrdonnees,3);
		g.fillPolygon(p);
	}

}
