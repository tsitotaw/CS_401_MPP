package address;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;

public class AddressController {
	 	 
	@FXML
	TextField txtName;
	@FXML
	TextField txtStreet;
	@FXML
	TextField txtState;
	@FXML
	TextField txtCity;
	@FXML
	TextField txtZip;
	
	 @FXML
	public void updateLabel(ActionEvent event) {
		 System.out.println(txtName.getText());	 
		 System.out.println(txtStreet.getText());
		 System.out.println(txtCity.getText() + ", " + txtState.getText() + " " + txtZip.getText());
    }
	 
	 
}
