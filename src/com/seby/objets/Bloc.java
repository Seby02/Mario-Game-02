package com.seby.objets;

//import java.awt.Image;
import javax.swing.ImageIcon;

public class Bloc extends Objet{
	
	// Variables
	// on passe par la superclasse objet 
//	private Image imgBloc;
//	private ImageIcon icoBloc;
	
	public Bloc(int x, int y) {
		super(x, y, 30, 30); // x et y position de l'objet, 43 et 65 ce sont les dimensions de l'objet
		super.icoObjet = new ImageIcon(getClass().getResource("/images/bloc.png"));
		super.imgObjet = this.icoObjet.getImage();
		
	}
// le getter devient inutile vu qu'on passe par la classe Objet
//	public Image getImgBloc() {
//		return imgBloc;
//	}
}