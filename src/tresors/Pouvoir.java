package tresors;

import protagonistes.*;

public class Pouvoir extends Tresor{
    protected Fee proprio;
    public int degats;

    public Pouvoir(){
        super("baguette");
        this.degats=2;
    }


    public String attaque (Sorciere s){
        String texte="";
        texte= this.proprio.getNom()+" attaque la sorciere "+s.getNom()+" avec son pouvoir magique.";
        texte += s.subirAttaque (this.proprio,this.degats);
        return texte;
    }
}
