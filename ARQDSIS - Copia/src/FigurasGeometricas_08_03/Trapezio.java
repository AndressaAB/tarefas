package FigurasGeometricas_08_03;

public class Trapezio extends Poligono {
	public int basao;

	public Trapezio(int a, int b, int bas) {
		super(a, b);
		basao=bas;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int area() {
		return ((basao + super.base)*alt) / 2;
	}

	@Override
	public int perimetro() {
		double z=( basao -base)/2;
		z=Math.sqrt(Math.pow(z, 2)+Math.pow(z, 2));
		return  (int) (z+ base + basao+z);
	}

}
