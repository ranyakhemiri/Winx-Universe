package protagonistes;

import tresors.Typetresorr;

public class Fee extends Personnage{
	public String Symbole;
    public int nbPouvoirs;
	public int nbArmure=0;
    public int ptprotec;
    
	public Fee(String nom) {
		super(nom, 30);
        this.nbPouvoirs=1;
        this.ptprotec=0;
        this.nbArmure=0;
	}
	
	public int getNbPouvoirs (){
        return this.nbPouvoirs;
    }
    public int getNbArmures (){
        return this.nbArmure;
    }
    public int getNbptprotec (){
        return this.nbArmure;
    }

	// @Override
	public String subirAttaque(Sorciere w, int nb_degats) {
		String texte=" ";
		texte+="La Fee "+this.getNom()+" est attaquée";

		if(nbArmure!=0){
			if(ptprotec>nb_degats){
				ptprotec-=nb_degats;
				texte+=", Heureusement que son armure la protege \n";
			}
			else{
				vie-=(nb_degats-ptprotec);
			}
		}
		else{
			if(vie> nb_degats){
				texte+="Aie \n";
				vie-=nb_degats;
			}
			else{
				this.die();
                w.win();
			}
		}
			return texte;
		}


    @Override
    public String gagnerTresor() {
        String texte=" ";
        Typetresorr t=Typetresorr.generateRandomTresor();
        
        if(t==Typetresorr.ARMURE){
        texte+="La fee "+ getNom()+" Obtient une armure";
        ptprotec+=10;
        nbArmure+=1;
        }
        else if(t==Typetresorr.POUVOIR){
            texte+="La fee "+ getNom()+" Obtient unn nouveau pouvoir";
            nbPouvoirs+=1;
        }
        else {
            gagnerTresor();
        }
        return texte;  
    }
}