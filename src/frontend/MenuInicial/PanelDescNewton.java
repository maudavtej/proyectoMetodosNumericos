package frontend.MenuInicial;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;

public class PanelDescNewton extends JPanel {
    //Panel titulo
    private JLabel lbTitulo;
    //Panel Subtitulo
    private JTextArea txtSubtitulo;
    private JTextArea txtDescripcionMetodo;
    //Panel boton
    private JButton btnSeleccion;
    //Panel Navegacion
    private JButton btnSiguiente;
    private JButton btnAnterior;

    public PanelDescNewton(){
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

        txtSubtitulo = new JTextArea("Metodo de Newton:");
        txtDescripcionMetodo = new JTextArea("El método de Newton es un método numérico utilizado para encontrar aproximaciones " +
                "de las raíces de una función, es decir, valores de x para los cuales f(x)=0.\n" + "Este método se basa en el uso de la derivada " +
                "de una función y la recta tangente para aproximarse progresivamente a una raíz. A diferencia del método de bisección, no necesita un " +
                "intervalo inicial, sino un valor inicial cercano a la raíz que se desea encontrar.\nEl método utiliza la recta tangente a la curva de " +
                "una función en un punto determinado para obtener una nueva aproximación de la raíz.\n" + "Su fórmula principal es: Xn + 1 = xn - f(xn)/f´(xn)" +
                ", donde:\n  xn: Aproximación actual de la raíz.\n  xn + 1:Nueva aproximación de la raíz.\n  f(xn):Valor dela función evaluada en xn.\n  " +
                "f´(xn):Dericada de la funcion evaluada en xn.\n*Proceso:\n1.Definir la función: Se establece la funcion f(x) cuya raíz se desea encontrar.\n" +
                "2.Calcular derivada: Se obtiene la derivada de f´(x) de la funcion original.\n3.Elegir un valor inicial: Se selecciona un valor x0 que se encuentre" +
                "relativamente cerca de la raiz.\n4.Aplicar formula: Se sustituye el valor inicial en la fórmula de Newton para obtener su nueva aproximación.\n" +
                "5.Repeteri procedimiento: Se utiliza como un nuevo valor inicial y se repite el calculo hatsa alcanzar la precisión deseada.");

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
