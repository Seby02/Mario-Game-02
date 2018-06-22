package com.seby.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Pipe extends Objet{
	
	// Variables
	
	private Image imgPipe;
	private ImageIcon icoPipe;
	
	public Pipe(int x, int y) {
		super(x, y, 43, 65); // x et y position de l'objet, 43 et 65 ce sont les dimensions de l'objet
		this.icoPipe = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
		this.imgPipe = this.icoPipe.getImage();
		
	}

	public Image getImgPipe() {
		return imgPipe;
	}
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
