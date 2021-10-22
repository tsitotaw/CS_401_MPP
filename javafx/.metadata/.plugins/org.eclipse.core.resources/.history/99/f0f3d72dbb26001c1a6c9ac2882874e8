package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import business.Address;
import business.Author;
import business.Book;
import business.ControllerInterface;
import business.LibraryMember;
import business.LoginException;
import business.SaveException;
import business.SystemController;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Administrator extends Stage {
	public static final Administrator INSTANCE = new Administrator();
	Book book;
	GridPane gridmember = new GridPane();
	GridPane gridbook = new GridPane();
	GridPane gridBookAllinfo = new GridPane();
	GridPane gridMembersinfo = new GridPane();

	GridPane gridAddBookCopy = new GridPane();

	private Text addCopyMessageBar = new Text();

	private Text messageBar = new Text();
	private Text messageBarmember = new Text();
	private ComboBox comboBox = new ComboBox();

	ObservableList<String> maxLimit = FXCollections.observableArrayList("7", "21");

	public void clear() {
		messageBar.setText("");
		messageBarmember.setText("");
		addCopyMessageBar.setText("");
	}

	/* This class is a singleton */
	private Administrator() {
	}

	public void init() {
		addMember();
		addBook();
		viewBook();
		viewMembers();
		addCopies();

		gridmember.setId("gridmember");
		gridbook.setId("gridbook");
		gridAddBookCopy.setId("gridAddBookCopy");
		gridBookAllinfo.setId("gridBookAllinfo");
		gridMembersinfo.setId("gridMembersinfo");

		BorderPane bPane = new BorderPane();
		bPane.setId("bPane");

		VBox topContainer = new VBox();
		topContainer.setId("top-container");

		MenuBar mainMenu = new MenuBar();
		topContainer.getChildren().add(mainMenu);

		Menu addOptionsMenu = new Menu("Add");
		MenuItem AddMembe = new MenuItem("Add Member");
		MenuItem addbook = new MenuItem("Add Book");
		MenuItem addBookCopies = new MenuItem("Add Book Copy");
		MenuItem logout = new MenuItem("Log Out");
		addOptionsMenu.getItems().addAll(AddMembe, addbook, addBookCopies, logout);
		mainMenu.getMenus().addAll(addOptionsMenu);

		AddMembe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				bPane.setCenter(gridmember);
			}
		});

		addbook.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// hideAllWindows();

				bPane.setCenter(gridbook);

			}
		});

		addBookCopies.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				bPane.setCenter(gridAddBookCopy);

			}
		});

		logout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Administrator.INSTANCE.hide();
				LoginWindow.INSTANCE.show();

			}
		});

		Menu viewOptionsMenu = new Menu("View");
		MenuItem viewbooks = new MenuItem("Books");
		MenuItem viewMembers = new MenuItem("Members");
		viewOptionsMenu.getItems().addAll(viewbooks, viewMembers);
		mainMenu.getMenus().addAll(viewOptionsMenu);

		viewbooks.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				bPane.setCenter(gridBookAllinfo);

			}
		});

		viewMembers.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				bPane.setCenter(gridMembersinfo);

			}
		});

		bPane.setTop(topContainer);

		// Creating a scene object
		Scene scene = new Scene(bPane, 700, 500, Color.rgb(204, 210, 217));
		scene.getStylesheets().add(getClass().getResource("library.css").toExternalForm());

		// Setting title to the Stage
		setTitle("Administrator");

		// Adding scene to the stage
		setScene(scene);

		// Displaying the contents of the stage
		show();

	}

	public void addMember() {
		gridmember.setAlignment(Pos.CENTER);
		gridmember.setHgap(10);
		gridmember.setVgap(10);
		gridmember.setPadding(new Insets(25, 25, 25, 25));

		Text memberTitle = new Text("Add Member");
		HBox hboxmemberTitle = new HBox(10);
		hboxmemberTitle.setAlignment(Pos.BASELINE_CENTER);
		hboxmemberTitle.getChildren().add(memberTitle);
		memberTitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20)); // Tahoma
		gridmember.add(memberTitle, 0, 0, 2, 1);

		Label memberId = new Label("Member ID:");
		gridmember.add(memberId, 0, 1);

		TextField memberIdTextField = new TextField();
		gridmember.add(memberIdTextField, 1, 1);

		Label firstName = new Label("First Name");
		gridmember.add(firstName, 0, 2);

		TextField firstNameTextField = new TextField();
		gridmember.add(firstNameTextField, 1, 2);

		Label lastName = new Label("Last Name");
		gridmember.add(lastName, 0, 3);

		TextField lastNameTextField = new TextField();
		gridmember.add(lastNameTextField, 1, 3);

		Label telephone = new Label("Telephone:");
		gridmember.add(telephone, 0, 4);

		TextField telephoneTextField = new TextField();
		gridmember.add(telephoneTextField, 1, 4);

		Label street = new Label("Street:");
		gridmember.add(street, 0, 5);

		TextField streetTextField = new TextField();
		gridmember.add(streetTextField, 1, 5);

		Label city = new Label("City:");
		gridmember.add(city, 0, 6);

		TextField cityTextField = new TextField();
		gridmember.add(cityTextField, 1, 6);

		Label state = new Label("State:");
		gridmember.add(state, 0, 7);

		TextField stateTextField = new TextField();
		gridmember.add(stateTextField, 1, 7);

		Label zip = new Label("Zip:");
		gridmember.add(zip, 0, 8);

		TextField zipTextField = new TextField();
		gridmember.add(zipTextField, 1, 8);

		Button addMemberBtn = new Button("Add");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(addMemberBtn);
		gridmember.add(hbBtn, 1, 10);

		HBox messageBox = new HBox(10);
		messageBox.setAlignment(Pos.BOTTOM_RIGHT);
		messageBox.getChildren().add(messageBarmember);
		

		

		gridmember.add(messageBox, 1, 11);


		addMemberBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					String memberId = memberIdTextField.getText();
					String firstName = firstNameTextField.getText();
					String lastName = lastNameTextField.getText();
					String telephone = telephoneTextField.getText();
					String street = streetTextField.getText();
					String city = cityTextField.getText();
					String state = stateTextField.getText();
					String zip = zipTextField.getText();

					saveMember(memberId, firstName, lastName, telephone, street, city, state, zip);

					memberIdTextField.setText("");
					firstNameTextField.setText("");
					lastNameTextField.setText("");
					telephoneTextField.setText("");
					streetTextField.setText("");
					cityTextField.setText("");
					stateTextField.setText("");
					zipTextField.setText("");

					messageBarmember.setFill(Start.Colors.green);
					messageBarmember.setText("Saved successfully");
					

				} catch (SaveException ex) {
					messageBarmember.setFill(Start.Colors.red);
					messageBarmember.setText("Error! " + ex.getMessage());
				}

			}
		});

	}

	public void addBook() {

		gridbook.setAlignment(Pos.CENTER);
		gridbook.setHgap(10);
		gridbook.setVgap(10);
		gridbook.setPadding(new Insets(25, 25, 25, 25));

		Text booktitle = new Text("Add Book");
		HBox hboxbooktitle = new HBox(10);
		hboxbooktitle.setAlignment(Pos.BASELINE_CENTER);
		hboxbooktitle.getChildren().add(booktitle);

		booktitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20)); // Tahoma
		gridbook.add(booktitle, 0, 0, 2, 1);
		Label isbn = new Label("ISBN:");
		gridbook.add(isbn, 0, 1);

		TextField isbnTextField = new TextField();
		gridbook.add(isbnTextField, 1, 1);

		Label title = new Label("Title");
		gridbook.add(title, 0, 2);

		TextField titleTextField = new TextField();
		gridbook.add(titleTextField, 1, 2);

		Label maxlimit = new Label("Max Limit");
		gridbook.add(maxlimit, 0, 3);
		comboBox = new ComboBox(maxLimit);
		Label copies = new Label("Copies");
		gridbook.add(comboBox, 1, 3);

		gridbook.add(copies, 0, 4);

		TextField copiesTextField = new TextField();
		gridbook.add(copiesTextField, 1, 4);

		Text authorDetailsTitle = new Text("Author's Details");
		gridbook.add(authorDetailsTitle, 0, 5);

		Label firstName = new Label("First Name:");
		gridbook.add(firstName, 0, 6);

		TextField firstNameTextField = new TextField();
		gridbook.add(firstNameTextField, 1, 6);

		Label lastName = new Label("Last Name:");
		gridbook.add(lastName, 0, 7);

		TextField lastNameTextField = new TextField();
		gridbook.add(lastNameTextField, 1, 7);

		Label telephone = new Label("Telephone:");
		gridbook.add(telephone, 0, 8);

		TextField telephoneTextField = new TextField();
		gridbook.add(telephoneTextField, 1, 8);

		Label street = new Label("Street:");
		gridbook.add(street, 4, 1);

		TextField streetTextField = new TextField();
		gridbook.add(streetTextField, 5, 1);

		Label city = new Label("City:");
		gridbook.add(city, 4, 2);

		TextField cityTextField = new TextField();
		gridbook.add(cityTextField, 5, 2);

		Label state = new Label("State:");
		gridbook.add(state, 4, 3);

		TextField stateTextField = new TextField();
		gridbook.add(stateTextField, 5, 3);

		Label zip = new Label("Zip:");
		gridbook.add(zip, 4, 4);

		TextField zipTextField = new TextField();
		gridbook.add(zipTextField, 5, 4);
		Button addBookBtn = new Button("Add");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(addBookBtn);
		gridbook.add(hbBtn, 1, 9);

		HBox messageBox = new HBox(10);
		messageBox.setAlignment(Pos.BOTTOM_RIGHT);
		messageBox.getChildren().add(messageBar);
		

		gridbook.add(messageBox, 1, 11);

		addBookBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					String isbn = isbnTextField.getText();
					String title = titleTextField.getText();
					String maxlimit = comboBox.getValue().toString();
					String copies = copiesTextField.getText();
					String firstname = firstNameTextField.getText();
					String lastname = lastNameTextField.getText();
					String telephone = telephoneTextField.getText();
					String street = streetTextField.getText();
					String city = cityTextField.getText();
					String state = stateTextField.getText();
					String zip = zipTextField.getText();

					saveBook(isbn, title, maxlimit, copies, firstname, lastname, telephone, street, city, state, zip);

					isbnTextField.setText("");
					titleTextField.setText("");
					copiesTextField.setText("");
					firstNameTextField.setText("");
					lastNameTextField.setText("");
					telephoneTextField.setText("");
					streetTextField.setText("");
					cityTextField.setText("");
					stateTextField.setText("");
					zipTextField.setText("");
					messageBar.setFill(Start.Colors.green);
					messageBar.setText("Saved successful");
				} catch (SaveException ex) {
					messageBar.setFill(Start.Colors.red);
					messageBar.setText("Error! " + ex.getMessage());
				}
			}
		});

	}

	public void viewBook() {

		TableView tableView = new TableView();

		ControllerInterface ci = new SystemController();
		List<Book> ids = ci.allBooks();
		StringBuilder sb = new StringBuilder();
		TableColumn<String, Book> column1 = new TableColumn<>("ISBN");
		column1.setMinWidth(100);

		TableColumn<String, Book> column2 = new TableColumn<>("title");
		column2.setMinWidth(100);

		TableColumn<String, Book> column3 = new TableColumn<>("maxCheckoutLength");
		column3.setMinWidth(100);
		TableColumn<String, Book> column4 = new TableColumn<>("");
		column4.setMinWidth(100);

		tableView.getColumns().add(column1);
		tableView.getColumns().add(column2);
		tableView.getColumns().add(column3);
		tableView.getColumns().add(column4);
		column1.setCellValueFactory(new PropertyValueFactory<>("isbn"));
		column2.setCellValueFactory(new PropertyValueFactory<>("title"));
		column3.setCellValueFactory(new PropertyValueFactory<>("maxCheckoutLength"));

		for (Book s : ids) {

			tableView.getItems().add(s);

		}

		VBox vbox = new VBox(tableView);
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		gridBookAllinfo.add(vbox, 0, 0);

	}

	public void viewMembers() {

		TableView tableViewmembers = new TableView();

		ControllerInterface ci = new SystemController();
		List<LibraryMember> Members = ci.allLibraryMembers();

		TableColumn<String, LibraryMember> column1 = new TableColumn<>("Member ID");
		column1.setMinWidth(100);
		TableColumn<String, LibraryMember> column2 = new TableColumn<>("First Name");
		column2.setMinWidth(100);
		TableColumn<String, LibraryMember> column3 = new TableColumn<>("Last Name");
		column3.setMinWidth(100);
		TableColumn<String, LibraryMember> column4 = new TableColumn<>("Telephone");
		column4.setMinWidth(100);
		TableColumn<String, LibraryMember> column5 = new TableColumn<>("");

		tableViewmembers.getColumns().add(column1);
		tableViewmembers.getColumns().add(column2);
		tableViewmembers.getColumns().add(column3);
		tableViewmembers.getColumns().add(column4);
		column1.setCellValueFactory(new PropertyValueFactory<>("memberId"));
		column2.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		column3.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		column4.setCellValueFactory(new PropertyValueFactory<>("telephone"));
		for (LibraryMember s : Members) {

			tableViewmembers.getItems().add(s);

		}

		VBox vboxmembers = new VBox(tableViewmembers);
		gridMembersinfo.add(vboxmembers, 0, 0);

	}

	public void saveBook(String isbn, String title, String maxlimit, String copies, String firstname, String lastname,
			String telephone, String street, String city, String state, String zip) throws SaveException {
		int maxlimt = Integer.valueOf(maxlimit);
		ControllerInterface ci = new SystemController();
		Address ad = new Address(street, city, state, zip);
		List<Author> li = new ArrayList<>();
		li.add(new Author(firstname, lastname, telephone, ad, " "));
		Book book = new Book(isbn, title, maxlimt, li);
		ci.saveNewBookcontroller(book);

	}

	public void saveMember(String memberId, String firstName, String lastName, String telephone, String street,
			String city, String state, String zip) throws SaveException {
		ControllerInterface ci = new SystemController();
		LibraryMember libraryMember = new LibraryMember(memberId, firstName, lastName, telephone,
				new Address(street, city, state, zip));
		ci.saveNewMembercontroller(libraryMember);
	}

	public void address() {
		ControllerInterface ci = new SystemController();
		List<String> ids = ci.allBookIds();
		Collections.sort(ids);
		StringBuilder sb = new StringBuilder();
		for (String s : ids) {
			sb.append(s + "\n");
		}
	}


	public void addCopies() {
		clear();

		gridAddBookCopy.setAlignment(Pos.CENTER);
		gridAddBookCopy.setHgap(10);
		gridAddBookCopy.setVgap(10);
		gridAddBookCopy.setPadding(new Insets(25, 25, 25, 25));

		Label isbn = new Label("ISBN:");
		gridAddBookCopy.add(isbn, 0, 0);

		TextField isbnTextField = new TextField();
		gridAddBookCopy.add(isbnTextField, 1, 0);

		Label numberOfCopies = new Label("Copies:");
		gridAddBookCopy.add(numberOfCopies, 0, 1);

		TextField numberOfCopiesTextField = new TextField();
		gridAddBookCopy.add(numberOfCopiesTextField, 1, 1);

		ControllerInterface ci = new SystemController();
		HashMap<String, Book> hash_map = ci.allBooksHashmap();

		Button addCopiesBtn = new Button("Add Copies");
		HBox hbbtnbook = new HBox(10);
		hbbtnbook.setAlignment(Pos.BOTTOM_CENTER);
		hbbtnbook.getChildren().add(addCopiesBtn);
		gridAddBookCopy.add(hbbtnbook, 1, 4);

		addCopiesBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String searchedIsbn = isbnTextField.getText().trim();
				int copies = Integer.valueOf(numberOfCopiesTextField.getText().trim());
				if (hash_map.containsKey(searchedIsbn)) {
					book = hash_map.get(searchedIsbn);
					for (int i = 0; i < copies; i++) {
						System.out.println(i);
						book.addCopy();
					}
					clear();
					Text successText = new Text(copies + " copies added.");
					gridAddBookCopy.add(successText, 1, 2);

				} else {

					HBox messageBox = new HBox(10);
					messageBox.setAlignment(Pos.CENTER);
					messageBox.getChildren().add(addCopyMessageBar);
					gridAddBookCopy.add(messageBox, 1, 2);
					addCopyMessageBar.setFill(Start.Colors.red);
					addCopyMessageBar.setText("Error! The specified Book does not EXIST ");

				}

			}
		});

	}

}