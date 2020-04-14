package lesson19;


public class LazyPerson extends Person {
	//use the tick to track the time
	private int tick = 0;

	public lazyPerson() {
		super();
	}


	void tryToMove() {

		//this person move every week
		if (tick%7==0){
			super.tryToMoveRandomly();
		}

		tick++;


	}
}
