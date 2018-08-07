package com.seby.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Piece extends Objet implements Runnable{
	
	// Variables
	private int compteur;
	private final int pause = 15; // temps de pause entre 2 tours de boucle en millisecondes
	
	public Piece(int x, int y) {
		super(x, y, 30, 30); // x et y position de l'objet, 30 et 30 ce sont les dimensions de l'objet
		super.icoObjet = new ImageIcon(getClass().getResource("/images/piece1.png"));
		super.imgObjet = this.icoObjet.getImage();
		
	}
	
	// M�thodes
	
	public Image bouge() { // Mouvement Pi�ces
		
		ImageIcon ico;
		Image img;
		String str;
		
		this.compteur++; 
		// permet l'effet de clignotement de la pi�ce
		if (this.compteur / 100 == 0) {
			str = "/images/piece1.png";
		}else {
			str = "/images/piece2.png";
		}
		if (this.compteur == 200) {
			this.compteur = 0 ;
		}
		
		// Affichage de Mario
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(20); // on mets 20ms avant d'appeler la m�thode bouge pour permettre la cr�ation de tous les objets
		} catch (InterruptedException e) {
		}
		while (true) { // boucle infinie
			this.bouge(); // appel de la m�thode toutes les 20ms ce qui permet d'afficher soit l'image piece1 ou l'image piece2
			try {
				Thread.sleep(pause);
		} catch (InterruptedException e){
			
		}
		
	}
}
}