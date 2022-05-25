package maps;

public class test_case {
	
	public static void main(String[] args) {
		Grille grille = new Grille();
		grille.init_map();
		grille.afficher_map();
		grille.deplacement(61, 10);
		grille.deplacement(61, 10);
		grille.deplacement(61, 10);

	}

}
