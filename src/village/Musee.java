package village;

import personnages.*;

public class Musee {
	Trophee[] trophees = new Trophee[200];
	int nbTrophee;

	public void donnerTrophees(Gaulois gaulois, Equipement equ) {
		this.trophees[nbTrophee] = new Trophee(gaulois, equ);
	}
}
