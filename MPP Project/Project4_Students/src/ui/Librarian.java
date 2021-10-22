package ui;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import business.Address;
import business.Author;
import business.Book;
import business.CheckOutEntry;
import business.CheckOutRecord;
import business.ControllerInterface;
import business.LibraryMember;
import business.SaveException;
import business.SystemController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Librarian extends Stage {

	public static final Librarian INSTANCE = new Librarian();

	Book book;
	LibraryMember member;
	GridPane gridCheckout = new GridPane();
	GridPane gridBookDetail = new GridPane();
	GridPane gridPrintCheckout = new GridPane();
	HBox hbbtnprintcheckout = new HBox(10);
	final VBox vbox = new VBox();
	Label label;
	private Text isbnTextFielddetail = new Text();
	private Text titleTextFielddetail = new Text();
	private Text authorsTextFielddetail = new Text();
	private Text maxLengthTextFielddetail = new Text();
	private Text availableCopiesTextFielddetail = new Text();
	private Text firstName = new Text();
	private Text lastName = new Text();
	private Text memberId = new Text();
	private TableView table = new TableView();
	private TableView tablebook = new TableView();
	HBox bookdetail = new HBox(10);
	GridPane gridprintcheckoutrecord = new GridPane();

	private Text messageBar = new Text();

	private Text messageBarmember = new Text();

	public void clear() {
		messageBar.setText("");
		messageBarmember.setText("");
	}

	/* This class is a singleton */
	private Librarian() {
	}

	public void init() {
		checkOut();

		gridCheckout.setId("gridCheckout");
		gridPrintCheckout.setId("gridPrintCheckout");
		
		// Instantiating the BorderPane class
		BorderPane bPane = new BorderPane();
		bPane.setId("bPane");

		// Setting the top, bottom, center, right and left nodes to the pane
		VBox topContainer = new VBox();
		
		MenuBar mainMenu = new MenuBar();
		topContainer.getChildren().add(mainMenu);
		topContainer.setId("top-container");
		Menu addOptionsMenu = new Menu("Tasks");
		MenuItem Checkout = new MenuItem("Check Out");
		MenuItem printcheckoutrecord = new MenuItem("Print Checkout Record");
		MenuItem logout = new MenuItem("Log Out");
		addOptionsMenu.getItems().addAll(Checkout, printcheckoutrecord, logout);
		mainMenu.getMenus().addAll(addOptionsMenu);

		Checkout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				bPane.setCenter(gridCheckout);

			}
		});

		printcheckoutrecord.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				printCheckOutDetail();
				bPane.setCenter(vbox);

			}
		});

		logout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Librarian.INSTANCE.hide();
				LoginWindow.INSTANCE.show();
			}
		});

		bPane.setTop(topContainer);
		bPane.setCenter(new Label());

		// Creating a scene object
		Scene scene = new Scene(bPane, 600, 400, Color.rgb(204, 210, 217));
		scene.getStylesheets().add(getClass().getResource("library.css").toExternalForm());

		// Setting title to the Stage
		setTitle("Librarian");

		// Adding scene to the stage
		setScene(scene);

		// Displaying the contents of the stage
		show();
	}

	public void checkOut() {

		// Instantiating the BorderPane class

		gridCheckout.setAlignment(Pos.CENTER);
		gridCheckout.setHgap(10);
		gridCheckout.setVgap(10);
		gridCheckout.setPadding(new Insets(25, 25, 25, 25));

		Label isbn = new Label("ISBN:");
		gridCheckout.add(isbn, 0, 0);

		TextField isbnTextField = new TextField();
		gridCheckout.add(isbnTextField, 1, 0);


		HBox bookDetailHbox = new HBox(10);
		bookDetailHbox.getChildren().add(gridBookDetail);

		// Creating a scene object
		Scene scene = new Scene(gridCheckout, 600, 400, Color.rgb(204, 210, 217));
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
				int check = bookDetail(isbnTextField.getText().trim(), memberIdTextField.getText().trim());
				if (check == 1) {
					Text ceheckoutStatus = new Text("Checkout Successful");
					gridCheckout.add(ceheckoutStatus, 1, 10);
				}

			}
		});
	}

	public void searchbook(String isbn) {

	}

	public int bookDetail(String searchedIsbn, String searchMemberId) {
		clear();
		int check = 0;

		ControllerInterface ci = new SystemController();
		HashMap<String, Book> hash_map = ci.allBooksHashmap();

		if (hash_map.containsKey(searchedIsbn)) {
			book = hash_map.get(searchedIsbn);

			if (book.isAvailable() == true) {			
				check = memberDetail(searchMemberId);

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, there is no data for specified Book id is not available! ");
				alert.showAndWait();
			}

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Ooops, there is no data for specified Book id is not exist or empty! ");
			alert.showAndWait();
		}

		return check;
	}

	public int memberDetail(String searchMemberId) {
		clear();
		int check = 0;
		ControllerInterface ci = new SystemController();
		HashMap<String, LibraryMember> hash_map = ci.allLibraryMembersHashmap();

		if (hash_map.containsKey(searchMemberId)) {
			member = hash_map.get(searchMemberId);
			System.out.println("Member is found");
			check = 1;
			saveCheckOutRecord(member, book);

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Ooops, there is no data for specified member id! ");
			alert.showAndWait();

		}
		return check;
	}

	public void saveCheckOutRecord(LibraryMember member, Book book) {
		ControllerInterface ci = new SystemController();
		LocalDate checkoutDate = LocalDate.now();
		LocalDate dueDate = LocalDate.now().plus(book.getMaxCheckoutLength(), ChronoUnit.DAYS);

		CheckOutRecord checkoutrecord = new CheckOutRecord(member, book, checkoutDate, dueDate);
		ci.updateBookcontroller(book);
		ci.saveNewCheckOutRecordcontroller(checkoutrecord);
		

	}

	public void printCheckOutDetail() {
		clear();
		ControllerInterface ci = new SystemController();
		HashMap<String, CheckOutRecord> hash_map = ci.allCheckOutRecordsHashmap();

		gridPrintCheckout.setAlignment(Pos.CENTER);
		gridPrintCheckout.setHgap(10);
		gridPrintCheckout.setVgap(10);
		gridPrintCheckout.setPadding(new Insets(25, 25, 25, 25));

		Label isbn = new Label("Member ID:");
		gridPrintCheckout.add(isbn, 0, 0);

		TextField isbnTextField = new TextField();
		gridPrintCheckout.add(isbnTextField, 1, 0);

		Label firstNameLabel = new Label("First Name");
		gridPrintCheckout.add(firstNameLabel, 1, 1);
		firstName = new Text();
		gridPrintCheckout.add(firstName, 1, 2);
		firstNameLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));

		Label lastNameLabel = new Label("Last Name");
		gridPrintCheckout.add(lastNameLabel, 2, 1);
		lastName = new Text();
		gridPrintCheckout.add(lastName, 2, 2);
		lastNameLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));

		Button printbtncheckout = new Button("Search");
		HBox printhbbtncheckout = new HBox(10);
		printhbbtncheckout.setAlignment(Pos.BOTTOM_CENTER);
		printhbbtncheckout.getChildren().add(printbtncheckout);

		TableColumn<String, Book> column1 = new TableColumn<>("ISBN");
		column1.setMinWidth(100);

		TableColumn<String, Book> column2 = new TableColumn<>("title");
		column2.setMinWidth(100);

		TableColumn<String, Book> column3 = new TableColumn<>("maxCheckoutLength");
		column3.setMinWidth(100);
		TableColumn<String, Book> column4 = new TableColumn<>("");
		column4.setMinWidth(100);

		table.getColumns().add(column1);
		table.getColumns().add(column2);
		table.getColumns().add(column3);
		table.getColumns().add(column4);
		column1.setCellValueFactory(new PropertyValueFactory<>("isbn"));
		column2.setCellValueFactory(new PropertyValueFactory<>("title"));
		column3.setCellValueFactory(new PropertyValueFactory<>("maxCheckoutLength"));

		printbtncheckout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					table.refresh();
					table.getItems().clear();
					LibraryMember members = hash_map.get(isbnTextField.getText()).getMember();

					List<CheckOutEntry> checkoutentry = hash_map.get(isbnTextField.getText()).getCheckOutEntryList();
					memberId.setText(members.getMemberId());
					firstName.setText(members.getFirstName());
					lastName.setText(members.getLastName());

					for (CheckOutEntry s : checkoutentry) {
						table.getItems().add(s.getBook());

					}

					vbox.setSpacing(5);
					vbox.setPadding(new Insets(10, 0, 0, 10));
				}

				catch (NullPointerException e1) {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Dialog");
					alert.setHeaderText("Look, an Error Dialog");
					alert.setContentText("Ooops, there is no data for specified member id! " + e1.getMessage());

					alert.showAndWait();
				}
			}

		});

		gridPrintCheckout.add(printhbbtncheckout, 2, 0);

		vbox.getChildren().addAll(gridPrintCheckout, table);

	}

}