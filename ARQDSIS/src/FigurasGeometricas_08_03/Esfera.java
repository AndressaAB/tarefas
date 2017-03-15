package FigurasGeometricas_08_03;

public class Esfera extends Figuras_Espaciais {
	int raio;

	public Esfera(int r) {
		raio = r;
	}

	@Override
	public int volume() {
		
		return (int) ((4/3)*3*Math.pow(raio, 3));
	}
}
