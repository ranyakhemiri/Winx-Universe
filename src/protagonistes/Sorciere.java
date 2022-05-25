package protagonistes;

import tresors.Typetresorr;

public class Sorciere extends Personnage{
	public String Symbole;
	public int nbSortileges;
	public int nbArmure=0;
    public int ptprotec;
    
	public Sorciere(String nom) {
		super(nom, 20);
		this.nbSortileges=1;
		this.nbArmure=0;
	}
	
	public int getNbSortileges(){
        return this.nbSortileges;
    }
	public int getNbArmures (){
        return this.nbArmure;
    }
	public int getNbptprotec (){
        return this.nbArmure;
    }
	
	@Override
	public String gagnerTresor() {
		String texte=" ";
        Typetresorr t=Typetresorr.generateRandomTresor();
        
        if(t==Typetresorr.ARMURE){
        texte+="La Sorciere "+ getNom()+" Obtient une armure";
        ptprotec+=10;
        nbArmure+=1;
        }
        else if(t==Typetresorr.SORTILEGE){
            texte+="La Sorciere "+ getNom()+" Obtient unn nouveau pouvoir";
            nbSortileges+=1;
        }
        else {
            gagnerTresor();
        }
        return texte;  
    }
	// @Override
		public String attaquer(Fee f,int nb_degats) {
			String texte=" ";
			texte+="La sorciere "+getNom()+" attaque la fee présente sur la case";
		    f.subirAttaque( this, 10  );
			return texte;
			}



		// @Override
		public String subirAttaque(Fee f,int nb_degats) {
			String texte=" ";
			texte+="La sorciere "+this.getNom()+" est attaquée";

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
					f.win();	
				}
			}
				return texte;
			}

		
}
