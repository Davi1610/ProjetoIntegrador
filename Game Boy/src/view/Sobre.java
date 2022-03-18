package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Sobre extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sobre dialog = new Sobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		setResizable(false);
		setTitle("Game Boy - Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/Game Boy Logotipo.png")));
		setBounds(100, 100, 495, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Game Boy - Hospital dos Consoles");
			lblNewLabel.setBounds(10, 60, 201, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Autor - Davi Galindo Fonseca");
			lblNewLabel_1.setBounds(10, 85, 169, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblGPL = new JLabel("");
			lblGPL.setIcon(new ImageIcon(Sobre.class.getResource("/img/gpl.png")));
			lblGPL.setBounds(257, 48, 64, 64);
			contentPanel.add(lblGPL);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Sob a licen\u00E7a GPL");
			lblNewLabel_2.setBounds(10, 189, 124, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Vers\u00E3o 1.0");
			lblNewLabel_3.setBounds(10, 214, 75, 14);
			contentPanel.add(lblNewLabel_3);
		}
	}

}
