package jeu;
import java.util.Random;
import java.util.Scanner;
import maps.Grille;

public class Jeu {
	public static void main(String[] args) {
		Grille grille = new Grille();
		grille.init_map();
		String Equipe_Jeu = "Sorciere";
		Random tour_debut = new Random();
		int choix = tour_debut.nextInt(2);
		if (choix == 0) {
			Equipe_Jeu = "Fee";
		}
		boolean Exit = false;
		Scanner sc = new Scanner(System.in);
		int NB_TOUR = 0;
		while (!Exit) {
			/* Incrémente le nombre de tour */
			NB_TOUR ++;
			/* Affiche le tour */
			System.out.println("Tour numéro "+NB_TOUR+" c'est au tour de l'equipe des "+Equipe_Jeu+"s");
			grille.afficher_map(); /* Affichage de la carte */
			/* Définition point de départ */
			boolean selection_depart = false;
			while (!selection_depart) {
				System.out.println("Quel pion voulez-vous bouger ?");
				int depart = sc.nextInt();
				if (grille.selection_valide(depart, Equipe_Jeu)) {
					boolean selection_arivee = false;
					/* Définition point d'arrivée */
					while (!selection_arivee) {
						System.out.println("Ou voulez-vous aller ?");
						int arivee = sc.nextInt();
						if (grille.deplacement(depart, arivee) < 3) {
							selection_arivee = true;
							selection_depart = true;
						}
					}
				}
			}
			/* Stop de la boucle */
			String str = sc.nextLine();
			System.out.println("Voulez-vous stoper le jeu ? (y/n)");
	        str = sc.nextLine();
	        if (str.equals("y")) {
	        	Exit = !Exit;
	        }
	        /* Changement de coté */
	        if (Equipe_Jeu == "Sorciere") {
	        	Equipe_Jeu = "Fee";
	        }
	        else Equipe_Jeu = "Sorciere";
		}
		sc.close();
		}
	}
