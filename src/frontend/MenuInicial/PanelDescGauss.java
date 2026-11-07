package frontend.MenuInicial;

import Matrices.Gauss;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;

public class PanelDescGauss extends JPanel{
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

    public PanelDescGauss(){
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

        txtSubtitulo = new JTextArea("Metodo de eliminacion de Gauss:");
        txtDescripcionMetodo = new JTextArea("El método de eliminación de Gauss es un procedimiento numérico utilizado para " +
                "resolver sistemas de ecuaciones lineales mediante operaciones elementales entre las filas de una matriz. Su " +
                "objetivo es transformar la matriz original en una matriz triangular superior, es decir, una matriz en la que " +
                "todos los elementos que se encuentran por debajo de la diagonal principal sean iguales a cero.\n Una vez obtenida " +
                "esta forma, se pueden calcular las incógnitas mediante un procedimiento llamado sustitución hacia atrás, comenzando " +
                "por la última ecuación y avanzando hasta encontrar el valor de todas las variables.\nEl método utiliza operaciones elementales " +
                "de fila para simplificar un sistema de ecuaciones sin modificar sus soluciones.\nPara aplicarlo, primero se representa el sistema" +
                " mediante una matriz aumentada, en la cual se incluyen los coeficientes de las variables y los términos independientes.\nLas operaciones" +
                " elementales que se pueden realizar son:\n*Intercambio de filas.\n*Multiplicación de una fila.\n*Suma de filas.\nEl procedimiento consiste " +
                "en los siguientes pasos:\n1. Construir la matriz aumentada: Se organizan los coeficientes y términos independientes del sistema de ecuaciones.\n" +
                "2. Seleccionar el pivote: Se identifica un elemento de la diagonal principal que servirá como referencia para realizar las operaciones de " +
                "eliminación.\n3. Eliminar los elementos inferiores al pivote: Se realizan operaciones elementales entre filas para convertir en cero los " +
                "elementos que se encuentran debajo del pivote.\n4. Repetir el procedimiento: Se continúa con las siguientes columnas hasta obtener una " +
                "matriz triangular superior.\n5. Realizar sustitución hacia atrás: Se comienza resolviendo la última ecuación y se sustituyen los resultados " +
                "obtenidos en las ecuaciones anteriores hasta encontrar todas las incógnitas.");

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
