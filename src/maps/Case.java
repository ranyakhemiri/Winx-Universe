package maps;
import javax.swing.JRadioButton;
import protagonistes.Personnage;

/**
 * @author yaici-khemiri-duguait
 * @param Case constructeur qui associe a la case sa coordonnee et le personnage qui l'occupe
 */ 

public class Case extends JRadioButton{
	private static final long serialVersionUID = 1L;
	private Personnage occupant;
	private int position; /* position initiale de la case */
	private int place; /* case ou le protagoniste souhaite aller */
	public Case(int position, Personnage occupant) {
		this.position = position;
		this.occupant = occupant;
		this.place = 0;
	}
	
	
	public void setPlace(int place) {
		this.place = place;
	}

	public int getPlace() {
		return place;
	}


	public Personnage getOccupant() {
		return occupant;
	}
	
	public int getPosition() {
		return position;
	}

	public void setOccupant(Personnage occupant) {
		this.occupant = occupant;
	}
}
