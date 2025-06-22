package application;
	
import dao.SingletonConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			SingletonConnection.getCon();
			Parent p = FXMLLoader.load(getClass().getResource("/views/acceuil.fxml"));
			Scene scene = new Scene(p,700,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.initStyle(StageStyle.UNDECORATED);
	        
			p.requestFocus();
			primaryStage.centerOnScreen();

			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
