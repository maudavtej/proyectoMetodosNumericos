    package frontend.MenuInicial;

    import java.awt.*;
    import javax.swing.*;
    import javax.swing.border.TitledBorder;
    import javax.swing.BorderFactory;

    public class PanelMenuInicial extends JPanel {
        //Panel titulo
        private JLabel lbTitulo;
        //Panel info
        private JLabel lbNombreIntegrante1;
        private JLabel lbNombreIntegrante2;
        private JLabel lbNombreProfesor;
        private JLabel lbNombreUniversidad;
        private JLabel lbGrupo;
        //Panel botones
        private JButton btnContinuar;
        private final static String CONTINUAR = "CONTINUAR";

        public PanelMenuInicial(){
            setLayout(new BorderLayout());
            TitledBorder border = BorderFactory.createTitledBorder("");
            border.setTitleColor(Color.BLACK);
            setBorder(border);

            JPanel panelPrincipal =  new JPanel();
            panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));

            JPanel panelTitulo = new JPanel();
            JPanel panelInfo = new JPanel();
            JPanel panelDescripcion = new JPanel();
            JPanel panelBoton = new JPanel();

            //Misma alineacion horizontal para los 4 paneles; si no, BoxLayout desplaza alguno
            for (JPanel p : new JPanel[]{panelTitulo, panelInfo, panelDescripcion, panelBoton}) {
                p.setAlignmentX(Component.LEFT_ALIGNMENT);
            }

            panelPrincipal.add(panelTitulo);
            panelPrincipal.add(panelInfo);
            panelPrincipal.add(panelDescripcion);
            panelPrincipal.add(panelBoton);

            add(panelPrincipal);


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

            //*PANEL INFO*//
            lbNombreIntegrante1 = new JLabel("Davila Tejero Mauricio");
            lbNombreIntegrante2 = new JLabel("De la Cruz Barcenas Abraham");
            lbNombreProfesor = new JLabel("Curiel García Carlos Pedro");
            lbNombreUniversidad = new JLabel("Universidad Nacional Autonoma de México");
            lbGrupo = new JLabel("Grupo 1355");

            panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
            panelInfo.setBackground(new Color(233,235,240));
            panelInfo.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0)); // margen izquierdo

            JLabel[] etiquetas = {lbNombreUniversidad, lbNombreProfesor,
                    lbNombreIntegrante1, lbNombreIntegrante2, lbGrupo};

            panelInfo.add(Box.createVerticalStrut(8));
            for (JLabel lb : etiquetas) {
                lb.setAlignmentX(Component.LEFT_ALIGNMENT); // todos alineados a la izquierda
                panelInfo.add(lb);
                panelInfo.add(Box.createVerticalStrut(5));
            }

            /*PANEL DESCRIPCION*/
            panelDescripcion.setLayout(new BorderLayout());
            panelDescripcion.setBackground(new Color(233,235,240));
            panelDescripcion.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

            JTextArea tituloDesc = new JTextArea("Introduccion a los metodos numericos:");
            JTextArea cuerpoDesc = new JTextArea("Los métodos numéricos son técnicas matemáticas que permiten encontrar " +
                    "soluciones aproximadas a problemas que, por su complejidad, no pueden resolverse fácilmente " +
                    "mediante métodos algebraicos tradicionales. Se utilizan para realizar cálculos, " +
                    "analizar fenómenos y resolver problemas matemáticos mediante procedimientos " +
                    "numéricos y algoritmos computacionales. Su aplicación consiste en " +
                    "introducir los datos de un problema en un algoritmo que realiza " +
                    "una serie de operaciones hasta obtener una solución aproximada con " +
                    "un margen de error determinado. Son ampliamente utilizados en áreas como la " +
                    "ingeniería, física, economía, informática y matemáticas para resolver problemas " +
                    "como sistemas de ecuaciones, cálculo de raíces, integración, derivación y análisis de funciones.\n"+
                    "En estre proyecto resolveremos los siguientes metodos: \n"+
                    "1.Bisección.\n2.Newton.\n3.Secante.\n4.Gauss.\n5.Gauss-Seidel.\n6.Jacobi.\n7.Doolitle.\n8.Crout.\n9.Potencia." +
                    "\n10.Potencia inverza.");

            tituloDesc.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // espacio entre titulo y parrafo
            tituloDesc.setFocusable(false); // quita el cursor parpadeante
            tituloDesc.setLineWrap(true);
            tituloDesc.setWrapStyleWord(true);
            tituloDesc.setEditable(false);
            tituloDesc.setOpaque(false);
            tituloDesc.setFont(new Font("Arial",Font.BOLD,16));

            cuerpoDesc.setFocusable(false); // quita el cursor parpadeante
            cuerpoDesc.setLineWrap(true);//Ajusta automaticamente el texto al ancho disponible
            cuerpoDesc.setWrapStyleWord(true);//Evita cortar palabras a la mitad
            cuerpoDesc.setEditable(false);
            cuerpoDesc.setOpaque(false);//Hace transparente el fondo
            cuerpoDesc.setFont(new Font("Arial",Font.PLAIN,13));

            panelDescripcion.add(tituloDesc, BorderLayout.NORTH);
            panelDescripcion.add(cuerpoDesc, BorderLayout.CENTER);

            /*PANEL BOTON*/
            btnContinuar = new JButton("CONTINUAR");
            panelBoton.add(btnContinuar);
            panelBoton.setBackground(new Color(233,235,240));

            //Definir el tamanio de todos los paneles
            panelTitulo.setPreferredSize(new Dimension(800, 90));
            panelTitulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

            panelInfo.setPreferredSize(new Dimension(800, 130));
            panelInfo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 130));

            panelDescripcion.setPreferredSize(new Dimension(800, 350));
            panelDescripcion.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

            panelBoton.setPreferredSize(new Dimension(800, 129));
            panelBoton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 129));
        }

        public JButton getBtnContinuar() {
            return btnContinuar;
        }
    }