package personnages;

public class Gaulois {
	public String nom;
	private int force;
	private int effetPotion =1;
	private int nb_trophees; 
	private Equipement trophees[] = new Equipement[100];
	
	public Gaulois (String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}

	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de "
//			+ romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
			Equipement trophees[] = romain.recevoirCoup((force / 3) *
effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,
nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}

	
	// @Override
	
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
			+ ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion (int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci Druide, je sens que ma force est "
							+forcePotion+" fois d�cupl�e.");
	}
	
	public static void main(String[] args) {
		//TODO cr�er un main permettant de tester la classe Gaulois
		Gaulois asterix = new Gaulois("Ast�rix",8) ;
		System.out.println(asterix.getNom());
		System.out.println(asterix);
//		System.out.println(asterix.prendreParole());
		asterix.parler("Obelix ! O� es-tu ?");
		Romain minus = new Romain ("Minus",6);
		asterix.frapper(minus);
		asterix.boirePotion(5);
	}

}
