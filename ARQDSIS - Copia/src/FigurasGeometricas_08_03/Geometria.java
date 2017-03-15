package FigurasGeometricas_08_03;

import java.util.ArrayList;

public class Geometria {
	public static void main(String args[]){
		ArrayList<Figura> figuras= new ArrayList<>();
		figuras.add(new Circulo(4));
		figuras.add(new Triangulo(3,7));
		figuras.add(new Quadrado(3,3));
		figuras.add(new Retangulo(2,7));
		figuras.add(new Losango(3,5));
		figuras.add(new Trapezio(4,2,8));
		
		ArrayList<Figuras_Espaciais> figE= new ArrayList<>();
		figE.add(new Cubo(4,5,8));
		figE.add(new Piramide(3,7,4));
		figE.add(new Cilindro(3,3));
		figE.add(new Esfera(2));
		
		String nomes[]={"Circulo","Triangulo","Quadrado","Retangulo","Losango","Trapezio","Cubo",
				"Pramide","Cilindro","Esfera"};
		int i=0;
		for (Figura fig:figuras){
			System.out.println(nomes[i]);
			System.out.println(fig.area());
			System.out.println(fig.perimetro());

			if(fig instanceof Diagonal){
				System.out.println(((Diagonal)fig).diagonal());
			}
			i++;
			System.out.println();
			
		}
		for (Figuras_Espaciais f:figE){
			System.out.println(nomes[i]);
			System.out.println(f.volume());
			i++;
			System.out.println();
		}
	}
}
