package application;

import java.util.List;

import business.Book;
import business.ControllerInterface;
import business.LibraryMember;
import business.SystemController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewMember extends Application {
	 @Override
	 public void start(Stage primaryStage) {
		 TableView tableViewmembers = new TableView();
		 
		 ControllerInterface ci = new SystemController();
			List<LibraryMember> Members = ci.allLibraryMembers();
			 
		 
				TableColumn<String, LibraryMember> column1 = new TableColumn<>("Member ID");
		        TableColumn<String, LibraryMember> column2 = new TableColumn<>("First Name");
		        
		        
		        tableViewmembers.getColumns().add(column1);
		        tableViewmembers.getColumns().add(column2);

		        
		        column1.setCellValueFactory(new PropertyValueFactory<>("memberId"));
		   	 	column2.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		   	 for(LibraryMember s: Members) {
		        	
		   		tableViewmembers.getItems().add(s);
		   		
		   	 }
		   	 
		   		VBox vbox = new VBox(tableViewmembers);

		        Scene scene = new Scene(vbox,600,400);

		        primaryStage.setScene(scene);
		        
		      
				
		 primaryStage.show();
	 }
	 public static void main(String[] args) {
	        launch(args);
	    }


}
