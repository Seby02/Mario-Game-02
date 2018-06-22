package com.seby.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.seby.objets.Bloc;
import com.seby.objets.Pipe;
import com.seby.persos.Mario;

@SuppressWarnings("serial") // on ne mets pas de numéro de série a cette classe
public class Panel extends JPanel{

	// permet de stocker l'image de fond
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private int xFond1; // définit l'abcisse du fond
	private int xFond2; // définit l'abcisse du fond
	private int xEcran; // déplacer l'écran horizontalement
	
	private int xPos; // éléments graphiques du jeu sur l'axe x (abcisse)
	
	private int ySol; // la hauteur du sol
	private int hauteurPlafond; // la hauteur du plafond
	
	// définit les éléments graphiques du jeu
	private ImageIcon icoChateau1;
	private Image imgChateau1;
	private ImageIcon icoDepart;
	private Image imgDepart;
	
//	private ImageIcon icoMario; // provisoire
//	private Image imgMario; // provisoire
	
	public Mario mario; 
	public Pipe pipe1;
	public Bloc bloc1;
	
	// Constructeur
	
	public Panel() {
		super();
		
		this.xFond1 = -50; // l'image du fond va déborder de chaque coté de l'écran
		this.xFond2 = 750; // l'image fait 800 de large donc 800 - 50 = 750
		this.xEcran = 0;
		this.xPos = -1; // il est a -1 pour pouvoir le manipuler + facilement
		this.ySol = 293; // du sol au plafond il y a 293 en y
		this.hauteurPlafond = 0;
		
		icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
		this.imgFond1 = this.icoFond.getImage(); // associe l'icone à l'image de fond
		this.imgFond2 = this.icoFond.getImage();
//		icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
//		this.imgMario = this.icoMario.getImage(); // associe l'icone à l'image de fond
		
		this.icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
		this.imgChateau1 = this.icoChateau1.getImage(); // associe l'icone à l'image de fond
		this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		this.imgDepart = this.icoDepart.getImage(); // associe l'icone à l'image de fond
		
		mario = new Mario(325, 245);
		pipe1 = new Pipe(850, 230);
		bloc1 = new Bloc(600, 180);
		
		this.setFocusable(true); // permet au composant d'avoir le focus
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier()); 
		
		//instanciation du Timer
		
		Thread timerEcran = new Thread(new Timer()); // création d'un programme indépendant 
		timerEcran.start();
	}
	
	
	
	public int getySol() {
		return ySol;
	}

	public void setySol(int ySol) {
		this.ySol = ySol;
	}

	public int getHauteurPlafond() {
		return hauteurPlafond;
	}

	public void setHauteurPlafond(int hauteurPlafond) {
		this.hauteurPlafond = hauteurPlafond;
	}

	public int getxEcran() {
		return xEcran;
	}
	//permet de modifier la valeur xEcran à l'extérieur de la classe
	public void setxEcran(int xEcran) {
		this.xEcran = xEcran;
	}
	
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	public int getxFond1() {
		return xFond1;
	}

	public void setxFond1(int xFond1) {
		this.xFond1 = xFond1;
	}

	public int getxFond2() {
		return xFond2;
	}

	public void setxFond2(int xFond2) {
		this.xFond2 = xFond2;
	}
	
	
	// LES DIFFERENTES METHODES

	// mettre à jour le déplacement du fond
	public void deplacementFond() {
		
		// on ne veut pas reculer vers la gauche (avant le chateau)
// a partir du moment ou xPos va etre négatif on ne pourra plus aller vers la gauche
		if(this.xPos >= 0) {
			this.xPos = this.xPos + this.xEcran;
			
		// la position du fond va se mettre à jour en tenant compte de la valeur de xEcran
			this.xFond1 = this.xFond1 - this.xEcran; 
			this.xFond2 = this.xFond2 - this.xEcran;
		}
		
		// combler le vide à gauche de l'écran
		if(this.xFond1 == -800) { // si toute l'image1 est a gauche de l'écran
			this.xFond1 = 800;} // xFond2 est à 0 donc l'image 2 prend tout l'écran, en mettant 800 a xFond1, on la mets à la suite
			else if(this.xFond2 == -800) {
				this.xFond2 = 800;
			}
			
		// combler le vide à droite de l'écran
			else if(this.xFond1 == 800) { // si toute l'image1 est a droite de l'écran
			this.xFond1 = -800;} // xFond2 est à 0 donc l'image 2 prend tout l'écran, en mettant -800 a xFond1, on la mets à la suite
			else if(this.xFond2 == 800) {
				this.xFond2 = -800;
			}
		
	}
	
	// Dessiner sous java
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g; // permet d'avoir un meilleur rendu des graphismes  (graphics2D)
		
		// Détection du contact
		// s'il y a contact avec le tuyau rouge, mario s'arrête et l'écran s'arrête
//		if(this.mario.chocAvant(pipe1) == true) {
//			this.mario.setMarche(false);
//			this.xEcran = 0;
//		}
//		this.mario.choc(pipe1);
//		this.mario.choc(bloc1);
		// si mario est proche du bloc alors mario aura un choc (avant arriere dessous dessus)
		if(this.mario.proche(this.bloc1)){
			this.mario.choc(bloc1);
		}
		// si mario est proche du pipe alors mario aura un choc (avant arriere dessous dessus)
		if(this.mario.proche(this.pipe1)) {
			this.mario.choc(pipe1);
		}
		
		// Déplacement des objets non mobiles du jeu
		this.deplacementFond();
		this.pipe1.deplacement();
		this.bloc1.deplacement();
		

		
		// 1. image que l'on dessine, 2 et 3. sa position, 4. observer : toujours null permettait de précharger une image a l'époque des petites connexions
		g2.drawImage(this.imgFond1, this.xFond1, 0, null); 
		g2.drawImage(this.imgFond2, this.xFond2, 0, null); 
//		g2.drawImage(this.mario.marche("mario", 25), 325, 245, null); // "mario" est égale au nom du perso, et le 25 est la fréquence de pas
		// ajout de xPos pour éviter que le chateau et le drapeau bouge
		g2.drawImage(imgChateau1, 10 - this.xPos, 95, null); 
		g2.drawImage(imgDepart, 220 - this.xPos, 234, null);
		g2.drawImage(this.pipe1.getImgPipe(), this.pipe1.getX(), this.pipe1.getY(), null); // suppression de xPos pour que le tuyau ne bouge plus
		g2.drawImage(this.bloc1.getImgBloc(), this.bloc1.getX(), this.bloc1.getY(), null);
		if(this.mario.isSaut()) {
			g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);
		}else {
			g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);
		}
	}



	
}
