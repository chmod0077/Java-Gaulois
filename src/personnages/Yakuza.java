package personnages;

public class Yakuza extends Humain {
	String clan;
	int reputation;
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
		this.reputation = 0;
	}
	
	public void extorquer(Commercant victime) {
		int argent = victime.getArgent();
		
		parler("Tiens, tiens, ne serait-ce pas un faible voyageur qui passe par là?");
		
		super.gagnerArgent(victime.seFaireExtorquer());
		parler("Hihihiii! J'ai piqué les $" + argent + " de " + victime.getNom() + ", ce qui me fait $" + super.getArgent() + " dans mon inventaire! :3");
		
		this.reputation++;
	}
}
