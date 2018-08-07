package com.seby.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.seby.objets.Bloc;
import com.seby.objets.Objet;
import com.seby.objets.Piece;
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
	public Pipe pipe2;
	public Pipe pipe3;
	public Pipe pipe4;
	public Pipe pipe5;
	public Pipe pipe6;
	public Pipe pipe7;
	public Pipe pipe8;
	
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;
	public Bloc bloc9;
	public Bloc bloc10;
	public Bloc bloc11;
	public Bloc bloc12;
	
	public Piece piece1;
	public Piece piece2;
	public Piece piece3;
	public Piece piece4;
	public Piece piece5;
	public Piece piece6;
	public Piece piece7;
	public Piece piece8;
	public Piece piece9;
	public Piece piece10;
	
	private ImageIcon icoChateauFin;
	private Image imgChateauFin;
	private ImageIcon icoDrapeau;
	private Image imgDrapeau;
	
	private ArrayList<Objet> tabObjets; // Tableau qui contient l'ensemble des objets du jeu
	// tableau qui contient toutes les pieces, on ne l'inclut pas aux objets vu que les pièces n'ont pas le meme comportement que les blocs et tuyaux au contact de mario
	private ArrayList<Piece> tabPieces; 
	
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
		
		// création de tous les tuyaux du jeu
		
		pipe1 = new Pipe(850, 230);
		pipe2 = new Pipe(1050, 230);
		pipe3 = new Pipe(1650, 230);
		pipe4 = new Pipe(2250, 230);
		pipe5 = new Pipe(2650, 230);
		pipe6 = new Pipe(3050, 230);
		pipe7 = new Pipe(3550, 230);
		pipe8 = new Pipe(4200, 230);
		
		// création de tous les blocs du jeu
		bloc1 = new Bloc(600, 180);
		bloc2 = new Bloc(950, 180);
		bloc3 = new Bloc(1300, 160);
		bloc4 = new Bloc(1450, 180);
		bloc5 = new Bloc(1800, 180);
		bloc6 = new Bloc(2400, 180);
		bloc7 = new Bloc(2750, 180);
		bloc8 = new Bloc(3200, 170);
		bloc9 = new Bloc(3400, 180);
		bloc10 = new Bloc(3700, 160);
		bloc11 = new Bloc(3900, 170);
		bloc12 = new Bloc(4100, 180);
		
		// création de toutes les pièces du jeu
		piece1 = new Piece(600, 150);
		piece2 = new Piece(950, 130);
		piece3 = new Piece(1350, 170);
		piece4 = new Piece(1550, 170);
		piece5 = new Piece(2000, 170);
		piece6 = new Piece(2550, 170);
		piece7 = new Piece(2850, 170);
		piece8 = new Piece(3250, 170);
		piece9 = new Piece(3650, 160);
		piece10 = new Piece(4100, 60);
		
		// instanciation du tableau d'objets
		tabObjets = new ArrayList<Objet>();
		
		// remplissage du tableau d'objet du jeu
		this.tabObjets.add(this.pipe1);
		this.tabObjets.add(this.pipe2);
		this.tabObjets.add(this.pipe3);
		this.tabObjets.add(this.pipe4);
		this.tabObjets.add(this.pipe5);
		this.tabObjets.add(this.pipe6);
		this.tabObjets.add(this.pipe7);
		this.tabObjets.add(this.pipe8);

		this.tabObjets.add(this.bloc1);
		this.tabObjets.add(this.bloc2);
		this.tabObjets.add(this.bloc3);
		this.tabObjets.add(this.bloc4);
		this.tabObjets.add(this.bloc5);
		this.tabObjets.add(this.bloc6);
		this.tabObjets.add(this.bloc7);
		this.tabObjets.add(this.bloc8);
		this.tabObjets.add(this.bloc9);
		this.tabObjets.add(this.bloc10);
		this.tabObjets.add(this.bloc11);
		this.tabObjets.add(this.bloc12);
		
		// instanciation du tableau de pièces
		tabPieces = new ArrayList<Piece>();
		
		this.tabPieces.add(this.piece1);
		this.tabPieces.add(this.piece2);
		this.tabPieces.add(this.piece3);
		this.tabPieces.add(this.piece4);
		this.tabPieces.add(this.piece5);
		this.tabPieces.add(this.piece6);
		this.tabPieces.add(this.piece7);
		this.tabPieces.add(this.piece8);
		this.tabPieces.add(this.piece9);
		this.tabPieces.add(this.piece10);
		
		
		this.icoChateauFin = new ImageIcon(getClass().getResource("/images/chateauFin.png"));
		this.imgChateauFin = this.icoChateauFin.getImage(); // associe l'icone à l'image de fond
		this.icoDrapeau = new ImageIcon(getClass().getResource("/images/drapeau.png"));
		this.imgDrapeau = this.icoDrapeau.getImage(); // associe l'icone à l'image de fond
		
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
// a partir du moment ou xPos va etre négatif on ne pourra plus aller vers la gauche et s'il est positif au dela de 4300 vers la droite
		if(this.xPos >= 0 && this.xPos <= 4300) {
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
//		if(this.mario.proche(this.bloc1)){
//			this.mario.choc(bloc1);
//		}
//		// si mario est proche du pipe alors mario aura un choc (avant arriere dessous dessus)
//		if(this.mario.proche(this.pipe1)) {
//			this.mario.choc(pipe1);
//		}
		
		// Détection des contacts avec les objets (avec le tableau d'objets)
		for(int i = 0; i < this.tabObjets.size(); i++) {
			if(this.mario.proche(this.tabObjets.get(i))){
				this.mario.choc(this.tabObjets.get(i));
			}
		}
		
		// Détection des contacts avec les pièces (+ suppresion des pièces du tableau)
				for(int i = 0; i < this.tabPieces.size(); i++) {
					if(this.mario.proche(this.tabPieces.get(i))){
						if(this.mario.chocPiece(this.tabPieces.get(i))) {
							this.tabPieces.remove(i);
						}
					}
				}
		
		// Déplacement des objets non mobiles du jeu
		this.deplacementFond();
		// remplacement de la fonction deplacement par le tableau d'objets
//		this.pipe1.deplacement();
//		this.bloc1.deplacement();
		// condition pour empêcher les objets de se déplacer après la fin du drapeau
		if(this.xPos >= 0 && this.xPos <= 4300) {
			for(int i = 0; i < this.tabObjets.size(); i++) {
			this.tabObjets.get(i).deplacement();
			}
			for(int i = 0; i < this.tabPieces.size(); i++) {
				this.tabPieces.get(i).deplacement();
				}
		}
		

		
		// 1. image que l'on dessine, 2 et 3. sa position, 4. observer : toujours null permettait de précharger une image a l'époque des petites connexions
		// image de fond
		g2.drawImage(this.imgFond1, this.xFond1, 0, null); 
		g2.drawImage(this.imgFond2, this.xFond2, 0, null); 
		
//		g2.drawImage(this.mario.marche("mario", 25), 325, 245, null); // "mario" est égale au nom du perso, et le 25 est la fréquence de pas
		// ajout de xPos pour éviter que le chateau et le drapeau bouge
		
		// image du chateau de départ
		g2.drawImage(imgChateau1, 10 - this.xPos, 95, null); 
		
		// image du panneau de départ
		g2.drawImage(imgDepart, 220 - this.xPos, 234, null);
		
		//Devient inutile vu qu'on a remplacé les variables bloc par objet
//		g2.drawImage(this.pipe1.getImgPipe(), this.pipe1.getX(), this.pipe1.getY(), null); // suppression de xPos pour que le tuyau ne bouge plus
//		g2.drawImage(this.bloc1.getImgBloc(), this.bloc1.getX(), this.bloc1.getY(), null);
		
		// Images des objets (pipe et bloc)
		for(int i = 0; i < this.tabObjets.size(); i++) {
			g2.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(), this.tabObjets.get(i).getY(), null);
		}
		
		// Images des pièces
		for(int i = 0; i < this.tabPieces.size(); i++) {
			g2.drawImage(this.tabPieces.get(i).bouge(), this.tabPieces.get(i).getX(), this.tabPieces.get(i).getY(), null);
		}
		
		// Image du drapeau d'arrivée
		g2.drawImage(imgDrapeau, 4500 - this.xPos, 115, null); 
		
		// Image du chateau d'arrivée
		g2.drawImage(imgChateauFin, 4900 - this.xPos, 145, null); 
		
		// image de Mario
		if(this.mario.isSaut()) {
			g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);
		}else {
			g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);
		}
	}



	
}
