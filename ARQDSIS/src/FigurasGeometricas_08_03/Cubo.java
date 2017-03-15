package FigurasGeometricas_08_03;

public class Cubo extends Figuras_Espaciais{
	int alt,larg,base;
	
	public Cubo(int a,int l,int b) {
		alt=a;
		larg=l;
		base=b;
		
	}
	@Override
	public int volume() {
		return alt*larg*base;
	}
}
