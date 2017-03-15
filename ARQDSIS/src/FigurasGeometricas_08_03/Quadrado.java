package FigurasGeometricas_08_03;

public class Quadrado extends Quadrilatero implements Diagonal{

	public Quadrado(int a, int b) {
		super(a, b);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int area() {
		// TODO Auto-generated method stub
		return super.area();
	}
	public int perimetro() {
		return super.perimetro();
	}

	@Override
	public int alt() {
		return alt;
	}

	@Override
	public int base() {
		return base;
	}

	@Override
	public double diagonal() {
		// TODO Auto-generated method stub
		return Diagonal.super.diagonal();
	}

	
}
