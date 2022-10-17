package personnages;

public class Romain {
	private String nom;
	private int force ;
	private Equipement[] equipements;
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force>=0 : " la force d’un Romain est toujours positive";
		equipements = new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert force>=0 : " la force d’un Romain est toujours positive";
		int forceAttaque = force;
		forceAttaque -= forceCoup;
		if (forceAttaque > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert force>=forceAttaque : "la force d'un Romain a diminué";
	}
	
	public void sEquiper (Equipement equip, Romain romain) {
		switch (nbEquipement){
			case (0):
				equipements[0]=equip;
				nbEquipement+=1;
				System.out.println("le soldat "+romain.getNom()+"s'equipe de "+equip);
			break;
			case(1):
				if equipements[0]==equip 
		}
	}
	
	public static void main (String[] args) {
		Romain cesar= new Romain ("Cesar",6);
		System.out.println(cesar.getNom());
		System.out.println(cesar);
//		System.out.println(cesar.prendreParole());
//		cesar.parler("je t'aurai un jour Astérix !!");
//		cesar.recevoirCoup(5);
		Equipement objet = Equipement.BOUCLIER;
		System.out.println(objet);

	}
}
