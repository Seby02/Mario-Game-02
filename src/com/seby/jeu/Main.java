package com.seby.jeu;

import javax.swing.JFrame;

public class Main {

	public static Panel panel;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Cr�ation de la fen�tre du jeu
		
		JFrame fenetre = new JFrame("Mario Game");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permet la fermeture du programme (croix rouge)
		fenetre.setSize(750, 390);
		fenetre.setLocationRelativeTo(null); // centrer la fen�tre � l'�cran
		fenetre.setResizable(false); // ne pas redimensionner la fenetre
		fenetre.setAlwaysOnTop(true); // au dessus de toutes les fenetres du PC
		
		// Instanciation de l'objet panel
		panel = new Panel();
		
		fenetre.setContentPane(panel); // association du panel � la fenetre du jeu
		fenetre.setVisible(true);
		
	}

}
