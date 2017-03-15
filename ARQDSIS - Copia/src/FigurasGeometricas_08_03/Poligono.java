package FigurasGeometricas_08_03;

public abstract class Poligono extends Figura {
	public int alt;
	public int base;

	public Poligono(int a, int b) {
		alt = a;
		base = b;
	}

	public void setAlt(int a) {
		alt = a;
	}

	public int getAlt() {
		return alt;
	}

	
}
