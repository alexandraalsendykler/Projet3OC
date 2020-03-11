package entrainement;

public class Challenger extends GameMode { // extends = heritage de GameMode

	public Challenger() { // constructeur de la classe Challenger

		this.IA = this.generateNumber(null, null);

	}

	public void play() {

		do { // boucle // do while
			this.recupererChoixHuman();
			this.ComparerValeurs();
			this.cpt++;
			if (this.success == true) {
				break;
			}

		} while (this.cpt < 4);

		if (this.success == true) {
			System.out.print("Vous avez gagne !");
		} else {
			System.out.print("Vous avez perdu !");

		}
	}

}
