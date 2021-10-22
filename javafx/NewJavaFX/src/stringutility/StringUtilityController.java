package stringutility;

import java.util.Arrays;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;

public class StringUtilityController {

	@FXML
	TextField txtInput;

	@FXML
	TextField txtOutput;

	@FXML
	public void onCountClicked(ActionEvent event) {
		if (txtInput != null) {
			txtOutput.setText("" + txtInput.getLength());
			System.out.println("" + txtInput.getLength());
		}
	}

	@FXML
	public void onReverseClicked(ActionEvent event) {
		System.out.println("Holla");
		if (txtInput != null) {
			String txt = txtInput.getText();
			txtOutput.setText(reverseString(txt));
			System.out.println("" + txtInput.getLength());
		}
	}
	
	@FXML
	public void onRemoveDuplicateClicked(ActionEvent event) {
		if (txtInput != null) {
		String noDuplicates = Arrays.asList(txtInput.getText().split(""))
                .stream()
                .distinct()
                .collect(Collectors.joining());
		
		txtOutput.setText(noDuplicates);
		}
	}

	private String reverseString(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		return sb.toString();
	}
}
