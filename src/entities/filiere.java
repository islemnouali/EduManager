package entities;

public class filiere {
	private int id;
	private String nom;
	public filiere(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public filiere(String nom) {
		super();
		this.nom = nom;
	}
	public filiere(int id) {
	    this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {	
		return "filiere [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
