package frontend.PanelesMetodos;

import Matrices.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PanelGaussSeidel extends JPanel {

    //======================================================
    // Etiquetas
    private JLabel lbTitulo;
    private JLabel lbEjemplos;
    private JLabel lbDescripcion;
    private JLabel lbSolucion;
    //==========================================================
    private JComboBox<String> cbEjemplos;
    //==========================================================
    JTextArea txtSolucion;
    //========================================================
    // BOTONES
    private JButton btnseleccionarEj;
    private JButton btnCalcular;
    private JButton btnSalir;
    private JButton btnBorrar;
    //====================================================
    //TABLA
    private JTable tablaGS;
    private DefaultTableModel modelo;
    //======================================================
    private GaussSeidel gs = new GaussSeidel();
    private Matriz matrizActual;

    public PanelGaussSeidel(){
        setLayout(new BorderLayout());
        TitledBorder border = BorderFactory.createTitledBorder("");
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        JPanel panelTitulo = new JPanel();
        JPanel panelEjemplos = new JPanel();
        JPanel panelDescripcion = new JPanel();
        JPanel panelTabla = new JPanel();
        JPanel panelPiePag = new JPanel();

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.add(panelTitulo);
        panelPrincipal.add(panelEjemplos);
        panelPrincipal.add(panelDescripcion);
        panelPrincipal.add(panelTabla);
        panelPrincipal.add(panelPiePag);
        add(panelPrincipal);

        for (JPanel p : new JPanel[]{panelTitulo, panelEjemplos, panelDescripcion, panelTabla, panelPiePag}) {
            p.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        //===================================================
        //TITULO
        lbTitulo = new JLabel("MÉTODO DE GAUSS-SEIDEL");
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 40));
        lbTitulo.setForeground(Color.WHITE);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setVerticalAlignment(SwingConstants.CENTER);
        panelTitulo.setBackground(new Color(0, 82, 158));
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.add(lbTitulo, BorderLayout.CENTER);

        //==================================================
        //EJEMPLOS
        panelEjemplos.setLayout(new BorderLayout());
        panelEjemplos.setBackground(new Color(233, 235, 240));
        panelEjemplos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        String[] sistemas = {"Sistema de ecuaciones de 2 incógnitas", "Sistema de ecuaciones de 3 incógnitas", "Sistema de ecuaciones de 4 incógnitas", "Sistema de ecuaciones de 5 incógnitas"
        };

        cbEjemplos = new JComboBox<>();
        cbEjemplos.addItem("Seleccione un ejemplo");
        for (String s : sistemas) cbEjemplos.addItem("<html>" + s + "</html>");

        lbEjemplos = new JLabel("Ejemplos: ");
        btnseleccionarEj = new JButton("SELECCIONAR");
        btnseleccionarEj.addActionListener(e -> btnSeleccionarEj(sistemas));

        panelEjemplos.add(lbEjemplos, BorderLayout.WEST);
        panelEjemplos.add(cbEjemplos, BorderLayout.CENTER);
        panelEjemplos.add(btnseleccionarEj, BorderLayout.EAST);

        //===================================================
        //DESCRIPCIÓN
        panelDescripcion.setLayout(new BorderLayout());
        panelDescripcion.setBackground(new Color(233, 235, 240));
        panelDescripcion.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        lbDescripcion = new JLabel("");
        lbDescripcion.setFont(new Font("Arial", Font.PLAIN, 13));
        panelDescripcion.add(lbDescripcion, BorderLayout.CENTER);

        btnCalcular = new JButton("CALCULAR");
        btnCalcular.addActionListener(e -> btnCalcular());
        panelDescripcion.add(btnCalcular, BorderLayout.EAST);

        //===================================================
        //TABLA
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBackground(new Color(233, 235, 240));
        panelTabla.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        String[] columnas = {"N", "x", "y", "z", "w", "g"};
        modelo = new DefaultTableModel(columnas, 0);
        tablaGS = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tablaGS);
        panelTabla.add(scroll, BorderLayout.CENTER);

        //===================================================
        //PANEL INFERIOR
        panelPiePag.setLayout(new BorderLayout());
        JPanel soluciones = new JPanel();
        JPanel salidas    = new JPanel();
        panelPiePag.add(soluciones, BorderLayout.NORTH);
        panelPiePag.add(salidas, BorderLayout.CENTER);

        soluciones.setLayout(new BorderLayout());
        soluciones.setBackground(new Color(233, 235, 240));
        soluciones.setBorder(BorderFactory.createEmptyBorder(2, 30, 2, 30));

        btnBorrar = new JButton("BORRAR");
        btnBorrar.addActionListener(e -> btnBorrarAction());
        btnSalir  = new JButton("REGRESAR");

        soluciones.add(btnSalir, BorderLayout.WEST);
        soluciones.add(btnBorrar, BorderLayout.EAST);

        salidas.setLayout(new BoxLayout(salidas, BoxLayout.X_AXIS));
        salidas.setBackground(new Color(233, 235, 240));
        salidas.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        lbSolucion = new JLabel("Convergencia: ");
        txtSolucion = new JTextArea("");
        txtSolucion.setFocusable(false);
        txtSolucion.setLineWrap(true);
        txtSolucion.setWrapStyleWord(true);
        txtSolucion.setEditable(false);
        txtSolucion.setFont(new Font("Arial", Font.PLAIN, 13));

        salidas.add(lbSolucion);
        //Scroll en la solución
        JScrollPane scrollSolucion = new JScrollPane(txtSolucion);
        scrollSolucion.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollSolucion.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollSolucion.setBorder(null);
        scrollSolucion.setPreferredSize(new Dimension(500, 60));
        scrollSolucion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        salidas.add(scrollSolucion);

        //===================================================
        //TAMAÑOS
        panelTitulo.setPreferredSize(new Dimension(800, 90));
        panelTitulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        panelEjemplos.setPreferredSize(new Dimension(800, 70));
        panelEjemplos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

        panelDescripcion.setPreferredSize(new Dimension(800, 120));
        panelDescripcion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        panelTabla.setPreferredSize(new Dimension(800, 359));
        panelTabla.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        panelPiePag.setPreferredSize(new Dimension(800, 120));
        panelPiePag.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));
    }

    private void btnBorrarAction() {
        lbDescripcion.setText("");
        cbEjemplos.setSelectedIndex(0);
        modelo.setRowCount(0);
        txtSolucion.setText("");
        matrizActual = null;
    }

    private void btnCalcular() {
        if (matrizActual == null) {
            JOptionPane.showMessageDialog(null, "Primero seleccione un ejemplo.");
            return;
        }
        try {
            modelo.setRowCount(0);

            ArrayList<double[]> tabla = gs.funcionGaussSeidel(matrizActual);
            ArrayList<String[]> tablaFormat = formatoRetorno(tabla);

            int nIncog = matrizActual.getN();
            for (int i = 0; i < tablaFormat.size(); i++) {
                String[] f = tablaFormat.get(i);
                String[] fila = new String[nIncog + 1];
                fila[0] = String.valueOf(i + 1);
                for (int j = 0; j < nIncog; j++)
                    fila[j + 1] = f[j];
                modelo.addRow(fila);
            }

            double[] sol = gs.getSolucionFinal();
            StringBuilder sb = new StringBuilder();
            sb.append("Convergió en ").append(gs.getIteracionesUsadas()).append(" iteraciones.\n");
            for (int i = 0; i < sol.length; i++) {
                sb.append(Matriz.INCOGNITAS[i]).append(" = ")
                        .append(String.format("%.8f", sol[i])).append("\n");
            }
            txtSolucion.setText(sb.toString());

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void btnSeleccionarEj(String[] sistemas) {
        int opcion = cbEjemplos.getSelectedIndex();
        if (opcion <= 0 || opcion > sistemas.length) {
            JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
            return;
        }
        switch (opcion) {
            case 1:
                matrizActual = new Ejemplo2V().getMatriz();
                break;
            case 2:
                matrizActual = new Ejemplo3V().getMatriz();
                break;
            case 3:
                matrizActual = new Ejemplo4V().getMatriz();
                break;
            case 4:
                matrizActual = new Ejemplo5V().getMatriz();
                break;
            default:
                JOptionPane.showMessageDialog(null,"Matriz fuera de rango");
                return;
        }

        lbDescripcion.setText("<html>" + sistemas[opcion - 1] + "<br>" + matrizActual.toString().replace("\n", "<br>") + "</html>");
        if (!gs.estrictaDominante(matrizActual)) {
            lbDescripcion.setText("No es estrictamente dominante");
        }
        int n = matrizActual.getN();
        String[] actualizaColumn = new String[n + 1];
        actualizaColumn[0] = "N";
        for (int i = 0; i < n; i++) {
            actualizaColumn[i + 1] = Matriz.INCOGNITAS[i];
        }
        modelo.setColumnIdentifiers(actualizaColumn);
        modelo.setRowCount(0);
        txtSolucion.setText("");
    }

    public ArrayList<String[]> formatoRetorno(ArrayList<double[]> tablaRetorno) {
        ArrayList<String[]> tablaConFormato = new ArrayList<>();
        for (double[] filaAux : tablaRetorno) {
            String[] filaStrAux = new String[filaAux.length];
            for (int j = 0; j < filaAux.length; j++) {
                filaStrAux[j] = String.format("%.8f", filaAux[j]);
            }
            tablaConFormato.add(filaStrAux);
        }
        return tablaConFormato;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }
}