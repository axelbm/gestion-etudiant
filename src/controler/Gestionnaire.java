package controler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import models.*;

public class Gestionnaire {
	private ArrayList<Enseignant> enseignants;
	private ArrayList<Etudiant> etudiants;

	private String pathEtudiants;

	public Gestionnaire() {
		enseignants = new ArrayList<Enseignant>();
		etudiants = new ArrayList<Etudiant>();
	}

	public Enseignant testConnection(String nomUtilisateur, String motPasse) {
		for (Enseignant enseignant : enseignants) {
			if (enseignant.getNomUtilisateur().equals(nomUtilisateur)) {
				if (enseignant.checkMotPasse(motPasse)) {
					return enseignant;
				}

				break;
			}
		}

		return null;
	}
	
	public void ajoutEnseignant(Enseignant enseigant) {
		enseignants.add(enseigant);
	}
	
	public ArrayList<Enseignant> getEnseignaits() {
		return enseignants;
	}
	
	public Enseignant getEnseignait(String id) {
		for (Enseignant enseignant : enseignants)
			if (enseignant.getId().equals(id))
				return enseignant;
		
		throw new ArrayIndexOutOfBoundsException();
	}

	public void chargerEnseignants(String path) {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = reader.readLine()) != null) {
				ajoutEnseignant(Enseignant.parse(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void ajoutEtudiant(Etudiant etudiant) {
		etudiants.add(etudiant);
	}
	
	public ArrayList<Etudiant> getEtudiants() {
		return etudiants;
	}
	
	public ArrayList<Etudiant> getEtudiantsParInstructeur(Enseignant enseignant) {
		ArrayList<Etudiant> nEtudiants = new ArrayList<Etudiant>();
		
		for (Etudiant etudiant : etudiants)
			if (etudiant.getIdInstructeur().equals(enseignant.getId()))
				nEtudiants.add(etudiant);
		
		return nEtudiants;
	}
	
	public Etudiant getEtudiant(String id) {
		for (Etudiant etudiant : etudiants)
			if (etudiant.getId().equals(id))
				return etudiant;
		
		throw new ArrayIndexOutOfBoundsException();
	}

	public void chargerEtudiants(String path) {
		pathEtudiants = path;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = reader.readLine()) != null) {
				ajoutEtudiant(Etudiant.parse(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sauvegarderEtudiants() {
		try (FileWriter file = new FileWriter(pathEtudiants)) {
			String data = "";
			
			for (Etudiant etudiant : etudiants)
				data += etudiant.toData() + "\n";
			
			file.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
