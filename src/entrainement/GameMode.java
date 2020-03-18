package entrainement;

import java.util.Scanner;

public abstract class GameMode {

	protected String[] human = new String[4];
	protected int[] IA = new int[4];
	protected String[] result = new String[4];
	protected int cpt = 0;
	protected int cptResults = 0;
	protected boolean success = false;

	public int[] generateNumber(int[] proposition, String[] result) { // faire une amelioration pour tenir compte
																		// chiffres // entrees + resultats des +/-/=
		int[] number = new int[4];
		if (proposition == null && result == null) {

			for (int i = 0; i < 4; i++) {
				int rand = (int) (Math.random() * 10);
				number[i] = rand;
			}
		} else {
			// ecrire le code pour la suite / parcourir result quand trouver le + je prends
			// le chiffre associe (1er valeur de la nouvelle proposition) je
			// defini // recupere resultat +/-/= examine 1 a 1, je me sers du - ou du + ou
			// du = / pour generer une valeur plus precise (a preparer pour pour session
			// 13/03/2020

			for (int i = 0; i < 4; i++) {
				if (result[i] == "=") {
					number[i] = proposition[i]; // la valeur de l'IA est garde si elle est egale a la precedente

				} else if (result[i] == "+") {
					int rand = (int) (Math.random() * (10 - proposition[i])) + proposition[i]; // math random l'IA
					number[i] = rand; // choisi un float
					// entre 0 et 1 puis
					// la multiplication
					// permet d'obtenir
					// le choix entre le
					// choix precedent
					// et le maximum

				} else if (result[i] == "-") {
					int rand = (int) (Math.random() * proposition[i]);
					number[i] = rand; // l'IA va prendre la valeur entre 0 et la valeur precedente

				}
			}

		}
		return number;
	}

	public void recupererChoixHuman() {

		System.out.print("Entrez votre proposition à 4 chiffres s'il vous plait : "); // modification le 08/03 pour
																						// rendre le jeu plus user
																						// friendly
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();

		human = userInput.split("", 0);
	}

	public void ComparerValeurs() {

		for (int i = 0; i < 4; i++) {
			int input = Integer.parseInt(human[i]);
			if (IA[i] < input) {
				result[i] = "-";
			} else if (IA[i] > input) {
				result[i] = "+";
			} else if (IA[i] == input) {
				result[i] = "=";
			}
			System.out.print(result[i]);

			if (result[i] == "=") {
				cptResults++;
			}
		}
		System.out.print("\n");

		if (cptResults == 4) {
			success = true;

		} else {
			success = false;
			cptResults = 0;
		}
	}

	public String[] comparerValeurs2(int[] proposition, int[] combinaisonadeviner) { // proposition &
																						// combinaisonadeviner sont
																						// parametres d'entree pour
																						// qu'elle puisse travailler
		View.comparerValeur2 = ""; // remet a 0 la valeur comparerValeur2 soit ce qui affiche le +/=/-
		String[] comparaison = new String[4]; // favoriser les variables locales plutôt que les attributs de classe 
		for (int i = 0; i < 4; i++) {
			if (proposition[i] < combinaisonadeviner[i]) {
				comparaison[i] = "+";
			} else if (proposition[i] > combinaisonadeviner[i]) {
				comparaison[i] = "-";
			} else if (proposition[i] == combinaisonadeviner[i]) {
				comparaison[i] = "=";
			}

			View.comparerValeur2 += comparaison[i]; // mets bout Ã  bout les valeurs de result soit +/=/-
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

}
