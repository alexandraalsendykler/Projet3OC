package entrainement;

public class Defender extends GameMode {

	public Defender() {

		this.recupererChoixHuman();

	}

	public void play() {

		do {
			this.IA = this.generateNumber(null, null);
			this.ComparerValeurs();
			this.cpt++;
			if (this.success == true) {
				break;
			}
			

		} while (this.cpt < 4);

		if (this.success == true) {
			View.display(View.vousAvezGagn�);
		} else {
			View.display(View.vousAvezPerdu);

		}
		
		View.display(View.jeuTermine);
	}

}

