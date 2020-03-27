package entrainement;

public class Defender extends GameMode {

	public Defender() {

		this.recupererChoixHuman();

	}

	public void play() {

		do {
			this.IA = this.generateNumber(null, null);
			this.ComparerValeurs(); // à modifier ancienne méthode 
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

