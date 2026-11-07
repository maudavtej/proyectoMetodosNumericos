package frontend.MenuInicial;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;

public class PanelDescGaussSeide extends JPanel{
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

    public PanelDescGaussSeide(){
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

        txtSubtitulo = new JTextArea("Metodo de Gauss-Seidel:");
        txtDescripcionMetodo = new JTextArea("El método de Gauss-Seidel es un método numérico iterativo utilizado para encontrar " +
                "soluciones aproximadas de sistemas de ecuaciones lineales. A diferencia del método de eliminación de Gauss, que " +
                "obtiene la solución mediante operaciones entre filas, Gauss-Seidel utiliza aproximaciones sucesivas para calcular " +
                "el valor de las incógnitas.\nSu funcionamiento consiste en despejar cada variable del sistema y calcular nuevos " +
                "valores utilizando las aproximaciones más recientes disponibles. Este proceso se repite hasta que los resultados " +
                "alcanzan una precisión o tolerancia previamente establecida.\nEl método parte de un conjunto de valores iniciales " +
                "para las incógnitas. En cada iteración, se calcula el valor de cada variable utilizando los valores actualizados " +
                "de las variables anteriores y los valores de la iteración anterior para las variables restantes.\nPara aplicar este " +
                "método, es recomendable que la matriz de coeficientes sea estrictamente diagonal dominante, aunque esta condición " +
                "no es indispensable en todos los casos para que el método converja.\n\nEl procedimiento consiste en los siguientes pasos:\n" +
                "1. Construir el sistema de ecuaciones: Se organiza el sistema en forma matricial, identificando los coeficientes y " +
                "términos independientes.\n2. Despejar las incógnitas: Se despeja cada variable en función de las demás, procurando " +
                "que los coeficientes de la diagonal principal sean distintos de cero.\n3. Elegir valores iniciales: Se asignan valores " +
                "iniciales a las incógnitas, generalmente ceros.\n4. Calcular las nuevas aproximaciones: Se sustituyen los valores iniciales" +
                " en las ecuaciones despejadas para obtener nuevos resultados. Es importante utilizar inmediatamente los valores recién " +
                "calculados dentro de la misma iteración.\n5. Evaluar el error: Se comparan los resultados de la iteración actual con los " +
                "de la iteración anterior para determinar si se ha alcanzado la tolerancia deseada.\n6. Repetir el procedimiento: Si el " +
                "error todavía es mayor que la tolerancia establecida, se realizan nuevas iteraciones hasta alcanzar la precisión requerida.");

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
