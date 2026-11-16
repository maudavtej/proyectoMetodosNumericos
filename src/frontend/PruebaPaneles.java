package frontend;

import frontend.PanelesMetodos.PanelBiseccion;
import frontend.PanelesMetodos.PanelGauss;
import frontend.PanelesMetodos.PanelNewton;
import frontend.PanelesMetodos.PanelSolucionSistemasEc;

import javax.swing.*;
import java.awt.BorderLayout;

public class PruebaPaneles extends  JFrame{

    PanelGauss panel = new PanelGauss();

    public PruebaPaneles(){
        setTitle("Metodos Numericos I");
        setSize(800,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        add(panel,BorderLayout.CENTER);
    }

    public static void main(String[] args){
        PruebaPaneles interfaz = new PruebaPaneles();
        interfaz.setVisible(true);
    }
}
