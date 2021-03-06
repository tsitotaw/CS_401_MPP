package application;

import java.util.Collections;
import java.util.List;

import business.ControllerInterface;
import business.SystemController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Start extends Application {

//	@Override
//	public void start(Stage primaryStage) {
//		
//	}

	public static void main(String[] args) {
		new Thread() {
			public void run() {
	            while(true) {
					launch(args);
				}
			}
		}.start();
	}
	
	private static Stage primStage = null;

	public static Stage primStage() {
		return primStage;
	}

	public static class Colors {
		static Color green = Color.web("#034220");
		static Color red = Color.FIREBRICK;
	}

	private static Stage[] allWindows = { LoginWindow.INSTANCE, AllMembersWindow.INSTANCE, AllBooksWindow.INSTANCE };

	public static void hideAllWindows() {
		primStage.hide();
		for (Stage st : allWindows) {
			st.hide();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		primStage = primaryStage;
		primaryStage.setTitle("Main Page");

		VBox topContainer = new VBox();
		topContainer.setId("top-container");
		MenuBar mainMenu = new MenuBar();
		VBox imageHolder = new VBox();
		VBox imageHolder1 = new VBox();
		Image image = new Image("ui/gettyimage.jpg", 400, 300, false, false);

		// simply displays in ImageView the image as is
		ImageView iv = new ImageView();
		iv.setImage(image);
		imageHolder.getChildren().add(iv);
		imageHolder.setAlignment(Pos.CENTER);
		HBox splashBox = new HBox();
		Label splashLabel = new Label("The Library System");
		splashLabel.setFont(Font.font("Trajan Pro", FontWeight.BOLD, 30));
		splashBox.getChildren().add(splashLabel);
		splashBox.setAlignment(Pos.CENTER);

		topContainer.getChildren().add(mainMenu);
		topContainer.getChildren().add(splashBox);

		Menu optionsMenu = new Menu("Login");

		MenuItem login = new MenuItem("Login");

		login.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				hideAllWindows();
				if (!LoginWindow.INSTANCE.isInitialized()) {
					LoginWindow.INSTANCE.init();
				}
				LoginWindow.INSTANCE.clear();
				LoginWindow.INSTANCE.show();
			}
		});
		
		Menu optionshelp = new Menu("Help");
		MenuItem welcome = new MenuItem("Welcome");
		MenuItem siteContent = new MenuItem("Site Content");
		MenuItem aboutTheSite = new MenuItem("About The Site");
		optionshelp.getItems().addAll(welcome,siteContent,aboutTheSite);
		welcome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(!topContainer.getChildren().contains(imageHolder1)) {
				Image image = new Image("ui/help.jpeg", 600, 500, false, false);
				ImageView iv1 = new ImageView();
				iv1.setImage(image);
				imageHolder1.getChildren().add(iv1);
				imageHolder1.setAlignment(Pos.CENTER);
				topContainer.getChildren().add(imageHolder1);
				}
			}
		});

		MenuItem bookIds = new MenuItem("All Book Ids");
		bookIds.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				hideAllWindows();
				if (!AllBooksWindow.INSTANCE.isInitialized()) {
					AllBooksWindow.INSTANCE.init();
				}

				ControllerInterface ci = new SystemController();
				List<String> ids = ci.allBookIds();
				Collections.sort(ids);
				StringBuilder sb = new StringBuilder();
				for (String s : ids) {
					sb.append(s + "\n");
				}
				AllBooksWindow.INSTANCE.setData(sb.toString());
				AllBooksWindow.INSTANCE.show();
			}
		});

		MenuItem memberIds = new MenuItem("All Member Ids");
		memberIds.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				hideAllWindows();
				if (!AllMembersWindow.INSTANCE.isInitialized()) {
					AllMembersWindow.INSTANCE.init();
				}
				ControllerInterface ci = new SystemController();
				List<String> ids = ci.allMemberIds();
				Collections.sort(ids);
				StringBuilder sb = new StringBuilder();
				for (String s : ids) {
					sb.append(s + "\n");
				}
				AllMembersWindow.INSTANCE.setData(sb.toString());
				AllMembersWindow.INSTANCE.show();
			}
		});


		optionsMenu.getItems().addAll(login);

		mainMenu.getMenus().addAll(optionsMenu, optionshelp);

		Scene scene = new Scene(topContainer, 420, 375);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("library.css").toExternalForm());
		primaryStage.show();
	}
}
