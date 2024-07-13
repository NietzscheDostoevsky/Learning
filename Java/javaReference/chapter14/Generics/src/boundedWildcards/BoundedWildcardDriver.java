package boundedWildcards;

public class BoundedWildcardDriver {
	
	public static void main(String[] args) {
		TwoD[]  td = {
			new TwoD(0, 0),
			new TwoD(7, 9),
			new TwoD(18, 4),
			new TwoD(-1, -23)
		};
		
		TwoD[]  td1 = {
				new ThreeD(0, 0, 0),
				
			};
		
		Coords<TwoD> tdlocs = new Coords<>(td);
		System.out.println("Contents of tdlocs");
		Coords.showXY(tdlocs);
		//Coords.showXYZ(tdlocs);
		
		FourD[] fd = {
				new FourD(1, 2, 3, 4),
				new FourD(6, 8, 14, 8),
				new FourD(22, 9, 4, 9),
				new FourD(3, -2, -23, 17)
				};
		
		Coords<FourD> fdlocs = new Coords<>(fd);
		System.out.println("Content of fdlocs");
		Coords.showXY(fdlocs);
		Coords.showXYZ(fdlocs);
		Coords.showAll(fdlocs);
		
		
		
		
	}
}
