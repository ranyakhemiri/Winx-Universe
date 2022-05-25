package tresors;

import java.util.Random;

public enum Typetresorr {
	  
    ARMURE, POUVOIR, SORTILEGE;

    public static Typetresorr generateRandomTresor() {
        Typetresorr[] values = Typetresorr.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
    






//public static void main(String[] args) {
//    System.out.println(Typetresorr.generateRandomTresor()); 
//    System.out.println(Typetresorr.generateRandomTresor()); 
//    System.out.println(Typetresorr.generateRandomTresor()); 
//}


}
