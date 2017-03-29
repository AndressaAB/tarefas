package interfaces;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;

import model.Extrato;

public class Interface_ExtratoDeConsumo extends JDialog {
	private JLabel lNumeroMesa, lPrecoTotal, lTaxaServico, lTempoCliente, lPrecoTaxa;
	private JLabel bNumeroMesa, vazio, vazio1, bPrecoTotal, bTaxaServico, bTempoCliente, bPrecoTaxa;
	private JTextField fNumeroMesa;
	private JButton bDinheiro, bCartao, bNotaFiscal, bCancelar;
	private JPanel painel, painel2, painelTable, painelMesa;
	private Container container;
	private static ResourceBundle bn;
	String cpfContribuente;
	private JTable table;
	private JScrollPane bar;
	JComboBox boxMesa;
	Extrato negocio = new Extrato();
	DecimalFormat df = new DecimalFormat("0.00");

	public Interface_ExtratoDeConsumo(JFrame fr) {

		super(fr, true);

		setTitle(bn.getString("extrato"));

		lNumeroMesa = new JLabel(bn.getString("lNumeroMesa"));
		lPrecoTotal = new JLabel(bn.getString("lPrecoTotal"));
		lTaxaServico = new JLabel(bn.getString("lTaxaServico"));
		lTempoCliente = new JLabel(bn.getString("lTempoCliente"));
		fNumeroMesa = new JTextField(3);
		lPrecoTaxa = new JLabel(bn.getString("PrecoTaxa"));

		bNumeroMesa = new JLabel("");
		vazio = new JLabel("");
		vazio1 = new JLabel("");
		bPrecoTotal = new JLabel();
		bTaxaServico = new JLabel();
		bTempoCliente = new JLabel();
		bPrecoTaxa = new JLabel();

		painel = new JPanel();
		painel.setLayout(new GridLayout(4, 2, 10, 15));
		painel.setPreferredSize(new Dimension(400, 100));

		painel2 = new JPanel();
		painel2.setLayout(new GridLayout(2, 2, 10, 10));
		 negocio.setCpf(null);
		
		String mesav[] = new String[51];
		mesav[0] = bn.getString("selecione");

		for (int i = 1; i < 51; i++) {
			mesav[i] = "" + (i);
		}
		boxMesa = new JComboBox(mesav);

		painelMesa = new JPanel();
		painelMesa.setLayout(new GridLayout(1, 4, 5, 0));

		painel.add(lPrecoTotal);
		painel.add(bPrecoTotal);
		painel.add(lTaxaServico);
		painel.add(bTaxaServico);
		painel.add(lPrecoTaxa);
		painel.add(bPrecoTaxa);
		painel.add(lTempoCliente);
		painel.add(bTempoCliente);

		painelMesa.add(vazio);
		painelMesa.add(vazio1);
		painelMesa.add(lNumeroMesa);
		painelMesa.add(boxMesa);

		bDinheiro = new JButton(bn.getString("bDinheiro"));
		bCartao = new JButton(bn.getString("bCartao"));
		bNotaFiscal = new JButton(bn.getString("bNotaFiscal"));
		bCancelar = new JButton(bn.getString("bCancelar"));

		Acao a = new Acao();
		bDinheiro.addActionListener(a);
		bCartao.addActionListener(a);
		bNotaFiscal.addActionListener(a);
		bCancelar.addActionListener(a);

		painelTable = new JPanel();
		painelTable.setLayout(new GridLayout(1, 1));
		painelTable.setPreferredSize(new Dimension(550, 250));
		Object[][] entra = new Object[30][4];
		String[] column = { bn.getString("descricao"), bn.getString("preco"), bn.getString("quantidade"),
				bn.getString("PrecoTotal") };
		boxMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				negocio.setMesa(boxMesa.getSelectedIndex());
				negocio.horaSaidaExtrato();
				//negocio.carregarHoraEntra();

				for (int i = 0; i < entra.length; i++) {
					for (int j = 0; j < 4; j++) {
						entra[i][j] = null;
					}
				}

				negocio.setSql(bn.getString("sqlExtrato"));
				negocio.setCarregarExtrato(entra);
				repaint();// coisa mais lindja
				bPrecoTotal.setText(bn.getString("r") + " " + df.format(negocio.getPreçoTotal()));
				bTaxaServico.setText(bn.getString("r") + " " + df.format(negocio.getPreçoTotal() * 0.10));
				if(negocio.getPreçoTotal()==0)
					bTempoCliente.setText("");
				else
					bTempoCliente.setText(negocio.getTempoPermanencia());

					
				bPrecoTaxa.setText(
						bn.getString("r") + " " + df.format(negocio.getPreçoTotal() + negocio.getPreçoTotal() * 0.10));
				negocio.setPreçoTotal(negocio.getPreçoTotal() + negocio.getPreçoTotal() * 0.10);
			}
		});

		table = new JTable(entra, column);
		table.setEnabled(false);
		bar = new JScrollPane(table);
		painelTable.add(bar);

		painel2.add(bDinheiro);
		painel2.add(bCartao);
		painel2.add(bNotaFiscal);
		painel2.add(bCancelar);

		container = getContentPane();
		container.setLayout(new FlowLayout());

		add(painelMesa);
		add(painelTable);
		add(painel);
		add(painel2);

		setSize(650, 550); // configura o tamanho do frame
		setLocationRelativeTo(null);

		setVisible(true);

	}

	private class Acao implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (boxMesa.getSelectedIndex() == 0) {
				UIManager.put("JOptionPane.okButtonText", bn.getString("confirmar"));
				JOptionPane.showMessageDialog(null, bn.getString("erroNumMesa"), "", 0);
			} else {
				if (bDinheiro == e.getSource()) {
					//Interface_Dinheiro.modificarBundle(bn);
					//Interface_Dinheiro d = new Interface_Dinheiro(null);
					dispose();
				}

				if (bCartao == e.getSource()) {
					//Interface_Cartoes.modificarBundle(bn);
					//Interface_Cartoes c = new Interface_Cartoes(null);
					dispose();

				}

				if (bNotaFiscal == e.getSource()) {
					//Interface_InputCpf.modificarBundle(bn);
					//Interface_InputCpf cod = new Interface_InputCpf(null);
					

				}
				if (bCancelar == e.getSource()) {
					dispose();
				}

			}
		}

	}

	public static void modificarBundle(ResourceBundle a) {
		bn = a;
	}
}