public class MetodoSecante {

    private static final int MAX_ITERACIONES = 100;
    private String descripcionFuncion;

    public void secante(int n,double valorInicial1, double valorInicial2){
        double fxn_1 = 0;
        double fxn = 0;
        double xn_1 = 0;
        double xn = 0;
        double siguienteX =0;

        Funcion[] ejemplos = new Funcion[2];
        ejemplos[0] = new Ejemplo1();
        ejemplos[1] = new Ejemplo2();

        int iteraciones = 1;

        descripcionFuncion = ejemplos[n].getFuncionStr();

        do{
            if(iteraciones == 1){
                xn_1 = valorInicial1;
                xn = valorInicial2;
                fxn_1 = ejemplos[n].calcularValorFuncion(xn_1);
                fxn = 0;
                iteraciones++;
                continue;
            } else if (iteraciones == 2) {
                fxn = ejemplos[n].calcularValorFuncion(xn);
                iteraciones++;
                continue;
            }

            //Validamos que no sea 0:
            if(fxn == fxn_1){
                break;
            }

            siguienteX = calcularXn_1(xn,xn_1,fxn,fxn_1);

            xn_1 = xn;
            fxn_1 = fxn;
            xn = siguienteX;
            fxn = ejemplos[n].calcularValorFuncion(xn);

            iteraciones++;
        }while((Math.abs(ejemplos[n].calcularValorFuncion(xn)) > Funcion.TOLERANCIA) && (iteraciones < MAX_ITERACIONES));
    }

    public double calcularXn_1(double xn,double xn_1,double fxn, double fxn_1){
        return xn - (fxn * (xn - xn_1)/ (fxn - fxn_1));
    }
}
