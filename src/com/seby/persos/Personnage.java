package com.seby.persos;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.seby.jeu.Main;
import com.seby.objets.Objet;

public class Personnage {

	// VARIABLES
	
	private int largeur; // dimension du perso
	private int hauteur; // dimension du perso
	private int x; // position du perso
	private int y; // position du perso
	private boolean marche; // true quand le perso marche
	private boolean versDroite; // true quand le perso est tourné vers la droite
	public int compteur; // compteur pas perso
	
	
	public Personnage(int x, int y,int largeur, int hauteur) {
		super();
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.x = x;
		this.y = y;
		this.marche = false;
		this.versDroite = true;
		this.compteur = 0;
	}


	public int getLargeur() {
		return largeur;
	}

	 // INUTILE ON NE MODIFIE PAS LA LARGEUR DU PERSO
//	public void setLargeur(int largeur) {
//		this.largeur = largeur;
//	}


	public int getHauteur() {
		return hauteur;
	}

	 // INUTILE ON NE MODIFIE PAS LA HAUTEUR DU PERSO
//	public void setHauteur(int hauteur) {
//		this.hauteur = hauteur;
//	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public boolean isMarche() {
		return marche;
	}


	public void setMarche(boolean marche) {
		this.marche = marche;
	}


	public boolean isVersDroite() {
		return versDroite;
	}


	public void setVersDroite(boolean versDroite) {
		this.versDroite = versDroite;
	}


	public int getCompteur() {
		return compteur;
	}


	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}
	
	// METHODES
	
	public Image marche(String nom, int frequencePas) {

		
		String string;
		ImageIcon ico;
		Image img;
	

		
		if(this.marche == false || Main.panel.getxPos() <= 0) { // si le perso est à l'arrêt ou collé à gauche de l'écran
			if(this.versDroite == true) {string = "/images/" + nom + "ArretDroite.png";} // si le perso est tourné a droite , afficher ArretDroite
			else{string = "/images/" + nom + "ArretGauche.png";} // sinon afficher perso + ArretGauche
		}else{ // sinon le perso bouge et on incrémente le compteur de pas
				this.compteur++; 
				// lorsque la division du compteur est égale à 0
				if(this.compteur / frequencePas == 0){
					if(this.versDroite == true){string = "/images/" + nom + "ArretDroite.png"; // on affiche le perso vers la droite
					}else{
						string = "/images/" + nom + "ArretGauche.png"; // sinon le perso vers la gauche
					}
				}else{ // sinon si la fréquence de pas est égale à 1 
					if(this.versDroite == true){string = "/images/" + nom + "MarcheDroite.png";
					}else{
						string = "/images/" + nom + "MarcheGauche.png";
					}
					// si la division est égale à 2, on remet le compteur à 0
				}if(this.compteur == 2 * frequencePas) {
					this.compteur = 0;
				}
			}
		// AFFICHAGE DE L'IMAGE DU PERSO
		ico = new ImageIcon(getClass().getResource(string)); // on va chercher les images du coup string qui récupère plusieurs images
		img = ico.getImage();
		return img;
		}
	
	
	
//	public boolean chocAvant(Objet objet) {
//		// si mario est tourné vers la droite
//		if(this.isVersDroite() == true) {
//		// si mario est trop a gauche, droite, trop haut ou trop bas
//		if(this.x + this.largeur < objet.getX() || this.x + this.largeur > objet.getX() + 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){
//			return false;} // il n'y a pas contact
//		else {
//			return true;} // sinon il y a contact
//		}else {
//			return false;
//			}
//		}
	
	// Détection choc a droite de Mario
	protected boolean chocAvant(Objet objet) {
		if(this.x + this.largeur < objet.getX() || this.x + this.largeur > objet.getX() + 5 || 
				this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()) {
			return false;
		}else {
			return true;
			}
	}
	
	// Détection choc à gauche de Mario
	protected boolean chocArriere (Objet objet) {
		// si le coté gauche de mario > au coté gauche de l'objet + largeur ou le coté droit de mario < coté gauche de l'objet + largeur de l'objet -5
		if(this.x > objet.getX()+ objet.getLargeur() || this.x + this.largeur < objet.getX() + objet.getLargeur() - 5 ||
				this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()) {
			return false;}
		else {
			return true;
		}
	}
	
	// Détection choc en dessous de Mario
	protected boolean chocDessous (Objet objet) {
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || 
				this.y + this.hauteur < objet.getY() || this.y + this.hauteur > objet.getY() + 5) {
			return false;
		}else {
			return true;
		}
	}
	
	// Détection choc au dessus de Mario
	protected boolean chocDessus (Objet objet) {
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || 
				this.y < objet.getY() + objet.getHauteur() || this.y > objet.getY() + objet.getHauteur() + 5) {
			return false;
		}else {
			return true;
		}
	}
	// Cette méthode permet qu'il n'y ait pas de conflit au niveau des objets fixes du jeu
	// on rajoute ou enleve 10 pour la detection de l'objet
	public boolean proche (Objet objet) {
		if((this.x > objet.getX() - 10 && this.x < objet.getX() + objet.getLargeur() + 10) || 
				(this.x + this.largeur > objet.getX() - 10 && this.x + this.largeur < objet.getX() + objet.getLargeur() + 10)) {
			return true;
		}else {
			return false;
		}
	}
	}

	
