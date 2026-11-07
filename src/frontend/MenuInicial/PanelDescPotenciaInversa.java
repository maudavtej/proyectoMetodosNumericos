package frontend.MenuInicial;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;

public class PanelDescPotenciaInversa extends JPanel {
    private JLabel lbTitulo;
    //Panel Subtitulo
    private JTextArea txtSubtitulo;
    private JTextArea txtDescripcionMetodo;
    //Panel boton
    private JButton btnSeleccion;
    //Panel Navegacion
    private JButton btnSiguiente;
    private JButton btnAnterior;

    public PanelDescPotenciaInversa(){
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

        txtSubtitulo = new JTextArea("Metodo de Potencia Inversa");
        txtDescripcionMetodo = new JTextArea("El método de la potencia inversa es un método numérico iterativo utilizado " +
                "para encontrar una aproximación del valor propio de menor magnitud (eigenvalor) de una matriz cuadrada y " +
                "su correspondiente vector propio (eigenvector).\n" +
                "Este método es una variante del método de la potencia tradicional. Mientras que el método de la potencia " +
                "busca el valor propio dominante, el método de la potencia inversa permite aproximarse al valor propio más " +
                "cercano a cero, siempre que la matriz sea invertible y se cumplan las condiciones de convergencia.\n" +
                "Su funcionamiento se basa en utilizar la matriz inversa de la matriz original para realizar multiplicaciones " +
                "sucesivas por un vector inicial.\nEl método parte de una matriz cuadrada invertible A y un vector inicial diferente " +
                "del vector cero. En lugar de multiplicar directamente por la matriz original, se resuelve un sistema de ecuaciones utilizando dicha matriz.\n" +
                "Esto permite obtener resultados equivalentes a multiplicar por A^-1, sin necesidad de calcular explícitamente la matriz inversa.\n\n" +
                "El procedimiento consiste en los siguientes pasos:\n" +
                "1. Construir la matriz: Se establece la matriz cuadrada A de la cual se desea encontrar el valor propio de menor magnitud.\n" +
                "2. Elegir un vector inicial: Se selecciona un vector inicial diferente del vector cero, generalmente con valores iguales a uno.\n" +
                "3. Resolver un sistema de ecuaciones: Se utiliza la matriz original para resolver el sistema:\n" +
                "Ay^(k+1)=x^k | De esta manera, se obtiene un nuevo vector y^(k+1).\n" +
                "4. Normalizar el resultado: Se divide el nuevo vector entre un factor de normalización para evitar que sus componentes " +
                "crezcan o disminuyan excesivamente.\n" +
                "5. Repetir el procedimiento: Se utiliza el vector normalizado para resolver nuevamente el sistema de ecuaciones.\n" +
                "6. Calcular el valor propio: Se estima el valor propio asociado al vector obtenido y se repite el proceso hasta alcanzar la precisión deseada.");

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
