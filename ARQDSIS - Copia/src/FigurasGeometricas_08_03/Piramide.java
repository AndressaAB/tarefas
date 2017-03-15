package FigurasGeometricas_08_03;

public class Piramide extends Figuras_Espaciais{
	int alt,larg,base;
	
	public Piramide(int a,int l,int b) {
		alt=a;
		larg=l;
		base=b;
		
	}
	@Override
	public int volume() {
		return (alt*larg*base)/3;
	}
}
