package frontend;

import frontend.PanelesMetodos.PanelBiseccion;
import frontend.PanelesMetodos.PanelNewton;

import javax.swing.*;
import java.awt.BorderLayout;

public class PruebaPaneles extends  JFrame{

    PanelNewton panelNewton=  new PanelNewton();

    public PruebaPaneles(){
        setTitle("Metodos Numericos I");
        setSize(800,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        add(panelNewton,BorderLayout.CENTER);
    }

    public static void main(String[] args){
        PruebaPaneles interfaz = new PruebaPaneles();
        interfaz.setVisible(true);
    }
}
