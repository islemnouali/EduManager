package entities;

public class etudiant {
	private int num;
	private String nom,prenom,email;
	private filiere f;
	public etudiant(int num, String nom, String prenom, String email, filiere f) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.f = f;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public filiere getF() {
		return f;
	}
	public void setF(filiere f) {
		this.f = f;
	}
	public int getNum() {
		return num;
	}
	@Override
	public String toString() {
		return "etudiant [num=" + num + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", f=" + f + "]";
	}		
	
	
}
