package entrainement;

public class Defender extends GameMode {

	
	private String[] resultIA = new String[4];
	
	public Defender() {

		this.recupererChoixHuman();

	}

	public void play() {

		do {

			if (resultIA[0] == null) { // si resultIA est égale à nul alors la proposition de l'IA va générer
				// 4 chiffres aléatoirement sinon il va vérifier si c'est = / + ou -

				this.IA = this.generateNumber(null, null);
			} else {
				this.IA = this.generateNumber(this.IA, resultIA);
			}
			resultIA = this.comparerValeurs2(this.IA, stringToInt(this.human));
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

