package frontend;

import Matrices.Gauss;
import frontend.MenuInicial.*;
import frontend.PanelesMetodos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfazAplicacion extends JFrame {

    private static final String MENU = "MENU";
    private static final String DESCRIPCIONES = "DESCRIPCIONES";
    //String para los metodos
    private static final String BISECCION = "BISECCION";
    private static final String NEWTON = "NEWTON";
    private static final String SECANTE = "SECANTE";
    private static final String GAUSS = "GAUSS";
    private static final String JACOBI = "JACOBI";
    private static final String GAUSS_SEIDEL = "GAUSS-SEIDEL";
    private static final String DOOLITLE = "DOOLITTLE";
    private static final String CROUT = "CROUT";
    private static final String POTENCIA = "POTENCIA";
    private static final String POTENCIA_INVERSA = "POTENCIA_INVERSA";

    private CardLayout cardLayout;
    private JPanel contenedor;
    //Paneles iniciales
    private PanelMenuInicial panelMenuInicial = new PanelMenuInicial();
    private PanelDescripciones panelDescripciones = new PanelDescripciones();
    //Metodos
    private PanelBiseccion panelBiseccion = new PanelBiseccion();
    private PanelNewton panelNewton = new PanelNewton();
    private PanelSecante panelSecante = new PanelSecante();
    private PanelGauss panelGauss = new PanelGauss();
    private PanelJacobi panelJacobi = new PanelJacobi();
    private PanelGaussSeidel panelGaussSeidel = new PanelGaussSeidel();
    private PanelDoolittle panelDoolittle = new PanelDoolittle();
    private PanelCrout panelCrout = new PanelCrout();
    private PanelPotencia panelPotencia = new PanelPotencia();
    private PanelPotenciaInversa panelPotenciaInversa = new PanelPotenciaInversa();

    public InterfazAplicacion(){
        setTitle("Metodos Numericos I");
        setSize(800,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        // Contenedor con CardLayout: aquí viven todos los paneles
        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        // Cada panel se agrega con un nombre para poder llamarlo después
        contenedor.add(panelMenuInicial, MENU);
        contenedor.add(panelDescripciones, DESCRIPCIONES);
        contenedor.add(panelBiseccion,BISECCION);
        contenedor.add(panelNewton,NEWTON);
        contenedor.add(panelSecante,SECANTE);
        contenedor.add(panelGauss,GAUSS);
        contenedor.add(panelJacobi, JACOBI);
        contenedor.add(panelGaussSeidel, GAUSS_SEIDEL);
        contenedor.add(panelDoolittle,DOOLITLE);
        contenedor.add(panelCrout,CROUT);
        contenedor.add(panelPotencia,POTENCIA);
        contenedor.add(panelPotenciaInversa,POTENCIA_INVERSA);

        add(contenedor, BorderLayout.CENTER);

        // Al presionar CONTINUAR, se muestra el panel de descripciones
        panelMenuInicial.getBtnContinuar().addActionListener(e -> cardLayout.show(contenedor, DESCRIPCIONES));
        panelDescripciones.getBtnRegresar().addActionListener(e -> cardLayout.show(contenedor,MENU));
        panelDescripciones.getBtnSeleccion().addActionListener( e -> cardLayout.show(contenedor,seleccionMetodo()));
        //Botones SALIR de los metodos
        panelBiseccion.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));
        panelNewton.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));
        panelSecante.getBtnSalir().addActionListener(e ->cardLayout.show(contenedor,DESCRIPCIONES));
        panelGauss.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor, DESCRIPCIONES));
        panelJacobi.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor, DESCRIPCIONES));
        panelGaussSeidel.getBtnSalir().addActionListener(e->cardLayout.show(contenedor, DESCRIPCIONES));
        panelDoolittle.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));
        panelCrout.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));
        panelPotencia.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));
        panelPotenciaInversa.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));

        //Boton para terminar el programa
        panelMenuInicial.getBtnSalir().addActionListener(e -> salirPrograma());
    }

    public String seleccionMetodo(){
        String metodoSeleccionado = "";
        switch(panelDescripciones.getNumMetodo() + 1){
            case 1:
                metodoSeleccionado = BISECCION;
                break;
            case 2:
                metodoSeleccionado = NEWTON;
                break;
            case 3:
                metodoSeleccionado = SECANTE;
                break;
            case 4:
                metodoSeleccionado = GAUSS;
                break;
            case 5:
                metodoSeleccionado= GAUSS_SEIDEL;
                break;
            case 6:
                metodoSeleccionado = JACOBI;
                break;
            case 7:
                metodoSeleccionado = DOOLITLE;
                break;
            case 8:
                metodoSeleccionado = CROUT;
                break;
            case 9:
                metodoSeleccionado = POTENCIA;
                break;
            case 10:
                metodoSeleccionado = POTENCIA_INVERSA;
                break;
            default:
                JOptionPane.showMessageDialog(null,"ERROR INTENTE DE NUEVO");
                break;
        }

        return metodoSeleccionado;
    }

    public void salirPrograma(){
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args){
        InterfazAplicacion interfaz = new InterfazAplicacion();
        interfaz.setVisible(true);
    }

}