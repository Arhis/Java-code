package casiocalc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Виктор
 */
public class FXMLDocumentController implements Initializable {   
    private double currentNumber;
    private String currentOperation;
    
    @FXML
    private TextField displayField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    private void handleDigitAction(ActionEvent event) {
       
       String digit = ((Button) event.getSource()).getText();  
       String oldText = displayField.getText();       
       String newText = oldText + digit;
       if (newText.charAt(0) != '.') {
          if(StringUtils.countMatches(newText, '.') == 0 ||
             StringUtils.countMatches(newText, '.') == 1)  
                displayField.setText(newText);           
       }
              
    }  
    
    @FXML
    private void handleEqualOperation(ActionEvent event) {
       String newText = displayField.getText();
       double newNumber = Double.parseDouble(newText);
       
        switch (currentOperation) {
            case "+":
                currentNumber += newNumber;
                break;
            case "-":
                currentNumber -= newNumber;
                break;
            case "*":
                currentNumber *= newNumber;
                break;
            case "/":
                currentNumber /= newNumber;
                break;
            default:
                break;
        } 
        
      /*#1 Checking is it number an Integer instead of Double
       *In this case, I am checking does number has more than one symbols after dot
       *if true, then checking is that number Zero(0)
       *if true, I convert Double to Integer
       *Otherwise, I provide no changes and just display it*/      
      
       String check = "" + currentNumber;
       int position = check.indexOf(".");
       
       if ((position+1) == (check.length()-1) &&
           check.indexOf("0") == (position+1)) {
           int isInteger = (int)currentNumber;
           displayField.setText(""+isInteger);
       } else {
           displayField.setText("" + currentNumber);
       }
       /*#1*******************************************/
       
    }

    @FXML
    private void handleOperation(ActionEvent event) {        
        String currentText = displayField.getText();
        currentNumber = Double.parseDouble(currentText);
        displayField.setText("");
        currentOperation = ((Button) event.getSource()).getText();
        
    }  

    @FXML
    private void handleClearAction(ActionEvent event) {
        currentOperation = "";
        currentNumber = 0.0;
        displayField.setText("");
        
    }
    
}
