package graphics2DInterpretation;


import java.util.Map.Entry;

import javax.swing.JFrame;

import patronComposite.DessinComposite;

public class Fenetre extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//Création d'une fenêtre 
public Fenetre(Entry<String, DessinComposite> entry){
	    this.setTitle(entry.getKey());
	    this.setSize(400, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
  		this.setContentPane(new Panneau(entry));
  		this.setVisible(true);
  		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
  }

}