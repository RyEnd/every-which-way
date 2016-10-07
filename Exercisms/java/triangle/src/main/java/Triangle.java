public class Triangle {
	double sideA, 
		   sideB, 
		   sideC;

	public Triangle(double sideA, 
				    double sideB, 
				    double sideC) throws TriangleException{
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		
		if (sideA + sideB <= sideC ||
		    sideB + sideC <= sideA || 
		    sideA + sideC <= sideB || 
		    sideA <= 0 || 
		    sideB <= 0 || 
		    sideC <=0){
			throw new TriangleException();
		}
	}

	public TriangleKind getKind(){
		if (sideA == sideB && 
			sideB == sideC && 
			sideA != 0){
			return TriangleKind.EQUILATERAL;
		} else if (sideA == sideB || 
			       sideB == sideC || 
			       sideA == sideC){
			return TriangleKind.ISOSCELES;
		} else {
			return TriangleKind.SCALENE;
		}
	}
}