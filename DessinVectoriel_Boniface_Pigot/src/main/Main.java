package main;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		//Création du builder
		Builder b = new Builder();
		String interpretation;
		//interpretation = "svg";
		interpretation = "graphics2D";
		//Evaluation de l'interpretation
		b.evaluate(interpretation);
	}

}
