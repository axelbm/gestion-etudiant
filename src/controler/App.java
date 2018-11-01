package controler;

import javax.swing.UIManager;

import menu.Login;
import menu.Manager;
import models.Enseignant;

public class App {
	private static final String PATH_ENGEIGNANT = "resources/data/enseignants.txt";
	private static final String PATH_ETUDIANT = "resources/data/etudiants.txt";
	
	private static Gestionnaire gestionnaire;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
		
		gestionnaire = new Gestionnaire();

		gestionnaire.chargerEnseignants(PATH_ENGEIGNANT);
		gestionnaire.chargerEtudiants(PATH_ETUDIANT);
		
		new Login(gestionnaire);
	}
	
	public static void ouvrireGestionnaire(Enseignant enseignant) {
		System.out.println(enseignant);
		new Manager(gestionnaire, enseignant);
	}
}
