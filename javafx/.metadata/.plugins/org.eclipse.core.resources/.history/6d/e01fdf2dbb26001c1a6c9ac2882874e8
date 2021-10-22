package application;

import java.util.HashMap;
import java.util.List;

import business.Book;
import business.ControllerInterface;
import business.SystemController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckoutWindow extends Application {
	Book book;
	GridPane gridCheckout = new GridPane();
	GridPane gridBookDetail = new GridPane();

	HBox bookdetail = new HBox(10);
	GridPane gridprintcheckoutrecord = new GridPane();

	private Text messageBar = new Text();

	// private Text messageBarmember = new Text();
	public void clear() {
		messageBar.setText("");
		// messageBarmember.setText("");
	}

	public static void main(String[] argv) {
		launch(argv);
	}

	public void start(Stage primaryStage) {

		// Instantiating the BorderPane class

		gridCheckout.setAlignment(Pos.CENTER);
		gridCheckout.setHgap(10);
		gridCheckout.setVgap(10);
		gridCheckout.setPadding(new Insets(25, 25, 25, 25));

		Label isbn = new Label("ISBN:");
		gridCheckout.add(isbn, 0, 0);

		TextField isbnTextField = new TextField();
		gridCheckout.add(isbnTextField, 1, 0);

		Button btnbook = new Button("Search");
		HBox hbbtnbook = new HBox(10);
		hbbtnbook.setAlignment(Pos.BOTTOM_CENTER);
		hbbtnbook.getChildren().add(btnbook);
		gridCheckout.add(hbbtnbook, 2, 0);

		HBox bookDetailHbox = new HBox(10);
		bookDetailHbox.getChildren().add(gridBookDetail);

		btnbook.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// hideAllWindows();

				bookDetail(isbnTextField.getText().trim());

				if (!gridCheckout.getChildren().contains(bookDetailHbox))
					gridCheckout.add(bookDetailHbox, 0, 1, 5, 1);

			}
		});
		// Creating a scene object
		Scene scene = new Scene(gridCheckout, 600, 400);

		// Setting title to the Stage
		primaryStage.setTitle("Librarian");

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();

		Label memberId = new Label("Member ID");
		gridCheckout.add(memberId, 0, 4);

		TextField memberIdTextField = new TextField();
		gridCheckout.add(memberIdTextField, 1, 4);

		Button btnCheckout = new Button("Checkout a book");
		HBox hbBtnCheckout = new HBox(10);
		hbBtnCheckout.setAlignment(Pos.BOTTOM_CENTER);
		hbBtnCheckout.getChildren().add(btnCheckout);
		gridCheckout.add(hbBtnCheckout, 1, 9);

		btnCheckout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// hideAllWindows();

				Text ceheckoutStatus = new Text("Checkout Successful");
				gridCheckout.add(ceheckoutStatus, 1, 10);

			}
		});
		primaryStage.show();
	}

	public void searchbook(String isbn) {
	}

	public void bookDetail(String searchedIsbn) {
		clear();
		ControllerInterface ci = new SystemController();
		HashMap<String, Book> hash_map = ci.allBooksHashmap();

		if (hash_map.containsKey(searchedIsbn)) {
			book = hash_map.get(searchedIsbn);
			Label isbn = new Label("ISBN:");
			gridBookDetail.add(isbn, 0, 0);

			Text isbnTextFielddetail = new Text(book.getIsbn());
			bookdetail.getChildren().add(isbnTextFielddetail);
			gridBookDetail.add(isbnTextFielddetail, 0, 1);

			Label title = new Label("Title:");
			gridBookDetail.add(title, 3, 0);

			Text titleTextFielddetail = new Text(book.getTitle());
			bookdetail.getChildren().add(titleTextFielddetail);
			gridBookDetail.add(titleTextFielddetail, 3, 1);

			Label authors = new Label("Authors:");
			gridBookDetail.add(authors, 6, 0);
			Text authorsTextFielddetail = new Text("John Doe");
			bookdetail.getChildren().add(authorsTextFielddetail);
			gridBookDetail.add(authorsTextFielddetail, 6, 1);

			Label maxLength = new Label("Max Length:");
			gridBookDetail.add(maxLength, 9, 0);
			Text maxLengthTextFielddetail = new Text(book.getMaxCheckoutLength() + "");
			bookdetail.getChildren().add(maxLengthTextFielddetail);
			gridBookDetail.add(maxLengthTextFielddetail, 9, 1);

			Label availableCopies = new Label("Available copies:");
			gridBookDetail.add(availableCopies, 12, 0);
			Text availableCopiesTextFielddetail = new Text(book.getCopyNums().size() + "");
			bookdetail.getChildren().add(availableCopiesTextFielddetail);
			gridBookDetail.add(availableCopiesTextFielddetail, 12, 1);
		} else {
			HBox messageBox = new HBox(10);
			messageBox.setAlignment(Pos.BOTTOM_RIGHT);
			messageBox.getChildren().add(messageBar);
			;
			gridBookDetail.add(messageBox, 3, 0);
			messageBar.setFill(Start.Colors.red);
			messageBar.setText("Error! The specified Book does not EXIST ");

		}

		gridBookDetail.setAlignment(Pos.CENTER);
		gridBookDetail.setHgap(10);
		gridBookDetail.setVgap(10);
		gridBookDetail.setPadding(new Insets(25, 25, 25, 25));

	}

}
