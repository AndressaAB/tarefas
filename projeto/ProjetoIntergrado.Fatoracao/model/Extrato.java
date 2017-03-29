package model;

import java.io.Serializable;
import java.text.DecimalFormat;

import DAO.Dao_Extrato;

public class Extrato implements Serializable{
	
	String desc, tipo, dispo, sql, horaEntrada, horaSaida,cpf, dataEntrada,permanenciaCliente,carregarHoraEntra;
	Object lista[][];
	private static final long serialVersionUID = 1L;
	
	//Dao_Extrato dao = new Dao_Extrato();
	DecimalFormat df = new DecimalFormat("0.00");

	boolean sucesso, finalizado;

	double preco, preçoTotal;
	int cod, pedido, numPrato, quantidade, mesa, numSeq, garçom, codItem;

	public String getHoraEntrada() {
		return getHoraEntrada();
	}

	public void setHoraEntrada(String horaEntra) {
		horaEntrada = horaEntra;
	}

	public String getHoraSaida() {
		return getHoraSaida();
	}

	public void setHoraSaida(String horaSai) {
		horaSaida = horaSai;
	}

	public void setPreçoTotal(double p) {
		preçoTotal = p;
		
	}

	public double getPreçoTotal() {
		return getPreçoTotal();
	}

	public int getCodItem() {
		return getCodItem();
	}

	public void setCodItem(int codIte) {
		codItem = codIte;
		
	}

	public void setQuantidade(int q) {
		quantidade = q;

	}

	public int getQuantidade() {
		return getQuantidade();
	}

	public void setNumSeq(int numSeq) {
		setNumSeq(numSeq);
	}

	public int getNumSeq() {
		return getNumSeq();
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return getPreco();
	}

	public String getPrecoString() {
		return df.format(preco);
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getCod() {
		return getCod();
	}

	public void setCod(int c) {
		cod = c;
		
	}

	public String getDispo() {
		return dispo;
	}

	public void setDispo(String dispo) {
		this.dispo = dispo;
	}

	public void setSql(String s) {
		sql = s;
		
	}

	public String getSql() {
		return getSql();
	}

	public void setSucesso(boolean s) {
		sucesso = s;
	}

	public boolean getSucesso() {
		return getSucesso();
	}

	public void setCarregarExtrato(Object[][] entra) {
		lista=entra;
	}
	
	public int getMesa() {
		return getMesa();
	}

	public void setMesa(int m) {
		mesa = m;
	}

	public void setNumPrato(int n) {
		numPrato = n;
	}

	public int setNumePratio() {
		return numPrato;
	}

	public void setFinalizado(boolean f) {
		finalizado = f;
	}

	public boolean getFinalizado() {
		return getFinalizado();
	}

	public boolean horaSaidaExtrato() {
		return horaSaidaExtrato();

	}
	
	public String getCpf() {
		return getCpf();
	}

	public void setCpf(String cp) {
		cpf = cp;
	}
	public String getDataEntrada() {
		return getDataEntrada();
	}

	public void setDataEntrada(String dataEntra) {
		dataEntrada = dataEntra;
	}

	public String getPermanenciaCliente() {
		return permanenciaCliente;
	}
	public void setPermanenciaCliente(String permanenciaCliente) {
		permanenciaCliente = permanenciaCliente;
	}

	

	public String getTempoPermanencia() {
		return carregarHoraEntra;
	}

	
	

}
