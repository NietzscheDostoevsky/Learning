package FishTank;

public class FishTankDriver {
	
	public static void main(String[] args) {
		
		Tank tank = new Tank("10cm Radius", "Glass", "Sphere", 10.0);
		System.out.println(tank);
		tank.addWater();
		tank.addFish();
		System.out.println(tank.fish.toString());
		tank.addStone();
		System.out.println(tank.stone.toString());
		tank.addFishFood();
		System.out.println(tank.fishFood.toString());
		tank.addLight();
		System.out.println(tank.light.toString());
		
		
		
	}

}
