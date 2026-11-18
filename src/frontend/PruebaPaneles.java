package frontend;

import frontend.PanelesMetodos.*;

import javax.swing.*;
import java.awt.BorderLayout;

public class PruebaPaneles extends  JFrame{

    PanelPotenciaInversa panel = new PanelPotenciaInversa();

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
