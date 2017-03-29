package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import model.Extrato;

public class Dao_Extrato {


DecimalFormat df = new DecimalFormat("0.00");
static boolean finalizado;
	

	boolean sucesso;

	//static double preco, preçoTotal;
	//static int cod,pedido,numPrato,quantidade,mesa,numSeq,garçom,numSeq1,codItem;


	/*
	public void setPreçoTotal(double p){
		preçoTotal=p;
	}
	public double getPreçoTotal(){
		return preçoTotal;
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
	
	public static int getCodItem() {
		return codItem;
	}

	public static void setCodItem(int codIn) {
		codItem = codIn;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public String getPrecoString() {
		return df.format(preco);
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	

	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getCod() {
		return cod;
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
		return sql;
	}

	public void setSucesso(boolean s) {
		sucesso = s;
	}

	public boolean getSucesso() {
		return sucesso;
	}
	

	public static void setPedido(int pedid) {
		pedido = pedid;
	}
	public static int getNumPrato() {
		return numPrato;
	}

	public static void setNumPrato(int numP) {
		numPrato = numP;
	}
	public static int getQuantidade() {
		return quantidade;
	}

	public static void setQuantidade(int quant) {
		quantidade = quant;
	}
	

	public static int getMesa() {
		return mesa;
	}

	public static void setMesa(int mes) {
		mesa = mes;
	}

	public static int getNumSeq() {
		return numSeq;
	}

	public static void setNumSeq(int numS) {
		numSeq = numS;
	}

	public static int getGarçom() {
		return garçom;
	}

	public static void setGarçom(int gar) {
	garçom = gar;
	}

	public static int getPedido() {
		return pedido;
	}
	
	public void setFinalizado(boolean f){
		finalizado=f;
	}
	
	public boolean getFinalizado(){
		return finalizado;
	}
	
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntra) {
		horaEntrada = horaEntra;
	}
	public String getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(String horaSai) {
		horaSaida = horaSai;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		Dao_Extrato.dataEntrada = dataEntrada;
	}
	public String getPermanenciaCliente() {
		return permanenciaCliente;
	}
	public void setPermanenciaCliente(String permanenciaCliente) {
		Dao_Extrato.permanenciaCliente = permanenciaCliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		Dao_Extrato.cpf = cpf;
	}
	*/
	public Extrato  carregarExtrato(Object data[][]){
		Extrato extrato = new Extrato();
		double preçoTotal=0;
		double precoT=0;
		int i = 0;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(extrato.getSql());){
			stm.setInt(1, extrato.getMesa());
			try(ResultSet rs = stm.executeQuery();){
			while (rs.next()) {
				extrato.setDesc(rs.getString(2));
				extrato.setQuantidade(rs.getInt(1));
				extrato.setPreco(rs.getInt(3));
				
				data[i][0]=extrato.getDesc();
				data[i][1]=extrato.getPreco();
				data[i][2]=extrato.getQuantidade();
				precoT=extrato.getPreco()*extrato.getQuantidade();
				data[i][3]=precoT;
				preçoTotal+=precoT;
				
				//sucesso=true;
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e1) {
		System.out.print(e1.getStackTrace());
	}
	return extrato;
}


	public boolean horaSaidaExtrato(Extrato extrato){
		String sqlInto = "update pedido set horaSaida=? where mesa=? and  pago=0";
		
		ResultSet rs = null;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInto);){
										
			Calendar horaC = Calendar.getInstance();
			String hora = String.format("%tT\n",horaC);
			stm.setString(1,hora);
			extrato.setHoraSaida(hora);
			stm.setInt(2, extrato.getMesa());
			
			stm.execute();
			sucesso=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucesso;
	}
	
	public void  carregarHora(Extrato extrato){
		String sqlS= "select horaEntrada,dataEntrada from pedido where mesa=? and pago=0 limit 1 ";
		ResultSet rs = null;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlS);){
			stm.setInt(1, extrato.getMesa());
			rs = stm.executeQuery();
			while (rs.next()) {
				extrato.setHoraEntrada(rs.getString(1));
				extrato.setDataEntrada(rs.getString(2));
				
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		
	}
	
	public boolean pedidoPago(Extrato extrato){
		String sqlInto = "update pedido set pago=? where mesa=?";
		
		ResultSet rs = null;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInto);) {

										
			Calendar horaC = Calendar.getInstance();
			String hora = String.format("%tT\n",horaC);
			stm.setInt(1,1);
			stm.setInt(2, extrato.getMesa());
			
			stm.execute();
			sucesso=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucesso;
	}
	
	public boolean adicionarExtrato(Extrato extrato){
		String sqlInto = "Insert into extrato(precoTotal,permanenciaCliente,dataCliente,cpf) values (?,?,?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInto);) {
		boolean sucesso = false;
			stm.setDouble(1, extrato.getPreçoTotal());
			stm.setString(2, extrato.getPermanenciaCliente());
			stm.setString(3, extrato.getDataEntrada());
			stm.setString(4, extrato.getCpf());

			stm.execute();
			sucesso=true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sucesso;

	}
	
	public boolean  horarioDePico(Extrato extrato){
		String sqlS= "SELECT SUBSTRING( horaEntrada, 1, 2) as hora, count(*) as quant FROM pedido WHERE dataEntrada =? group By hora order by quant desc limit 1";
		boolean sucesso=false;
		ResultSet rs = null;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlS);){
			stm.setString(1, extrato.getDataEntrada());
			rs = stm.executeQuery();
			while (rs.next()) {
				extrato.setHoraEntrada(rs.getString(1));
				//setDataEntrada(rs.getString(2));
				sucesso=true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		
		}
		
	return sucesso;	
	}
	
	public void carregarCpf( ArrayList<String> entrada) {
		Extrato extrato = new Extrato();
		String sqlS= "SELECT * from extrato where cpf!='' and dataCliente=?";
		double preco=0;
		ResultSet rs = null;
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlS);){
			Calendar dataC = Calendar.getInstance();
			String data = String.format("%tF\n",dataC);
			int dataAno = Integer.parseInt(data.substring(0, 4));
			int dataMes = Integer.parseInt(data.substring(5, 7));
			int  dataDia = Integer.parseInt(data.substring(8, 10));
			String dataS=dataAno+"-"+dataMes+"-"+dataDia;
			stm.setString(1, dataS);
			rs = stm.executeQuery();
			while (rs.next()) {
				extrato.setCpf(rs.getString(5));
				extrato.setPreco(rs.getDouble(2));	
				
				entrada.add(extrato.getCpf());
				entrada.add(df.format(extrato.getPreco()));
				preco=preco+extrato.getPreco();
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
	}
		extrato.setPreçoTotal(preco);
	}
	
	
}
