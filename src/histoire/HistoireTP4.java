package histoire;
import personnages.*;

public class HistoireTP4 {
	public static void main(String[] args) {
		Humain courier = new Humain("Courier 6", "Sunset sarsapiralla", 200);
		Commercant dona = new Commercant("Dona", "Beer", 150);
		Yakuza benny = new Yakuza("Benny", "Whiskey", 6000, "TOPS Casino");
		Ronin ace = new Ronin("Ace", "Water", 60);
		
		courier.direBonjour();
		courier.acheter("54 cartouches de .308", 108);
		courier.boire();
		courier.acheter("100000000 NCR dollars", 5);
		courier.acheter("Hardened T-51b Powered infantry combat armor", 8263);
	
		dona.direBonjour();
		dona.seFaireExtorquer();
		dona.recevoir(2);
		dona.boire();
		
		benny.direBonjour();
		benny.extorquer(dona);
		
		ace.direBonjour();
		ace.donner(dona);
		
		ace.provoquer(benny);
	}
}
