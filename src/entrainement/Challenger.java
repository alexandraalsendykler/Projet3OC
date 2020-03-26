package entrainement;

public class Challenger extends GameMode { // extends = heritage de GameMode

	public Challenger() { // constructeur de la classe Challenger
		
		this.IA = this.generateNumber(null, null);

	}

	public void play(String developpeurMode) {
		
		if(developpeurMode.equals("activermodedev")) {
			View.display(View.propositionIA(this.IA));
		}

		do { // boucle // do while
			this.recupererChoixHuman();
			this.ComparerValeurs();
			this.cpt++;
			if (this.success == true) {
				break;
			}

		} while (this.cpt < 4);

		if (this.success == true) {
			View.display(View.vousAvezGagné); // a remplacé system.out.println
		} else {
			View.display(View.vousAvezPerdu); // a remplacé system.out.println

		}
		
		View.display(View.jeuTermine);
	}

}
