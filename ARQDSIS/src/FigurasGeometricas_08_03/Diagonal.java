package FigurasGeometricas_08_03;

public interface Diagonal {
		int alt();
		int base();	
	
		default double diagonal(){
		return Math.sqrt(Math.pow(base(),2)+ Math.pow(alt(),2));
	}
}
