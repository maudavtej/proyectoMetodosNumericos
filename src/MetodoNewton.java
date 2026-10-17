public class MetodoNewton {

    private static final int MAX_ITERACIONES = 100;
    private String descripcionFuncion;
    private String descripcionDerivada;

    public void newton(int n, double valorInicial){
        double xn;
        double fxn;
        double fxnD;

        int iteraciones = 0;

        Funcion[] ejemplos = new Funcion[2];
        ejemplos[0] = new Ejemplo1();
        ejemplos[1] = new Ejemplo2();

        descripcionFuncion = ejemplos[n].getFuncionStr();
        descripcionDerivada = ejemplos[n].getDerivadaStr();

        xn = valorInicial;

        do{
            fxn = ejemplos[n].calcularValorFuncion(xn);
            fxnD = ejemplos[n].calcularValorDerivada(xn);
            xn = caclcularXn_1(xn,fxn,fxnD);

            iteraciones++;
        }while((Math.abs(ejemplos[n].calcularValorFuncion(xn)) > Funcion.TOLERANCIA) && (iteraciones < MAX_ITERACIONES));
    }

    public double caclcularXn_1(double xn, double fxn, double fxnD){
        return xn - (fxn / fxnD);
    }
}