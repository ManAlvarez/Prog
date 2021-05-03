/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicalculadorafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author 
 */
public class MiniCalculadoraInterfazController implements Initializable {
   
    @FXML
    private TextField tfNumero1;
    
    @FXML
    private TextField tfNumero2;
    
    @FXML
    private TextField tfResultado;
    
    @FXML
    private void buttonSumarHandler (ActionEvent event){
        //Variables para almacenar los operandos a sumar.
        int num1, num2, resul;
        
        num1= Integer.parseInt(tfNumero1.getText());
        num2= Integer.parseInt(tfNumero2.getText());
        
        //Ya hemos recogido el valor de los operados de los campos de texto de la interfaz. Realizamos la suma.
        resul=num1+num2;
        
        tfResultado.setText(String.valueOf(resul));
    }
    
    @FXML
    private void buttonSalirHandler (ActionEvent event){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
