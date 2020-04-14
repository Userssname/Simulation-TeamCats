package lesson19;

public class MixedPopulation extends Population{
  int numShelterInPlace;
  int numEssential;
  int numSkeptic;
  int numFlier;
  int numLazy;

  public MixedPopulation(int numShelterInPlace, int numEssential, int numSkeptic, int numFlier, int numLazy){
    super(numShelterInPlace + numEssential + numSkeptic + numFlier + numLazy);
    this.numShelterInPlace = numShelterInPlace;
    this.numEssential = numEssential;
    this.numSkeptic = numSkeptic;
    this.numFlier = numFlier;
    this.numLazy = numLazy;
  }

  public void createPeople(){
    for(int i=0; i<this.numShelterInPlace; i++){
      this.addPerson(new StayAtHome());
    }
    for(int i=0; i<this.numEssential; i++){
      this.addPerson(new StayAtHomeIfSick());
    }
    for(int i=0; i<this.numSkeptic; i++){
      this.addPerson(new Skeptic());
    }
    for(int i=0; i<this.numFlier; i++){
      this.addPerson(new FrequentFlier());
    }
    for(int i=0; i<this.numLazy; i++){
      this.addPerson(new LazyPerson());
    }

  }
}
