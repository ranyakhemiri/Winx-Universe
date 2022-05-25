package tresors;

import protagonistes.Fee;
import protagonistes.Sorciere;

public class Sortilege extends Tresor{
    protected Sorciere proprio;
    public int degats;

public Sortilege(){
    super("sortilege");
    this.degats=1;
}

public String attaque (Fee f){
    String texte="";
    texte= this.proprio.getNom()+" attaque la fee "+f.getNom()+" avec son sortilege.";
    texte += f.subirAttaque (this.proprio,this.degats);
    return texte;
}
}
