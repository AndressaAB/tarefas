package FigurasGeometricas_08_03;

public abstract class Quadrilatero extends Poligono{

	public Quadrilatero(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int area() {
		return super.base*super.alt;
	}
	@Override
	public int perimetro() {
		return (super.base*2)+(super.alt*2);
	}
	

}
