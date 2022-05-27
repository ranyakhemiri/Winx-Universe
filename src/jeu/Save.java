package jeu;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
public class Save {
/**
 * @author yaici-khemiri-duguait
 * @param sauvegarder Permet de sauvegarder la partie dans un fichier texte
 * @param charger Permet de charger la partie numéro x  à partir du fichier save.txt
 */ 


    /* Sauvegarde dans save.txt */
    public static String sauvegarder(String partie) throws IOException{
        File save_txt = new File("./src/jeu/save.txt");
        FileWriter saver = new FileWriter(save_txt,true);
        /* Si il y a déja un élément dans le fichier on rajoute un saut de ligne */
        if (save_txt.length() != 0){
            saver.write("\n"+partie);
        }
        else saver.write(partie);
        saver.close();
        return "partie sauvegardée !";
    };


    /* Permet de charger la partie */
    public static String charger(int num_partie) throws IOException{
        File save_txt = new File("./src/jeu/save.txt");
        FileReader loader = new FileReader(save_txt);
        BufferedReader br = new BufferedReader(loader);
        String map = "";
        for (int i = 0;i<num_partie;i++){
            map = br.readLine();
        }
        br.close();
        return map;
    }
}
