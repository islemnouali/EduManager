package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SingletonConnection;
import entities.etudiant;
import entities.filiere;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CrudEtudiant {
	public static ObservableList<etudiant> getAll() {
	    ObservableList<etudiant> etud = FXCollections.observableArrayList();
	    String req = "SELECT num, nom, prenom, email, nomFiliere FROM etudiant;";
	    PreparedStatement ps;
	    ResultSet rs;
	    etudiant e;

	    try {
	        ps = SingletonConnection.getCon().prepareStatement(req);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            int num = rs.getInt("num");
	            String nom = rs.getString("nom");
	            String prenom = rs.getString("prenom");
	            String email = rs.getString("email");
	            int filiereId = rs.getInt("nomFiliere");

	            filiere f = CrudFiliere.findById(filiereId); // get full filiere object
	            
	            if (f == null) {
	                f = new filiere(filiereId, "Inconnue");
	            }
	            
	            
	            e = new etudiant(num, nom, prenom, email, f);
	            etud.add(e);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        System.out.println("Error fetching students.");
	    }
	    return etud;
	}

	public static int create(etudiant e) {
	    String req = "INSERT INTO etudiant (nom, prenom, email, nomFiliere) VALUES (?, ?, ?, ?);";
	    try {
	        PreparedStatement ps = SingletonConnection.getCon().prepareStatement(req);
	        ps.setString(1, e.getNom());
	        ps.setString(2, e.getPrenom());
	        ps.setString(3, e.getEmail());
	        ps.setInt(4, e.getF().getId()); // ✅ this is correct now
	        return ps.executeUpdate();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return 0;
	    }
	}

	
	public static int delete(etudiant e) {
		String req = "delete from etudiant where num = ?;";
		PreparedStatement ps;
		try {
			ps=SingletonConnection.getCon().prepareStatement(req);
			ps.setInt(1, e.getNum());
			return ps.executeUpdate();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return 0;
		}
	}
}
