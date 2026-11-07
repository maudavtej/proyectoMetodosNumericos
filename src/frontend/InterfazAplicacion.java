package frontend;

import frontend.MenuInicial.*;

import javax.swing.*;
import java.awt.BorderLayout;

public class InterfazAplicacion extends JFrame {

    private PanelDescPotenciaInversa panelTitulo;

    public InterfazAplicacion(){
        //Forma
        setTitle("Metodos Numericos I");
        setSize(800,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        panelTitulo = new PanelDescPotenciaInversa();
        add(panelTitulo,BorderLayout.NORTH);
    }

    public static void main(String[] args){
        InterfazAplicacion interfaz = new InterfazAplicacion();
        interfaz.setVisible(true);
    }
}
