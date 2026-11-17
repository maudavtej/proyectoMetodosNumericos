package frontend.PanelesMetodos;

import Matrices.Matriz;
import Raices.*;
import Unidad4.Doolittle;
import Unidad5.Potencia;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelPotencia extends JPanel{
    //Panel principal
    JPanel panelPrincipal;
    //Instanceamos el metodo a usar
    private Potencia potencia = new Potencia();

    //Panel titulo
    private JLabel lbTitulo;
    //PanelDescripcion
    private JLabel lbDescripcion;
    //Panel Caputra de datos
    JPanel panelCapturaN;
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

    private JTextField txtA21 = new JTextField(5);
    private JTextField txtA22 = new JTextField(5);
    private JTextField txtA23 = new JTextField(5);
    private JTextField txtA24 = new JTextField(5);
    private JTextField txtA25 = new JTextField(5);

    private JTextField txtA31 = new JTextField(5);
    private JTextField txtA32 = new JTextField(5);
    private JTextField txtA33 = new JTextField(5);
    private JTextField txtA34 = new JTextField(5);
    private JTextField txtA35 = new JTextField(5);

    private JTextField txtA41 = new JTextField(5);
    private JTextField txtA42 = new JTextField(5);
    private JTextField txtA43 = new JTextField(5);
    private JTextField txtA44 = new JTextField(5);
    private JTextField txtA45 = new JTextField(5);

    private JTextField txtA51 = new JTextField(5);
    private JTextField txtA52 = new JTextField(5);
    private JTextField txtA53 = new JTextField(5);
    private JTextField txtA54 = new JTextField(5);
    private JTextField txtA55 = new JTextField(5);

    private JTextField[][] txtSistemaCompleto = {
            {txtA11, txtA12, txtA13, txtA14, txtA15},
            {txtA21, txtA22, txtA23, txtA24, txtA25},
            {txtA31, txtA32, txtA33, txtA34, txtA35},
            {txtA41, txtA42, txtA43, txtA44, txtA45},
            {txtA51, txtA52, txtA53, txtA54, txtA55}};

    private JTextField txtV1 = new JTextField();
    private JTextField txtV2 = new JTextField();
    private JTextField txtV3 = new JTextField();
    private JTextField txtV4 = new JTextField();
    private JTextField txtV5 = new JTextField();

    //Panel Vector inicial
    JPanel panelVectorInicial = new JPanel();
    private JLabel lbVInicial = new JLabel("Vector inicial: ");
    private JTextField[] txtVectorInicial = {txtV1, txtV2, txtV3, txtV4, txtV5};

    //PanelResultado
    JPanel panelResultado;
    private JLabel lbResultado = new JLabel("Resultado: ");
    private JLabel lbValorPropioDominante = new JLabel("Valor propio dominante: ");
    private JLabel lbVectorPropio = new JLabel("Vector propio aproximado: ");
    private JLabel lbIteraciones = new JLabel("Iteraciones: ");
    private JTextField txtValorPropioDom = new JTextField(5);
    private JTextField txtVectorPropio = new JTextField(10);
    private JTextField txtIteraciones = new JTextField(5);

    //Panel opciones
    JPanel panelOpciones;
    private JButton btnLimpiar;
    private JButton btnCaclular;
    private JButton btnSalir;

    public PanelPotencia(){
        setLayout(new BorderLayout());
        TitledBorder border = BorderFactory.createTitledBorder("");
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        JPanel panelTitulo = new JPanel();
        JPanel panelDescripcion = new JPanel();
        JPanel panelCapturaSistema = new JPanel();
        panelCapturaN = new JPanel();
        panelOpciones = new JPanel();
        panelResultado = new JPanel();


        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        panelPrincipal.add(panelTitulo);
        panelPrincipal.add(panelDescripcion);
        panelPrincipal.add(panelCapturaN);
        panelPrincipal.add(panelCapturaSistema);
        panelPrincipal.add(panelVectorInicial);
        panelPrincipal.add(panelResultado);
        panelPrincipal.add(panelOpciones);

        add(panelPrincipal);

        //Misma alineacion horizontal para los 4 paneles; si no, BoxLayout desplaza alguno
        for (JPanel p : new JPanel[]{panelTitulo, panelDescripcion, panelCapturaSistema, panelCapturaN, panelVectorInicial,panelResultado, panelOpciones}) {
            p.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        //*PANEL TITULO*//
        lbTitulo = new JLabel("METODO POTENCIA");
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
        panelDescripcion.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        lbDescripcion = new JLabel("Ingrese la matriz A: ");
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
        panelMostrarN.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelMostrarN.setBackground(new Color(233, 235, 240));
        lbTamanioSistema = new JLabel("Tamaño de la matriz (nxn):");
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
        panelCapturaN.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
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

        //*PANEL Vector Inicial*//
        actualizarPanelVecInicial(n);
        panelVectorInicial.setBackground(new Color(233, 235, 240));
        panelVectorInicial.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panelVectorInicial.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));

        //*PANEL RESULTADO*//
        panelResultado.setBackground(new Color(233, 235, 240));
        panelResultado.setLayout(new BoxLayout(panelResultado,BoxLayout.Y_AXIS));

        JPanel panelSubtituloRes = new JPanel();
        panelSubtituloRes.setBackground(new Color(233, 235, 240));
        panelSubtituloRes.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelSubtituloRes.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 30));
        panelSubtituloRes.add(lbResultado);
        panelSubtituloRes.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));

        JPanel panelResultados = new JPanel();
        panelResultados.setBackground(new Color(233, 235, 240));
        panelResultados.setLayout(new GridLayout(3,2,10,10));
        panelResultados.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 30));
        panelResultados.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE));

        txtValorPropioDom.setEditable(false);
        txtValorPropioDom.setFocusable(false);

        txtVectorPropio.setEditable(false);
        txtVectorPropio.setFocusable(false);

        txtIteraciones.setEditable(false);
        txtIteraciones.setFocusable(false);

        panelResultados.add(lbValorPropioDominante);
        panelResultados.add(txtValorPropioDom);
        panelResultados.add(lbVectorPropio);
        panelResultados.add(txtVectorPropio);
        panelResultados.add(lbIteraciones);
        panelResultados.add(txtIteraciones);

        panelResultado.add(panelSubtituloRes);
        panelResultado.add(panelResultados);

        //*PANEL OPCIONES*//
        panelOpciones.setBackground(new Color(233, 235, 240));
        panelOpciones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelOpciones.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        btnSalir = new JButton("SALIR");
        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.addActionListener(e -> btnLimpiar());
        btnCaclular = new JButton("CALCULAR");
        btnCaclular.addActionListener(e -> btnCalcular());


        panelOpciones.add(btnSalir);
        panelOpciones.add(btnLimpiar);
        panelOpciones.add(btnCaclular);

        //Definir el tamanio de todos los paneles
        panelTitulo.setPreferredSize(new Dimension(800, 90));
        panelTitulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        panelDescripcion.setPreferredSize(new Dimension(800, 30));
        panelDescripcion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        panelCapturaSistema.setPreferredSize(new Dimension(800, 250));
        panelCapturaSistema.setMaximumSize(new Dimension(Integer.MAX_VALUE, 250));

        panelCapturaN.setPreferredSize(new Dimension(800, 55));
        panelCapturaN.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));

        panelVectorInicial.setPreferredSize(new Dimension(800, 50));
        panelVectorInicial.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        panelResultado.setPreferredSize(new Dimension(800,90));
        panelResultado.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE));

        panelOpciones.setPreferredSize(new Dimension(800, 50));
        panelOpciones.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
    }

    //Metodos de los botones
    private void btnSiguienteN() {
        if (n < 5) {
            n++;
        }
        txtTamanioSistema.setText(String.valueOf(n));
        actualizarPanelSistema(n);
        actualizarPanelVecInicial(n);
    }
    private void btntAnteriorN() {
        if (n > 2) {
            n--;
        }
        txtTamanioSistema.setText(String.valueOf(n));
        actualizarPanelSistema(n);
        actualizarPanelVecInicial(n);
    }
    private void btnLimpiar() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txtSistemaCompleto[i][j].setText("");

            }
            txtVectorInicial[i].setText("1");
        }
    }
    private void btnCalcular() {
        String[] resultadoStr = new String[n];
        double[][] matriz = obtenerMatriz();
        double[] vInicial = obtenerVectorInicial();
        double valorPropioDom;
        int iteraciones;

        if(matriz ==  null || vInicial == null){
            return;
        }
        resultadoStr = potencia.potencia(matriz,vInicial);
        if(resultadoStr == null){
            return;
        }

        valorPropioDom = potencia.getLambda();
        iteraciones = potencia.getContador();
        actualizarPanelResultado(valorPropioDom,resultadoStr,iteraciones);
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
            }
            panelSistema.add(fila);
        }

        panelSistema.revalidate();
        panelSistema.repaint();
    }
    private void actualizarPanelVecInicial(int n){
        panelVectorInicial.removeAll();
        panelVectorInicial.add(lbVInicial);
        for(int i = 0; i < n; i++){
            txtVectorInicial[i].setPreferredSize(new Dimension(60, 25));
            txtVectorInicial[i].setText("1");
            panelVectorInicial.add(txtVectorInicial[i]);
        }
        panelVectorInicial.revalidate();
        panelVectorInicial.repaint();
    }
    private void actualizarPanelResultado(double valorPropioDom, String[] vector,int iteracioens){
        StringBuilder vectorStr = new StringBuilder("(");
        for(int i = 0; i < n; i++){
            vectorStr.append(vector[i]);

            if(i < n - 1){
                vectorStr.append(", ");
            }
        }
        vectorStr.append(")");
        String resultado = vectorStr.toString();




        txtIteraciones.setText(String.valueOf(iteracioens));
        txtValorPropioDom.setText(String.format("%.4f",valorPropioDom));
        txtVectorPropio.setText(resultado);

    }
    private double[][] obtenerMatriz(){
        double[][] matriz = new double[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                try {
                    matriz[i][j] =  Double.parseDouble(txtSistemaCompleto[i][j].getText());
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Ingrese datos correctos del sistema.");
                    btnLimpiar();
                    return null;
                }
            }
        }

        return matriz;
    }
    private double[] obtenerVectorInicial(){
        double[] vIinicial = new double[n];
        for(int i = 0; i < n; i++){
            try {
                vIinicial[i] = Double.parseDouble(txtVectorInicial[i].getText());
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Datos incorrectos intente de nuevo");
                limpiarVectorInicial();
                return null;
            }
        }
        return vIinicial;
    }
    private void limpiarVectorInicial(){
        for(int i = 0; i < n; i++){
            txtVectorInicial[i].setText("1");
        }
    }
}

