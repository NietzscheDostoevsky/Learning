class Planet {

    public static void main(String[] args) {
        int diameterInKilometers = 12742;
        int distanceFromSun = 149_600_000;
        int mass = 1_972_000_000;
        int surfaceTemperature = 15;
        int numberOfMoons = 23;

        System.out.println("Diameter (km): " + diameterInKilometers);
        System.out.println("Distance from Sun (million km): " + distanceFromSun);
        System.out.println("Mass (kg): " + mass);
        System.out.println("Surface temperature (°C): " + surfaceTemperature);
        System.out.println("Number of moons: " + numberOfMoons);
    }
}
