/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Manuel
 */
public class EjemploGridLayout extends JFrame {

    JButton boton[], botonResultado;
    JLabel display;
    JPanel panelBotones;
    int ancho = 50, alto = 50;
    FlowLayout miFlowLayout;
    GridLayout miGridLayout;

    public EjemploGridLayout() {
        initDisplay();
        initBotones();
        initBotonResultado();
        initPnatalla();
    }

    private void initDisplay() {
        display = new JLabel("0");
        display.setPreferredSize(new Dimension(230, 60));
        display.setOpaque(true);
        display.setBackground(Color.black);
        display.setForeground(Color.green);
        display.setBorder(new LineBorder(Color.DARK_GRAY));
        display.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display);
    }

    private void initBotones() {
        // Inicializo el panel de botones y su gridLayout de 4 columnas y 4 filas.
        panelBotones = new JPanel();
        panelBotones.setBackground(Color.BLACK);
        miGridLayout = new GridLayout(4, 4, 10, 10);
        panelBotones.setLayout(miGridLayout);
        add(panelBotones);

        //Array de texto de botones.
        String[] texto_boton = new String[]{"0", ".", "C", "+", "1", "2", "3", "-", "4", "5", "6", "*", "7", "8", "9", "/"};
        //Inicializo el array de botones.
        boton = new JButton[16];

        for (int i = 0; i <= 15; i++) {
            //Inicializo botón con su texto.
            boton[i] = new JButton(texto_boton[i]);
            boton[i].setPreferredSize(new Dimension(ancho, alto));
            boton[i].setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
            boton[i].setOpaque(true);
            boton[i].setFocusPainted(false);
            boton[i].setBackground(Color.DARK_GRAY);
            boton[i].setBorder(new LineBorder(Color.DARK_GRAY));
            //Añado el botón al panel de botones.
            panelBotones.add(boton[i]);
        }
    }

    private void initBotonResultado() {
        botonResultado = new JButton("RESULTADO");
        botonResultado.setPreferredSize(new Dimension(230, alto));
        botonResultado.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        botonResultado.setOpaque(true);
        botonResultado.setFocusPainted(false);
        botonResultado.setBackground(Color.DARK_GRAY);
        botonResultado.setBorder(new LineBorder(Color.DARK_GRAY));
        botonResultado.setForeground(Color.WHITE);
        add(botonResultado);
    }

    public void initPnatalla() {
        miFlowLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        setLayout(miFlowLayout);
        setTitle("Ejercicio 1");
        setMinimumSize(new Dimension(255, 405));
        setResizable(false);
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new EjemploGridLayout();
    }

}
