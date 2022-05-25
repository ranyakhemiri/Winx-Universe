package maps;
import javax.swing.JRadioButton;

import protagonistes.Personnage;

public class Case extends JRadioButton{
	private static final long serialVersionUID = 1L;
	private Personnage occupant;
	private int position;
	private int place; /* depart arrivee null */
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
