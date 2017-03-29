package teste;
import java.util.Locale;
import java.util.ResourceBundle;

import interfaces.Interface_ExtratoDeConsumo;

public class Teste {
	public static void main(String args[]) {

	  ResourceBundle bn = ResourceBundle.getBundle("proj", new Locale("pt", "BR"));

	Interface_ExtratoDeConsumo.modificarBundle(bn);
	Interface_ExtratoDeConsumo cons = new Interface_ExtratoDeConsumo(null);	
	}
}
