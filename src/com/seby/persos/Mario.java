package com.seby.persos;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.seby.jeu.Main;
import com.seby.objets.Objet;
import com.seby.objets.Piece;

public class Mario extends Personnage {

	// VARIABLES
	private ImageIcon icoMario; 
	private Image imgMario; 
	private boolean saut; // vrai si mario saute
	private int compteurSaut; // g�rer la dur�e et la hauteur du saut
	
	// CONSTRUCTEUR
	public Mario(int x, int y) {
		
		super(x, y, 28, 50); // 28 et 50 sont les valeurs de la taille de l'image
		this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
		this.imgMario = this.icoMario.getImage();
		this.saut = false;
		this.compteurSaut = 0;
	}

	
	public boolean isSaut() {
		return saut;
	}


	public void setSaut(boolean saut) {
		this.saut = saut;
	}


	public Image getImgMario() {
		return imgMario;
	}

	public void setImgMario(Image imgMario) {
		this.imgMario = imgMario;
	}

	
	// M�thodes
	
	public Image saute() {
		
		ImageIcon ico;
		Image img;
		String str;
		
		this.compteurSaut++; // incr�mentation du saut
		
		// Mont�e de mario en sautant
		if(this.compteurSaut <= 40) { // hauteur du saut de mario
			if(this.getY() > Main.panel.getHauteurPlafond()) { // si la tete de mario est sup�rieur de la hauteur du plafond
				this.setY(this.getY() - 4 ); // on fait monter mario � l'�cran et son ordonn�e va baisser
			}else {
				this.compteurSaut = 41; // on bloque le compteur � 41
			}
			if(this.isVersDroite() == true) {
				str = "/images/marioSautDroite.png";
			}else{
				str = "/images/marioSautGauche.png";
			}
		// retomb�e de mario apres le saut
		}else if (this.getY() + this.getHauteur() < Main.panel.getySol()) { // si les pieds de mario sont inf�rieurs � la hauteur du sol
			this.setY(this.getY() + 1); // on fait redescendre mario 
			if(this.isVersDroite() == true) {
				str = "/images/marioSautDroite.png";
			}else{
				str = "/images/marioSautGauche.png";
			}
		// Atterissage de mario
		}else { // d�s que mario touche le sol, on change les images de mario
			if(this.isVersDroite() == true) {
				str = "/images/marioArretDroite.png";
			}else{
				str = "/images/marioArretGauche.png";
			}
			this.saut = false; // la variable de saut passe � false
			this.compteurSaut = 0; // le compteur saut passe � 0
		}
		
		// Affichage de Mario
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
		
	}
	
	public void choc (Objet objet) {
		// choc horizontal
		
		if((super.chocAvant(objet) == true && this.isVersDroite() == true) || (super.chocArriere(objet) == true && this.isVersDroite() == false)) {
			Main.panel.setxEcran(0); 
			this.setMarche(false);
		}
		// choc avec objet en dessous
		
		if(super.chocDessous(objet) == true && this.saut == true) { // si mario saute sur un objet
			Main.panel.setySol(objet.getY());
		}else if(super.chocDessous(objet) == false) { // et si Mario tombe sur le sol
			Main.panel.setySol(293); // position du sol initial
			if(this.saut == false) { // si mario arr�te de sauter et tombe d'une plateforme
				this.setY(243); // altitude initiale de mario (on doit mettre ce IF sinon mario reste en l'air et vole)
			}
		}
		
		// choc avec objet au dessus
		if(super.chocDessus(objet) == true) {
			Main.panel.setHauteurPlafond(objet.getY() + objet.getHauteur()); // le plafond devient le dessous de l'objet
		}else if(super.chocDessus(objet) == false && this.saut == false) {
			Main.panel.setHauteurPlafond(0); // altitude du plafond
		}
	}
	
	public boolean chocPiece (Piece piece) {
		if(this.chocArriere(piece) == true || this.chocAvant(piece) == true || this.chocDessous(piece) == true || this.chocDessus(piece) == true) {
			return true;
		}else {
			return false;
		}
	}
	
}
