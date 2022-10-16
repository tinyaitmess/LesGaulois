package personnages;

public class Gaulois {
	public String nom;
	private int force;
	private int effetPotion =1;
	
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
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
			+ romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	
	// @Override
	
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
			+ ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion (int forcePotion) {
		effetPotion=forcePotion;
		System.out.println("Merci Druide, je sens que ma force est "
							+forcePotion+" fois décuplée.");
	}
	
	public static void main(String[] args) {
		//TODO créer un main permettant de tester la classe Gaulois
		Gaulois asterix = new Gaulois("Astérix",8) ;
		System.out.println(asterix.getNom());
		System.out.println(asterix);
//		System.out.println(asterix.prendreParole());
		asterix.parler("Obelix ! Où es-tu ?");
		Romain minus = new Romain ("Minus",6);
		asterix.frapper(minus);
		asterix.boirePotion(5);
	}

}
