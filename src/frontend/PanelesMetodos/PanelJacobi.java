package frontend.PanelesMetodos;

import Matrices.*;
import Raices.Ejemplo3;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PanelJacobi extends JPanel {

    //======================================================
    // Etiquetas
    private JLabel lbTitulo;
    private JLabel lbEjemplos;
    private JLabel lbDescripcion;
    private JLabel lbSolucion;
    //==========================================================
    // Desplegable que guarda las opciones
    private JComboBox<String> cbEjemplos;
    //==========================================================
    //TEXTOS
    JTextArea txtSolucion;

    //========================================================
    // BOTONES
    private JButton btnseleccionarEj;
    private JButton btnCalcular;
    private JButton btnSalir;
    private JButton btnBorrar;
    //====================================================
    //TABLA
    private JTable tablaJacobi;
    private DefaultTableModel modelo;
    private ArrayList<String[]> tablaFormat;
    //======================================================
    Jacobi jac = new Jacobi();

    private String solucionStrFormat;

    public PanelJacobi(){
        setLayout(new BorderLayout());
        TitledBorder border = BorderFactory.createTitledBorder("");
        border.setTitleColor(Color.BLACK);
        setBorder(border);
        JPanel panelTitulo = new JPanel();
        JPanel panelEjemplos = new JPanel();
        JPanel panelDescripcion = new JPanel();
        JPanel panelTabla = new JPanel();
        JPanel panelPiePag = new JPanel();

        //=============================================================
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));
        panelPrincipal.add(panelTitulo);
        panelPrincipal.add(panelEjemplos);
        panelPrincipal.add(panelDescripcion);
        panelPrincipal.add(panelTabla);
        panelPrincipal.add(panelPiePag);

        add(panelPrincipal);

        //alineacion
        for (JPanel p : new JPanel[]{panelTitulo,panelEjemplos,panelDescripcion,panelTabla,panelTabla,panelPiePag}) {
            p.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        //==========================================================================
        //TITULO
        lbTitulo = new JLabel("MÉTODO DE JACOBI");
        lbTitulo.setFont(new Font("Arial",Font.BOLD,40));
        lbTitulo.setForeground(Color.WHITE);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setVerticalAlignment(SwingConstants.CENTER);
        panelTitulo.setBackground(new Color(0,82,158));
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.add(lbTitulo,BorderLayout.CENTER);
        //===========================================================================
        panelEjemplos.setLayout(new BorderLayout());
        panelEjemplos.setBackground(new Color(233,235,240));
        panelEjemplos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        String[] sistemas = {"Sistema de ecuaciones de 2 incógnitas","Sistema de ecuaciones de 3 incógnitas","Sistema de ecuaciones de 4 incógnitas","Sistema de ecuaciones de 5 incógnitas"};
        cbEjemplos = new JComboBox<>();
        cbEjemplos.addItem("Seleccione un ejemplo");
        for (int i  = 0; i < sistemas.length; i++){
            cbEjemplos.addItem("<html>"+sistemas[i]+"</html>");
        }
        lbEjemplos = new JLabel("Ejemplos: ");
        btnseleccionarEj = new JButton("SELECCIONAR");
        btnseleccionarEj.addActionListener(ActionEvent->btnseleccionarEj(sistemas));
        panelEjemplos.add(lbEjemplos,BorderLayout.WEST);
        panelEjemplos.add(cbEjemplos,BorderLayout.CENTER);
        panelEjemplos.add(btnseleccionarEj,BorderLayout.EAST);
        //===================================================================
        //DESCRIPCION
        panelDescripcion.setLayout(new BorderLayout());
        panelDescripcion.setBackground(new Color(233,235,240));
        panelDescripcion.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        lbDescripcion = new JLabel("");
        lbDescripcion.setFont(new Font("Arial",Font.PLAIN,13));
        panelDescripcion.add(lbDescripcion,BorderLayout.CENTER);
        btnCalcular = new JButton("CALCULAR");
        panelDescripcion.add(btnCalcular, BorderLayout.EAST);
        btnCalcular.addActionListener(ActionEvent->btnCalcular());
        //=======================================================================
        //TABLA
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBackground(new Color(233,235,240));
        panelTabla.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        String[] columnas = {"N","x","y","z","w","g"};
        modelo  = new DefaultTableModel(columnas,0);
        tablaJacobi = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tablaJacobi);
        panelTabla.add(scroll,BorderLayout.CENTER);
        //==========================================================
        //PANEL INFERIOR
        panelPiePag.setLayout(new BorderLayout());
        JPanel soluciones = new JPanel();
        JPanel salidas = new JPanel();
        panelPiePag.add(soluciones, BorderLayout.NORTH);
        panelPiePag.add(salidas, BorderLayout.CENTER);

        soluciones.setLayout(new BorderLayout());
        soluciones.setBackground(new Color(233,235,240));
        soluciones.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        btnBorrar = new JButton("BORRAR");
        btnSalir = new JButton("REGRESAR");
        btnBorrar.addActionListener(e -> btnBorrarAction());

        soluciones.add(btnSalir,BorderLayout.WEST);
        soluciones.add(btnBorrar,BorderLayout.EAST);
        //PANEL SALIDAS
        salidas.setLayout(new BoxLayout(salidas,BoxLayout.X_AXIS));
        salidas.setBackground(new Color(233,235,240));
        salidas.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        lbSolucion = new JLabel("Convergencia: ");
        txtSolucion = new JTextArea("");
        txtSolucion.setFocusable(false);
        txtSolucion.setLineWrap(true);
        txtSolucion.setWrapStyleWord(true);
        txtSolucion.setEditable(false);
        txtSolucion.setFont(new Font("Arial",Font.PLAIN,13));

        salidas.add(lbSolucion);
        salidas.add(txtSolucion);
        //================================================================

        panelTitulo.setPreferredSize(new Dimension(800, 90));
        panelTitulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        panelEjemplos.setPreferredSize(new Dimension(800, 70));
        panelEjemplos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

        panelDescripcion.setPreferredSize(new Dimension(800,120));
        panelDescripcion.setMaximumSize(new Dimension(Integer.MAX_VALUE,120));
        panelTabla.setPreferredSize(new Dimension(800,359));
        panelTabla.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE));

        panelPiePag.setPreferredSize(new Dimension(800,120));
        panelPiePag.setMaximumSize(new Dimension(Integer.MAX_VALUE,120));




    }

    private void btnBorrarAction() {
        lbDescripcion.setText("");
        cbEjemplos.setSelectedIndex(0);
        modelo.setRowCount(0);
        txtSolucion.setText("");
    }

    private void btnCalcular() {
        int[] vectorPropuestoS = {0,0,0,0,0};
        int ejemploSelccionado = cbEjemplos.getSelectedIndex() - 1;

        //Borra los valores anteriormente puestos en la tabla
        modelo.setRowCount(0);
        if(ejemploSelccionado < 0){
            JOptionPane.showMessageDialog(null,"Seleccione un ejemplo.");
            return;
        }
    }

    private void btnseleccionarEj(String[] sistemas) {
        int opcion = cbEjemplos.getSelectedIndex();
        if (opcion > 0 && opcion <= sistemas.length){
            switch (opcion){
                case 1:
                    Ejemplo2V ej2 = new Ejemplo2V();
                    ej2.toString();
                    lbDescripcion.setText("<html> Sistema de "+sistemas[opcion - 1]+"<br>"+ej2+"</html>");
                    break;
                case 2:
                    Ejemplo3V ej3 = new Ejemplo3V();
                    ej3.toString();
                    lbDescripcion.setText("<html> Sistema de "+sistemas[opcion - 1]+"<br>"+ej3+"</html>");
                    break;
                case 3:
                    Ejemplo4V ej4 = new Ejemplo4V();
                    ej4.toString();
                    lbDescripcion.setText("<html> Sistema de "+sistemas[opcion - 1]+"<br>"+ej4+"</html>");
                    break;
                case 4:
                    Ejemplo5V ej5 = new Ejemplo5V();
                    ej5.toString();
                    lbDescripcion.setText("<html> Sistema de "+sistemas[opcion - 1]+"<br>"+ej5+"</html>");
                    break;
                default:
                    lbDescripcion.setText("Seleccione una opción");
            }
        }else{
            lbDescripcion.setText("Ingrese una opción válida");
        }

        tablaFormat = formatoRetorno(jac.(ejemploSelccionado,intervaloA,intervaloB));
    }

    public ArrayList<String[]> formatoRetorno(ArrayList<double[]> tablaRetorno){
        ArrayList<String[]> tablaConFormato = new ArrayList<>();

        for(int i = 0; i < tablaRetorno.size(); i++){
            double[]  filaAux = tablaRetorno.get(i);
            String[] filaStrAux = new String[filaAux.length];
            for(int j = 0; j < filaAux.length;j++){
                filaStrAux[j] = String.format("%.4f",filaAux[j]);
            }
            tablaConFormato.add(filaStrAux);
        }

        return tablaConFormato;
    }
    //Getter
    public JButton getBtnSalir() {
        return btnSalir;
    }
}
}
