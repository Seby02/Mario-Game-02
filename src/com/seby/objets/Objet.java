package com.seby.objets;

import com.seby.jeu.Main;

public class Objet {

	// Variables
	
	private int largeur; // dimension de l'objet
	private int hauteur;
	private int x; // position de l'objet
	private int y;
	
	// Constructeur
	public Objet(int x, int y, int largeur, int hauteur) {
		super();
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;

	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

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
	
	// Méthodes
	// met àjour la position en x de l'objet en enlevant le déplaccement de l'écran
	public void deplacement(){
		
		if(Main.panel.getxPos() >= 0) {
			this.x = this.x - Main.panel.getxEcran();
		}
	}
}
