package personnages;
import personnages.Trophee;

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
	
	public String extraireInstructionsCaml(Trophee[] trophees) {
		String texte="let musee = [\n";
		for(int i=0;i<trophees.length;i++) {
			Gaulois donnateur = trophees[i].getGaulois();
			texte+="	"+trophees[i].donnerNom(donnateur)+","+trophees[i].getEquipement()+";\n";
		}
		return texte+"]"  ;
	}
	
}
