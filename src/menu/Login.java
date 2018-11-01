package menu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controler.App;
import controler.Gestionnaire;
import models.Enseignant;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomUtilisateur, tfMotPasse;
	private JLabel lblErreur;
	private Gestionnaire gestionnaire;
	
	public static final String MESS_INVALID_USER = "Le nom d'utilisateur ou le mot de passe ne correspondent pas.";

	/**
	 * Create the frame.
	 */
	public Login(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
		
		
		setResizable(false);
		Font font = new Font("Arial", Font.PLAIN, 15);
		
		setTitle("Acc\u00E8s");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 220);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel sideImage = new JLabel("");
		Image image = new ImageIcon("resources/images/cle.jpg").getImage().getScaledInstance(156, 156, java.awt.Image.SCALE_SMOOTH);
		sideImage.setIcon(new ImageIcon(image));
		
		contentPane.add(sideImage, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 0, 20, 20));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{32, 32, 0, 32};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNomUtilisateur = new JLabel("Nom d'utilisateur :");
		lblNomUtilisateur.setFont(font);
		GridBagConstraints gbc_lblNomUtilisateur = new GridBagConstraints();
		gbc_lblNomUtilisateur.anchor = GridBagConstraints.EAST;
		gbc_lblNomUtilisateur.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomUtilisateur.gridx = 0;
		gbc_lblNomUtilisateur.gridy = 0;
		panel.add(lblNomUtilisateur, gbc_lblNomUtilisateur);
		
		tfNomUtilisateur = new JTextField();
		tfNomUtilisateur.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER)
					testConnection();}});
		tfNomUtilisateur.setFont(font);
		GridBagConstraints gbc_tfNomUtilisateur = new GridBagConstraints();
		gbc_tfNomUtilisateur.gridwidth = 2;
		gbc_tfNomUtilisateur.insets = new Insets(0, 0, 5, 0);
		gbc_tfNomUtilisateur.fill = GridBagConstraints.BOTH;
		gbc_tfNomUtilisateur.gridx = 1;
		gbc_tfNomUtilisateur.gridy = 0;
		panel.add(tfNomUtilisateur, gbc_tfNomUtilisateur);
		tfNomUtilisateur.setColumns(10);
		
		JLabel lblMotPasse = new JLabel("Mot de passe :");
		lblMotPasse.setFont(font);
		GridBagConstraints gbc_lblMotPasse = new GridBagConstraints();
		gbc_lblMotPasse.anchor = GridBagConstraints.EAST;
		gbc_lblMotPasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotPasse.gridx = 0;
		gbc_lblMotPasse.gridy = 1;
		panel.add(lblMotPasse, gbc_lblMotPasse);
		
		tfMotPasse = new JPasswordField();
		tfMotPasse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER)
					testConnection();}});
		tfMotPasse.setFont(font);
		GridBagConstraints gbc_tfMotPasse = new GridBagConstraints();
		gbc_tfMotPasse.gridwidth = 2;
		gbc_tfMotPasse.insets = new Insets(0, 0, 5, 0);
		gbc_tfMotPasse.fill = GridBagConstraints.BOTH;
		gbc_tfMotPasse.gridx = 1;
		gbc_tfMotPasse.gridy = 1;
		panel.add(tfMotPasse, gbc_tfMotPasse);
		tfMotPasse.setColumns(10);
		
		lblErreur = new JLabel("");
		lblErreur.setForeground(Color.RED);
		lblErreur.setFont(font);
		lblErreur.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblErreur = new GridBagConstraints();
		gbc_lblErreur.fill = GridBagConstraints.BOTH;
		gbc_lblErreur.gridwidth = 2;
		gbc_lblErreur.insets = new Insets(0, 0, 5, 0);
		gbc_lblErreur.gridx = 1;
		gbc_lblErreur.gridy = 2;
		panel.add(lblErreur, gbc_lblErreur);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testConnection();
			}
		});
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConfirmer.setFont(font);
		GridBagConstraints gbc_btnConfirmer = new GridBagConstraints();
		gbc_btnConfirmer.fill = GridBagConstraints.BOTH;
		gbc_btnConfirmer.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmer.gridx = 1;
		gbc_btnConfirmer.gridy = 3;
		panel.add(btnConfirmer, gbc_btnConfirmer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fermer();
			}
		});
		btnAnnuler.setFont(font);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.fill = GridBagConstraints.BOTH;
		gbc_btnAnnuler.gridx = 2;
		gbc_btnAnnuler.gridy = 3;
		panel.add(btnAnnuler, gbc_btnAnnuler);
		
		setVisible(true);
	}

	public void fermer() {
		dispose();
	}
	
	public void testConnection() {
		String nomUtilisateur = this.tfNomUtilisateur.getText();
		String motPasse = this.tfMotPasse.getText();
		
		Enseignant enseignant = gestionnaire.testConnection(nomUtilisateur, motPasse);
		
		if (enseignant != null) {
			App.ouvrireGestionnaire(enseignant);
			fermer();
		} else {
			lblErreur.setText(MESS_INVALID_USER);
			tfMotPasse.setText("");
			tfMotPasse.requestFocus();
		}
	}
}
