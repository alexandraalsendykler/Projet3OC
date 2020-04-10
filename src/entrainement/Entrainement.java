package entrainement;


import java.util.*;
import java.io.*;

public class Entrainement {

	public static void main(String[] args) throws IOException {
		String localDir = System.getProperty("user.dir");
		FileInputStream config = new FileInputStream(localDir + "//src//properties//config.properties");
		Properties properties = new Properties();
		properties.load(config);
		
		String nbEssai = properties.getProperty("nb_essai"); // a maitriser par coeur !!!
		String nBChiffreCombinaison = properties.getProperty("nb_chiffre_combinaison");
		String modeDev = properties.getProperty("mode_dev");
		 
		if (args.length != 0) {
			modeDev = args[0];
		}
		int choiceReStart = 1; // variable interne a la methode et non plus un attribut de classe
		while (choiceReStart == 1) { // tant que choiceRestart est = 1 (choix) j'execute la boucle

			View.display(View.choixmodedejeu);

			Scanner sc = new Scanner(System.in);
			int userInput = sc.nextInt();
			View.display(View.choixmodejeueffectué(userInput));
			switch (userInput) {
			case 1:
				Challenger chall = new Challenger();
				chall.play(modeDev);

				break;

			case 2:
				Defender def = new Defender();
				def.play();
				break;

			case 3:
				Duel duel = new Duel();
				duel.play(modeDev);
				break;

			}

			View.display(View.voulezVousrejouer);
			Scanner scan = new Scanner(System.in);
			choiceReStart = scan.nextInt();

		}
		View.display(View.aurevoirAbientôt);
	}

}
