package service;

import DAO.Dao_Extrato;
import model.Extrato;

public class serv_Extrato {
	
	Dao_Extrato dao = new Dao_Extrato();
	
	public void carregarExtrato(Object entra[][]) {
		dao.carregarExtrato(entra);
	}
	public void carregarHoraEntra(Extrato extrato){
		dao.carregarHora( extrato);
	}

	public String tempoPermanencia(Extrato extrato) {

		int horaEntra = Integer.parseInt(extrato.getHoraEntrada().substring(0, 2));
		int minuEntra = Integer.parseInt(extrato.getHoraEntrada().substring(3, 5));
		int horaSaida = Integer.parseInt(extrato.getHoraSaida().substring(0, 2));
		int minuSaida = Integer.parseInt(extrato.getHoraSaida().substring(3, 5));
		
			int saida =(horaSaida*60)+minuSaida;
			int entra =(horaEntra*60)+minuEntra;
			int total = saida-entra; 
			extrato.setPermanenciaCliente((total/60) + ":" + (total%60));
			return extrato.getPermanenciaCliente();
					
	}
	public boolean adicionarExtrato(Extrato extrato){
		return dao.adicionarExtrato( extrato);
	}
	public boolean pedidoPago(Extrato extrato){
		return dao.pedidoPago( extrato);
	}

	public boolean horarioDePico(Extrato extrato){
		return dao.horarioDePico( extrato);
	}
}
