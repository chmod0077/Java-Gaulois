package histoire;
import personnages.*;

public class HistoireTP4 {
	public static void main(String[] args) {
		Humain courier = new Humain("Courier 6", "Sunset sarsapiralla", 200);
		courier.direBonjour();
		courier.acheter("54 cartouches de .308", 108);
		courier.boire();
		courier.acheter("100000000 NCR dollars", 5);
		courier.acheter("Hardened T-51b Powered infantry combat armor", 8263);
	}
}
