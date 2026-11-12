package Raices;

import java.util.ArrayList;

public class MetodoNewton {

    private static final int MAX_ITERACIONES = 100;
    private double xn;
    private double xnAux;
    private double fxn;
    private double fxnD;
    private ArrayList<double[]> tablaCompleta = new ArrayList<>();

    public ArrayList<double[]> newton(int n, double valorInicial){
        int iteraciones = 0;

        Funcion[] ejemplos = new Funcion[4];
        ejemplos[0] = new Ejemplo1();
        ejemplos[1] = new Ejemplo2();
        ejemplos[2] = new Ejemplo3();
        ejemplos[3] = new Ejemplo4();

        xnAux = valorInicial;

        do{
            xn = xnAux;
            fxn = ejemplos[n].calcularValorFuncion(xn);
            fxnD = ejemplos[n].calcularValorDerivada(xn);
            tablaCompleta.add(new double[]{xn,fxn,fxnD});
            xnAux = caclcularXn_1(xn,fxn,fxnD);


            iteraciones++;
        }while((Math.abs(ejemplos[n].calcularValorFuncion(xn)) > Funcion.TOLERANCIA) && (iteraciones < MAX_ITERACIONES));

        return tablaCompleta;
    }

    public double caclcularXn_1(double xn, double fxn, double fxnD){
        return xn - (fxn / fxnD);
    }

    public double getXn() {
        return xn;
    }
}