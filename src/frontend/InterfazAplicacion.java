package frontend;

import frontend.MenuInicial.*;
import frontend.PanelesMetodos.PanelBiseccion;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class InterfazAplicacion extends JFrame {

    private static final String MENU = "MENU";
    private static final String DESCRIPCIONES = "DESCRIPCIONES";
    //String para los metodos
    private static final String BISECCION = "BISECCION";

    private CardLayout cardLayout;
    private JPanel contenedor;
    private PanelMenuInicial panelMenuInicial;
    private PanelDescripciones panelDescripciones;
    //Metodos
    private PanelBiseccion panelBiseccion;

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

        panelMenuInicial = new PanelMenuInicial();
        panelDescripciones = new PanelDescripciones();
        //Paneles de los metodos
        panelBiseccion = new PanelBiseccion();

        // Cada panel se agrega con un nombre para poder llamarlo después
        contenedor.add(panelMenuInicial, MENU);
        contenedor.add(panelDescripciones, DESCRIPCIONES);
        contenedor.add(panelBiseccion,BISECCION);

        add(contenedor, BorderLayout.CENTER);

        // Al presionar CONTINUAR, se muestra el panel de descripciones
        panelMenuInicial.getBtnContinuar().addActionListener(e -> cardLayout.show(contenedor, DESCRIPCIONES));
        panelDescripciones.getBtnSeleccion().addActionListener( e -> cardLayout.show(contenedor,seleccionMetodo()));
        //Botones SALIR de los metodos
        panelBiseccion.getBtnSalir().addActionListener(e -> cardLayout.show(contenedor,DESCRIPCIONES));
    }

    public String seleccionMetodo(){
        String metodoSeleccionado = "";
        switch(panelDescripciones.getNumMetodo() + 1){
            case 1:
                metodoSeleccionado = BISECCION;
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