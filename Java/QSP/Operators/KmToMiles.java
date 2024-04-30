class KmToMiles {

    public static void main(String[] args) {
        double distanceKm = 14.0; // in km
        double timeInMinutes = 45.5f;

        // Conversion factor
        double milesPerKm = 1 / 1.6; // miles per km

        double distanceMile = distanceKm * milesPerKm;
        double speedMPH = distanceMile / (timeInMinutes / 60.0);

        // displaying the output

        System.out.println("Speed in MPH : " + speedMPH + "MPH");

    }
}
