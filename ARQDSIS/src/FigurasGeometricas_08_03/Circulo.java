package FigurasGeometricas_08_03;

public class Circulo extends Figura {
	public int raio;

	public Circulo(int r) {
		raio = r;
	}
	
	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}


	@Override
	public int area() {
		return (int) (3*Math.pow(raio, 2));
	}
	@Override
	public int perimetro() {
		return raio*2*3;
	}

}
