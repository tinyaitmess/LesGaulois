package personnages;

public class Romain {
	private String nom;
	private int force ;
	private Equipement[] equipements;
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		if (force < 0 ) {
			throw new IllegalArgumentException("Invalide force :"+force+"force romain toujours positive");
		}
		equipements = new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// Precondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if(force>=0) {
			parler("Aie");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminue
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
			int resistanceEquipement = 0;
			if (nbEquipement != 0) {
				texte += "\n Mais heureusement, grace a mon equipement sa force est diminue de ";
				for (int i = 0; i < nbEquipement;i++) {
					if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 8;
					} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
					}
				}
				texte += resistanceEquipement+ "!" ;
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup>0) {
			return forceCoup;
		}
		return 0;
		
	}
		private Equipement[] ejecterEquipement() {
			Equipement[] equipementEjecte = new Equipement[nbEquipement];
			System.out.println("L'equipement de " + nom + " s'envole sous la force du coup.");
			int nbEquipementEjecte = 0;
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null) {
					equipementEjecte[nbEquipementEjecte] =equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				}
			}
			return equipementEjecte;
		}


	
	public void sEquiper (Equipement equip,Romain romain) {
		String soldat= "le soldat "+romain.getNom();
		switch (nbEquipement){
			case (0):
				equipements[0]=equip;
				nbEquipement+=1;
				System.out.println(soldat+" s'equipe avec un "+equip+".");
			break;
			case(1):
				if (equipements[0]==equip) {
					System.out.println(soldat+" posséde déja un "+equip+" !");
				}else {
					equipements[1]=equip;
					nbEquipement+=1;
					System.out.println(soldat+" s'equipe avec un "+equip+".");
				}
			break;
			default:
				System.out.println(soldat+" est déja bien protégé !");
		}
	}
	
	public static void main (String[] args) {
		Romain cesar= new Romain ("Cesar",6);
		System.out.println(cesar.getNom());
		System.out.println(cesar);
		Equipement objet = Equipement.CASQUE;
		Equipement protec= Equipement.BOUCLIER;
		cesar.sEquiper(objet, cesar);
		cesar.sEquiper(objet, cesar);
		cesar.sEquiper(protec, cesar);
		cesar.sEquiper(objet, cesar);

	}
}
