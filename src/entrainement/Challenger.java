package entrainement;

public class Challenger extends GameMode { // extends = heritage de GameMode

	public Challenger() { // constructeur de la classe Challenger

		this.IA = this.generateNumber(null, null);

	}

	public void play(String developpeurMode) {
		
		if(developpeurMode.equals("activermodedev")) {
			View.display(View.combinaisonIA(this.IA)); 
		}
		int cpt = 0;
		boolean winHuman = false;
		do { 
			this.recupererChoixHuman();
			
			String[] resultHuman = this.comparerValeurs2(stringToInt(this.human), this.IA);
			winHuman = checkResult(resultHuman);
			cpt++;
			if (winHuman == true) {
				break;
			}

		} while (cpt < 4);

		if (winHuman == true) {
			View.display(View.vousAvezGagné); 
		} else {
			View.display(View.vousAvezPerdu); 

		}
		
		View.display(View.jeuTermine);
	}

}
