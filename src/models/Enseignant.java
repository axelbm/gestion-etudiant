package models;

public class Enseignant {
	private String id;
	private String prenom;
	private String nom;
	private String nomUtilisateur;
	private String motPasse;
	
	public Enseignant(String id, String prenom, String nom, String nomUtilisateur, String motPasse) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.nomUtilisateur = nomUtilisateur;
		this.motPasse = motPasse;
	}
	
	// Prenom
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	// Nom
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Nom d'utilisateur
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	
	// Mot de passe
	public boolean checkMotPasse(String modPasse) {
		return this.motPasse.equals(modPasse);
	}
	
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	
	// Id
	public String getId() {
		return id;
	}
	
	public String toString() {
		return String.format("%s: %s - %s %s", id, nomUtilisateur, prenom, nom);
	}
	
	public static Enseignant parse(String data) {
		String[] parts = data.split("/");
		
		try {
			return new Enseignant(parts[0], parts[1], parts[2], parts[3], parts[4]);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
}
