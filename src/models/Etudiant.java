package models;

public class Etudiant {
	private String id;
	private String prenom;
	private String nom;
	private String adresse;
	private String ville;
	private String province;
	private String codePostal;
	private String idInstructeur;
	
	public Etudiant(String id, String prenom, String nom, String adresse, String ville, String province,
			String codePostal, String idInstructeur) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.province = province;
		this.codePostal = codePostal;
		this.idInstructeur = idInstructeur;
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

	// Adresse
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	// Ville
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	// Province
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	// Code Postal
	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	// Id de l'instructeur
	public String getIdInstructeur() {
		return idInstructeur;
	}

	public void setIdInstructeur(String idInstructeur) {
		this.idInstructeur = idInstructeur;
	}

	// Id
	public String getId() {
		return id;
	}
	
	public String toString() {
		return String.format("%s %s", prenom, nom);
	}
	
	public String toData() {
		return String.format("%s/%s/%s/%s/%s/%s/%s/%s", id, prenom, nom, adresse, ville, province, codePostal, idInstructeur);
	}
	
	public static Etudiant parse(String data) {
		String[] parts = data.split("/");
		
		try {
			return new Etudiant(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
}
