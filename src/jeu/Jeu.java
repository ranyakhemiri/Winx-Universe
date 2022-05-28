package jeu;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import maps.Grille;
/**
 * @author yaici-khemiri-duguait
 * @param main affiche et execute le jeu sur la console 
 */ 


public class Jeu {
	public static void main(String[] args) throws IOException {

		/* Choix entre charger une partie ou commencer une nouvelle partie */
		Scanner scan = new Scanner(System.in);
		Grille grille = new Grille();
		System.out.println("Voulez vous charger une partie ? (y/n)");
		if (scan.nextLine().equals("y")){
			System.out.println("Entrer le numéro de sauvegarde");
			grille.init_map_saved(Save.charger(scan.nextInt()));
		}
		else grille.init_map();

		/* Choix aléatoire du premier joueur */
		String Equipe_Jeu = "Sorciere";
		Random tour_debut = new Random();
		int choix = tour_debut.nextInt(2);
		if (choix == 0) {
			Equipe_Jeu = "Fee";
		}


		boolean Exit = false;
		int NB_TOUR = 0;
		while (!Exit) {
			/* Incr�mente le nombre de tour */
			NB_TOUR ++;
			/* Affiche le tour */
			System.out.println("Tour numero "+NB_TOUR+": c'est au tour de l'equipe des "+Equipe_Jeu+"s");
			grille.afficher_map(); /* Affichage de la carte */
			/* D�finition point de d�part */
			boolean selection_depart = false;
			scan.nextLine();
			while (!selection_depart) {
				System.out.println("Quel pion voulez-vous bouger ?");
				String strD= scan.nextLine(); //r�cup�re l'entr�e de l'utilisateur sous forme de lettre(colonne)+chiffre(ligne)
				int depart = grille.modifier_input(strD); //traduit cette entr�e String en une coordonn�e valable
				if (grille.selection_valide(depart, Equipe_Jeu)) {
					boolean selection_arivee = false;
					/* D�finition point d'arriv�e */
					while (!selection_arivee) {
						System.out.println("Ou voulez-vous aller ?");
						String strA= scan.nextLine(); 
						int arivee = grille.modifier_input(strA);
						if (grille.deplacement(depart, arivee) < 3) {
							selection_arivee = true;
							selection_depart = true;
						}
					}
				}
			}
			/* Stop de la boucle */
			System.out.println("Voulez-vous stoper le jeu ? (y/n)");
	        if (scan.nextLine().equals("y")) {
	        	Exit = !Exit;
	        	/*Sauvegarde de la carte + tour de jeu*/
				System.out.println("Voulez-vous sauvegarder le jeu ? (y/n)");
	        	String save = scan.nextLine();
	        	if (save.equals("y")) {
	        		System.out.println(Save.sauvegarder(grille.GetMapString(),grille.GetMapVie(),grille.GetMapTres()));
	        	}
			}
	        /* Changement de cot� */
	        if (Equipe_Jeu == "Sorciere") {
	        	Equipe_Jeu = "Fee";
	        }
	        else Equipe_Jeu = "Sorciere";
		}
		scan.close();
		}
	public static void sauvegarderpartie() {
		
	}
}