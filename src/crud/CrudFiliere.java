package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SingletonConnection;
import entities.filiere;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CrudFiliere {
	public static ObservableList<filiere>getAll() {
		ObservableList<filiere> fils =FXCollections.observableArrayList();
		String req="select id,nom from filiere;";
		PreparedStatement ps;
		ResultSet rs;
		filiere f;
		try {
			ps=SingletonConnection.getCon().prepareStatement(req);
			rs = ps.executeQuery();
			while ( rs.next()) {
				f = new filiere(rs.getInt(1),rs.getString(2));
				fils.add(f);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return fils;
	}
	public static int create(filiere f) {
		String req = "insert into filiere (nom) values(?);";
		PreparedStatement ps;
		try {
			ps=SingletonConnection.getCon().prepareStatement(req);
			ps.setString(1, f.getNom());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public static int delete(filiere f) {
		String req = "delete from filiere where id = ?;";
		PreparedStatement ps;
		try {
			ps=SingletonConnection.getCon().prepareStatement(req);
			ps.setInt(1, f.getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public static filiere findById(int id) {
	    String req = "SELECT * FROM filiere WHERE id = ?";
	    PreparedStatement ps;
	    try {    
	    	ps=SingletonConnection.getCon().prepareStatement(req);
	    	ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return new filiere(rs.getInt(1), rs.getString(2));
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
}