package com.seby.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bloc extends Objet{
	
	// Variables
	
	private Image imgBloc;
	private ImageIcon icoBloc;
	
	public Bloc(int x, int y) {
		super(x, y, 30, 30); // x et y position de l'objet, 43 et 65 ce sont les dimensions de l'objet
		this.icoBloc = new ImageIcon(getClass().getResource("/images/bloc.png"));
		this.imgBloc = this.icoBloc.getImage();
		
	}

	public Image getImgBloc() {
		return imgBloc;
	}
}