package entrainement;

public class Duel extends GameMode {

	private String[] combinaisonHumain ;
	private int[] combinaisonIA ;
	private String[] resultIA ;

	public Duel(String nBChiffreCombinaison) { // constructeur, a toujours le meme nom que la classe // c'est une super methode
		this.nb_chiffre_combinaison = Integer.parseInt(nBChiffreCombinaison);
		this.recupererChoixHuman();
		combinaisonHumain = this.human;
		combinaisonIA = this.generateNumber(null, null);
		
	}

	public void play(String developpeurMode, int nbEssai) { // methode
		View.display(View.nBEssai(nbEssai)); // indique au joueur le nb d'essai
		if(developpeurMode.equals("true")) {
			View.display(View.combinaisonIA(combinaisonIA, this.nb_chiffre_combinaison));
		}
		
		boolean winIA = false;
		boolean winHuman = false;
		while (winIA == false && winHuman == false && nbEssai != 0) {

			// demander une proposition au joueur

			this.recupererChoixHuman();

			String[] resultHuman = this.comparerValeurs2(stringToInt(this.human), combinaisonIA);
			winHuman = checkResult(resultHuman);

			if (resultIA == null) { // si resultIA est égale à nul alors la proposition de l'IA va générer
				// 4 chiffres aléatoirement sinon il va vérifier si c'est = / + ou -

				this.IA = this.generateNumber(null, null);
			} else {
				this.IA = this.generateNumber(this.IA, resultIA);
			}
			View.display(View.combinaisonIA(this.IA, this.nb_chiffre_combinaison));
			resultIA = this.comparerValeurs2(this.IA, stringToInt(combinaisonHumain));
			winIA = checkResult(resultIA);

			nbEssai--;
			View.display(View.nBEssaiRestant(nbEssai)); // exemple

		}
		View.display(View.jeuTermine); 
	}

}
