package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageoisMaximum=0;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	
	
	public Village(String nom,int nbVillageoisMaximum) {
		super();
		Gaulois [] villageois = new Gaulois[nbVillageoisMaximum];
		this.nbVillageois = nbVillageoisMaximum;
	}



	public void setVillageois(Gaulois[] villageois) {
		this.villageois = villageois;
	}


	public Village(String nom) {
		this.nom=nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public Chef getChef() {
		return chef;
	}


	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant (Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;
		nbVillageois+=1;
	}
	
	public Gaulois trouverHabitant(int numeroVillageois) {
		return villageois[numeroVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef"+chef.getNom()+"vivent les légendaires"
							+"gaulois :");
	}
	
	public static void main (String[] args) {
		Village village = new Village ("Village des Irréductibles",30);
//		Gaulois gaulois = village.trouverHabitant(30);
		
		Chef chef = new Chef ("Abraracourcix ",6,1,village) ;
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterHabitant(asterix);
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Exception in thread "main" java.lang.NullPointerException: Cannot store to object array because "this.villageois" is null
//		at personnages.Village.ajouterHabitant(Village.java:31)
//		at personnages.Village.main(Village.java:44)
		Gaulois obelix = new Gaulois ("Obélix",25);
		village.ajouterHabitant(obelix);
		
		
		
	}
	
}
