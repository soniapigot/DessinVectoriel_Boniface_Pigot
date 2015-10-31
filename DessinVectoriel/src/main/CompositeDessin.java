package main;

import java.util.ArrayList;

import Figure.IChemin;
import Figure.Position;

public class CompositeDessin implements IDessin{

	private ArrayList<IDessin> dessins = new ArrayList<IDessin>();
	
	
	@Override
	public void dessiner(IDessin d, IChemin chemin, Crayon crayon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remplir(IDessin d, IChemin chemin, Crayon crayon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserer(IDessin d1, IDessin d2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void etiqueter(IDessin d, Position p, String s) {
		// TODO Auto-generated method stub
		
	}
	
	public void sequence(){
	// TODO	
	}

	public void alternative(){
	//TODO
	}
	
	public void boucle(){
	//TODO
	}
}
