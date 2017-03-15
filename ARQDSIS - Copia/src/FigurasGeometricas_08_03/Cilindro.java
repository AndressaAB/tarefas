package FigurasGeometricas_08_03;

public class Cilindro extends Figuras_Espaciais {
	int raio, alt;
	public Cilindro (int a , int r){
		raio=r;
		alt=a;
	}
	@Override
	public int volume() {
		return (int) (3*alt*Math.pow(raio, 3));
	}
}
