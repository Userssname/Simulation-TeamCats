package lesson19;


public class lazyPerson extends Person {
	private int tick = 0;
	
	public lazyPerson() {
		super();
	}


	void tryToMove() {
	
		
		if (tick%7==0){
			super.tryToMoveRandomly();
		}
		
		tick++;
		

	} 
}