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
    public static String sauvegarder(String partie,String vie,String tres) throws IOException{
        File save_txt = new File("./src/jeu/save.txt");
        FileWriter saver = new FileWriter(save_txt,true);
        /* Si il y a déja un élément dans le fichier on rajoute un saut de ligne */
        if (save_txt.length() != 0){
            saver.write("\n"+partie);
        }
        else saver.write(partie);
        saver.write("\n"+vie);
        saver.write("\n"+tres);
        saver.close();
        return "partie sauvegardée !";
    };


    /* Permet de charger la partie */
    public static String[] charger(int num_partie) throws IOException{
        File save_txt = new File("./src/jeu/save.txt");
        FileReader loader = new FileReader(save_txt);
        BufferedReader br = new BufferedReader(loader);
        String map = "";
        String mapvies = "";
        String maptres = "";
        for (int i = 0;i<num_partie*2;i++){
            if (i==num_partie){
                map = br.readLine();
                mapvies = br.readLine();
                maptres = br.readLine();
            }
            else {
                br.readLine();
                br.readLine();
                br.readLine();
            }
        }
        br.close();
        String[] sortie = new String[3];
        sortie[0]=map;
        sortie[1]=mapvies;
        sortie[2]=maptres;
        return sortie;
    }
}
