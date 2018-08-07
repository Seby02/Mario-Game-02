package com.seby.objets;

//import java.awt.Image;

import javax.swing.ImageIcon;

public class Pipe extends Objet{
	
	// Variables
	// on passe par la superclasse objet
//	private Image imgPipe;
//	private ImageIcon icoPipe;
	
	public Pipe(int x, int y) {
		super(x, y, 43, 65); // x et y position de l'objet, 43 et 65 ce sont les dimensions de l'objet
		super.icoObjet = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
		super.imgObjet = this.icoObjet.getImage();
		
	}
	// le getter devient inutile vu qu'on passe par la classe Objet
//	public Image getImgPipe() {
//		return imgPipe;
//	}
//
//	public void setImgPipe(Image imgPipe) {
//		this.imgPipe = imgPipe;
//	}
//
//	public ImageIcon getIcoPipe() {
//		return icoPipe;
//	}
//
//	public void setIcoPipe(ImageIcon icoPipe) {
//		this.icoPipe = icoPipe;
//	}

	
	
	
	
}
