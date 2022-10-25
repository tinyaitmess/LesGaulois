package personnages;
import personnages.Trophee;

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
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
			Equipement [] tropheesBataille = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesBataille != null && i < tropheesBataille.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = tropheesBataille[i];
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
							+forcePotion+" fois decuplée.");
	}
	
	public void faireUneDonnation (Musee musee,Gaulois gaulois) {
		String texte="Le gaulois "+nom+" : « Je donne au musee tous mes trophees :";
			while(nbTrophees>0) {
				nbTrophees-=1;
				musee.donnerTrophees(gaulois, trophees[nbTrophees]);
				texte +="\n-"+trophees[nbTrophees];
				trophees[nbTrophees]=null;
			}
			texte+="»";
		System.out.println(texte);
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8) ;
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.parler("Obelix ! Où es-tu ?");
		Romain minus = new Romain ("Minus",6);
		asterix.frapper(minus);
		asterix.boirePotion(5);
	}

}
