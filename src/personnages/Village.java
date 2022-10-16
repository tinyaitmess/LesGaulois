package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageoisMaximum=0;
	private Gaulois[] villageois;
	private int nbVillageois;
	
	
	public Village(int nbVillageoisMaximum) {
		super();
		Gaulois [] villageois = new Gaulois[nbVillageoisMaximum];
		this.nbVillageois = nbVillageoisMaximum;
	}


	public Village(String nom) {
		this.nom=nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
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
	
	public static void main (String[] args) {
		Village village = new Village ("Village des Irréductibles",30);
	}
	
}
