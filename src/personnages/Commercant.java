package personnages;

public class Commercant extends Humain {
	public Commercant(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}

	public int seFaireExtorquer() {
		int argent = super.getArgent();
		
		super.perdreArgent(super.getArgent());
		super.parler("J'ai tout perdu... Le monde est trop injuste, tu sais, avant que je sois un commerçant, j'étais un baron et je possédais une dizaine de Brahmin, puis j'ai on m'a forcé à abandonner mon ranche, par un baron plus gros...");
		
		return argent;
	}
	
	public void recevoir(int argent) {
		super.gagnerArgent(argent);
		super.parler("$" + argent + "! Merci beaucoup généreux voyageur! Que les dieux du ciel soient avec toi!");
	}
}
