package entrainement;

import java.util.Scanner;

public class Entrainement {

	public static void main(String[] args) {
		int choiceReStart = 1; // variable interne a la methode et non plus un attribut de classe 
		while (choiceReStart == 1) { // tant que choiceRestart est = 1 (choix) j'execute la boucle

			System.out.print("Bonjour ! " + "Vous pouvez choisir entre plusieurs modes de jeu :\n" + "1) Challenger\n"
					+ "2) Defender\n" + "3) Duel\n" + "Quel est votre choix ?");

			Scanner sc = new Scanner(System.in);
			int userInput = sc.nextInt();
			System.out.println("Vous avez choisi le mode " + userInput + ", bon jeu !");
			switch (userInput) {
			case 1:
				Challenger chall = new Challenger();
				chall.play();

				break;

			case 2:
				Defender def = new Defender();
				def.play();
				break;

			case 3:
				Duelme duel = new Duelme();
				duel.play();
				break;

			}

			System.out.print(" Voulez-vous rejouer ?\n1) oui \n2) non \n" + "Quel est votre choix ?");
			Scanner scan = new Scanner(System.in);
			choiceReStart = scan.nextInt();

		}
		System.out.print("Aurevoir & a bientot"); // phrase de fin pour dire au revoir au joueur
	}
}
