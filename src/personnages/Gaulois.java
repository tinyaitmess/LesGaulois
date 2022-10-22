package personnages;

public class Gaulois {
	private String nom;
//	j'ai changé le type du nom de public à private
	private int force;
	private int effetPotion =1;
	private int nbTrophees; 
	private Equipement[] trophees;
	
	public Gaulois (String nom, int force) {
		this.nom = nom;
		this.force = force;
		trophees= new Equipement[100];
	}

	public String getNom() {
		return nom;
	}
	
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
			trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,
nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
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
		Gaulois asterix = new Gaulois("Ast�rix",8) ;
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.parler("Obelix ! Où es-tu ?");
		Romain minus = new Romain ("Minus",6);
		asterix.frapper(minus);
		asterix.boirePotion(5);
	}

}
