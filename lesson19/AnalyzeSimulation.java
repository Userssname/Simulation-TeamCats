package lesson19;

import java.util.Random;
/**
 *
 * @author tim
 *
 */

public class AnalyzeSimulation {
	// the maximum number of days the simulation will run
	private static int MAX_TICKS=1000;

	private Random random = new Random();

  public static int numOfDays;
  public static int numOfInfected;
  public static int peakInfectedLevel;

	public static void main(String[] args) {
		// first we get the simulation parameters
		// from the command line

		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		int numStayHome = Integer.parseInt(args[2]);
		int numEssential = Integer.parseInt(args[3]);
		int numSkeptic = Integer.parseInt(args[4]);
		int numFlier = Integer.parseInt(args[5]);
		int numLazy = Integer.parseInt(args[6]);
    int numSimulation = Integer.parseInt(args[7]);


    for(int i=0;i< numSimulation;i++){
    		// next we create the population and the country
    		Population population;
    		population = new MixedPopulation(numStayHome, numEssential, numSkeptic, numFlier, numLazy);
    		population.createPeople();

    		Country country = new Country(width,height);
    		// and add a link to the population in the country
    		country.population = population;
    		// next we place the people into the country randomly
    		population.placePeople(country);

        int Days = 0;
        int Infected = 0;
        int maxLevel = 0;

    		for(int k=0;k<MAX_TICKS; k++) {
    			country.simulateOneStep();
    			// until the peak day of the infected
          if (country.numInfected>Infected){
            Infected = country.numInfected;
          } else {
            Days = k;
          }
          // until the last day
    			if (country.numInfected==0) {
            maxLevel = country.numRecovered;
    				break;
    			}
    		}

        System.out.println("\nDays until no new infections: "+ Days
              +"Number of people infected:"+ Infected
              +"Maximum number of people infected:"+maxLevel);
        numOfDays += Days;
        numOfInfected += Infected;
        peakInfectedLevel += maxLevel;

    }
    System.out.printf("%n%10s%22d%28d%36d%n","Average:", numOfDays/numSimulation,numOfInfected/numSimulation,peakInfectedLevel/numSimulation);
	}




}
