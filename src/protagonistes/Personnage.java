package protagonistes;

import Bataille.Batailles;

public abstract class Personnage {
	protected int vie;
	protected String nom;
	protected String Symbole;
	protected int NbArmure;
	protected int ptprotec;
	public Personnage(String nom,int vie) {
		this.vie = vie;
		this.nom = nom;
	}
	
	
	public int getVie() {
		return vie;
	}
	
	
	public int getNbArmure() {
		return NbArmure;
	}
	
	
	public String die() {
		String texte=" ";
		texte+=this.getNom()+" n'a pas survécu \n";
		//il faut remove ici
		return texte;
		}

	public String win() {
		String msg=" ";
		msg+=this.getNom()+ " remporte le duel \n";
		msg+=this.regeneration();
		msg += this.gagnerTresor();
		return msg;
	}
	
	public String regeneration(){
		String texte=" ";
		if(vie<20){
			vie=20;
			texte+=this.getNom()+" a récupéré ses points de vie \n";
		}
		else{
			texte+=this.getNom()+" a deja tous ses points de vie \n";
		}
		return texte;
	}

	
	public String attaquer(Personnage p,int degat) {
		String texte=" ";
		texte+="Le Personnage "+getNom()+" attaque "+p.getNom()+" présente sur la case";
		texte+="\n"+p.subirAttaque( this, 10  );
		return texte;
	}
	
	public String subirAttaque(Personnage p,int nb_degats) {
		String texte=" ";
		texte+="La sorciere "+this.getNom()+" est attaquée\n";

		
		if(NbArmure!=0){
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
				this.vie = 0;
				texte += this.die();
				texte += p.win();
			}
		}
			return texte;
		}
	
	public String rejointBataille(Batailles bataille){
        return "";
    }
	
//	public int subir_degat(int degat) {
//		if (degat > this.vie){
//			this.vie = 0;
//		}
//		else this.vie -= degat;
//		return this.vie;
//	}

	public String getSymbole() {
		return Symbole;
	}

	public String getNom() {
		return nom;
	}
//	public int attaque(String type) {
//		return 0;
//	}


	public abstract String gagnerTresor();
}
