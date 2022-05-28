package protagonistes;

import Bataille.Batailles;

/**
 * @author yaici-khemiri-duguait
 * @param die affiche un message qui indique la mort d'un protagoniste
 * @param regeneration lorsqu'un joueur gagne le combat on lui redonne tous ses points de vie
 * @param attaquer affiche un message qui indique l'attaquant et l'attaqué, et excute l'attaque sur la victime
 * @param subirAttaque traite une attaque contre le protagoniste victime (selon ses pts de vie, de protection..)
 * @param gagnerTresor attribue a un protagoniste vainceur un tresor a la fin du combat
 */ 

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

	public void setVie(int vie) {
		this.vie = vie;
	}
	
	public int getNbArmure() {
		return NbArmure;
	}

	public void setNbArmure(int nbarmure){
		this.NbArmure = nbarmure;
	}
	
	
	public String die() {
		String texte=" ";
		texte+=this.getNom()+" n'a pas surv�cu \n";
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
			texte+=this.getNom()+" a r�cup�r� ses points de vie \n";
		}
		else{
			texte+=this.getNom()+" a deja tous ses points de vie \n";
		}
		return texte;
	}

	
	public String attaquer(Personnage p,int degat) {
		String texte=" ";
		texte+="Le protagoniste "+getNom()+" attaque "+p.getNom()+" pr�sente sur la case";
		texte+="\n"+p.subirAttaque( this, 10  );
		return texte;
	}
	
	public String subirAttaque(Personnage p,int nb_degats) {
		String texte=" ";
		texte+="Le protagoniste "+this.getNom()+" est attaquee\n";

		
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
			texte += this.getNom()+" a : "+this.getVie()+" point de vie";
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
