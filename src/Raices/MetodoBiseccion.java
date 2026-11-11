package Raices;

import java.util.ArrayList;

public class MetodoBiseccion {
    private static final int MAX_ITERACIONES=100;
    private double c = 0;
    private double f_a = 0;
    private double f_b = 0;
    private double f_c = 0;

    private ArrayList<double[]> tablaCompleta = new ArrayList<>();

    //Metodo Biseccion
    public ArrayList<double[]> biseccion(int n,double a, double b){
        //Ejemplos disponibles
        Funcion[] ejemplos = new Funcion[2];
        ejemplos[0]=new Ejemplo1();
        ejemplos[1]=new Ejemplo2();

        if (n<0||n>=ejemplos.length){
            throw new IllegalArgumentException("Elige un ejemplo válido");
        }
        if (a>=b){
            throw new IllegalArgumentException("El extremo a debe ser menor que el extremo b");
        }
        Funcion f = ejemplos[n];
        f_a = f.calcularValorFuncion(a);
        f_b = f.calcularValorFuncion(b);

        if (f_a*f_b>0){
            throw new IllegalArgumentException("No existe cambio de signo en este intervalo. Intente con otro");
        }

        int iteraciones = 0;
        do {
            c = (a+b)/2;
            f_c = f.calcularValorFuncion(c);
            iteraciones++;

            tablaCompleta.add(new double[]{a,b,c,f_a,f_b,f_c});

            a = (f_a * f_c > 0) ? c : a;//si el signo es el mismo, sustituimos por c ese valor, si no sigue siendo el mismo
            f_a = (f_a * f_c > 0) ? f_c : f_a;
            b = (f_b * f_c > 0) ? c : b;
            f_b = (f_b * f_c > 0) ? f_c : f_b;
        }while (Math.abs(f_c)> Funcion.TOLERANCIA && iteraciones<MAX_ITERACIONES);

        return tablaCompleta;
    }

    //Getter
    public double getC() {
        return c;
    }
}
