
package com.oc.alexandra;

public class View {
	public static String inputPropositionHuman = "Merci de saisir votre proposition";
	public static String inputPropositionIA = "l'IA a fait sa proposition";
	public static String erreurdefrappe = "Merci de choisir l'un des modes de jeux proposés";
	public static String joueurdoitchoisirunmodeprésent = "Veuillez choisir l'un des modes ci-dessous";
	public static String erreurchoix = "Mauvais choix entré";

	public static String jeuTermine = "Le jeu est terminé, merci d'avoir joué !"; 
	public static String vousAvezGagné = "Vous avez gagné !"; 
	public static String vousAvezPerdu = "Vous avez perdu !"; 
	public static String bonjour = "Bonjour !";
	public static String choixmodedejeu =  "Vous pouvez choisir entre plusieurs modes de jeu :\n" + "1) Challenger\n" + 
	"2) Defender\n" + "3) Duel\n" + "Quel est votre choix ?";

	public static String voulezVousrejouer = " Voulez-vous rejouer ?\n1) oui \n2) non \n" + "Quel est votre choix ?";
	public static String aurevoirAbientôt = "Aurevoir & a bientot";
	public static String choixmodejeueffectué(int userInput) {
		return "Vous avez choisi le mode " + userInput + ", bon jeu !";
	}
	public static void display(String text) { // methode on les reconnait grace aux accolades et les parentheses

		System.out.println(text);
	}

	public static String combinaisonIA(int[] propositionIA, int nbCombinaison) {
		String choixIA = ""; // "" sont la pour remettre a 0 les valeurs
		for (int i = 0; i < nbCombinaison; i++) { // boucle est la pour parcourir le tableau du proposition IA
			choixIA += String.valueOf(propositionIA[i]); // le += sert a concatener la chaine de caractere de
															// proposition IA
		}
		return inputPropositionIA + " " + choixIA;
	}

	public static String nBEssaiRestant(int essai) {
		return "Il vous reste " + String.valueOf(essai) + " essai(s)"; // ajout de cette methode pour indiquer nb
																		// d'essai restant

	}

	public static String comparerValeur2; // comparerValeur2 = propriete pour afficher le result +/=/- // defini la
											// classe
	public static String nBEssai(int nbEssai) {
		return "Vous disposez de "+String.valueOf(nbEssai)+" essais"; 
	}
	public static String entréeProposition (int nbCombinaison) {
		return "Entrez votre proposition à "+String.valueOf(nbCombinaison)+" chiffres s'il vous plait : ";
	}
	
}

