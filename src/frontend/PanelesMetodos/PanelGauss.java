package frontend.PanelesMetodos;

import Matrices.Gauss;
import Matrices.Matriz;
import Raices.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelGauss extends JPanel {
    //Instanceamos el metodo a usar
    private Gauss gauss = new Gauss();

    //Panel titulo
    private JLabel lbTitulo;
    //PanelDescripcion
    private JLabel lbDescripcion;
    //Panel Caputra de datos
    private JLabel lbTamanioSistema;
    private JTextField txtTamanioSistema;
    private JButton btnSiguienteN;
    private JButton btnAnteriorN;
    private int n = 5;
    //Panel captura sistema
    private JPanel panelSistema;
    private JTextField txtA11 = new JTextField(5);
    private JTextField txtA12 = new JTextField(5);
    private JTextField txtA13 = new JTextField(5);
    private JTextField txtA14 = new JTextField(5);
    private JTextField txtA15 = new JTextField(5);
    private JTextField txtA16 = new JTextField(5);

    private JTextField txtA21 = new JTextField(5);
    private JTextField txtA22 = new JTextField(5);
    private JTextField txtA23 = new JTextField(5);
    private JTextField txtA24 = new JTextField(5);
    private JTextField txtA25 = new JTextField(5);
    private JTextField txtA26 = new JTextField(5);

    private JTextField txtA31 = new JTextField(5);
    private JTextField txtA32 = new JTextField(5);
    private JTextField txtA33 = new JTextField(5);
    private JTextField txtA34 = new JTextField(5);
    private JTextField txtA35 = new JTextField(5);
    private JTextField txtA36 = new JTextField(5);

    private JTextField txtA41 = new JTextField(5);
    private JTextField txtA42 = new JTextField(5);
    private JTextField txtA43 = new JTextField(5);
    private JTextField txtA44 = new JTextField(5);
    private JTextField txtA45 = new JTextField(5);
    private JTextField txtA46 = new JTextField(5);

    private JTextField txtA51 = new JTextField(5);
    private JTextField txtA52 = new JTextField(5);
    private JTextField txtA53 = new JTextField(5);
    private JTextField txtA54 = new JTextField(5);
    private JTextField txtA55 = new JTextField(5);
    private JTextField txtA56 = new JTextField(5);

    private JTextField[][] txtSistemaCompleto = {
            {txtA11, txtA12, txtA13, txtA14, txtA15, txtA16},
            {txtA21, txtA22, txtA23, txtA24, txtA25, txtA26},
            {txtA31, txtA32, txtA33, txtA34, txtA35, txtA36},
            {txtA41, txtA42, txtA43, txtA44, txtA45, txtA46},
            {txtA51, txtA52, txtA53, txtA54, txtA55, txtA56}};

    private JTextField txtSolX = new JTextField();
    private JTextField txtSolY = new JTextField();
    private JTextField txtSolZ = new JTextField();
    private JTextField txtSolW = new JTextField();
    private JTextField txtSolG = new JTextField();

    //Panel Solucion
    JPanel panelResultado = new JPanel();
    private JLabel lbResultado = new JLabel("Solución: ");
    private JTextField[] txtVectorSolucion = {txtSolX, txtSolY, txtSolZ, txtSolW, txtSolG};

    //Panel opciones
    private JButton btnLimpiar;
    private JButton btnCaclular;
    private JButton btnSalir;

    public PanelGauss() {
        setLayout(new BorderLayout());
        TitledBorder border = BorderFactory.createTitledBorder("");
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        JPanel panelTitulo = new JPanel();
        JPanel panelDescripcion = new JPanel();
        JPanel panelCapturaSistema = new JPanel();
        JPanel panelCapturaN = new JPanel();
        JPanel panelOpciones = new JPanel();

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        panelPrincipal.add(panelTitulo);
        panelPrincipal.add(panelDescripcion);
        panelPrincipal.add(panelCapturaSistema);
        panelPrincipal.add(panelCapturaN);
        panelPrincipal.add(panelResultado);
        panelPrincipal.add(panelOpciones);

        add(panelPrincipal);

        //Misma alineacion horizontal para los 4 paneles; si no, BoxLayout desplaza alguno
        for (JPanel p : new JPanel[]{panelTitulo, panelDescripcion, panelCapturaSistema, panelCapturaN, panelResultado, panelOpciones}) {
            p.setAlignmentX(Component.LEFT_ALIGNMENT);
        }
        //*PANEL TITULO*//
        lbTitulo = new JLabel("METODO DE GAUSS");
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
        lbDescripcion.setFont(new Font("Arial", Font.BOLD, 13));
        panelDescripcion.add(lbDescripcion, BorderLayout.WEST);

        //*PANEL CAPTURA DE DATOS*//
        //Panel para los botones
        JPanel panelBotonesN = new JPanel();
        panelBotonesN.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
        panelBotonesN.setBackground(new Color(233, 235, 240));
        btnSiguienteN = new JButton(">");
        btnSiguienteN.setMaximumSize(new Dimension(5, 20));
        btnAnteriorN = new JButton("<");
        btnSiguienteN.setMaximumSize(new Dimension(5, 20));
        btnSiguienteN.addActionListener(e -> btnSiguienteN());
        btnAnteriorN.addActionListener(e -> btntAnteriorN());
        //Panel mostrarN
        JPanel panelMostrarN = new JPanel();
        panelMostrarN.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
        panelMostrarN.setBackground(new Color(233, 235, 240));
        lbTamanioSistema = new JLabel("Tamaño del sistema de ecuaciones (nxn):");
        txtTamanioSistema = new JTextField(1);
        txtTamanioSistema.setText("" + n);
        txtTamanioSistema.setEditable(false);
        txtTamanioSistema.setFocusable(false); // quita el cursor parpadeante
        txtTamanioSistema.setMaximumSize(new Dimension(10, 10));
        panelMostrarN.add(lbTamanioSistema);
        panelMostrarN.add(txtTamanioSistema);
        panelMostrarN.add(btnAnteriorN);
        panelMostrarN.add(btnSiguienteN);

        panelCapturaN.setLayout(new GridLayout(2, 1, 15, 0));
        panelCapturaN.setBackground(new Color(233, 235, 240));
        panelCapturaN.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        panelCapturaN.add(panelMostrarN);

        //**PANEL CAPTURA SISTEMA*//
        panelCapturaSistema.setLayout(new BorderLayout());
        panelCapturaSistema.setBackground(new Color(233, 235, 240));
        panelCapturaSistema.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        //Panel sistema
        panelSistema = new JPanel();
        actualizarPanelSistema(n);
        panelSistema.setBackground(new Color(233, 235, 240));

        panelCapturaSistema.add(panelSistema, BorderLayout.CENTER);

        //*PANEL RESULTADO*//
        actualizarPanelResultado(n);
        panelResultado.setBackground(new Color(233, 235, 240));
        panelResultado.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panelResultado.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));


        //*PANEL OPCIONES*//
        panelOpciones.setBackground(new Color(233, 235, 240));
        panelOpciones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelOpciones.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.addActionListener(e -> btnLimpiar());
        btnCaclular = new JButton("CALCULAR");
        btnCaclular.addActionListener(e -> btnCalcular());
        btnSalir = new JButton("SALIR");

        panelOpciones.add(btnSalir);
        panelOpciones.add(btnLimpiar);
        panelOpciones.add(btnCaclular);

        //Definir el tamanio de todos los paneles
        panelTitulo.setPreferredSize(new Dimension(800, 90));
        panelTitulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        panelDescripcion.setPreferredSize(new Dimension(800, 30));
        panelDescripcion.setPreferredSize(new Dimension(Integer.MAX_VALUE, 30));

        panelCapturaSistema.setPreferredSize(new Dimension(800, 250));
        panelCapturaSistema.setMaximumSize(new Dimension(Integer.MAX_VALUE, 250));

        panelCapturaN.setPreferredSize(new Dimension(800, 100));
        panelCapturaN.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        panelResultado.setPreferredSize(new Dimension(800, 50));
        panelResultado.setPreferredSize(new Dimension(Integer.MAX_VALUE, 50));

        panelOpciones.setPreferredSize(new Dimension(800, 70));
        panelOpciones.setMaximumSize(new Dimension(Integer.MAX_VALUE,70));


    }

    //Metodos de los botones
    private void btnSiguienteN() {
        if (n < 5) {
            n++;
        }
        txtTamanioSistema.setText(String.valueOf(n));
        actualizarPanelSistema(n);
        actualizarPanelResultado(n);
    }
    private void btntAnteriorN() {
        if (n > 2) {
            n--;
        }
        txtTamanioSistema.setText(String.valueOf(n));
        actualizarPanelSistema(n);
        actualizarPanelResultado(n);
    }
    private void btnLimpiar() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txtSistemaCompleto[i][j].setText("");
            }
            txtSistemaCompleto[i][5].setText("");
            txtVectorSolucion[i].setText("");
        }
    }
    private void btnCalcular() {
        String[] resultadoStr = new String[n];
        double[][] matriz = obtenerMatriz();
        if(matriz ==  null){
            return;
        }
        resultadoStr = gauss.gauss(matriz);

        for(int i  = 0; i < n; i++){
            txtVectorSolucion[i].setText(resultadoStr[i]);
        }
    }

    //Getter
    public JButton getBtnSalir() {
        return btnSalir;
    }

    private void actualizarPanelSistema(int n) {
        panelSistema.removeAll();
        panelSistema.setLayout(new GridLayout(n, 1, 0, 10));

        for (int i = 0; i < n; i++) {
            JPanel fila = new JPanel();
            fila.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
            fila.setBackground(new Color(233, 235, 240));
            for (int j = 0; j < n; j++) {
                txtSistemaCompleto[i][j].setPreferredSize(new Dimension(15, 20));
                fila.add(txtSistemaCompleto[i][j]);
                String operador = (j == n - 1) ? " = " : " + ";
                fila.add(new JLabel(String.valueOf(Matriz.INCOGNITAS[j]) + operador));
            }
            fila.add(txtSistemaCompleto[i][5]);
            panelSistema.add(fila);
        }

        panelSistema.revalidate();
        panelSistema.repaint();
    }
    private void actualizarPanelResultado(int n){
        panelResultado.removeAll();
        panelResultado.add(lbResultado);
        for(int i = 0; i < n; i++){
            txtVectorSolucion[i].setPreferredSize(new Dimension(60, 25));
            panelResultado.add(new JLabel(Matriz.INCOGNITAS[i]+" = "));
            panelResultado.add(txtVectorSolucion[i]);
        }
        panelResultado.revalidate();
        panelResultado.repaint();
    }
    private double[][] obtenerMatriz(){
        double[][] matriz = new double[n][n + 1];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                try {
                    matriz[i][j] =  Double.parseDouble(txtSistemaCompleto[i][j].getText());
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Ingrese datos correctos");
                    btnLimpiar();
                    return null;
                }
            }
            try {
                matriz[i][n] =  Double.parseDouble(txtSistemaCompleto[i][5].getText());
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Ingrese datos correctos");
                btnLimpiar();
                return null;
            }
        }

        return matriz;
    }
}