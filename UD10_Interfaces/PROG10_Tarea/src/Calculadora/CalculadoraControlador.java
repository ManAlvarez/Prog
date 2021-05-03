package Calculadora;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class CalculadoraControlador implements Initializable {

    @FXML
    private TextField tfPantalla, tfResultado;
    private int primerEntero, segundoEntero, resultado;
    private boolean sumaClick, restaClick, multiClick, divClick, igualClick;

    @FXML
    public void button0Handler(ActionEvent event) {
        if (igualClick) {
            tfResultado.setText("");
            igualClick = false;
        }
        tfResultado.setText(tfResultado.getText() + "0");
    }

    @FXML
    private void button1Handler(ActionEvent event) {
        if (igualClick) {
            tfResultado.setText("");
            igualClick = false;
        }
        tfResultado.setText(tfResultado.getText() + "1");

    }

    @FXML
    private void button2Handler(ActionEvent event) {
        if (igualClick) {
            tfResultado.setText("");
            igualClick = false;
        }
        tfResultado.setText(tfResultado.getText() + "2");
    }

    @FXML
    private void button3Handler(ActionEvent event) {
        if (igualClick) {
            tfResultado.setText("");
            igualClick = false;
        }
        tfResultado.setText(tfResultado.getText() + "3");
    }

    @FXML
    private void button4Handler(ActionEvent event) {
        if (igualClick) {
            tfResultado.setText("");
            igualClick = false;
        }
        tfResultado.setText(tfResultado.getText() + "4");
    }

    @FXML
    private void button5Handler(ActionEvent event) {
        if (igualClick) {
            tfResultado.setText("");
            igualClick = false;
        }
        tfResultado.setText(tfResultado.getText() + "5");
    }

    @FXML
    private void button6Handler(ActionEvent event) {
        if (igualClick) {
            tfResultado.setText("");
            igualClick = false;
        }
        tfResultado.setText(tfResultado.getText() + "6");
    }

    @FXML
    private void button7Handler(ActionEvent event) {
        if (igualClick) {
            tfResultado.setText("");
            igualClick = false;
        }
        tfResultado.setText(tfResultado.getText() + "7");
    }

    @FXML
    private void button8Handler(ActionEvent event) {
        if (igualClick) {
            tfResultado.setText("");
            igualClick = false;
        }
        tfResultado.setText(tfResultado.getText() + "8");
    }

    @FXML
    private void button9Handler(ActionEvent event) {
        if (igualClick) {
            tfResultado.setText("");
            igualClick = false;
        }
        tfResultado.setText(tfResultado.getText() + "9");
    }

    @FXML
    private void buttonCHandler(ActionEvent event) {
        tfResultado.setText("");
        tfPantalla.setText("");
        sumaClick = false;
        restaClick = false;
        multiClick = false;
        divClick = false;
        igualClick = false;
    }

    @FXML
    private void buttonSumaHandler(ActionEvent event) {
        if (!sumaClick && !tfResultado.getText().equalsIgnoreCase("")) {
            primerEntero = Integer.parseInt(String.valueOf(tfResultado.getText()));
            tfPantalla.setText(tfResultado.getText() + " + ");
            tfResultado.setText("");
            sumaClick = true;
            restaClick = false;
            multiClick = false;
            divClick = false;
            igualClick = false;
        } 
    }

    @FXML
    private void buttonRestaHandler(ActionEvent event) {
        if (!restaClick && !tfResultado.getText().equalsIgnoreCase("")) {
            primerEntero = Integer.parseInt(String.valueOf(tfResultado.getText()));
            tfPantalla.setText(tfResultado.getText() + " - ");
            tfResultado.setText("");
            sumaClick = false;
            restaClick = true;
            multiClick = false;
            divClick = false;
            igualClick = false;
        }
    }

    @FXML
    private void buttonMultiHandler(ActionEvent event) {
        if (!multiClick && !tfResultado.getText().equalsIgnoreCase("")) {
            primerEntero = Integer.parseInt(String.valueOf(tfResultado.getText()));
            tfPantalla.setText(tfResultado.getText() + " x ");
            tfResultado.setText("");
            sumaClick = false;
            restaClick = false;
            multiClick = true;
            divClick = false;
            igualClick = false;
        }
    }

    @FXML
    private void buttonDivHandler(ActionEvent event) {
        if (!divClick && !tfResultado.getText().equalsIgnoreCase("")) {
            primerEntero = Integer.parseInt(String.valueOf(tfResultado.getText()));
            tfPantalla.setText(tfResultado.getText() + " / ");
            tfResultado.setText("");
            sumaClick = false;
            restaClick = false;
            multiClick = false;
            divClick = true;
            igualClick = false;
        }
    }

    @FXML
    private void buttonIgualHandler(ActionEvent event) {
        if (!igualClick && !tfResultado.getText().equalsIgnoreCase("")) {
            segundoEntero = Integer.parseInt(String.valueOf(tfResultado.getText()));
            operacion();
            primerEntero = resultado;
            sumaClick = false;
            restaClick = false;
            multiClick = false;
            divClick = false;
            igualClick = true;
            tfPantalla.setText(tfPantalla.getText() + tfResultado.getText() + " = ");
            tfResultado.setText(String.valueOf(resultado));
        }
    }

    private void operacion() {
        if (sumaClick) {
            resultado = primerEntero + segundoEntero;
        } else if (restaClick) {
            resultado = primerEntero - segundoEntero;
        } else if (multiClick) {
            resultado = primerEntero * segundoEntero;
        } else if (divClick) {
            resultado = primerEntero / segundoEntero;
        } else {
            resultado = primerEntero;
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
