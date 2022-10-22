package personnages;

public class Romain {
	private String nom;
	private int force ;
	private Equipement[] equipements;
	private int nbEquipement=0;
	private String texte;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force>=0 : " la force d�un Romain est toujours positive";
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
//	public void recevoirCoup(int forceCoup) {
//		assert force>=0 : " la force d�un Romain est toujours positive";
//		int forceAttaque = force;
//		forceAttaque -= forceCoup;
//		if (forceAttaque > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force>=forceAttaque : "la force d'un Romain a diminu�";
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// 		parler("Aïe");
		// } else {
		// 		equipementEjecte = ejecterEquipement();
		// 		parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
			int resistanceEquipement = 0;
			if (!(nbEquipement == 0)) {
				texte += "n Mais heureusement, grace à mon équipement sa
		force est diminué de ";
				for (int i = 0; i < nbEquipement;) {
					if ((equipements[i] != null &&
		equipements[i].equals(Equipement.BOUCLIER)) == true) {
						resistanceEquipement += 8;
					} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
					}
					i++;
				}
				texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
		private Equipement[] ejecterEquipement() {
			Equipement[] equipementEjecte = new Equipement[nbEquipement];
			System.out.println("L'équipement de " + nom.toString() + "
		s'envole sous la force du coup.");
			//TODO
			int nbEquipementEjecte = 0;
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] == null) {
					continue;
				} else {
					equipementEjecte[nbEquipementEjecte] =
		equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				}
			}
			return equipementEjecte;
		}


	
	public void sEquiper (Equipement equip, Romain romain) {
		switch (nbEquipement){
			case (0):
				equipements[0]=equip;
				nbEquipement+=1;
				System.out.println("le soldat "+romain.getNom()+" s'equipe avec un "+equip+".");
			break;
			case(1):
				if (equipements[0]==equip) {
					System.out.println("le soldat "+romain.getNom()+" possède déja un "+equip+" !");
				}else {
					equipements[1]=equip;
					nbEquipement+=1;
					System.out.println("le soldat "+romain.getNom()+" s'equipe avec un "+equip+".");
				}
			break;
			default:
				System.out.println("le soldat "+romain.getNom()+" est déjà bien protégé !");
		}
	}
	
	public static void main (String[] args) {
		Romain cesar= new Romain ("Cesar",6);
		System.out.println(cesar.getNom());
		System.out.println(cesar);
//		System.out.println(cesar.prendreParole());
//		cesar.parler("je t'aurai un jour Ast�rix !!");
//		cesar.recevoirCoup(5);
		Equipement objet = Equipement.CASQUE;
		Equipement protec= Equipement.BOUCLIER;
		cesar.sEquiper(objet, cesar);
		cesar.sEquiper(objet, cesar);
		cesar.sEquiper(protec, cesar);
		cesar.sEquiper(objet, cesar);



	}
}
