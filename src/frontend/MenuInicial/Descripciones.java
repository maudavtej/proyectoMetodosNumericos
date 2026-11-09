package frontend.MenuInicial;

public class Descripciones {
    //Descripciones de todos los metodos
    private static final String DESCRIPCION_BISECCION =
            "El método de bisección es un método numérico utilizado para encontrar una aproximación de la raíz de una " +
                    "función, es decir, un valor de x para el cual f(x)=0. Se basa en el teorema del valor intermedio y consiste " +
                    "en dividir repetidamente un intervalo en dos partes iguales hasta encontrar una aproximación suficientemente " +
                    "cercana a la raíz.\n" +
                    "  ¿Cómo funciona?\n" +
                    "Para aplicar este método, se necesita una función continua f(x) y un intervalo inicial [a,b] en el que los " +
                    "valores de la función tengan signos opuestos: f(a) * f(b) < 0.\n" +
                    "*Procedimiento:\n" +
                    "1.Establecer el valor inicial.\n" +
                    "2.Calcular el punto medio: Se obtiene mediante la fórmula: xr = (a + b)/2\n" +
                    "3.Evaluar la función: Se sustituye xr en la función para determinar el signo de f(xr).\n" +
                    "4.Reducir el intervalo:\n" +
                    "  Si f(a) * f(xr) < 0, el nuevo intervalo será [a,xr]\n" +
                    "  Si f(xr) * f(b) < 0, el nuevo intervalo será [xr,b]\n" +
                    "  Si f(xr) = 0 se ha encontrado la raíz exacta\n" +
                    "5.Repetir procedimiento.\n" +
                    "El método de bisección es una herramienta fundamental de los métodos numéricos porque permite aproximar " +
                    "raíces de funciones mediante un procedimiento iterativo, sencillo y confiable. Su principal característica " +
                    "es que reduce el intervalo de búsqueda a la mitad en cada iteración, acercándose progresivamente a la raíz " +
                    "buscada.";

    private static final String DESCRIPCION_NEWTON =
            "El método de Newton es un método numérico utilizado para encontrar aproximaciones de las raíces de una " +
                    "función, es decir, valores de x para los cuales f(x)=0.\n" +
                    "Este método se basa en el uso de la derivada de una función y la recta tangente para aproximarse " +
                    "progresivamente a una raíz. A diferencia del método de bisección, no necesita un intervalo inicial, sino " +
                    "un valor inicial cercano a la raíz que se desea encontrar.\n" +
                    "El método utiliza la recta tangente a la curva de una función en un punto determinado para obtener una " +
                    "nueva aproximación de la raíz.\n" +
                    "Su fórmula principal es: Xn+1 = Xn - f(Xn)/f'(Xn), donde:\n" +
                    "  Xn: Aproximación actual de la raíz.\n" +
                    "  Xn+1: Nueva aproximación de la raíz.\n" +
                    "  f(Xn): Valor de la función evaluada en Xn.\n" +
                    "  f'(Xn): Derivada de la función evaluada en Xn.\n" +
                    "*Proceso:\n" +
                    "1.Definir la función: Se establece la función f(x) cuya raíz se desea encontrar.\n" +
                    "2.Calcular derivada: Se obtiene la derivada f'(x) de la función original.\n" +
                    "3.Elegir un valor inicial: Se selecciona un valor x0 que se encuentre relativamente cerca de la raíz.\n" +
                    "4.Aplicar fórmula: Se sustituye el valor inicial en la fórmula de Newton para obtener su nueva " +
                    "aproximación.\n" +
                    "5.Repetir procedimiento: Se utiliza como nuevo valor inicial y se repite el cálculo hasta alcanzar la " +
                    "precisión deseada.";

    private static final String DESCRIPCION_SECANTE =
            "El método de la secante es un método numérico utilizado para encontrar aproximaciones de las raíces de " +
                    "una función, es decir, valores de x para los cuales f(x)=0.\n" +
                    "Este método se basa en utilizar una recta secante que pasa por dos puntos de la función para aproximarse " +
                    "progresivamente a una raíz. Es similar al método de Newton, pero tiene una diferencia importante: no " +
                    "necesita calcular la derivada de la función, ya que utiliza dos aproximaciones anteriores para estimar " +
                    "la pendiente.\n" +
                    "El método utiliza dos valores iniciales para construir una recta secante. Posteriormente, calcula el " +
                    "punto donde esta recta intersecta el eje x, utilizando ese punto como una nueva aproximación de la raíz.\n" +
                    "Su fórmula principal es:\n" +
                    "     Xn+1 = Xn - (f(Xn)*(Xn - Xn-1))/(f(Xn) - f(Xn-1))\n" +
                    "Donde:\n" +
                    "Xn: Aproximación actual de la raíz.\n" +
                    "Xn-1: Aproximación anterior.\n" +
                    "Xn+1: Nueva aproximación de la raíz.\n" +
                    "f(Xn) y f(Xn-1): Valores de la función evaluados en las aproximaciones correspondientes.\n\n" +
                    "El procedimiento consiste en los siguientes pasos:\n" +
                    "1. Definir la función: Se establece la función f(x) cuya raíz se desea encontrar.\n" +
                    "2. Elegir dos valores iniciales: Se seleccionan dos aproximaciones iniciales, X0 y X1, preferentemente " +
                    "cercanas a la raíz buscada.\n" +
                    "3. Aplicar la fórmula: Se sustituyen ambos valores en la fórmula del método de la secante para obtener " +
                    "una nueva aproximación.\n" +
                    "4. Actualizar los valores: Se reemplaza Xn-1 por Xn y Xn por Xn+1.\n" +
                    "5. Repetir el procedimiento: Se continúa calculando nuevas aproximaciones hasta alcanzar la precisión o " +
                    "tolerancia deseada.";

    private static final String DESCRIPCION_GAUSS =
            "El método de eliminación de Gauss es un procedimiento numérico utilizado para resolver sistemas de " +
                    "ecuaciones lineales mediante operaciones elementales entre las filas de una matriz. Su objetivo es " +
                    "transformar la matriz original en una matriz triangular superior, es decir, una matriz en la que todos " +
                    "los elementos que se encuentran por debajo de la diagonal principal sean iguales a cero.\n" +
                    "Una vez obtenida esta forma, se pueden calcular las incógnitas mediante un procedimiento llamado " +
                    "sustitución hacia atrás, comenzando por la última ecuación y avanzando hasta encontrar el valor de todas " +
                    "las variables.\n" +
                    "El método utiliza operaciones elementales de fila para simplificar un sistema de ecuaciones sin modificar " +
                    "sus soluciones. Para aplicarlo, primero se representa el sistema mediante una matriz aumentada, en la " +
                    "cual se incluyen los coeficientes de las variables y los términos independientes.\n" +
                    "Las operaciones elementales que se pueden realizar son:\n" +
                    "*Intercambio de filas.\n" +
                    "*Multiplicación de una fila.\n" +
                    "*Suma de filas.\n\n" +
                    "El procedimiento consiste en los siguientes pasos:\n" +
                    "1. Construir la matriz aumentada: Se organizan los coeficientes y términos independientes del sistema de " +
                    "ecuaciones.\n" +
                    "2. Seleccionar el pivote: Se identifica un elemento de la diagonal principal que servirá como referencia " +
                    "para realizar las operaciones de eliminación.\n" +
                    "3. Eliminar los elementos inferiores al pivote: Se realizan operaciones elementales entre filas para " +
                    "convertir en cero los elementos que se encuentran debajo del pivote.\n" +
                    "4. Repetir el procedimiento: Se continúa con las siguientes columnas hasta obtener una matriz triangular " +
                    "superior.\n" +
                    "5. Realizar sustitución hacia atrás: Se comienza resolviendo la última ecuación y se sustituyen los " +
                    "resultados obtenidos en las ecuaciones anteriores hasta encontrar todas las incógnitas.";

    private static final String DESCRIPCION_GAUSS_SEIDEL =
            "El método de Gauss-Seidel es un método numérico iterativo utilizado para encontrar soluciones " +
                    "aproximadas de sistemas de ecuaciones lineales. A diferencia del método de eliminación de Gauss, que " +
                    "obtiene la solución mediante operaciones entre filas, Gauss-Seidel utiliza aproximaciones sucesivas para " +
                    "calcular el valor de las incógnitas.\n" +
                    "Su funcionamiento consiste en despejar cada variable del sistema y calcular nuevos valores utilizando las " +
                    "aproximaciones más recientes disponibles. Este proceso se repite hasta que los resultados alcanzan una " +
                    "precisión o tolerancia previamente establecida.\n" +
                    "El método parte de un conjunto de valores iniciales para las incógnitas. En cada iteración, se calcula el " +
                    "valor de cada variable utilizando los valores actualizados de las variables anteriores y los valores de " +
                    "la iteración anterior para las variables restantes.\n" +
                    "Para aplicar este método, es recomendable que la matriz de coeficientes sea estrictamente diagonal " +
                    "dominante, aunque esta condición no es indispensable en todos los casos para que el método converja.\n\n" +
                    "El procedimiento consiste en los siguientes pasos:\n" +
                    "1. Construir el sistema de ecuaciones: Se organiza el sistema en forma matricial, identificando los " +
                    "coeficientes y términos independientes.\n" +
                    "2. Despejar las incógnitas: Se despeja cada variable en función de las demás, procurando que los " +
                    "coeficientes de la diagonal principal sean distintos de cero.\n" +
                    "3. Elegir valores iniciales: Se asignan valores iniciales a las incógnitas, generalmente ceros.\n" +
                    "4. Calcular las nuevas aproximaciones: Se sustituyen los valores iniciales en las ecuaciones despejadas " +
                    "para obtener nuevos resultados. Es importante utilizar inmediatamente los valores recién calculados " +
                    "dentro de la misma iteración.\n" +
                    "5. Evaluar el error: Se comparan los resultados de la iteración actual con los de la iteración anterior " +
                    "para determinar si se ha alcanzado la tolerancia deseada.\n" +
                    "6. Repetir el procedimiento: Si el error todavía es mayor que la tolerancia establecida, se realizan " +
                    "nuevas iteraciones hasta alcanzar la precisión requerida.";

    private static final String DESCRIPCION_JACOBI =
            "El método de Jacobi es un método numérico iterativo utilizado para encontrar soluciones aproximadas de " +
                    "sistemas de ecuaciones lineales. Su funcionamiento consiste en despejar las incógnitas de un sistema y " +
                    "calcular sus valores mediante aproximaciones sucesivas, repitiendo el procedimiento hasta alcanzar una " +
                    "precisión o tolerancia previamente establecida.\n" +
                    "A diferencia del método de Gauss-Seidel, el método de Jacobi utiliza exclusivamente los valores de la " +
                    "iteración anterior para calcular todas las nuevas aproximaciones. Esto significa que los resultados " +
                    "obtenidos durante una iteración no se utilizan hasta que comienza la siguiente.\n\n" +
                    "El procedimiento consiste en los siguientes pasos:\n" +
                    "1. Construir el sistema de ecuaciones: Se identifican los coeficientes de las variables y los términos " +
                    "independientes.\n" +
                    "2. Despejar las incógnitas: Se despeja cada variable en función de las demás, procurando que los " +
                    "coeficientes de la diagonal principal sean distintos de cero.\n" +
                    "3. Elegir valores iniciales: Se asignan valores iniciales a todas las incógnitas, generalmente ceros.\n" +
                    "4. Calcular las nuevas aproximaciones: Se sustituyen los valores de la iteración anterior en las " +
                    "ecuaciones despejadas para obtener los nuevos resultados.\n" +
                    "5. Evaluar el error: Se comparan las aproximaciones actuales con las anteriores para determinar si se ha " +
                    "alcanzado la tolerancia establecida.\n" +
                    "6. Repetir el procedimiento: Si no se ha alcanzado la precisión deseada, se utilizan los nuevos valores " +
                    "para comenzar otra iteración.";

    private static final String DESCRIPCION_DOOLITTLE =
            "El método de Doolittle es un procedimiento numérico utilizado para resolver sistemas de ecuaciones " +
                    "lineales mediante la descomposición de matrices. Consiste en expresar una matriz cuadrada como el " +
                    "producto de dos matrices triangulares: una matriz triangular inferior y una matriz triangular superior.\n" +
                    "Este procedimiento forma parte de los métodos de factorización LU y permite simplificar la resolución de " +
                    "sistemas de ecuaciones, evitando realizar directamente la eliminación de Gauss cada vez que se necesita " +
                    "encontrar una solución.\n" +
                    "El método consiste en descomponer la matriz de coeficientes A de un sistema de ecuaciones en dos " +
                    "matrices: A = LU.\n" +
                    "Donde:\n" +
                    "A: matriz original de coeficientes.\n" +
                    "L: matriz triangular inferior, cuya diagonal principal está formada por unos.\n" +
                    "U: matriz triangular superior.\n\n" +
                    "Una vez obtenidas estas matrices, se resuelve el sistema original mediante dos sistemas más sencillos: " +
                    "Ax = b\n" +
                    "Como A=LU, entonces: LUx=b\n" +
                    "Se introduce una variable auxiliar y, obteniendo: Ly=b\n" +
                    "Posteriormente: Ux=y\n\n" +
                    "De esta manera, primero se resuelve el sistema triangular inferior y después el sistema triangular " +
                    "superior.\n\n" +
                    "El procedimiento consiste en los siguientes pasos:\n" +
                    "1. Construir la matriz de coeficientes: Se identifica la matriz cuadrada A del sistema de ecuaciones.\n" +
                    "2. Realizar la descomposición LU: Se calculan las matrices L y U, de manera que su producto sea igual a " +
                    "la matriz original.\n" +
                    "3. Resolver el sistema inferior: Se utiliza la matriz L para resolver Ly=b, obteniendo los valores de la " +
                    "variable auxiliar y.\n" +
                    "4. Resolver el sistema superior: Se utiliza la matriz U para resolver Ux=y, obteniendo finalmente los " +
                    "valores de las incógnitas originales.";

    private static final String DESCRIPCION_CROUT =
            "El método de Crout es un procedimiento numérico utilizado para resolver sistemas de ecuaciones lineales " +
                    "mediante la descomposición de matrices. Consiste en expresar una matriz cuadrada como el producto de dos " +
                    "matrices triangulares: una matriz triangular inferior y una matriz triangular superior.\n" +
                    "Este método pertenece a los procedimientos de factorización LU y permite simplificar la resolución de " +
                    "sistemas de ecuaciones mediante operaciones matriciales más sencillas.\n" +
                    "Su principal característica es que la diagonal principal de la matriz triangular superior está formada " +
                    "por unos, a diferencia del método de Doolittle, donde los unos se encuentran en la matriz triangular " +
                    "inferior.\n" +
                    "El método consiste en descomponer la matriz de coeficientes A de un sistema de ecuaciones en dos " +
                    "matrices: A=LU\n" +
                    "Donde:\n" +
                    "-A: matriz original de coeficientes.\n" +
                    "-L: matriz triangular inferior.\n" +
                    "-U: matriz triangular superior, cuya diagonal principal está formada por unos.\n\n" +
                    "Una vez obtenidas ambas matrices, se resuelve el sistema original: Ax=b\n" +
                    "Sustituyendo la descomposición: LUx=b\n" +
                    "Se introduce una variable auxiliar y: Ly=b\n" +
                    "Posteriormente: Ux=y\n" +
                    "De esta manera, primero se resuelve el sistema triangular inferior mediante sustitución hacia adelante y " +
                    "después el sistema triangular superior mediante sustitución hacia atrás.\n" +
                    "El procedimiento consiste en los siguientes pasos:\n" +
                    "1. Construir la matriz de coeficientes: Se identifica la matriz cuadrada A del sistema de ecuaciones.\n" +
                    "2. Realizar la descomposición LU: Se calculan las matrices L y U, de manera que su producto sea igual a " +
                    "la matriz original.\n" +
                    "3. Resolver el sistema inferior: Se utiliza la matriz L para resolver Ly=b, obteniendo los valores de la " +
                    "variable auxiliar y.\n" +
                    "4. Resolver el sistema superior: Se utiliza la matriz U para resolver Ux=y, obteniendo finalmente los " +
                    "valores de las incógnitas originales.";

    private static final String DESCRIPCION_POTENCIA =
            "El método de la potencia es un método numérico iterativo utilizado para encontrar una aproximación del " +
                    "valor propio dominante (eigenvalor) de una matriz cuadrada y su correspondiente vector propio " +
                    "(eigenvector).\n" +
                    "El valor propio dominante es aquel que tiene el mayor valor absoluto entre los valores propios de la " +
                    "matriz. Este método se basa en multiplicar repetidamente una matriz por un vector inicial y normalizar " +
                    "los resultados para obtener aproximaciones cada vez más cercanas al vector propio dominante.\n" +
                    "Es especialmente útil cuando se trabaja con matrices de gran tamaño y se desea encontrar su valor propio " +
                    "dominante sin calcular todos los valores propios de manera directa.\n\n" +
                    "El procedimiento consiste en los siguientes pasos:\n" +
                    "1. Construir la matriz: Se establece la matriz cuadrada A de la cual se desea obtener el valor propio " +
                    "dominante.\n" +
                    "2. Elegir un vector inicial: Se selecciona un vector inicial diferente del vector cero, generalmente con " +
                    "valores iguales a uno.\n" +
                    "3. Multiplicar la matriz por el vector: Se realiza el producto matricial entre A y el vector inicial " +
                    "para obtener un nuevo vector.\n" +
                    "4. Normalizar el resultado: Se divide el nuevo vector entre uno de sus componentes o mediante una norma, " +
                    "evitando que sus valores crezcan o disminuyan excesivamente.\n" +
                    "5. Repetir el procedimiento: Se utiliza el vector normalizado para realizar una nueva multiplicación y " +
                    "se repite el proceso hasta que las aproximaciones se estabilicen.\n" +
                    "6. Calcular el valor propio dominante: Una vez obtenida una aproximación suficientemente precisa del " +
                    "vector propio, se estima el valor propio correspondiente.";

    private static final String DESCRIPCION_POTENCIA_INVERSA =
            "El método de la potencia inversa es un método numérico iterativo utilizado para encontrar una " +
                    "aproximación del valor propio de menor magnitud (eigenvalor) de una matriz cuadrada y su correspondiente " +
                    "vector propio (eigenvector).\n" +
                    "Este método es una variante del método de la potencia tradicional. Mientras que el método de la potencia " +
                    "busca el valor propio dominante, el método de la potencia inversa permite aproximarse al valor propio " +
                    "más cercano a cero, siempre que la matriz sea invertible y se cumplan las condiciones de convergencia.\n" +
                    "Su funcionamiento se basa en utilizar la matriz inversa de la matriz original para realizar " +
                    "multiplicaciones sucesivas por un vector inicial.\n" +
                    "El método parte de una matriz cuadrada invertible A y un vector inicial diferente del vector cero. En " +
                    "lugar de multiplicar directamente por la matriz original, se resuelve un sistema de ecuaciones " +
                    "utilizando dicha matriz. Esto permite obtener resultados equivalentes a multiplicar por A^-1, sin " +
                    "necesidad de calcular explícitamente la matriz inversa.\n\n" +
                    "El procedimiento consiste en los siguientes pasos:\n" +
                    "1. Construir la matriz: Se establece la matriz cuadrada A de la cual se desea encontrar el valor propio " +
                    "de menor magnitud.\n" +
                    "2. Elegir un vector inicial: Se selecciona un vector inicial diferente del vector cero, generalmente con " +
                    "valores iguales a uno.\n" +
                    "3. Resolver un sistema de ecuaciones: Se utiliza la matriz original para resolver el sistema:\n" +
                    "   Ay^(k+1)=x^k\n" +
                    "   De esta manera, se obtiene un nuevo vector y^(k+1).\n" +
                    "4. Normalizar el resultado: Se divide el nuevo vector entre un factor de normalización para evitar que " +
                    "sus componentes crezcan o disminuyan excesivamente.\n" +
                    "5. Repetir el procedimiento: Se utiliza el vector normalizado para resolver nuevamente el sistema de " +
                    "ecuaciones.\n" +
                    "6. Calcular el valor propio: Se estima el valor propio asociado al vector obtenido y se repite el " +
                    "proceso hasta alcanzar la precisión deseada.";

    //Arreglo con todas las descripciones
    private String[] descripcionesMetodos = {DESCRIPCION_BISECCION, DESCRIPCION_NEWTON, DESCRIPCION_SECANTE,
            DESCRIPCION_GAUSS, DESCRIPCION_GAUSS_SEIDEL, DESCRIPCION_JACOBI, DESCRIPCION_DOOLITTLE,
            DESCRIPCION_CROUT, DESCRIPCION_POTENCIA, DESCRIPCION_POTENCIA_INVERSA};

    //Titulos de los metodos
    private static final String TITULO_BISECCION = "Método de Bisección: ";
    private static final String TITULO_NEWTON = "Método de Newton: ";
    private static final String TITULO_SECANTE = "Método de la Secante: ";
    private static final String TITULO_GAUSS = "Método de Gauss: ";
    private static final String TITULO_GAUSS_SEIDEL = "Método de Gauss-Seidel: ";
    private static final String TITULO_JACOBI = "Método de Jacobi: ";
    private static final String TITULO_DOOLITTLE = "Método de Doolittle: ";
    private static final String TITULO_CROUT = "Método de Crout: ";
    private static final String TITULO_POTENCIA = "Método de la Potencia: ";
    private static final String TITULO_POTENCIA_INVERSA = "Método de la Potencia Inversa: ";

    //Arreglo con todos los titulos
    private String[] titulosMetodos = {TITULO_BISECCION, TITULO_NEWTON, TITULO_SECANTE, TITULO_GAUSS,
            TITULO_GAUSS_SEIDEL, TITULO_JACOBI, TITULO_DOOLITTLE, TITULO_CROUT, TITULO_POTENCIA,
            TITULO_POTENCIA_INVERSA};

    //Getters
    public String[] getDescripcionesMetodos() {
        return descripcionesMetodos;
    }
    public String[] getTitulosMetodos() {
        return titulosMetodos;
    }
}
