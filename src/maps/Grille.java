package maps;

import java.util.Random;

import protagonistes.*;

/**
 * @author yaici-khemiri-duguait
 * @param getMap revoie la coordonnee d'une case
 * @param init_terrain_Sorciere place les sorcieres sur l'echiquier inital
 * @param init_terrain_vide initialise les cases vides sur l'echiquier
 * @param init_terrain_Fee place les fees sur l'echiquier inital
 * @param init_map genere l'echiquier initial en sa totalite
 * @param afficher_map affichage de l'echiquier en forme de grille 
 * @param deplacement change l'emplacement des protagnistes suite a leur deplacement
 * @param combat gere les combats entre les deux camps
 */ 


public class Grille{
	private Case[] map = new Case[64];

	public Grille() {
	}
	
	public Case getMap(int i) {
		return map[i];
	}
	/******************* initialisation des protagnistes sur l'echiquier  *********************/
	private void init_terrain_Sorciere() {
		Random s = new Random();
		for (int i=0;i<16;i++) {
			int alea1 = s.nextInt(2);
			if (alea1 == 0) {
				map[i] = new Case(i,new Stormy());
			}
			else {
				map[i] = new Case(i,new Icy());
			}
		}
	}
	private void init_terrain_vide() {
		for (int i=16;i<48;i++) {
			map[i] = new Case(i,new Vide());
		}
	}
	private void init_terrain_Fee() {
		Random f = new Random();
		for (int i=48;i<64;i++) {
			int alea2 = f.nextInt(5);
			if (alea2 == 0) {
				map[i] = new Case(i,new Bloom());
			}
			else if (alea2 == 1) {
				map[i] = new Case(i,new Flora());
			}
			else if (alea2 == 2) {
				map[i] = new Case(i,new Stella());
			}
			else {
				map[i] = new Case(i,new Musa());
			}
		}
	}
	/**************************************** Création de la map initiale *******************************************/

	public void init_map() {
		init_terrain_Sorciere();
		init_terrain_vide();
		init_terrain_Fee();
	}

	/***************************** Création de la map a partir du fichier de sauvegarde *****************************/

	public void init_map_saved(String map_str){
		for (int i = 0;i<64;i++){
			char[] symbol = new char[2];
			map_str.getChars(i*2, i*2+2, symbol, 0);
			String test_symbol = String.valueOf(symbol);
			switch (test_symbol){
				case "SS":
					map[i] = new Case(i,new Stormy());
					break;
				case "SI":
					map[i] = new Case(i,new Icy());
					break;
				case "FB":
					map[i] = new Case(i,new Bloom());
					break;
				case "FF":
					map[i] = new Case(i,new Flora());
					break;
				case "FM":
					map[i] = new Case(i,new Musa());
					break;
				case "FS":
					map[i] = new Case(i,new Stella());
					break;
				case "  ":
					map[i] = new Case(i,new Vide());
					break;
				default:
					break;
			}

			
		}


	}
	/******************************* Conversion de la grille en String pour sauvegarde ******************************/
	public String GetMapString(){
		String sortie = "";
		for (int i =0;i<64;i++){
			sortie += this.map[i].getOccupant().getSymbole();
		}
		return sortie;
	}

	/******************************* affichage de l'echiquier  ******************************/
	public void afficher_map() {
        String maps = "   a  b  c  d  e  f  g  h\n1 ";
        int i = 0;
        while(i<64) {
            maps += "|";
            maps += map[i].getOccupant().getSymbole();
            i++;
            if ((i%8 == 0) && (i<64)) {maps += "|\n"+((i/8)+1)+" ";}
        }
        maps += "|";
        System.out.println( maps);
    }

	/******************************* Test validité de la séléction du départ  ******************************/
	public boolean selection_valide(int i1 , String Equipe) {
		if (map[i1].getOccupant().getSymbole().charAt(0) != Equipe.charAt(0)) {
			return false;
		}
		return true;
	}
	

	/******* conversion de l'entree de l'utilisateur sous forme de lettre(colonne)+chiffre(ligne) ******/
	public int input_init(String dep) {
		//traite le cas ou on se trouve sur la 1ere colonne
		char chiffre= dep.charAt(1);
		int c= Character.getNumericValue(chiffre);
			for (int i=1; i<9; i++){
				if (c==i){
					c= 8*(c-1);
					break;}
			}
		return c; //retourne les resultats de la premiere colonne (les resultats de a1,a2,a3...a8)
	}
	
	public int modifier_input(String dep) {
	  int c= input_init(dep); //le chiffre qui indique la ligne
	  char lettre= dep.charAt(0); //la lettre qui indique la colonne
	  	if (lettre=='a') {
	  		return c;
	  	}
	  	else {
	  		//difference des codes ascii
	  		int ascii = (int) lettre; //code ASCII de la colonne (entr�e par le joueur)
	  		int diff= ascii - 97; //97= code ASCII de A
	  		return c+diff;
	  	}
	}
	

	/********************* gerer les deplacements des protganistes ********************/
	public int deplacement(int i1,int i2) {
		if (map[i1].getOccupant().getSymbole() == "  ") {
			System.out.println("S�l�ction non correcte !");
			return 2;
		}
		else if (map[i2].getOccupant().getSymbole() == "  ") {
			Case tmp = map[i1];
			map[i1] = map[i2];
			map[i2] = tmp;
			return 0;
		}
		else if (map[i2].getOccupant().getClass().getSuperclass() == map[i1].getOccupant().getClass().getSuperclass()) {
			System.out.println("D�placement impossible, case occup�e par un coh�quipier !");
			return 3;
		}
		else {
			combat(map[i1],map[i2]);
			return 1;
		}
		/* Code retour: 0=OK(combat) 1=OK(case vide) 2=OK(Tresor) 3= !Selection 4= !Arriv�e */
	}
	

	/********************* gerer les combats entre protganistes ********************/
	public void combat(Case perso1,Case perso2) {
		if (perso1.getOccupant().getSymbole().charAt(0) == 'S') {
			System.out.println(perso1.getOccupant().attaquer(perso2.getOccupant(), 10));
			if (perso2.getOccupant().getVie()<=0) {
				map[perso2.getPosition()] = new Case(perso2.getPosition(),new Vide());
				deplacement(perso1.getPosition(), perso2.getPosition());
			}
		}
		else if (perso1.getOccupant().getSymbole().charAt(0) == 'F') {
			System.out.println(perso1.getOccupant().attaquer(perso2.getOccupant(), 20));
			if (perso2.getOccupant().getVie()<=0) {
				map[perso2.getPosition()] = new Case(perso2.getPosition(),new Vide());
				deplacement(perso1.getPosition(), perso2.getPosition());
			}
		}
//		int attaque = perso1.getOccupant().attaque();
//		perso2.getOccupant().subir_degat(attaque);
//		System.out.println(perso1.getOccupant().getNom()+" a attaqu� "+perso2.getOccupant().getNom());
//		if (perso2.getOccupant().getVie() == 0) {
//			/* Combat gagn� perso1 va en perso2 */
//			perso2.getOccupant().mourir();
//			map[perso2.getPosition()] = new Case(perso2.getPosition(),new Vide());
//			deplacement(perso1.getPosition(),perso2.getPosition());
//			System.out.println(perso2.getOccupant().getNom()+" n'a pas survecu a l'attaque il c�de sa place � "+perso1.getOccupant().getNom());
//		}
	}

}

