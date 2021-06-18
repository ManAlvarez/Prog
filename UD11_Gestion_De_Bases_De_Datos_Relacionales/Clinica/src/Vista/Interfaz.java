/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Conexion;
import Modelo.PersonaDAO;
import Tools.Tools;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Manuel
 */
public class Interfaz extends JFrame {

    JLabel jlIdPersona;
    JLabel jlNomPersona;
    JLabel jlApelPersona;
    JLabel jlIdAnimal;
    JLabel jlNomAnimal;
    JLabel jlIdPropietario;

    JTextField jtfIdPersona;
    JTextField jtfNomPersona;
    JTextField jtfApelPersona;
    JTextField jtfIdAnimal;
    JTextField jtfNomAnimal;
    JTextField jtfIdPropietario;

    JDialog jdPersona;
    JDialog jdAnimal;
    JDialog jdListaPersonas;

    JButton jbAnadirPersona;
    JButton jbActualizarPersona;
    JButton jbEliminarPersona;
    JButton jbIrPersona;
    JButton jbIrListaPersonas;

    JButton jbAnadirAnimal;
    JButton jbActualizarAnimal;
    JButton jbEliminarAnimal;
    JButton jbIrAnimal;
    JButton jbElimPersLista;

    JPanel jpPersona;
    JPanel jpAnimal;
    JPanel jpPrincipal;
    JPanel jpListaPesonas;

    JList jlListaPersonas;
    JButton jbGenerarFichero;
    JButton jbLeerFichero;

    public Interfaz() {

        // Crear componentes;
        jpPrincipal = new JPanel();
        jpPrincipal.setBorder(new TitledBorder("Clinica Veterinaria"));
        jbIrPersona = new JButton("Persona");
        jbIrAnimal = new JButton("Animal");
        jbIrListaPersonas = new JButton("Lista Personas");

        jdPersona = new JDialog();
        jpPersona = new JPanel();
        jlIdPersona = new JLabel("ID: ");
        jlNomPersona = new JLabel("Nombre: ");
        jlApelPersona = new JLabel("Apellidos: ");
        jtfIdPersona = new JTextField();
        jtfNomPersona = new JTextField();
        jtfApelPersona = new JTextField();
        jbAnadirPersona = new JButton("Añadir");
        jbActualizarPersona = new JButton("Actualizar");
        jbEliminarPersona = new JButton("Eliminar");

        jdAnimal = new JDialog();
        jpAnimal = new JPanel();
        jlIdAnimal = new JLabel("ID: ");
        jlNomAnimal = new JLabel("Nombre: ");
        jlIdPropietario = new JLabel("ID: ");
        jtfIdAnimal = new JTextField();
        jtfNomAnimal = new JTextField();
        jtfIdPropietario = new JTextField();
        jbAnadirAnimal = new JButton("Añadir");
        jbActualizarAnimal = new JButton("Actualizar");
        jbEliminarAnimal = new JButton("Eliminar");
        jbElimPersLista = new JButton("Eliminar");
        
        jbGenerarFichero = new JButton("Generar fichero");
        jbLeerFichero = new JButton("Leer Fichero");

        jdListaPersonas = new JDialog();
        jpListaPesonas = new JPanel();
        DefaultListModel model = new DefaultListModel();
        model = PersonaDAO.listarPersonas();
        jlListaPersonas = new JList();

        setContentPane(jpPrincipal);
        jpPrincipal.add(jbIrPersona);
        jpPrincipal.add(jbIrAnimal);
        jpPrincipal.add(jbIrListaPersonas);
        jpPrincipal.add(jbGenerarFichero);
        jpPrincipal.add(jbLeerFichero);
        
        jbLeerFichero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tools.leerFichero();
            }
        });
        
        
        jbGenerarFichero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tools.guardarFichero(PersonaDAO.listarPersonas2());
            }
        });

        jbIrListaPersonas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpListaPesonas.setBorder(new TitledBorder("Lista de personas"));
                jdListaPersonas.add(jpListaPesonas);
                DefaultListModel model = new DefaultListModel();
                model = PersonaDAO.listarPersonas();
                jlListaPersonas.setModel(model);
                jpListaPesonas.add(jlListaPersonas);
                jpListaPesonas.add(jbElimPersLista);
                jdListaPersonas.setSize(1000, 200);
                jdListaPersonas.setLocationRelativeTo(null);
                jdListaPersonas.setModal(true);
                jdListaPersonas.setVisible(true);
            }
        });

        jbElimPersLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seleccion = jlListaPersonas.getSelectedIndex();
                if (seleccion >= 0) {
                    String valor = (String) jlListaPersonas.getSelectedValue();
                    String[] valores = new String[3];
                    valores = valor.split(",");
                    PersonaDAO.deletePersona(Integer.parseInt(valores[0]));
                    DefaultListModel model = new DefaultListModel();
                    model = PersonaDAO.listarPersonas();
                    jlListaPersonas.setModel(model);

                }
            }
        });

        jbIrPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jpPersona.setBorder(new TitledBorder("Datos Persona"));
                jpPersona.setLayout(new GridLayout(3, 3));
                jdPersona.setContentPane(jpPersona);

                jpPersona.add(jlIdPersona);
                jpPersona.add(jtfIdPersona);
                jpPersona.add(jbAnadirPersona);

                jpPersona.add(jlNomPersona);
                jpPersona.add(jtfNomPersona);
                jpPersona.add(jbActualizarPersona);

                jpPersona.add(jlApelPersona);
                jpPersona.add(jtfApelPersona);
                jpPersona.add(jbEliminarPersona);

                jdPersona.setSize(1000, 200);
                jdPersona.setLocationRelativeTo(null);
                jdPersona.setModal(true);
                jdPersona.setVisible(true);
            }
        });

        jbIrAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jpAnimal.setBorder(new TitledBorder("Datos Animal"));
                jpAnimal.setLayout(new GridLayout(3, 3));
                jdAnimal.setContentPane(jpAnimal);

                jpAnimal.add(jlIdAnimal);
                jpAnimal.add(jtfIdAnimal);
                jpAnimal.add(jbAnadirAnimal);

                jpAnimal.add(jlNomAnimal);
                jpAnimal.add(jtfNomAnimal);
                jpAnimal.add(jbActualizarAnimal);

                jpAnimal.add(jlIdPropietario);
                jpAnimal.add(jtfIdPropietario);
                jpAnimal.add(jbEliminarAnimal);

                jdAnimal.setSize(1000, 200);
                jdAnimal.setLocationRelativeTo(null);
                jdAnimal.setModal(true);
                jdAnimal.setVisible(true);
            }
        });

        jbAnadirPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPersona = jtfIdPersona.getText();
                String nomPersona = jtfNomPersona.getText();
                String apelPersona = jtfApelPersona.getText();
                if (idPersona.equals("") || nomPersona.equals("") || apelPersona.equals("")) {
                    JOptionPane.showMessageDialog(null, "No se ha podido añadir la persona.", "ERROR", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!Tools.isNumero(idPersona)) {
                        JOptionPane.showMessageDialog(null, "El id de la persona no es un número", "ERROR", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (!PersonaDAO.existePersona(Integer.parseInt(idPersona))) {
                            PersonaDAO.insertPersona(Integer.parseInt(idPersona), nomPersona, apelPersona);
                            JOptionPane.showMessageDialog(null, "La persona se ha añadido correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La persona ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                jtfIdPersona.setText("");
                jtfNomPersona.setText("");
                jtfApelPersona.setText("");
            }
        });

        jbActualizarPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPersona = jtfIdPersona.getText();
                String nomPersona = jtfNomPersona.getText();
                String apelPersona = jtfApelPersona.getText();
                if (idPersona.equals("") || nomPersona.equals("") || apelPersona.equals("")) {
                    JOptionPane.showMessageDialog(null, "No se ha podido añadir la persona.", "ERROR", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!Tools.isNumero(idPersona)) {
                        JOptionPane.showMessageDialog(null, "El id de la persona no es un número", "ERROR", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (PersonaDAO.existePersona(Integer.parseInt(idPersona))) {
                            PersonaDAO.actualizarPersona(Integer.parseInt(idPersona), nomPersona, apelPersona);
                            JOptionPane.showMessageDialog(null, "La persona se ha actualizado correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La persona no existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                jtfIdPersona.setText("");
                jtfNomPersona.setText("");
                jtfApelPersona.setText("");
            }
        });

        jbEliminarPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPersona = jtfIdPersona.getText();
                if (idPersona.equals("")) {
                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar la persona.", "ERROR", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!Tools.isNumero(idPersona)) {
                        JOptionPane.showMessageDialog(null, "El id de la persona no es un número", "ERROR", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (PersonaDAO.existePersona(Integer.parseInt(idPersona))) {
                            PersonaDAO.deletePersona(Integer.parseInt(idPersona));
                            JOptionPane.showMessageDialog(null, "La persona se ha eliminado correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La persona no existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                jtfIdPersona.setText("");
                jtfNomPersona.setText("");
                jtfApelPersona.setText("");
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Interfaz interfaz = new Interfaz();
        interfaz.setTitle("ClinicaVeterinaria");
        interfaz.setLocationRelativeTo(null);
        interfaz.setExtendedState(MAXIMIZED_BOTH);
        interfaz.setDefaultCloseOperation(EXIT_ON_CLOSE);
        interfaz.setVisible(true);

    }

}
