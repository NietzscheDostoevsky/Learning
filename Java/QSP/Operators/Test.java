public class PopulationProjection {
    public static void main(String[] args) {
        // Current population
        long currentPopulation = 312032486;

        // Calculate the number of seconds in a year
        long secondsInYear = 365 * 24 * 60 * 60;

        // Calculate the population change per year
        long birthsPerYear = secondsInYear / 7;
        long deathsPerYear = secondsInYear / 13;
        long immigrantsPerYear = secondsInYear / 45;

        // Calculate the population for each of the next five years
        for (int i = 1; i <= 5; i++) {
            // Calculate the population change for the current year
            long populationChange = birthsPerYear - deathsPerYear + immigrantsPerYear;

            // Update the current population
            currentPopulation += populationChange;

            // Display the population for the current year
            System.out.println("Population after " + i + " year(s): " + currentPopulation);
        }
    }
}
