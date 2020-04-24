package com.oc.alexandra;

import org.apache.log4j.Logger;

public class Challenger extends GameMode { // extends = heritage de GameMode
	
	private static Logger logger = Logger.getLogger(Challenger.class);

	public Challenger(String nBChiffreCombinaison) { // constructeur de la classe Challenger
		this.nb_chiffre_combinaison = Integer.parseInt(nBChiffreCombinaison);
		this.IA = this.generateNumber(null, null);

	}

	public void play(String developpeurMode,int nbEssai) {
		logger.info("Début du mode Challenger"); // rajout pour log
		if(developpeurMode.equals("true")) {
			logger.info("Le mode Dev est activé");
			View.display(View.combinaisonIA(this.IA, this.nb_chiffre_combinaison)); 
			logger.info(View.combinaisonIA(this.IA, this.nb_chiffre_combinaison));

		}
		int cpt = 0;
		boolean winHuman = false;
		do { 
			this.recupererChoixHuman();
			
			String[] resultHuman = this.comparerValeurs2(stringToInt(this.human), this.IA);
			winHuman = checkResult(resultHuman);
			cpt++;
			if (winHuman == true) {
				break;
			}

		} while (cpt < nbEssai);

		if (winHuman == true) {
			View.display(View.vousAvezGagné); 
		} else {
			View.display(View.vousAvezPerdu); 

		}
		
		View.display(View.jeuTermine);
		logger.info("Fin de la manche Challenger"); // rajout pour log 
	}}

	
