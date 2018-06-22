package com.seby.jeu;

public class Timer implements Runnable{
	
	private final int pause = 3; // temps de pause entre 2 tours de boucle en millisecondes

	@Override
	public void run() {

		while(true) { // permet d'avoir une boucle infinie, pas de conditions d'arret
			
			// appelle la fonction paintComponent par la classe Main ou on a déclarer panel avec public
			Main.panel.repaint(); 
			
			// System.out.println("coucou"); vérification si la boucle fonctionne
			
			// obligé de mettre try, catch au cas ou il y aurait un bug de l'appli
			try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
