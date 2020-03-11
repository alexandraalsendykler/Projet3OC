package entrainement;

public class Duel extends GameMode {
	protected boolean IaSuccess = false;
	protected boolean joueurSuccess = false;
	protected String[] combinaisonJoueur = new String[4];
	protected int[] combinaisonIA = new int[4];
	protected int[] propositionIA = new int[4];
	protected int[] bonneReponseIA = { 10, 10, 10, 10 };

	public Duel() {
		this.generateNumber();
		this.combinaisonIA = this.IA;

		this.RecupererChoixHuman();
		this.combinaisonJoueur = this.human;
	}

	public void BonneReponse() {
		for (int i = 0; i < 4; i++) {

			if (this.bonneReponseIA[i] == 10) {

				int rand = (int) (Math.random() * 10);
				this.propositionIA[i] = rand;

			} else {
				this.propositionIA[i] = this.bonneReponseIA[i];
			}
			System.out.print(this.propositionIA[i]);
		}

		System.out.print("\n");

	}

	public void ChangeBonneReponse() {
		for (int i = 0; i < 4; i++) {
			if (this.result[i] == "=") {
				this.bonneReponseIA[i] = this.IA[i];
			}
		}
	}

	public void Play() {
		while (IaSuccess == false && joueurSuccess == false) {
			if (this.cpt % 2 == 0) {
				this.BonneReponse();
				this.IA = this.propositionIA;
				this.human = this.combinaisonJoueur;
				this.ComparerValeurs();
				this.ChangeBonneReponse();
				if (this.success) {
					this.IaSuccess = true;
				}
			} else {
				this.RecupererChoixHuman();
				this.IA = this.combinaisonIA;
				this.ComparerValeurs();
				if (this.success) {
					this.joueurSuccess = true;
				}
			}

			cpt++;
		}
		if (joueurSuccess == true) {
			System.out.print(" Vous avez gagné ! ");
		} else {
			System.out.print(" Vous avez perdu ");
		}

	}
}