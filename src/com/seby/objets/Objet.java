package com.seby.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.seby.jeu.Main;

public class Objet {

	// Variables
	
	private int largeur; // dimension de l'objet
	private int hauteur;
	private int x; // position de l'objet
	private int y;
	
	// permet d'avoir l'image directement de la superclasse (pour passer à une image générique, plus besoin de passer par une image pipe et bloc)
	// on mets protected pour que les sous classes puissent accéder aux variables 
	protected Image imgObjet;
	protected ImageIcon icoObjet;
	
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
	
	public Image getImgObjet() {
		return imgObjet;
	}

	public void setImgObjet(Image imgObjet) {
		this.imgObjet = imgObjet;
	}
	
	// Méthodes
	// met àjour la position en x de l'objet en enlevant le déplaccement de l'écran
	public void deplacement(){
		
		if(Main.panel.getxPos() >= 0) {
			this.x = this.x - Main.panel.getxEcran();
		}
	}
}
