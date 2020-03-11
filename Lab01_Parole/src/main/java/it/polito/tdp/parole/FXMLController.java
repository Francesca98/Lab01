package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	String word = this.txtParola.getText();
    	//System.out.print(word + "\n");
    	if(word.length() == 0)
    	{
    		txtResult.appendText("Devi inserire un nome" + "\n");
    		return;
    	}
    	
    	
    	try {
    		Integer n =  Integer.parseInt(word);
    	} catch (NumberFormatException e)
    	{
    	this.txtParola.clear();
    	this.txtResult.clear();
    	String n = word.substring(0,1);
    	String string = word.substring(1, word.length());
    	String neword =n.toUpperCase() + string.toLowerCase();
    	if(!elenco.getElenco().contains(neword))
    	{elenco.addParola(neword);
    	}

    	
    	for(Object s : elenco.getElenco().stream().sorted().collect(Collectors.toList()))
    	
    		txtResult.appendText(s.toString()+"\n");
    	return;
    	}

		txtResult.appendText("Formato non valido"+"\n");	
		
	
    		
    

    }

    @FXML
    void doReset(ActionEvent event) {
      elenco.reset();
      txtResult.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
