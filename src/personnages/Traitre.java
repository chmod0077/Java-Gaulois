package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	int niveauTraitrise;
	Random rand = new Random();

	public Traitre(String seigneur, String nom, String boisson, int argent) {
		super(seigneur, nom, boisson, argent);
		niveauTraitrise = 0;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		super.parler("Je suis un traitre de LVL" + niveauTraitrise);
	}
	
	public void ranconner(Commercant commercant) {
		int argentRancon;
		
		if( niveauTraitrise < 3 ) {
			argentRancon = commercant.getArgent() / 5;
			commercant.perdreArgent(argentRancon);
			gagnerArgent(argentRancon);
			
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer! Donnes-moi $" + argentRancon + " ou gare à toi!");
			commercant.parler("Yes mommy please don't hurt me grand " + getNom() + " TwT");
			
			niveauTraitrise++;
		}
		else {
			parler("Grrrrrr arghhhhhh je ne peux plus rançonner personne ou un samouraï pourrait me démasquer :(((");
		}
	}
	
	public void faireLeGentil() {
		if( nbConnaissance < 1 ) parler("Je ne peux pas faire ami-ami <3 parce que je ne connais personne :/");
		else {
			int random = rand.nextInt(nbConnaissance);
			int don = getArgent() / 20;
			
			Humain ami = memoire[random];
			
			parler("Il faut absolument remonter ma cote de confiance, je vais faire ami-ami <3 avec " + ami.getNom());
			parler("Bonjour l'ami! Je voudrais vous aider en vous donnant $" + don);
			ami.gagnerArgent(don);
			perdreArgent(don);
			
			ami.parler("Merci " + getNom() + ". Vous etes quelqu'un de bien.");
			parler("(Secrètement) MOUAHAHAHAHAHAHAHAHAHAHHAAAAAAAAAAAAAAAAAAH :PPPP");
			
			if( niveauTraitrise > 1 ) niveauTraitrise--;
		}
	}
}
