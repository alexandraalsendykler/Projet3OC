package entrainement;

public class Defender extends GameMode {

	public Defender() {

		this.recupererChoixHuman();

	}

	public void play() {

		do {
			this.IA = this.generateNumber(null, null);
			this.ComparerValeurs(); // � modifier ancienne m�thode 
			this.cpt++;
			if (this.success == true) {
				break;
			}
			

		} while (this.cpt < 4);

		if (this.success == true) {
			View.display(View.vousAvezGagn�); // a remplac� system.out.println
		} else {
			View.display(View.vousAvezPerdu); // a remplac� system.out.println

		}
		
		View.display(View.jeuTermine);
	}

}

