class Planet {

    public static void main(String[] args) {
        int diameter = 12742;
        long distanceFromSun = 149_600_000_000L;
        int mass = 1_972_000_000;
        int surfaceTemperature = 15;
        int numberOfMoons = 23;

        System.out.println("*****DETAILS OF NEW FOUND PLANET********");
        System.out.println("Diameter (km): " + diameter);
        System.out.println("Distance from Sun (million km): " + distanceFromSun);
        System.out.println("Mass (in Thousand kg): " + mass);
        System.out.println("Surface temperature (°C): " + surfaceTemperature);
        System.out.println("Number of moons: " + numberOfMoons);
    }
}
