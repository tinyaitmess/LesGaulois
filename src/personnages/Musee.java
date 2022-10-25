package personnages;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophee=0;
	
	public Musee() {
		super();
		trophees =new Trophee[200];
		this.nbTrophee=nbTrophee;
	}
	
	public void donnerTrophees (Gaulois gaulois,Equipement equipement) {
		Trophee don = new Trophee(gaulois,equipement);
		trophees[nbTrophee]=don;
		nbTrophee+=1;

	}
	
	
}
