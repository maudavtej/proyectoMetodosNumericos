package frontend.MenuInicial;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.*;

public class PanelMenuInicial extends JPanel {
    //Panel titulo
    private JLabel lbTitulo;
    //Panel info
    private JLabel lbIntegrantes;
    private JLabel lbNombreIntegrante1;
    private JLabel lbNombreIntegrante2;
    private JLabel lbNombreProfesor;
    private JLabel lbNombreUniversidad;
    private JLabel lbGrupo;
    //Panel botones
    private JButton btnContinuar;
    private JButton btnSalir;

    public PanelMenuInicial(){
        setLayout(new BorderLayout());
        TitledBorder border = BorderFactory.createTitledBorder("");
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 42);
        Font fuenteSubtitulo = new Font("Segoe UI", Font.BOLD, 18);
        Font fuenteCuerpo = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteInfo = new Font("Segoe UI", Font.BOLD, 14);

        JPanel panelTitulo = new JPanel();
        JPanel panelInfo = new JPanel();
        JPanel panelDescripcion = new PanelScrollable(); // solo este se desplaza
        JPanel panelBoton = new JPanel();

        JPanel panelNorte = new JPanel(new BorderLayout());
        panelNorte.add(panelTitulo, BorderLayout.NORTH);
        panelNorte.add(panelInfo, BorderLayout.CENTER);

        // Scroll solo para la descripción
        JScrollPane scrollDesc = new JScrollPane(panelDescripcion);
        scrollDesc.setBorder(null);
        scrollDesc.getVerticalScrollBar().setUnitIncrement(16);
        scrollDesc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDesc.getViewport().setBackground(Color.WHITE);

        add(panelNorte, BorderLayout.NORTH);
        add(scrollDesc, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        //*PANEL TITULO*//
        lbTitulo = new JLabel("METODOS NUMERICOS I");
        lbTitulo.setFont(fuenteTitulo);
        lbTitulo.setForeground(Color.WHITE);
        panelTitulo.setBackground(new Color(0,82,158));
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.add(lbTitulo, BorderLayout.CENTER);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setVerticalAlignment(SwingConstants.CENTER);

        //*PANEL INFO*//
        lbIntegrantes = new JLabel("Integrantes: ");
        lbIntegrantes.setFont(fuenteSubtitulo);
        lbNombreIntegrante1 = new JLabel("Davila Tejero Mauricio Eloy");
        lbNombreIntegrante2 = new JLabel("De la Cruz Barcenas Abraham");
        lbNombreProfesor = new JLabel("Profesor: Curiel García Carlos Pedro");
        lbNombreUniversidad = new JLabel("Universidad Nacional Autonoma de México");
        lbGrupo = new JLabel("Grupo: 1355");

        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        panelInfo.setBackground(new Color(233,235,240));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));

        JLabel[] etiquetas = {lbNombreUniversidad, lbNombreProfesor, lbGrupo,
                lbIntegrantes, lbNombreIntegrante1, lbNombreIntegrante2};

        panelInfo.add(Box.createVerticalStrut(15));
        for (JLabel lb : etiquetas) {
            lb.setAlignmentX(Component.LEFT_ALIGNMENT);
            lb.setFont(fuenteInfo);
            lb.setForeground(new Color(0x000000));
            panelInfo.add(lb);
            panelInfo.add(Box.createVerticalStrut(12));
        }

        /*PANEL DESCRIPCION*/
        panelDescripcion.setLayout(new BorderLayout());
        panelDescripcion.setBackground(new Color(233,235,240));
        panelDescripcion.setBorder(BorderFactory.createEmptyBorder(5, 40, 15, 40));

        JTextArea tituloDesc = new JTextArea("Introducción a los métodos numéricos");
        tituloDesc.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        tituloDesc.setFocusable(false);
        tituloDesc.setLineWrap(true);
        tituloDesc.setWrapStyleWord(true);
        tituloDesc.setEditable(false);
        tituloDesc.setOpaque(false);
        tituloDesc.setFont(fuenteSubtitulo);

        String textoCuerpo = "Los métodos numéricos son técnicas matemáticas que permiten encontrar " +
                "soluciones aproximadas a problemas que, por su complejidad, no pueden resolverse fácilmente " +
                "mediante métodos algebraicos tradicionales. Se utilizan para realizar cálculos, " +
                "analizar fenómenos y resolver problemas matemáticos mediante procedimientos " +
                "numéricos y algoritmos computacionales. Su aplicación consiste en " +
                "introducir los datos de un problema en un algoritmo que realiza " +
                "una serie de operaciones hasta obtener una solución aproximada con " +
                "un margen de error determinado. Son ampliamente utilizados en áreas como la " +
                "ingeniería, física, economía, informática y matemáticas para resolver problemas " +
                "como sistemas de ecuaciones, cálculo de raíces, integración, derivación y análisis de funciones.\n" +
                "En este proyecto resolveremos los siguientes métodos: \n" +
                "1.Bisección.\n2.Newton.\n3.Secante.\n4.Gauss.\n5.Gauss-Seidel.\n6.Jacobi.\n7.Doolitle.\n8.Crout.\n9.Potencia." +
                "\n10.Potencia inversa.";

        JTextPane cuerpoDesc = new JTextPane();
        cuerpoDesc.setText(textoCuerpo);
        cuerpoDesc.setFont(fuenteCuerpo);
        cuerpoDesc.setEditable(false);
        cuerpoDesc.setFocusable(false);
        cuerpoDesc.setOpaque(false);

        StyledDocument doc = cuerpoDesc.getStyledDocument();
        SimpleAttributeSet estilo = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(estilo, 0.6f);
        doc.setParagraphAttributes(0, doc.getLength(), estilo, false);

        panelDescripcion.add(tituloDesc, BorderLayout.NORTH);
        panelDescripcion.add(cuerpoDesc, BorderLayout.CENTER);

        /*PANEL BOTON*/
        btnSalir = new JButton("SALIR");
        panelBoton.add(btnSalir);
        btnContinuar = new JButton("CONTINUAR");
        panelBoton.add(btnContinuar);
        panelBoton.setBackground(new Color(233,235,240));
        panelBoton.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

        panelTitulo.setPreferredSize(new Dimension(800, 90));
        panelBoton.setPreferredSize(new Dimension(800, 70));
    }

    // Panel que se ajusta al ancho del scroll y solo crece en vertical
    private static class PanelScrollable extends JPanel implements Scrollable {
        public Dimension getPreferredScrollableViewportSize() { return getPreferredSize(); }
        public int getScrollableUnitIncrement(Rectangle r, int o, int d) { return 16; }
        public int getScrollableBlockIncrement(Rectangle r, int o, int d) { return r.height - 20; }
        public boolean getScrollableTracksViewportWidth() { return true; }
        public boolean getScrollableTracksViewportHeight() { return false; }
    }

    public JButton getBtnContinuar() {
        return btnContinuar;
    }
    public JButton getBtnSalir(){return btnSalir;}
}