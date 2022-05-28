package Bataille;
import protagonistes.Fee;
import protagonistes.Sorciere;

/**
 * @author yaici-khemiri-duguait
 * @param Batailles gere l'affrontement entre les camps du jeux
 * @param massacrerS supprime une sorciere du camp des sorcieres et affiche un message
 * @param massacrerF supprime une fee du camp des fees et affiche un message
 * @param donnerNombreFees retourne le nombre de fees vivantes jusqu'au moment de l'appel de la fonction
 * @param donnerNombreSorcieres retourne le nombre de sorcieres vivantes jusqu'au moment de l'appel de la fonction
 */ 

public class Batailles {
    public Camps campSorciere= new Camps(); //liste des joueurs socieres
    public Camps campFee= new Camps();//liste des joueurs fees


    /************************ eliminer un protagoniste ************************/
    public String massacrerS(Sorciere witch){
        String texte="";   
        //suppression de la sorcière du camp Sorcière
        campSorciere.supprimerS(witch);
		if (campSorciere.nbSorcieres() == 0 && campFee.nbFees() > 0) {
            texte="La sorciere "+ witch.getNom()+" a ete liminee \n";
        }
        return texte;
    }
    public String massacrerF(Fee fee, Sorciere witch){
        String texte="";   
        //suppression de la fee du camp Fee
        campFee.supprimerF(fee);
		if (campFee.nbFees() == 0 && campSorciere.nbSorcieres() > 0) {
            witch.gagnerTresor();
            texte="La fee "+ fee.getNom()+" a ete eliminee \n"+"  la sorciere "+witch.getNom()+" gagne un nouveau sortilege ";   
        }
        return texte;
    }


    /********************* GETTERS *********************/
    public int donnerNombreSorcieres() {
		return campSorciere.nbSorcieres();
	}
	public int donnerNombreFees() {
		return campFee.nbFees();
	}

}
