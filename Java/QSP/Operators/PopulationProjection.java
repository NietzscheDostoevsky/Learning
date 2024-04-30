public class PopulationProjection {

    public static void main(String[] args) {

        // Given Data
        final int currentPopulation = 312_032_486; // people
        final int year = 365; // days
        final int birth = 7;
        final int death = 13;
        final int immigration = 45;

        // Calculated Data

        int secondsInYear = year * 24 * 60 * 60; // seconds
        int birthPerYear = secondsInYear / birth; // births in a year
        int deathPerYear = secondsInYear / death; // deatgs in a year
        int immigrationPerYear = secondsInYear / immigration; // immigration per year

        // calculating yearly change

        int yearlyPopDelta = birthPerYear - deathPerYear + immigrationPerYear;

        // Printing for 5 years
        int i = 1;
        for (i = 1; i < 6; i++) {
            int newPopulation = currentPopulation + (yearlyPopDelta * i);
            System.out.println("Population in year " + i + " : " + newPopulation);
        }

    }
}
