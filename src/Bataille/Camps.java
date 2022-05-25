package Bataille;

import java.util.ArrayList;
import java.util.List;

import protagonistes.Fee;
import protagonistes.Sorciere;

public class Camps {
    private List<Sorciere> witch= new ArrayList<>(16);
	private List<Fee> fee= new ArrayList<>(16);

	public void supprimerS(Sorciere w) {
		witch.remove(w);
	}
	public void supprimerF(Fee f) {
		fee.remove(f);
	}

	public int nbSorcieres() {
		return witch.size();
	}

	public int nbFees() {
		return fee.size();
	}

    
    }
