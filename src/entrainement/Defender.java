package entrainement;

import org.apache.log4j.Logger;

public class Defender extends GameMode {
	
	private static Logger logger = Logger.getLogger(Defender.class);
	
	private String[] resultIA ;
	
	public Defender(String nBChiffreCombinaison ) {
		logger.info("Début du mode Defender");
		this.nb_chiffre_combinaison = Integer.parseInt(nBChiffreCombinaison);
		this.recupererChoixHuman();

	}
	
	public void play(int nbEssai) {
		
		boolean winIA = false;
		int cpt = 0;
		do {

			if (resultIA == null) { // si resultIA est égale à nul alors la proposition de l'IA va générer
				// 4 chiffres aléatoirement sinon il va vérifier si c'est = / + ou -
				this.IA = this.generateNumber(null, null);
			} else {
				this.IA = this.generateNumber(this.IA, resultIA);
			}
			resultIA = this.comparerValeurs2(this.IA, stringToInt(this.human));
			cpt++;
			
			winIA = checkResult(resultIA);
			
			if (winIA == true) {
				break;
			}
			

		} while (cpt < nbEssai);

		if (winIA == true) {
			View.display(View.vousAvezPerdu); 
		} else {
			View.display(View.vousAvezGagné); 

		}
		
		View.display(View.jeuTermine);
		logger.info("Fin de la manche Defender");
	}

}

