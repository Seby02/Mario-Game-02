package com.seby.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener{

	@Override
	// quand on appuie sur la touche
	public void keyPressed(KeyEvent e) {
// on utilise cette méthode pour le probleme de mise a jour de la variable
// on compense le décalage de 1 qui se fait, pour bloquer l'écran et que tous les éléments se remettent correctement
		if(e.getKeyCode() == KeyEvent.VK_D) { // si la touche est la fleche vers la droite
			if(Main.panel.getxPos()== -1){ // on est completement collé a gauche
				Main.panel.setxPos(0);
				Main.panel.setxFond1(-50);
				Main.panel.setxFond2(750);
			}
			Main.panel.mario.setMarche(true);
			Main.panel.mario.setVersDroite(true);
			Main.panel.setxEcran(1); // déplacement du fond vers la gauche quand on appuie sur la fleche droite
			
		}else if(e.getKeyCode() == KeyEvent.VK_Q){ // si la touche est la fleche vers la gauche
			Main.panel.mario.setMarche(true);
			Main.panel.mario.setVersDroite(false);
			Main.panel.setxEcran(-1); // déplacement du fond vers la droite quand on appuie sur la fleche gauche
		}
		// saut de mario
		if(e.getKeyCode() == KeyEvent.VK_SPACE ){
			Main.panel.mario.setSaut(true);
		}
	}

	@Override
	// quand on relache la touche
	public void keyReleased(KeyEvent e) {
		Main.panel.mario.setMarche(false);
		// on l'initialise a 0 pour que l'écran ne bouge plus quand on appuie sur aucune fleche
		Main.panel.setxEcran(0); 
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
