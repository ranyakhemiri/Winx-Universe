package tresors;

public class Armure extends Tresor {
	private int protection; //entre 1 et 3 points
	
	public Armure(int protection) {
		super("armure");
		this.protection = protection;
	}
	
	public String getNature() {
		return nature;
	}
	public int getProtection() {
		return protection;
	}
	
}
