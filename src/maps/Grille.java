package maps;

import java.util.Random;

import protagonistes.*;

public class Grille{
	private Case[] map = new Case[64];

	public Grille() {
	}
	
	public Case getMap(int i) {
		return map[i];
	}

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
	public void init_map() {
		init_terrain_Sorciere();
		init_terrain_vide();
		init_terrain_Fee();
	}
	
	public void afficher_map() {
		String maps = "";
		int i = 0;
		while(i<64) {
			maps += "|";
			maps += map[i].getOccupant().getSymbole();
			i++;
			if (i%8 == 0) {maps += "|\n";}
		}
		System.out.println(maps);
	}
	
	public boolean selection_valide(int i1 , String Equipe) {
		if (map[i1].getOccupant().getSymbole().charAt(0) != Equipe.charAt(0)) {
			return false;
		}
		return true;
	}
	
	public int deplacement(int i1,int i2) {
		if (map[i1].getOccupant().getSymbole() == "  ") {
			System.out.println("Séléction non correcte !");
			return 2;
		}
		else if (map[i2].getOccupant().getSymbole() == "  ") {
			Case tmp = map[i1];
			map[i1] = map[i2];
			map[i2] = tmp;
			return 0;
		}
		else if (map[i2].getOccupant().getClass().getSuperclass() == map[i1].getOccupant().getClass().getSuperclass()) {
			System.out.println("Déplacement impossible, case occupée par un cohéquipier !");
			return 3;
		}
		else {
			combat(map[i1],map[i2]);
			return 1;
		}
		/* Code retour: 0=OK(combat) 1=OK(case vide) 2=OK(Tresor) 3= !Selection 4= !Arrivée */
	}
	
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
//		System.out.println(perso1.getOccupant().getNom()+" a attaqué "+perso2.getOccupant().getNom());
//		if (perso2.getOccupant().getVie() == 0) {
//			/* Combat gagné perso1 va en perso2 */
//			perso2.getOccupant().mourir();
//			map[perso2.getPosition()] = new Case(perso2.getPosition(),new Vide());
//			deplacement(perso1.getPosition(),perso2.getPosition());
//			System.out.println(perso2.getOccupant().getNom()+" n'a pas survecu a l'attaque il cède sa place à "+perso1.getOccupant().getNom());
//		}
	}
}
