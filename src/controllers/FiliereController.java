package controllers;

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
import entities.filiere;
import crud.CrudFiliere;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FiliereController implements Initializable {

    @FXML
    private Button btnajout;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnquitter;

    @FXML
    private TableColumn<filiere, Integer> colId;

    @FXML
    private TableColumn<filiere, String> colNom;

    @FXML
    private Button btnreturn;
    
    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<filiere> tableFiliere;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Link table columns to filiere class properties
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));


        // Load data using the CrudFiliere class
        ObservableList<filiere> data = CrudFiliere.getAll();
        tableFiliere.setItems(data);
        
        for (TableColumn<?, ?> column : tableFiliere.getColumns()) {
            column.setReorderable(false);
            column.setReorderable(false);
        }
    }

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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/Ajout.fxml"));
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/Delete.fxml"));
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
}
