package frontend;

import frontend.MenuInicial.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class InterfazAplicacion extends JFrame {

    private static final String MENU = "MENU";
    private static final String DESCRIPCIONES = "DESCRIPCIONES";

    private CardLayout cardLayout;
    private JPanel contenedor;
    private PanelMenuInicial panelMenuInicial;
    private PanelDescripciones panelDescripciones;

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

        // Cada panel se agrega con un nombre para poder llamarlo después
        contenedor.add(panelMenuInicial, MENU);
        contenedor.add(panelDescripciones, DESCRIPCIONES);

        add(contenedor, BorderLayout.CENTER);

        // Al presionar CONTINUAR, se muestra el panel de descripciones
        panelMenuInicial.getBtnContinuar().addActionListener(
                e -> cardLayout.show(contenedor, DESCRIPCIONES));
    }

    public static void main(String[] args){
        InterfazAplicacion interfaz = new InterfazAplicacion();
        interfaz.setVisible(true);
    }
}
