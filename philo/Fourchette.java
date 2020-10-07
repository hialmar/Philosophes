package philo;

public class Fourchette {
	private boolean estPrise = false;
	private int identite;

	public Fourchette(int identite) {
		this.identite = identite;
	}

	public synchronized void poser() {
		estPrise = false;
		System.out.println("La fourchette " + identite + " a ete posee.");
		this.notify();
	}

	public synchronized void prendre() {
		while(estPrise) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		estPrise = true;
		System.out.println("La fourchette " + identite + " a ete prise.");
	}

}
