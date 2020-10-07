package philo;

public class Philosophe implements Runnable {
	private int identite;
	private Fourchette gauche;
	private Fourchette droite;

	public Philosophe(int identite, Fourchette gauche, Fourchette droite) {
		this.identite = identite;
		this.gauche = gauche;
		this.droite = droite;
	}

	public void penser() {
		System.out.println("Le philosophe " + identite + " pense.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void manger() {
		System.out.println("Le philosophe " + identite + " mange.");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {

			// pense
			penser();
			// a faim
			System.out.println("Le philosophe " + identite + " a faim.");
			droite.prendre();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Le philosophe " + identite + " a une fourchette.");
			// il a la fourchette droite
			gauche.prendre();
			// mange
			manger();
			droite.poser();
			gauche.poser();

		}
	}

}
