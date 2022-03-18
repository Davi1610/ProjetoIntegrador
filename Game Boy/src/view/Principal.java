package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Game Boy - Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/gameboy.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 510);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUsuarios = new JButton("");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				usuario.setVisible(true);
			}
		});
		btnUsuarios.setToolTipText("Usuarios");
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/usuario.png")));
		btnUsuarios.setBounds(34, 35, 128, 128);
		contentPane.add(btnUsuarios);
		
		JButton btnClientes = new JButton("");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setVisible(true);
			}
		});
		btnClientes.setToolTipText("Clientes");
		btnClientes.setIcon(new ImageIcon(Principal.class.getResource("/img/cliente.png")));
		btnClientes.setBounds(198, 35, 128, 128);
		contentPane.add(btnClientes);
		
		JLabel lblGame = new JLabel("");
		lblGame.setIcon(new ImageIcon(Principal.class.getResource("/img/gameboy.png")));
		lblGame.setBounds(410, 215, 256, 256);
		contentPane.add(lblGame);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abrir a janela Sobre
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/sobre.png")));
		btnSobre.setBounds(585, 44, 64, 64);
		contentPane.add(btnSobre);
	}
}
