package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisa;
	private JTextField txtIdCli;
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtCpf;
	private JTextField txtFone1;
	private JTextField txtFone2;
	private JTextField txtEmail;
	private JTextField txtEnd;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JComboBox cboUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cliente() {
		setTitle("Game Boy -  Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cliente.class.getResource("/img/gameboy.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtPesquisa = new JTextField();
		txtPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarCliente();
			}
		});
		txtPesquisa.setBounds(104, 38, 298, 20);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Cliente.class.getResource("/img/pesq.png")));
		lblNewLabel.setBounds(423, 27, 48, 48);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 198, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(10, 236, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtIdCli = new JTextField();
		txtIdCli.setBounds(51, 195, 86, 20);
		contentPane.add(txtIdCli);
		txtIdCli.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(51, 233, 195, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("CEP");
		lblNewLabel_3.setBounds(182, 198, 46, 14);
		contentPane.add(lblNewLabel_3);

		txtCep = new JTextField();
		txtCep.setBounds(222, 195, 115, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setBounds(291, 236, 46, 14);
		contentPane.add(lblNewLabel_4);

		txtCpf = new JTextField();
		txtCpf.setBounds(329, 233, 131, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Telefone 1");
		lblNewLabel_5.setBounds(480, 236, 59, 14);
		contentPane.add(lblNewLabel_5);

		txtFone1 = new JTextField();
		txtFone1.setBounds(560, 233, 130, 20);
		contentPane.add(txtFone1);
		txtFone1.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Telefone 2");
		lblNewLabel_6.setBounds(480, 277, 59, 17);
		contentPane.add(lblNewLabel_6);

		txtFone2 = new JTextField();
		txtFone2.setBounds(560, 275, 130, 20);
		contentPane.add(txtFone2);
		txtFone2.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("E-Mail");
		lblNewLabel_7.setBounds(10, 278, 46, 14);
		contentPane.add(lblNewLabel_7);

		txtEmail = new JTextField();
		txtEmail.setBounds(63, 275, 274, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Endere\u00E7o");
		lblNewLabel_8.setBounds(10, 319, 65, 14);
		contentPane.add(lblNewLabel_8);

		txtEnd = new JTextField();
		txtEnd.setBounds(73, 316, 218, 20);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("N\u00FAmero");
		lblNewLabel_9.setBounds(335, 319, 46, 14);
		contentPane.add(lblNewLabel_9);

		txtNumero = new JTextField();
		txtNumero.setBounds(421, 316, 86, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Bairro");
		lblNewLabel_10.setBounds(10, 357, 46, 14);
		contentPane.add(lblNewLabel_10);

		txtBairro = new JTextField();
		txtBairro.setText("");
		txtBairro.setBounds(51, 354, 218, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Cidade");
		lblNewLabel_11.setBounds(291, 357, 46, 14);
		contentPane.add(lblNewLabel_11);

		txtCidade = new JTextField();
		txtCidade.setText("");
		txtCidade.setBounds(335, 354, 172, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("UF");
		lblNewLabel_12.setBounds(519, 357, 30, 14);
		contentPane.add(lblNewLabel_12);

		cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF" }));
		cboUf.setBounds(545, 353, 48, 22);
		contentPane.add(cboUf);

		JLabel lblNewLabel_13 = new JLabel("Complemento");
		lblNewLabel_13.setBounds(517, 319, 86, 14);
		contentPane.add(lblNewLabel_13);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(618, 316, 72, 20);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					txtCep.requestFocus();
				} else {
					// Busca do CEP
					buscarCep();
				}
			}
		});
		btnBuscar.setBounds(371, 194, 89, 23);
		contentPane.add(btnBuscar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(480, 194, 89, 23);
		contentPane.add(btnLimpar);

		btnAdicionar = new JButton("");
		btnAdicionar.setToolTipText("Adicionar Cliente");
		btnAdicionar.setIcon(new ImageIcon(Cliente.class.getResource("/img/add.png")));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarCliente();
			}
		});
		btnAdicionar.setBounds(148, 392, 70, 72);
		contentPane.add(btnAdicionar);

		btnEditar = new JButton("");
		btnEditar.setToolTipText("Editar Cliente");
		btnEditar.setIcon(new ImageIcon(Cliente.class.getResource("/img/alterar.png")));
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCliente();
			}
		});
		btnEditar.setBounds(251, 392, 70, 72);
		contentPane.add(btnEditar);

		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Cliente.class.getResource("/img/apagar.png")));
		btnExcluir.setToolTipText("Excluir Cliente");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirCliente();
			}
		});
		btnExcluir.setBounds(356, 392, 70, 72);
		contentPane.add(btnExcluir);

		// uso da biblioteca atxy2k para validacao do campo txtCep
		RestrictedTextField validar = new RestrictedTextField(txtCep);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 74, 680, 98);
		contentPane.add(desktopPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 680, 98);
		desktopPane.add(scrollPane);
		
		tableCliente = new JTable();
		tableCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			}
		});
		scrollPane.setViewportView(tableCliente);
		validar.setOnlyNums(true);
		validar.setLimit(8);
	}// fim do construtor
	DAO dao = new DAO();
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnAdicionar;
	private JTable tableCliente;

	private void buscarCep() {
		String Logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader reader = new SAXReader();
			Document documento = reader.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				// Se ele encontrar o nome da variavel farar o preenchimento de busca dos campos
				if (element.getQualifiedName().equals("cidade")) {
					// identificando e extraindo um documento do xml
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					// identificando e extraindo um documento do xml
					txtBairro.setText(element.getText());
				}
				// Identificando Uf
				if (element.getQualifiedName().equals("uf")) {
					// identificando e extraindo um documento do xml
					cboUf.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					// identificando e extraindo um documento do xml
					tipoLogradouro = element.getText();

				}
				if (element.getQualifiedName().equals("logradouro")) {
					// identificando e extraindo um documento do xml
					Logradouro = element.getText();

				}
				// setar o campo endereco
				txtEnd.setText(tipoLogradouro + " " + Logradouro);
				// Alertando se o cep não existir
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						// Colocando icone de ok de cep encontado
						/*
						 * lblStatus.setIcon(new
						 * javax.swing.ImageIcon(getClass().getResource("/img/okcep.png")));
						 */
					} else
						JOptionPane.showMessageDialog(null, "CEP não encontrado");

				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//metodo para inserir um novo cliente
			private void adicionarCliente() {
				//validacao dos campos obrigatorios
				if (txtNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o nome do cliente ");
					txtNome.requestFocus();
					} 
				else if (txtCep.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Cep do cliente ");
					txtCep.requestFocus();
					}
						
						else if (txtFone1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o telefone do cliente ");
						txtFone1.requestFocus();
						}
						else if (txtFone2.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha o telefone do cliente ");
							txtFone2.requestFocus();
							}
					 else if (txtEmail.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha o Email do cliente ");
							txtEmail.requestFocus();
							}
					 else if (txtCpf.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha o CPF do cliente ");
							txtCpf.requestFocus();
							}
					 else if (txtEnd.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha o Endereço do cliente ");
							txtEnd.requestFocus();
							}
					 else if (txtBairro.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha o Bairro do cliente ");
							txtBairro.requestFocus();
							}
					 else if (txtCidade.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha a Cidade do cliente ");
							txtCidade.requestFocus();
							}
					
				
			//////////////// Lógica Principal ////////////////////////////////////////////////////////	
					 else {
							// logica principal
							// String (query) SQL
							String create = "insert into clientes (nome,cpf,email,fone1,fone2,cep,endereco,numero,complemento,bairro,cidade) values(?,?,?,?,?,?,?,?,?,?,?)";
							try {
								//abrir a conexao com o banco
								Connection con = dao.conectar();
								//preparar a conexao com a instrucao sql(query)
								PreparedStatement pst = con.prepareStatement(create);
								
								//substituir os parametros(?,?) pelo conteudo das caixas texto
								pst.setString(1, txtNome.getText());
								pst.setString(2, txtCpf.getText());
								pst.setString(3, txtEmail.getText());
								pst.setString(4, txtFone1.getText());
								pst.setString(5, txtFone2.getText());
								pst.setString(6, txtCep.getText());
								pst.setString(7, txtEnd.getText());
								pst.setString(8, txtNumero.getText());
								pst.setString(9, txtComplemento.getText());
								pst.setString(10, txtBairro.getText());
								pst.setString(11, txtCidade.getText());
							
								//executar a query confirmando a inclusao do cliente
								int confirma = pst.executeUpdate();
								if (confirma == 1) {
								JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso.");
								}
								
								//encerrar a conexao
								con.close();
								
								//limpar os campos
								limpar();
								// a linha abaixo trata o problema do campo unique no login, devolvendo uma mensagem amigavel ao usuario se o login ja existir
							} catch (java.sql.SQLIntegrityConstraintViolationException ex) {
								JOptionPane.showMessageDialog(null, "CPF ou Email Já Registrado\nCadastre novamente ");
								txtCpf.setText(null);
								txtCpf.requestFocus();
								txtEmail.setText(null);
								txtEmail.requestFocus();
								}
								
								
						
								
								
								
								 catch (Exception e) {
								System.out.println(e);
								}
								}
			}
			// Pesquisa avançada de clientes usando abiblioteca rs2xml
			
			private void pesquisarCliente() {

				String read = "select * from clientes where nome like ? order by nome";
				try {
				//abrir a conexao com o banco
				Connection con = dao.conectar();
				//preparar a query(instrucao sql) para pesquisar no banco
				PreparedStatement pst = con.prepareStatement(read);
				//substituir o parametro(?) Atencao ao % para completar a query
				pst.setString(1, txtPesquisa.getText() + "%");
				//obter os dados do banco (resultado)
				ResultSet rs = pst.executeQuery();
				//popular(preencher) a tabela com os dados do banco
				tableCliente.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (Exception e) {
				System.out.println(e);
				
			}
			}
			///////////////////////////////////// EDITAR CLIENTE //////////////////////////////////////////////
			// EDITAR CLIENTE (CRUD Update) EDITAR CLIENTE CADASTRADO
				private void editarCliente() {
					//confirmar a exclusao do usuario
					int editar = JOptionPane.showConfirmDialog(null, "Deseja realmente Editar o usuário?", "Atenção!", JOptionPane.YES_NO_OPTION);
					if(editar ==JOptionPane.YES_OPTION)
					// validacao dos campos obrigatorios
					if (txtNome.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o nome do Cliente");
						txtNome.requestFocus();
					} else if (txtCpf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o CPF");
						txtCpf.requestFocus();
					}else if (txtEmail.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha o Email");
							txtEmail.requestFocus();
							
					}else if (txtFone1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Telefone");
						txtFone1.requestFocus();
					}else if (txtFone2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Telefone");
						txtFone2.requestFocus();
						
					}else if (txtCep.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o CEP");
						txtCep.requestFocus();
					}else if (txtEnd.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Endereço");
						txtEnd.requestFocus();
					}else if (txtCidade.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha a Cidade");
						txtCidade.requestFocus();
					}else if (txtBairro.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Bairro");
						txtBairro.requestFocus();
					
							
							
						
					
							
						} else {
						// instrucao sql para Editar usuario o mesmo comando que damos no sql para
						// Editar um usuário
						String update = "update clientes set nome=?,cpf=?,email=?,fone1=?,fone2=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=? where idCli=?";
						try {
							// estabelecer uma conexao atraves da classe DAO que é responsável pela ligação
							// do sql abrindo a conexão
							Connection con = dao.conectar();
							// preparar a instrução sql PreparedStatement vai substituir (?) pelo conteúdo
							// cadastrado no sql cada
							PreparedStatement pst = con.prepareStatement(update);
							// substituir parametros setamos o 2 de acordo com a posição de cadastro de
							// usuário no sql (?)
							
							pst.setString(1, txtNome.getText());
							pst.setString(2, txtCpf.getText());
							pst.setString(3, txtEmail.getText());
							pst.setString(4, txtFone1.getText());
							pst.setString(5, txtFone2.getText());
							pst.setString(6, txtCep.getText());
							pst.setString(7, txtEnd.getText());
							pst.setString(8, txtNumero.getText());
							pst.setString(9, txtComplemento.getText());
							pst.setString(10, txtBairro.getText());
							pst.setString(1, txtCidade.getText());
							pst.setString(12, txtIdCli.getText());
							
							// exibir uma caixa de mensagem mostrando que o usuário foi editado com sucesso.
							int confirma = pst.executeUpdate();
							if (confirma == 1) {
								JOptionPane.showMessageDialog(null, "Dados de Cliente alterado com Sucesso");
							}
							// criando acao limpar caixa de texto quando os dados forem cadastrado
							limpar();
							
							con.close();
							// a linha abaixo trata o problema do campo unique no cadastro de cliente , devolvendo uma mensagem amigavel ao usuario se o Cliente ja existir
						} catch (java.sql.SQLIntegrityConstraintViolationException ex) {
							JOptionPane.showMessageDialog(null, "CPF ou Email Já Registrado\nCadastre novamente ");
							txtCpf.setText(null);
							txtCpf.requestFocus();
							txtEmail.setText(null);
							txtEmail.requestFocus();
							}
						
							
							
						 catch (Exception e) {
							System.out.println(e);
						}
					}

				}
				
				
				/////////////////////// DELETE (CRUD) ///////////////////////////////////////////////
				// Exluir usuario (CRUD Delete) excluir um usuário pela janela interativa Java
				private void excluirCliente() {
					// validacao dos campos obrigatorios
					//confirmar a exclusao do usuario
					int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir o usuário?", "Atenção!", JOptionPane.YES_NO_OPTION);
					if(confirma ==JOptionPane.YES_OPTION) {
						// instrucao sql para deletar usuario o mesmo comando que damos no sql para
						// Editar um usuário
						String delete = "delete from clientes where idCli=?";
						try {
							// estabelecer uma conexao atraves da classe DAO que é responsável pela ligação
							// do sql abrindo a conexão
							Connection con = dao.conectar();
							// preparar a instrução sql PreparedStatement vai substituir (?) pelo conteúdo
							// cadastrado no sql cada
							PreparedStatement pst = con.prepareStatement(delete);
							// substituir parametros setamos o 2 de acordo com a posição de cadastro de
							// usuário no sql (?)
							pst.setString(1, txtIdCli.getText());
							// exibir uma caixa de mensagem mostrando que o usuário foi excluido  com sucesso.
							int verifica = pst.executeUpdate();
							if (verifica == 1) {
								JOptionPane.showMessageDialog(null, "Dados do Usuário Deletado com Sucesso");
							}
							// criando acao limpar caixa de texto quando os dados forem cadastrado
							limpar();
							con.close();
							
							
						} catch (Exception e) {
							System.out.println(e);
						}
					}

				}
			
				
				
			
			
			
			
			
			
			// setar os campos do formulario com o conteudo da tabela assim que colocar o cursor do mouse sobre o id ele vai preencher os campos
			private void setarCampos() {
			int setar = tableCliente.getSelectedRow();
			//(setar, 0) 0 -> 1º campo da tabela | 1 -> 2º campo da tabela ...
			txtIdCli.setText(tableCliente.getModel().getValueAt(setar, 0).toString());
			txtNome.setText(tableCliente.getModel().getValueAt(setar, 1).toString());
			txtCpf.setText(tableCliente.getModel().getValueAt(setar, 2).toString());
			txtEmail.setText(tableCliente.getModel().getValueAt(setar, 3).toString());
			txtFone1.setText(tableCliente.getModel().getValueAt(setar, 4).toString());
			txtFone2.setText(tableCliente.getModel().getValueAt(setar, 5).toString());
			txtCep.setText(tableCliente.getModel().getValueAt(setar, 6).toString());
			txtEnd.setText(tableCliente.getModel().getValueAt(setar, 7).toString());
			txtNumero.setText(tableCliente.getModel().getValueAt(setar, 8).toString());
			txtComplemento.setText(tableCliente.getModel().getValueAt(setar, 9).toString());
			txtBairro.setText(tableCliente.getModel().getValueAt(setar, 10).toString());	
			txtCidade.setText(tableCliente.getModel().getValueAt(setar, 11).toString());
			btnEditar.setEnabled(true);
			btnExcluir.setEnabled(true);
			btnAdicionar.setEnabled(false);
			
			
		
			
			}
			
			
			
			
			
			//limpar os campos e gerenciar os botoes
			private void limpar() {
			txtNome.setText(null);
			txtCpf.setText(null);
			txtEmail.setText(null);
			txtFone1.setText(null);
			txtFone2.setText(null);
			txtCep.setText(null);
			txtEnd.setText(null);
			txtCidade.setText(null);
			txtBairro.setText(null);
			txtComplemento.setText(null);
			cboUf.setSelectedItem(null);
			btnEditar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnAdicionar.setEnabled(true);
			
			
		
	}
}
