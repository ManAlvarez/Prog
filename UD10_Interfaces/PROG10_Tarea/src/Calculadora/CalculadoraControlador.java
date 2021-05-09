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
    private int digito, num1, num2, numInsert, resultado;
    private boolean clickSum, clickRest, clickMult, clickDiv, clickIgual, clickOp;
    private String operador;

    @FXML
    public void button0Handler(ActionEvent event) {
        digito = 0;
        addNumero();
    }

    @FXML
    private void button1Handler(ActionEvent event) {
        digito = 1;
        addNumero();
    }

    @FXML
    private void button2Handler(ActionEvent event) {
        digito = 2;
        addNumero();
    }

    @FXML
    private void button3Handler(ActionEvent event) {
        digito = 3;
        addNumero();
    }

    @FXML
    private void button4Handler(ActionEvent event) {
        digito = 4;
        addNumero();
    }

    @FXML
    private void button5Handler(ActionEvent event) {
        digito = 5;
        addNumero();
    }

    @FXML
    private void button6Handler(ActionEvent event) {
        digito = 6;
        addNumero();
    }

    @FXML
    private void button7Handler(ActionEvent event) {
        digito = 7;
        addNumero();
    }

    @FXML
    private void button8Handler(ActionEvent event) {
        digito = 8;
        addNumero();
    }

    @FXML
    private void button9Handler(ActionEvent event) {
        digito = 9;
        addNumero();
    }

    @FXML
    private void buttonCHandler(ActionEvent event) {
        tfPantalla.setText("");
        tfResultado.setText("0");
        operador = "";
        resultado = 0;
        num1 = 0;
        num2 = 0;
        inicializarClicks();
        clickOp = true;
    }

    @FXML
    private void buttonSumaHandler(ActionEvent event) {
        operador = "+";
        addPrimerNumero(clickSum);
    }

    @FXML
    private void buttonRestaHandler(ActionEvent event) {
        operador = "-";
        addPrimerNumero(clickRest);
    }

    @FXML
    private void buttonMultiHandler(ActionEvent event) {
        operador = "*";
        addPrimerNumero(clickMult);
    }

    @FXML
    private void buttonDivHandler(ActionEvent event) {
        operador = "/";
        addPrimerNumero(clickDiv);
    }

    @FXML
    private boolean buttonIgualHandler(ActionEvent event) {
        if (!clickIgual) {
            num2 = Integer.parseInt(String.valueOf(tfResultado.getText()));
            if (operador.equalsIgnoreCase("/") && num2 == 0) {
                tfPantalla.setText(String.valueOf("No se puede dividir entre cero"));
                inicializarClicks();
                clickOp = true;
                return false;
            }
            numInsert = num2;
        } else {
            num2 = numInsert;
            num1 = resultado;
        }
        calcular();
        tfPantalla.setText(num1 + operador + num2 + " = ");
        tfResultado.setText(String.valueOf(resultado));
        clickIgual = true;
        clickOp = true;
        return true;
    }

    private void addPrimerNumero(boolean click) {
        if (!click) {
            num1 = Integer.parseInt(String.valueOf(tfResultado.getText()));
            numInsert = num1;
            tfPantalla.setText(String.valueOf(num1 + operador));
        }
        activarClicks();
    }

    private void addNumero() {
        if (!clickOp) {
            tfResultado.setText(tfResultado.getText() + digito);
        } else {
            tfResultado.setText(String.valueOf(digito));
            inicializarClicks();
        }
    }

    private void calcular() {
        switch (operador) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                resultado = num1 / num2;
                break;
            default:
                resultado = num1;
                break;
        }
    }

    private void activarClicks() {
        switch (operador) {
            case "+":
                clickSum = true;
                clickRest = false;
                clickMult = false;
                clickDiv = false;
                clickIgual = false;
                break;
            case "-":
                clickSum = false;
                clickRest = true;
                clickMult = false;
                clickDiv = false;
                clickIgual = false;
                break;
            case "*":
                clickSum = false;
                clickRest = false;
                clickMult = true;
                clickDiv = false;
                clickIgual = false;
                break;
            case "/":
                clickSum = false;
                clickRest = false;
                clickMult = false;
                clickDiv = true;
                clickIgual = false;
                break;
            default:
                clickSum = false;
                clickRest = false;
                clickMult = false;
                clickDiv = false;
                clickIgual = false;
                break;
        }
        clickOp = true;
    }

    private void inicializarClicks() {
        clickSum = false;
        clickRest = false;
        clickMult = false;
        clickDiv = false;
        clickOp = false;
        clickIgual = false;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
