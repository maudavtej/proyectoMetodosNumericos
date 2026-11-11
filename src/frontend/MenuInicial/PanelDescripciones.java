package frontend.MenuInicial;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;

public class PanelDescripciones extends JPanel{
    private JLabel lbTitulo;
    //Panel Subtitulo
    private JTextArea txtSubtitulo;
    private JTextArea txtDescripcionMetodo;
    //Panel boton
    private JButton btnSeleccion;
    //Panel Navegacion
    private JButton btnSiguiente;
    private JButton btnAnterior;

    //DESCRIPCIONES Y TITULOS
    private Descripciones desc = new Descripciones();
    private int numMetodo = 0;
    private String[] descripciones = desc.getDescripcionesMetodos();
    private String[] titulos = desc.getTitulosMetodos();

    public PanelDescripciones(){
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

        txtSubtitulo = new JTextArea(titulos[numMetodo]);
        txtSubtitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // espacio entre titulo y parrafo
        txtSubtitulo.setFocusable(false); // quita el cursor parpadeante
        txtSubtitulo.setLineWrap(true);
        txtSubtitulo.setWrapStyleWord(true);
        txtSubtitulo.setEditable(false);
        txtSubtitulo.setOpaque(false);
        txtSubtitulo.setFont(new Font("Arial",Font.BOLD,16));

        txtDescripcionMetodo = new JTextArea(descripciones[numMetodo]);
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
        panelNavegacion.setBackground(new Color(233,235,240));


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

        //Aciones de los botones
        btnSiguiente.addActionListener(e -> btnSiguienteAction());
        btnAnterior.addActionListener(e -> btnAnteriorAction());
    }

    private void actualizarTexto(){
        txtSubtitulo.setText(titulos[numMetodo]);
        txtDescripcionMetodo.setText(descripciones[numMetodo]);
    }

    public void btnSiguienteAction(){
        numMetodo = (numMetodo + 1) % titulos.length;
        actualizarTexto();
    }
    public void btnAnteriorAction() {
        numMetodo = (numMetodo - 1 + titulos.length) % titulos.length;
        actualizarTexto();
    }

    //Getters
    public JButton getBtnSeleccion() {
        return btnSeleccion;
    }
    public int getNumMetodo() {
        return numMetodo;
    }
}
