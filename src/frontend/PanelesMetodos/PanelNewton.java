package frontend.PanelesMetodos;

import Raices.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PanelNewton extends JPanel{
    //Panel titulo
    private JLabel lbTitulo;
    //Panel Seleccion Ejemplo
    private JComboBox<String> cbEjemplos;
    private JLabel lbEjemplos;
    private JButton btnSeleccionar;
    //Panel descripcion
    private JLabel lbDescripcion;
    private JTextArea txtDescripcion;
    //Panel Caputra de datos
    private JLabel lbValorInicial;
    private JTextArea txtValorInicial;
    private JButton btnCalcular;
    //Panel modelo
    private JTable tablaBiseccion;
    private DefaultTableModel modelo;
    //Panel Opciones
    private JButton btnBorrar;
    private JButton btnSalir;
    private JLabel lbSolucion;
    private JTextArea txtSolucion;

    //Instanceamos el metodo a usar
    MetodoNewton newton = new MetodoNewton();
    private ArrayList<String[]> tablaFormat;
    private String solucionStrFormat;

    //Constructor
    public PanelNewton(){
        setLayout(new BorderLayout());
        TitledBorder border = BorderFactory.createTitledBorder("");
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        JPanel panelTitulo = new JPanel();
        JPanel panelEjemplos = new JPanel();
        JPanel panelDescripcion = new JPanel();
        JPanel panelCapturaDatos = new JPanel();
        JPanel panelTabla = new JPanel();
        JPanel panelFinal = new JPanel();

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));

        panelPrincipal.add(panelTitulo);
        panelPrincipal.add(panelEjemplos);
        panelPrincipal.add(panelDescripcion);
        panelPrincipal.add(panelCapturaDatos);
        panelPrincipal.add(panelTabla);
        panelPrincipal.add(panelFinal);

        add(panelPrincipal);

        //Misma alineacion horizontal para los 4 paneles; si no, BoxLayout desplaza alguno
        for (JPanel p : new JPanel[]{panelTitulo,panelEjemplos,panelDescripcion,panelCapturaDatos,panelTabla,panelFinal}) {
            p.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        //*PANEL TITULO*//
        lbTitulo = new JLabel("METODO DE NEWTON");
        lbTitulo.setFont(new Font("Arial",Font.BOLD,40));//Tipo de letra
        lbTitulo.setForeground(Color.WHITE);//Color de la letra
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setVerticalAlignment(SwingConstants.CENTER);
        panelTitulo.setBackground(new Color(0,82,158));
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.add(lbTitulo,BorderLayout.CENTER);

        //*PANEL SELECCION EJEMPLO*//
        panelEjemplos.setLayout(new BorderLayout());
        panelEjemplos.setLayout(new BorderLayout());
        panelEjemplos.setBackground(new Color(233,235,240));
        panelEjemplos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        String[] funciones = {Ejemplo1.toStringFunc(), Ejemplo2.toStringFunc(), Ejemplo3.toStringFunc(), Ejemplo4.toStringFunc()};
        cbEjemplos = new JComboBox<>();
        cbEjemplos.addItem("Seleccione un ejemplo");
        for (int i  = 0; i < funciones.length; i++){
            cbEjemplos.addItem("<html>"+funciones[i]+"</html>");
        }
        lbEjemplos = new JLabel("Ejemplos: ");
        btnSeleccionar = new JButton("SELECCIONAR");
        //btnSeleccionar
        btnSeleccionar.addActionListener(e -> btnSeleccionarAction(funciones));

        panelEjemplos.add(lbEjemplos,BorderLayout.WEST);
        panelEjemplos.add(cbEjemplos,BorderLayout.CENTER);
        panelEjemplos.add(btnSeleccionar,BorderLayout.EAST);

        //*PANEL DESCRIPCION*//
        panelDescripcion.setLayout(new BorderLayout());
        panelDescripcion.setBackground(new Color(233,235,240));
        panelDescripcion.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        lbDescripcion = new JLabel("");
        lbDescripcion.setFont(new Font("Arial",Font.PLAIN,13));

        panelDescripcion.add(lbDescripcion,BorderLayout.CENTER);

        //*PANEL CAPTURA DE DATOS*//
        panelCapturaDatos.setLayout(new BoxLayout(panelCapturaDatos,BoxLayout.X_AXIS));
        panelCapturaDatos.setBackground(new Color(233,235,240));
        panelCapturaDatos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        lbValorInicial = new JLabel("Valor inicial: ");
        txtValorInicial =  new JTextArea();
        btnCalcular = new JButton("CALCULAR");
        panelCapturaDatos.add(lbValorInicial);
        panelCapturaDatos.add(txtValorInicial);
        panelCapturaDatos.add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcularAction());

        //Panel tabla
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBackground(new Color(233,235,240));
        panelTabla.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 60));

        String[] columnas = {"n","xn","f(xn)","f´(xn)"};
        modelo  = new DefaultTableModel(columnas,0);
        tablaBiseccion = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tablaBiseccion);
        panelTabla.add(scroll,BorderLayout.CENTER);

        //*PANEL FINAL*/
        panelFinal.setLayout(new BoxLayout(panelFinal,BoxLayout.X_AXIS));

        JPanel panelOpciones = new JPanel();
        JPanel panelSolucion =  new JPanel();

        panelFinal.add(panelSolucion);
        panelFinal.add(panelOpciones);

        //*Panel opciones*/
        panelOpciones.setLayout(new BorderLayout());
        panelOpciones.setBackground(new Color(233,235,240));
        panelOpciones.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        btnBorrar = new JButton("BORRAR");
        btnSalir = new JButton("SALIR");

        btnBorrar.addActionListener(e -> btnBorrarAction());

        panelOpciones.add(btnSalir,BorderLayout.WEST);
        panelOpciones.add(btnBorrar,BorderLayout.EAST);
        //*Panel Solucion*/
        panelSolucion.setLayout(new BoxLayout(panelSolucion,BoxLayout.X_AXIS));
        panelSolucion.setBackground(new Color(233,235,240));
        panelSolucion.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        lbSolucion = new JLabel("Solucion: ");
        txtSolucion = new JTextArea("");
        txtSolucion.setFocusable(false); // quita el cursor parpadeante
        txtSolucion.setLineWrap(true);//Ajusta automaticamente el texto al ancho disponible
        txtSolucion.setWrapStyleWord(true);//Evita cortar palabras a la mitad
        txtSolucion.setEditable(false);
        txtSolucion.setFont(new Font("Arial",Font.PLAIN,13));

        panelSolucion.add(lbSolucion,BorderLayout.WEST);
        panelSolucion.add(txtSolucion,BorderLayout.EAST);

        //Definir el tamanio de todos los paneles
        panelTitulo.setPreferredSize(new Dimension(800, 90));
        panelTitulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        panelEjemplos.setPreferredSize(new Dimension(800, 70));
        panelEjemplos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

        panelDescripcion.setPreferredSize(new Dimension(800,70));
        panelDescripcion.setMaximumSize(new Dimension(Integer.MAX_VALUE,70));

        panelCapturaDatos.setPreferredSize(new Dimension(800,40));
        panelCapturaDatos.setMaximumSize(new Dimension(Integer.MAX_VALUE,70));

        panelTabla.setPreferredSize(new Dimension(800,359));
        panelTabla.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE));

        panelOpciones.setPreferredSize(new Dimension(800,70));
        panelOpciones.setMaximumSize(new Dimension(Integer.MAX_VALUE,70));

    }

    //Acciones de los botones
    public void btnBorrarAction(){
        txtValorInicial.setText("");
        lbDescripcion.setText("");
        cbEjemplos.setSelectedIndex(0);
        modelo.setRowCount(0);
        txtSolucion.setText("");
    }
    public void btnSeleccionarAction(String funciones[]){
        int itemSeleccionado = cbEjemplos.getSelectedIndex();
        if (itemSeleccionado > 0 && itemSeleccionado <= funciones.length){
            lbDescripcion.setText("<html>-Solucion de "+funciones[itemSeleccionado - 1]+" por el metodo de biseccion, ingrese valores para continuar: </html>");
        }else{
            lbDescripcion.setText("-Ingrese una opcion valida");
        }
    }
    public void btnCalcularAction(){
        int valorInicial = 0;
        int ejemploSelccionado = cbEjemplos.getSelectedIndex() - 1;

        //Borra los valores anteriormente puestos en la tabla
        modelo.setRowCount(0);

        try {
            valorInicial = Integer.parseInt(txtValorInicial.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Ingrese un numero valido.");
            txtValorInicial.setText("");
            return;
        }

        if(ejemploSelccionado < 0){
            JOptionPane.showMessageDialog(null,"Seleccione un ejemplo.");
            return;
        }

        tablaFormat = formatoRetorno(newton.newton(ejemploSelccionado,valorInicial));


        for(int i = 0; i < tablaFormat.size();i++){
            modelo.addRow(new Object[]{i + 1,tablaFormat.get(i)[0],tablaFormat.get(i)[1],tablaFormat.get(i)[2]});
        }

        //Actualizamos panel con la solucion
        solucionStrFormat = String.format("%.4f",newton.getXn());
        txtSolucion.setText(solucionStrFormat);
    }
    //Getter boton
    public JButton getBtnSalir() {
        return btnSalir;
    }
    //Formato tabla
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
}
