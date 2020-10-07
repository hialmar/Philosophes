package philo;

public class Main {
	public static void main(String[] args) {
		Fourchette[] fourchettes = new Fourchette[5];
		for (int i = 0; i < 5; i++)
			fourchettes[i] = new Fourchette(i);
		Philosophe[] philosophes = new Philosophe[5];
		for (int i = 0; i < 5; i++) {
			if (i < 4)
				philosophes[i] = new Philosophe(i, fourchettes[i], fourchettes[i + 1]);
			else
				philosophes[i] = new Philosophe(i, fourchettes[0], fourchettes[i]);
			Thread t = new Thread(philosophes[i]);
			t.start();
		}
	}

}
