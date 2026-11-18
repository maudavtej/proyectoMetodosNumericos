package frontend;

import Matrices.Gauss;
import frontend.MenuInicial.*;
import frontend.PanelesMetodos.*;

import javax.swing.*;
import java.awt.*;

public class InterfazAplicacion extends JFrame {

    private static final String MENU = "MENU";
    private static final String DESCRIPCIONES = "DESCRIPCIONES";
    //String para los metodos
    private static final String BISECCION = "BISECCION";
    private static final String NEWTON = "NEWTON";
    private static final String SECANTE = "SECANTE";
    private static final String GAUSS = "GAUSS";
    private static final String DOOLITTLE = "DOOLITTLE";
    private static final String CROUT = "CROUT";
    private static final String POTENCIA = "POTENCIA";

    private CardLayout cardLayout;
    private JPanel contenedor;
    private PanelMenuInicial panelMenuInicial = new PanelMenuInicial();
    private PanelDescripciones panelDescripciones = new PanelDescripciones();
    //Metodos
    private PanelBiseccion panelBiseccion = new PanelBiseccion();
    private PanelNewton panelNewton = new PanelNewton();
    private PanelSecante panelSecante = new PanelSecante();
    private PanelGauss panelGauss = new PanelGauss();
    private PanelDoolittle panelDoolittle = new PanelDoolittle();
    private PanelCrout panelCrout = new PanelCrout();
    private PanelPotencia panelPotencia = new PanelPotencia();

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
        contenedor.add(panelDoolittle,DOOLITTLE);
        contenedor.add(panelCrout,CROUT);
        contenedor.add(panelPotencia,POTENCIA);

        add(contenedor, BorderLayout.CENTER);

        // Al presionar CONTINUAR, se muestra el panel de descripciones
        panelMenuInicial.getBtnContinuar().addActionListener(e -> cardLayout.show(contenedor, DESCRIPCIONES));
        panelDescripciones.getBtnSeleccion().addActionListener( e -> cardLayout.show(contenedor,seleccionMetodo()));
        //Botones SALIR de los metodos
        panelBiseccion.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));
        panelNewton.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));
        panelSecante.getBtnSalir().addActionListener(e ->cardLayout.show(contenedor,DESCRIPCIONES));
        panelGauss.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));
        panelDoolittle.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));
        panelCrout.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));
        panelPotencia.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));

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
            case 7:
                metodoSeleccionado = DOOLITTLE;
                break;
            case 8:
                metodoSeleccionado = CROUT;
                break;
            case 9:
                metodoSeleccionado = POTENCIA;
                break;
            default:
                JOptionPane.showMessageDialog(null,"ERROR INTENTE DE NUEVO");
        }

        return metodoSeleccionado;
    }

    public static void main(String[] args){
        InterfazAplicacion interfaz = new InterfazAplicacion();
        interfaz.setVisible(true);
    }

}