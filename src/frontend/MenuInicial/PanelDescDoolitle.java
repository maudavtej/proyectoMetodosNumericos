package frontend.MenuInicial;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;

public class PanelDescDoolitle extends JPanel{
    private JLabel lbTitulo;
    //Panel Subtitulo
    private JTextArea txtSubtitulo;
    private JTextArea txtDescripcionMetodo;
    //Panel boton
    private JButton btnSeleccion;
    //Panel Navegacion
    private JButton btnSiguiente;
    private JButton btnAnterior;

    public PanelDescDoolitle(){
        setLayout(new BorderLayout());
        TitledBorder border = BorderFactory.createTitledBorder("");
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        JPanel panelPrincipal =  new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));

        JPanel panelTitulo = new JPanel();
        JPanel panelDescripcion = new JPanel();
        JPanel panelBoton = new JPanel();
        JPanel panelNavegacion = new JPanel();

        panelPrincipal.add(panelTitulo);
        panelPrincipal.add(panelDescripcion);
        panelPrincipal.add(panelBoton);
        panelPrincipal.add(panelNavegacion);
        add(panelPrincipal);

        //Misma alineacion horizontal para los 4 paneles; si no, BoxLayout desplaza alguno
        for (JPanel p : new JPanel[]{panelTitulo,panelDescripcion,panelBoton,panelNavegacion}) {
            p.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        //*PANEL TITULO*//
        lbTitulo = new JLabel("METODOS NUMERICOS I");
        lbTitulo.setFont(new Font("Arial",Font.BOLD,40));//Tipo de letra
        lbTitulo.setForeground(Color.WHITE);//Color de la letra
        //Personalizacion del panel
        panelTitulo.setBackground(new Color(0,82,158));
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.add(lbTitulo,BorderLayout.CENTER);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setVerticalAlignment(SwingConstants.CENTER);

        //*PANEL SUBTITULO*//
        panelDescripcion.setLayout(new BorderLayout());
        panelDescripcion.setBackground(new Color(233,235,240));
        panelDescripcion.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        txtSubtitulo = new JTextArea("Metodo de Doolitle");
        txtDescripcionMetodo = new JTextArea("El método de Doolittle es un procedimiento numérico utilizado" +
                " para resolver sistemas de ecuaciones lineales mediante la descomposición de matrices. Consiste" +
                " en expresar una matriz cuadrada como el producto de dos matrices triangulares: una matriz " +
                "triangular inferior y una matriz triangular superior.\nEste procedimiento forma parte de los " +
                "métodos de factorización LU y permite simplificar la resolución de sistemas de ecuaciones, evitando" +
                " realizar directamente la eliminación de Gauss cada vez que se necesita encontrar una solución.El " +
                "método consiste en descomponer la matriz de coeficientes A de un sistema de ecuaciones en dos matrices:  A = LU.\n" +
                "Donde:\nA: matriz original de coeficientes.\nL: matriz triangular inferior, cuya diagonal principal está formada por unos.\n" +
                "U: matriz triangular superior.\n\nUna vez obtenidas estas matrices, se resuelve el sistema original mediante dos sistemas más sencillos:Ax = b\n" +
                "Como A=LU, entonces: LUx=b\nSe introduce una variable auxiliar y, obteniendo:Ly=b\nPosteriormente: Ux=y\n\n" +
                "De esta manera, primero se resuelve el sistema triangular inferior y después el sistema triangular superior.El procedimiento consiste " +
                "en los siguientes pasos:\n" +
                "1. Construir la matriz de coeficientes: Se identifica la matriz cuadrada A del sistema de ecuaciones.\n" +
                "2. Realizar la descomposición LU: Se calculan las matrices L y U, de manera que su producto sea igual a la matriz original.\n" +
                "3. Resolver el sistema inferior: Se utiliza la matriz L para resolver Ly=b, obteniendo los valores de la variable auxiliar y.\n" +
                "4. Resolver el sistema superior: Se utiliza la matriz U para resolver Ux=y, obteniendo finalmente los valores de las incógnitas originales.");

        txtSubtitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // espacio entre titulo y parrafo
        txtSubtitulo.setFocusable(false); // quita el cursor parpadeante
        txtSubtitulo.setLineWrap(true);
        txtSubtitulo.setWrapStyleWord(true);
        txtSubtitulo.setEditable(false);
        txtSubtitulo.setOpaque(false);
        txtSubtitulo.setFont(new Font("Arial",Font.BOLD,16));

        txtDescripcionMetodo.setFocusable(false); // quita el cursor parpadeante
        txtDescripcionMetodo.setLineWrap(true);//Ajusta automaticamente el texto al ancho disponible
        txtDescripcionMetodo.setWrapStyleWord(true);//Evita cortar palabras a la mitad
        txtDescripcionMetodo.setEditable(false);
        txtDescripcionMetodo.setOpaque(false);//Hace transparente el fondo
        txtDescripcionMetodo.setFont(new Font("Arial",Font.PLAIN,13));

        panelDescripcion.add(txtSubtitulo, BorderLayout.NORTH);
        panelDescripcion.add(txtDescripcionMetodo, BorderLayout.CENTER);

        //*PANEL BOTON*//
        btnSeleccion = new JButton("SELECCIONAR");
        panelBoton.add(btnSeleccion);
        panelBoton.setBackground(new Color(233,235,240));

        //*PANEL NAVEGACION//
        btnSiguiente = new JButton(">");
        btnAnterior = new JButton("<");
        panelNavegacion.add(btnAnterior);

        panelNavegacion.add(btnSiguiente);
        panelBoton.setBackground(new Color(233,235,240));


        //Definir el tamanio de todos los paneles
        panelTitulo.setPreferredSize(new Dimension(800, 90));
        panelTitulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        // La descripcion absorbe el espacio sobrante de la ventana
        panelDescripcion.setPreferredSize(new Dimension(800, 450));
        panelDescripcion.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        panelBoton.setPreferredSize(new Dimension(800, 80));
        panelBoton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

        panelNavegacion.setPreferredSize(new Dimension(800,79));
        panelBoton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 79));

    }
}
