class AreaCircle {

    public static void main(String[] args) {

        final float pi = 3.14159f;
        float radius = 5.5f;

        double perimeter;
        double area;
        perimeter = 2 * pi * radius;
        area = pi * radius * radius;

        System.out.println("Perimeter = " + perimeter);
        System.out.println("Area = " + area);

    }

}