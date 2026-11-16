package frontend.PanelesMetodos;

import Matrices.Gauss;
import Matrices.Matriz;
import Raices.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelSolucionSistemasEc extends JPanel{
    //Instanceamos el metodo a usar
    private Gauss gauss = new Gauss();
    private Matriz claseM = new Matriz();

    //Panel titulo
    private JLabel lbTitulo;
    //PanelDescripcion
    private JLabel lbDescripcion;

    public PanelSolucionSistemasEc(){
        setLayout(new BorderLayout());
        TitledBorder border = BorderFactory.createTitledBorder("");
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        JPanel panelTitulo = new JPanel();
        JPanel panelDescripcion = new JPanel();
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        panelPrincipal.add(panelTitulo);
        panelPrincipal.add(panelDescripcion);
        add(panelPrincipal);

        //Misma alineacion horizontal para los 4 paneles; si no, BoxLayout desplaza alguno
        for (JPanel p : new JPanel[]{panelTitulo, panelDescripcion}) {
            p.setAlignmentX(Component.LEFT_ALIGNMENT);
        }
        //*PANEL TITULO*//
        lbTitulo = new JLabel("SOLUCION");
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 40));//Tipo de letra
        lbTitulo.setForeground(Color.WHITE);//Color de la letra
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setVerticalAlignment(SwingConstants.CENTER);
        panelTitulo.setBackground(new Color(0, 82, 158));
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.add(lbTitulo, BorderLayout.CENTER);

        //*PANEL DESCRIPCION*//
        panelDescripcion.setLayout(new BorderLayout());
        panelDescripcion.setBackground(new Color(233, 235, 240));
        panelDescripcion.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        lbDescripcion = new JLabel("Ingrese el sistema de ecuaciones: ");
        lbDescripcion.setFont(new Font("Arial",Font.BOLD,13));
        panelDescripcion.add(lbDescripcion,BorderLayout.WEST);
    }
}
