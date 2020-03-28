package entrainement;

public class Defender extends GameMode {

	
	private String[] resultIA = new String[4];
	
	public Defender() {

		this.recupererChoixHuman();

	}

	public void play() {

		do {

			if (resultIA[0] == null) { // si resultIA est �gale � nul alors la proposition de l'IA va g�n�rer
				// 4 chiffres al�atoirement sinon il va v�rifier si c'est = / + ou -

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
			View.display(View.vousAvezGagn�); // a remplac� system.out.println
		} else {
			View.display(View.vousAvezPerdu); // a remplac� system.out.println

		}
		
		View.display(View.jeuTermine);
	}

}

