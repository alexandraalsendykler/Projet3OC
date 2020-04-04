package entrainement;

public class Duel extends GameMode {

	private String[] combinaisonHumain = new String[4];
	private int[] combinaisonIA = new int[4];
	private String[] resultIA = new String[4];

	public Duel() { // constructeur, a toujours le meme nom que la classe // c'est une super methode

		this.recupererChoixHuman();
		combinaisonHumain = this.human;
		combinaisonIA = this.generateNumber(null, null);
		View.display(View.nBEssai); // indique au joueur le nb d'essai
	}

	public void play(String developpeurMode) { // methode
		
		if(developpeurMode.equals("activermodedev")) {
			View.display(View.combinaisonIA(combinaisonIA));
		}
		
		int nbEssai = 4; // variable local (valide uniquement dans la methode play) // modifier ici car il y a un bug
		boolean winIA = false;
		boolean winHuman = false;
		while (winIA == false && winHuman == false && nbEssai != 0) {

			// demander une proposition au joueur

			this.recupererChoixHuman();

			String[] resultHuman = this.comparerValeurs2(stringToInt(this.human), combinaisonIA);
			winHuman = checkResult(resultHuman);

			if (resultIA[0] == null) { // si resultIA est égale à nul alors la proposition de l'IA va générer
				// 4 chiffres aléatoirement sinon il va vérifier si c'est = / + ou -

				this.IA = this.generateNumber(null, null);
			} else {
				this.IA = this.generateNumber(this.IA, resultIA);
			}
			View.display(View.combinaisonIA(this.IA));
			resultIA = this.comparerValeurs2(this.IA, stringToInt(combinaisonHumain));
			winIA = checkResult(resultIA);

			nbEssai--;
			View.display(View.nBEssaiRestant(nbEssai)); // exemple

		}
		View.display(View.jeuTermine); 
	}

}
