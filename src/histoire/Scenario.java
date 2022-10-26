package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
import personnages.Musee;



public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller preparer une petite potion...");
		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obelix", 25);
		Gaulois asterix = new Gaulois("Asterix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER, minus);
		minus.sEquiper(Equipement.CASQUE,minus);
		milexcus.sEquiper(Equipement.CASQUE,minus);
		minus.parler("UN GAU... UN GAUGAU...");
		int i=10;
		do{
			asterix.frapper(minus);
			i--;
		} while (minus.getForce() > 0 && i>0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		i=10;
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0 && i>0);
		
		
		Musee musee = new Musee();
		asterix.faireUneDonnation(musee,asterix);

	}

}