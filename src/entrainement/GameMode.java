package entrainement;

import java.util.Properties;
import java.util.Scanner;
import java.io.*;

public abstract class GameMode {

//	Properties properties = new Properties(System.getProperties());
//	public int nb_chiffre_combinaison = Integer.parseInt(properties.getProperty("nb_chiffre_combinaison"));

	public int nb_chiffre_combinaison;
	protected String[] human = new String[nb_chiffre_combinaison];
	protected int[] IA = new int[nb_chiffre_combinaison];

	public int[] generateNumber(int[] proposition, String[] result) { // faire une amelioration pour tenir compte
																		// chiffres // entrees + resultats des +/-/=
		int[] number = new int[nb_chiffre_combinaison];
		if (proposition == null && result == null) {

			for (int i = 0; i < nb_chiffre_combinaison; i++) {
				int rand = (int) (Math.random() * 10);
				number[i] = rand;
			}
		} else {
			// ecrire le code pour la suite / parcourir result quand trouver le + je prends
			// le chiffre associe (1er valeur de la nouvelle proposition) je
			// defini // recupere resultat +/-/= examine 1 a 1, je me sers du - ou du + ou
			// du = / pour generer une valeur plus precise (a preparer pour pour session
			// 13/03/2020

			for (int i = 0; i < nb_chiffre_combinaison; i++) {
				if (result[i] == "=") {
					number[i] = proposition[i]; // la valeur de l'IA est garde si elle est egale a la precedente

				} else if (result[i] == "+") {
					int rand = (int) (Math.random() * (10 - proposition[i] + 1)) + proposition[i] + 1; // math random
																										// l'IA
					number[i] = rand; // choisi un float
					// entre 0 et 1 puis
					// la multiplication
					// permet d'obtenir
					// le choix entre le
					// choix precedent
					// et le maximum

				} else if (result[i] == "-") {
					int rand = (int) (Math.random() * proposition[i] - 1);
					number[i] = rand; // l'IA va prendre la valeur entre 0 et la valeur precedente

				}
			}

		}
		return number;
	}

	public void recupererChoixHuman() {

		View.display(View.entréeProposition(nb_chiffre_combinaison));

		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();

		human = userInput.split("", 0);
	}

	public String[] comparerValeurs2(int[] proposition, int[] combinaisonadeviner) { // proposition &
																						// combinaisonadeviner sont
																						// parametres d'entree pour
																						// qu'elle puisse travailler
		View.comparerValeur2 = ""; // remet a 0 la valeur comparerValeur2 soit ce qui affiche le +/=/-
		String[] comparaison = new String[nb_chiffre_combinaison]; // favoriser les variables locales plutôt que les attributs de classe
		for (int i = 0; i < nb_chiffre_combinaison; i++) {
			if (proposition[i] < combinaisonadeviner[i]) {
				comparaison[i] = "+";
			} else if (proposition[i] > combinaisonadeviner[i]) {
				comparaison[i] = "-";
			} else if (proposition[i] == combinaisonadeviner[i]) {
				comparaison[i] = "=";
			}

			View.comparerValeur2 += comparaison[i]; // mets bout à bout les valeurs de result soit +/=/-
		}

		View.display(View.comparerValeur2);

		return comparaison; // permet de retourner un resultat / It is used to exit from a method, with or
		// without a value / valeurs en sortie

	}

	public int[] stringToInt(String[] tableauString) {

		int[] tableauInt = new int[tableauString.length];
		for (int i = 0; i < tableauString.length; i++) {

			tableauInt[i] = Integer.parseInt(tableauString[i]);

		}

		return tableauInt;
	}

	public boolean checkResult(String[] result) {
		int cpt = 0;
		for (int i = 0; i < nb_chiffre_combinaison; i++) {
			if (result[i] == "=") {
				cpt++;
			}
		}
		if (cpt == nb_chiffre_combinaison) {
			return true;
		} else {
			return false;
		}
	}

}
