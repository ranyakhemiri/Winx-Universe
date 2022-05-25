package protagonistes;

public class Vide extends Personnage{
	private String Symbole = "  ";
	
	public Vide() {
		super("",0);
	}
	
	public String getSymbole() {
		return Symbole;
	}

	@Override
	public String win() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gagnerTresor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String die() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
