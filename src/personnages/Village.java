package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageoisMaximum=10;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	
	
	public Village(String nom,int nbVillageoisMaximum) {
		super();
		villageois = new Gaulois[nbVillageoisMaximum];
		this.nbVillageois = nbVillageois;
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
		System.out.println("Dans le village du chef"+chef.getNom()+"vivent les l�gendaires"
							+"gaulois :");
	}
	
	public static void main (String[] args) {
		Village village = new Village ("Village des Irr�ductibles",30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 30
//		at personnages.Village.trouverHabitant(Village.java:45)
//		at personnages.Village.main(Village.java:55)
		
		Chef chef = new Chef ("Abraracourcix ",6,1,village) ;
		Gaulois asterix = new Gaulois("Ast�rix",8);
		village.ajouterHabitant(asterix);
		
//		Gaulois gaulois = village.trouverHabitant(0);
//		System.out.println(gaulois);
//		Gaulois [nom=Ast�rix, force=8, effetPotion=1]

		Gaulois obelix = new Gaulois ("Ob�lix",25);
		village.ajouterHabitant(obelix);
		
		
		
	}
	
}
