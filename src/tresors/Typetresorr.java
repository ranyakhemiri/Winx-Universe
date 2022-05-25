package tresors;
import java.util.Random;

/**
 * @param Typetresor genere de maniere aleatoire un tresor que le vainqueur d'un combat gagnera 
 */

public enum Typetresorr {
	  
    ARMURE, POUVOIR, SORTILEGE;

    public static Typetresorr generateRandomTresor() {
        Typetresorr[] values = Typetresorr.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }

}
