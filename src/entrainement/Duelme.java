package entrainement;

public class Duelme extends GameMode {

	private String[] combinaisonHumain = new String[4];
	private int[] combinaisonIA = new int[4];
	private String[] resultIA = new String[4];

	public Duelme() { // constructeur, a toujours le meme nom que la classe // c'est une super methode

		this.recupererChoixHuman();
		combinaisonHumain = this.human;
		combinaisonIA = this.generateNumber(null, null);
		View.display(View.nBEssai); // indique au joueur le nb d'essai
	}

	public void play() { // methode

		int nbEssai = 4; // variable local (valide uniquement dans la methode play)
		boolean winIA = false;
		boolean winHuman = false;
		while (winIA == false && winHuman == false && nbEssai != 0) {

			// demander une proposition au joueur

			this.recupererChoixHuman();

			String[] resultHuman = this.comparerValeurs2(stringToInt(this.human), combinaisonIA);
			winHuman = checkResult(resultHuman);

			// demander la proposition de l'IA
			// if (resultIA == null) {
			// this.generateNumber(null, null);
			// } else {
			// int[] tampIA = this.IA;
			// this.generateNumber(tampIA, resultIA);
			// }

			if (resultIA[0] == null) { // si resultIA est �gale � nul alors la proposition de l'IA va g�n�rer
				// 4 chiffres al�atoirement sinon il va v�rifier si c'est = / + ou -

				this.IA = this.generateNumber(null, null);
			} else {
				this.IA = this.generateNumber(this.IA, resultIA);
			}
			View.display(View.propositionIA(this.IA));
			resultIA = this.comparerValeurs2(this.IA, stringToInt(combinaisonHumain));
			winIA = checkResult(resultIA);

			nbEssai--;
			View.display(View.nBEssaiRestant(nbEssai)); // exemple

		}
		View.display(View.jeuTermine); // faire attention au debut mise dans la boucle (mega blonde) -_- // bien mettre
										// en dehors de la boucle
	}

	private boolean checkResult(String[] result) {
		int cpt = 0;
		for (int i = 0; i < 4; i++) {
			if (result[i] == "=") {
				cpt++;
			}
		}
		if (cpt == 4) {
			return true;
		} else {
			return false;
		}
	}

}