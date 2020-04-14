package lesson19;

import java.util.Random;

public class FrequentFlier extends Person {
	private Random random = new Random();
	
	public FrequentFlier() {
		super();
	}


	void tryToMove() {
	
		int i = random.nextInt(country.places.length);
		int j = random.nextInt(country.places[i].length);
		while (country.places[i][j] != null) {
			i = random.nextInt(country.places.length);
			j = random.nextInt(country.places[i].length);
		}
	
		super.moveTo(i, j);
	} 
}