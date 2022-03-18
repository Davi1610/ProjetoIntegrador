package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtUsuario;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario dialog = new Usuario();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Usuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuario.class.getResource("/img/gameboy.png")));
		setTitle("Game Boy - Usu\u00E1rios");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(49, 53, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(105, 50, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("* Usu\u00E1rio");
		lblNewLabel_1.setBounds(49, 94, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(105, 88, 235, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("* Login");
		lblNewLabel_2.setBounds(49, 132, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(105, 129, 235, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setBounds(49, 178, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(105, 175, 235, 20);
		contentPane.add(txtSenha);
		
		JLabel lblNewLabel_4 = new JLabel("* CAMPOS OBRIGAT\u00D3RIOS");
		lblNewLabel_4.setBounds(435, 53, 184, 14);
		contentPane.add(lblNewLabel_4);
		
		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnAdicionar.setEnabled(false);
		btnAdicionar.setToolTipText("Adicionar Usu\u00E1rio");
		btnAdicionar.setIcon(new ImageIcon(Usuario.class.getResource("/img/add.png")));
		btnAdicionar.setBounds(61, 270, 78, 80);
		contentPane.add(btnAdicionar);
		
		btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarUsuario();
			}
		});
		btnPesquisar.setIcon(new ImageIcon(Usuario.class.getResource("/img/search.png")));
		btnPesquisar.setToolTipText("Pesquisar Usu\u00E1rio");
		btnPesquisar.setBounds(180, 270, 78, 80);
		contentPane.add(btnPesquisar);
		
		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarUsuario();
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setIcon(new ImageIcon(Usuario.class.getResource("/img/alterar.png")));
		btnAlterar.setToolTipText("Alterar Usu\u00E1rio");
		btnAlterar.setBounds(296, 270, 78, 80);
		contentPane.add(btnAlterar);
		
		btnDeletar = new JButton("");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnDeletar.setEnabled(false);
		btnDeletar.setIcon(new ImageIcon(Usuario.class.getResource("/img/apagar.png")));
		btnDeletar.setToolTipText("Deletar Usu\u00E1rio");
		btnDeletar.setBounds(414, 270, 78, 80);
		contentPane.add(btnDeletar);
	} // fim do construtor
	
	//Criando objeto para reutilizar a classe DAO (conexao com o banco de dados)
	DAO dao = new DAO();
	private JButton btnAdicionar;
	private JButton btnDeletar;
	private JButton btnAlterar;
	private JButton btnPesquisar;
	
	
	// pesquisar usuario (CRUD Read)
		private void pesquisarUsuario() {
			// validacao
			// se o campo txtId estiver vazio
			if (txtID.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o ID");
				txtID.requestFocus();
			} else {
				// instrucao sql para pesquisar um usuario
				String read = "select * from usuarios where idUsu=?";
				// tratamento de excecoes(ex: servidor indisponivel)
				try {
					// estabelecer uma conexao atraves da classe DAO
					Connection con = dao.conectar();
					// preparar a instrução sql
					PreparedStatement pst = con.prepareStatement(read);
					// substituir parametros (?)
					pst.setString(1, txtID.getText());
					// resultado (executar a query e obter os dados)
					ResultSet rs = pst.executeQuery();
					// se existir este usuario no banco
					if (rs.next()) {
						// setar campos
						txtUsuario.setText(rs.getString(2));
						txtLogin.setText(rs.getString(3));
						txtSenha.setText(rs.getString(4));
						// gerenciar botoes (UX)
						btnPesquisar.setEnabled(false);
						btnAlterar.setEnabled(true);
						btnDeletar.setEnabled(true);
						// desativar o txtId
						txtID.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(null, "Usuário inexistente");
						// limpar o campo ID
						txtID.setText(null);
						// gerenciar os botoes
						btnAdicionar.setEnabled(true);
						btnPesquisar.setEnabled(false);
						btnAlterar.setEnabled(false);
						btnDeletar.setEnabled(false);
						// desabilitar o txtId e posicionar o cursor no usuario
						txtID.setEnabled(false);
						txtUsuario.requestFocus();
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		// adicionar usuario (CRUD Create)
		private void adicionarUsuario() {
			// validacao dos campos obrigatorios
			if (txtUsuario.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Usuário");
				txtUsuario.requestFocus();
			} else if (txtLogin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Login");
				txtLogin.requestFocus();
			} else {
				// instrucao sql para inserir um usuario
				String create = "insert into usuarios(usuario,login,senha) values (?,?,md5(?))";
				try {
					// estabelecer uma conexao atraves da classe DAO
					Connection con = dao.conectar();
					// preparar a instrução sql
					PreparedStatement pst = con.prepareStatement(create);
					// substituir parametros (?)
					pst.setString(1, txtUsuario.getText());
					pst.setString(2, txtLogin.getText());
					pst.setString(3, txtSenha.getText());
					// exibir um caixa de mensagem caso o usuario seja inserido
					int confirma = pst.executeUpdate();
					if (confirma == 1) {
						JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
					}
					limpar();
					con.close();
					// a linha abaixo trata o problema do campo unique no login, devolvendo uma mensagem amigavel ao usuario se o login ja existir
				} catch (java.sql.SQLIntegrityConstraintViolationException ex) {
					JOptionPane.showMessageDialog(null, "Login já existente\nCadastre outro login");
					txtLogin.setText(null);
					txtLogin.requestFocus();
					
				}

				catch (Exception e) {
					System.out.println(e);
				}
			}
		}

		// editar usuario (CRUD Update)
		private void editarUsuario() {
			// validacao
			if (txtUsuario.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Usuário");
				txtUsuario.requestFocus();
			} else if (txtLogin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Login");
				txtLogin.requestFocus();
			} else {
				// instrucao sql para editar um usuario
				String update = "update usuarios set usuario=?,login=?,senha=md5(?) where idUsu=?";
				try {
					// estabelecer uma conexao atraves da classe DAO
					Connection con = dao.conectar();
					// preparar a instrução sql
					PreparedStatement pst = con.prepareStatement(update);
					// substituir parametros (?)
					pst.setString(1, txtUsuario.getText());
					pst.setString(2, txtLogin.getText());
					pst.setString(3, txtSenha.getText());
					pst.setString(4, txtID.getText());
					// exibir um caixa de mensagem caso o usuario seja editado
					int confirma = pst.executeUpdate();
					if (confirma == 1) {
						JOptionPane.showMessageDialog(null, "Dados do usuário alterados com sucesso");
					}
					limpar();
					con.close();
				} catch (java.sql.SQLIntegrityConstraintViolationException ex) {
					JOptionPane.showMessageDialog(null, "Usuário já existe");
					txtLogin.setText(null);
					txtLogin.requestFocus();
				}
				catch (Exception e) {
					System.out.println(e);
				}
			}
		}

		// excluir usuario (CRUD Delete)
		private void excluirUsuario() {
			// confirmar a exclusao do usuario
			int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?", "Atenção!",
					JOptionPane.YES_NO_OPTION);

			if (confirma == JOptionPane.YES_OPTION) {
				// instrucao sql para excluir um usuario
				String delete = "delete from usuarios where idUsu=?";
				try {
					// estabelecer uma conexao atraves da classe DAO
					Connection con = dao.conectar();
					// preparar a instrução sql
					PreparedStatement pst = con.prepareStatement(delete);
					// substituir parametros (?)
					pst.setString(1, txtID.getText());
					// exibir um caixa de mensagem caso o usuario seja excluido
					int verifica = pst.executeUpdate();
					if (verifica == 1) {
						JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso");
					}
					limpar();
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		}

		// limpar campos e gerenciar os botoes
		private void limpar() {
			// habilitar a pesquisa por ID
			txtID.setEnabled(true);
			// posicionar o cursor na caixa ID
			txtID.requestFocus();
			// limpar as caixas de texto
			txtID.setText(null);
			txtUsuario.setText(null);
			txtLogin.setText(null);
			txtSenha.setText(null);
			// ativar o botao de pesquisa
			btnPesquisar.setEnabled(true);
			// desativar os demais botoes
			btnAdicionar.setEnabled(false);
			btnAlterar.setEnabled(false);
			btnDeletar.setEnabled(false);
		}

}
