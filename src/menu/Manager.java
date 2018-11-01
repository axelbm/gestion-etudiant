package menu;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.Gestionnaire;
import models.Enseignant;
import models.Etudiant;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Manager extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Gestionnaire gestionnaire;
	private Enseignant enseignant;

	private JPanel contentPane;
	private JComboBox<Etudiant> comboBox;
	
	private JTextField tfId;
	private JTextField tfPrenom;
	private JTextField tfNom;
	private JTextField tfAdresse;
	private JTextField tfVile;
	private JTextField tfProvince;
	private JTextField tfCodePostal;
	private JTextField tfEnseignant;
	private Etudiant etudiant;

	/**
	 * Create the frame.
	 */
	public Manager(Gestionnaire gestionnaire, Enseignant ensaignant) {
		this.gestionnaire = gestionnaire;
		this.enseignant = ensaignant;

		Font font = new Font("Arial", Font.PLAIN, 16);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("List des \u00E9tudiants");
		lblNewLabel.setFont(font);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBox = new JComboBox<Etudiant>();
		comboBox.setFont(font);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualiserEtudiant((Etudiant)comboBox.getSelectedItem());
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		contentPane.add(comboBox, gbc_comboBox);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(font);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 2;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Informations", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Observations", null, panel_1, null);
		tabbedPane.setEnabledAt(1, false);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{96, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(font);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel.add(lblId, gbc_lblId);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setFont(font);
		GridBagConstraints gbc_tfId = new GridBagConstraints();
		gbc_tfId.insets = new Insets(0, 0, 5, 0);
		gbc_tfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfId.gridx = 1;
		gbc_tfId.gridy = 0;
		panel.add(tfId, gbc_tfId);
		tfId.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setFont(font);
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.anchor = GridBagConstraints.WEST;
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 0;
		gbc_lblPrenom.gridy = 1;
		panel.add(lblPrenom, gbc_lblPrenom);
		
		tfPrenom = new JTextField();
		tfPrenom.setFont(font);
		GridBagConstraints gbc_tfPrenom = new GridBagConstraints();
		gbc_tfPrenom.insets = new Insets(0, 0, 5, 0);
		gbc_tfPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrenom.gridx = 1;
		gbc_tfPrenom.gridy = 1;
		panel.add(tfPrenom, gbc_tfPrenom);
		tfPrenom.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(font);
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 2;
		panel.add(lblNom, gbc_lblNom);
		
		tfNom = new JTextField();
		tfNom.setFont(font);
		GridBagConstraints gbc_tfNom = new GridBagConstraints();
		gbc_tfNom.insets = new Insets(0, 0, 5, 0);
		gbc_tfNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNom.gridx = 1;
		gbc_tfNom.gridy = 2;
		panel.add(tfNom, gbc_tfNom);
		tfNom.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setFont(font);
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.WEST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 0;
		gbc_lblAdresse.gridy = 3;
		panel.add(lblAdresse, gbc_lblAdresse);
		
		tfAdresse = new JTextField();
		tfAdresse.setFont(font);
		GridBagConstraints gbc_tfAdresse = new GridBagConstraints();
		gbc_tfAdresse.insets = new Insets(0, 0, 5, 0);
		gbc_tfAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAdresse.gridx = 1;
		gbc_tfAdresse.gridy = 3;
		panel.add(tfAdresse, gbc_tfAdresse);
		tfAdresse.setColumns(10);
		
		JLabel lblVile = new JLabel("Vile :");
		lblVile.setFont(font);
		GridBagConstraints gbc_lblVile = new GridBagConstraints();
		gbc_lblVile.anchor = GridBagConstraints.WEST;
		gbc_lblVile.insets = new Insets(0, 0, 5, 5);
		gbc_lblVile.gridx = 0;
		gbc_lblVile.gridy = 4;
		panel.add(lblVile, gbc_lblVile);
		
		tfVile = new JTextField();
		tfVile.setFont(font);
		GridBagConstraints gbc_tfVile = new GridBagConstraints();
		gbc_tfVile.insets = new Insets(0, 0, 5, 0);
		gbc_tfVile.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfVile.gridx = 1;
		gbc_tfVile.gridy = 4;
		panel.add(tfVile, gbc_tfVile);
		tfVile.setColumns(10);
		
		JLabel lblProvince = new JLabel("Province :");
		lblProvince.setFont(font);
		GridBagConstraints gbc_lblProvince = new GridBagConstraints();
		gbc_lblProvince.anchor = GridBagConstraints.WEST;
		gbc_lblProvince.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvince.gridx = 0;
		gbc_lblProvince.gridy = 5;
		panel.add(lblProvince, gbc_lblProvince);
		
		tfProvince = new JTextField();
		tfProvince.setFont(font);
		GridBagConstraints gbc_tfProvince = new GridBagConstraints();
		gbc_tfProvince.insets = new Insets(0, 0, 5, 0);
		gbc_tfProvince.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfProvince.gridx = 1;
		gbc_tfProvince.gridy = 5;
		panel.add(tfProvince, gbc_tfProvince);
		tfProvince.setColumns(10);
		
		JLabel lblCodePostal = new JLabel("Code postal :");
		lblCodePostal.setFont(font);
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.anchor = GridBagConstraints.WEST;
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 0;
		gbc_lblCodePostal.gridy = 6;
		panel.add(lblCodePostal, gbc_lblCodePostal);
		
		tfCodePostal = new JTextField();
		tfCodePostal.setFont(font);
		GridBagConstraints gbc_tfCodePostal = new GridBagConstraints();
		gbc_tfCodePostal.insets = new Insets(0, 0, 5, 0);
		gbc_tfCodePostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCodePostal.gridx = 1;
		gbc_tfCodePostal.gridy = 6;
		panel.add(tfCodePostal, gbc_tfCodePostal);
		tfProvince.setColumns(10);
		
		JLabel lblEnseignant = new JLabel("Enseignant :");
		lblEnseignant.setFont(font);
		GridBagConstraints gbc_lblEnseignant = new GridBagConstraints();
		gbc_lblEnseignant.anchor = GridBagConstraints.WEST;
		gbc_lblEnseignant.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnseignant.gridx = 0;
		gbc_lblEnseignant.gridy = 7;
		panel.add(lblEnseignant, gbc_lblEnseignant);
		
		tfEnseignant = new JTextField();
		tfEnseignant.setFont(font);
		GridBagConstraints gbc_tfEnseignant = new GridBagConstraints();
		gbc_tfEnseignant.insets = new Insets(0, 0, 5, 0);
		gbc_tfEnseignant.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEnseignant.gridx = 1;
		gbc_tfEnseignant.gridy = 7;
		panel.add(tfEnseignant, gbc_tfEnseignant);
		tfProvince.setColumns(10);
		
		JButton btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sauvegarder();
			}
		});
		btnSauvegarder.setFont(font);
		GridBagConstraints gbc_btnSauvegarder = new GridBagConstraints();
		gbc_btnSauvegarder.anchor = GridBagConstraints.EAST;
		gbc_btnSauvegarder.gridx = 1;
		gbc_btnSauvegarder.gridy = 8;
		panel.add(btnSauvegarder, gbc_btnSauvegarder);
		
		populerEtudiants();

		setVisible(true);
	}
	
	private void populerEtudiants() {
		ArrayList<Etudiant> etudiants = gestionnaire.getEtudiantsParInstructeur(enseignant);
		
		comboBox.removeAllItems();
		
		for (Etudiant etudiant : etudiants)
			comboBox.addItem(etudiant);
	}
	
	private void actualiserEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
		
		tfId.setText(etudiant.getId());
		tfPrenom.setText(etudiant.getPrenom());
		tfNom.setText(etudiant.getNom());
		tfAdresse.setText(etudiant.getAdresse());
		tfVile.setText(etudiant.getVille());
		tfProvince.setText(etudiant.getProvince());
		tfCodePostal.setText(etudiant.getCodePostal());
		tfEnseignant.setText(etudiant.getIdInstructeur());
	}
	
	private void sauvegarder() {
		etudiant.setPrenom(tfPrenom.getText());
		etudiant.setNom(tfNom.getText());
		etudiant.setAdresse(tfAdresse.getText());
		etudiant.setVille(tfVile.getText());
		etudiant.setProvince(tfProvince.getText());
		etudiant.setCodePostal(tfCodePostal.getText());
		etudiant.setIdInstructeur(tfEnseignant.getText());
		
		gestionnaire.sauvegarderEtudiants();
		comboBox.updateUI();
	}

}
