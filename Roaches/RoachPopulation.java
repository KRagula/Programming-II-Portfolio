/**
 * The class represents a roach population that may breed and that may be
 * controlled by insecticide.
 */
public class RoachPopulation {
	private int population;

	/**
	 * Create an initial roach population with given size.
	 * 
	 * @param size
	 *            initial population
	 */
	public RoachPopulation(int size) {
		population = size;
	}

	/**
	 * Simulates a breeding period increasing the population.
	 */
	public void doublePopulation() {
		population = population * 2;
	}

	/**
	 * Simulates a breeding period increasing the population.
	 */
	public void breed() {
		population *= 2;
	}

	/**
	 * Simulates a dying period halving the population.
	 */
	public void halfPopulation() {
		population = population / 2;
	}

	/**
	 * Simulates a roach wandering into the population.
	 */
	public void incrementPopulation() {
		population += 1;
	}

	/**
	 * Simulates a roach wandering away.
	 */
	public void decrementPopulation() {
		population -= 1;
	}

	/**
	 * Simulates an exterminator visit that eliminates 10% of the population
	 */
	public void exterminator() {
		population *= .9;
	}

	/**
	 * Simulates an explosion of the sun or any other act of God because nuclear
	 * blasts don't kill roaches
	 */
	public void killAll() {
		population = 0;
	}

	/**
	 * Returns the current population size.
	 * 
	 * @return current population size
	 */
	public int getPopulation() {
		return population;
	}
	
	/**
	 * Returns the current population size.
	 * 
	 * @return current population size
	 */
	public int getRoaches() {
		return population;
	}
	
	/** Sprays portion of the roach population
	 * 
	 * @param percent percent of roach population to be sprayed (killed)
	 */
	public void spray(double percent) {
		population *= (1 - (percent / 100));
	}

}
