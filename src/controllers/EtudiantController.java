package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import crud.CrudEtudiant;
import entities.etudiant;
import entities.filiere;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EtudiantController implements Initializable {

    @FXML
    private Button btnajout;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnquitter;

    @FXML
    private TableColumn<etudiant, String> colEmail;

    @FXML
    private TableColumn<etudiant, String> colFiliere;

    @FXML
    private TableColumn<etudiant, String> colNom;

    @FXML
    private TableColumn<etudiant, String> colNum;

    @FXML
    private TableColumn<etudiant, String> colPrenom;

    @FXML
    private AnchorPane pane;
    
    @FXML
    private Button btnreturn;

    @FXML
    private TableView<etudiant> tableEtudiant;

    @FXML
    void Quitter(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void Return(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Choice.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void Ajouter(ActionEvent event) {
    	try {
            // Load the new FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/AjoutEtud.fxml"));
            Parent root = fxmlLoader.load();

            // Get the current stage (window)
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            
			root.requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void Supprimer(ActionEvent event) {
    	try {
            // Load the new FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/DeleteEtud.fxml"));
            Parent root = fxmlLoader.load();

            // Get the current stage (window)
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            
			root.requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNum.setCellValueFactory(new PropertyValueFactory<>("num"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // This one needs to access filiere name from the etudiant object
        colFiliere.setCellValueFactory(cellData -> {
            filiere f = cellData.getValue().getF();
            String nomFiliere = (f != null) ? f.getNom() : "Inconnue";
            return new SimpleStringProperty(nomFiliere);
        });


        ObservableList<etudiant> data = CrudEtudiant.getAll();
        tableEtudiant.setItems(data);

        for (TableColumn<?, ?> column : tableEtudiant.getColumns()) {
            column.setReorderable(false);
        }
    }

}
