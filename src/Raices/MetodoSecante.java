package Raices;

import java.util.ArrayList;

public class MetodoSecante {

    private static final int MAX_ITERACIONES = 100;
    private String descripcionFuncion;
    private double fxn_1 = 0;
    private double fxn = 0;
    private double xn_1 = 0;
    private double xn = 0;
    private double siguienteX =0;

    ArrayList<double[]> tablaCompleta = new ArrayList<>();

    public ArrayList<double[]> secante(int n,double valorInicial1, double valorInicial2){
        Funcion[] ejemplos = new Funcion[4];
        ejemplos[0] = new Ejemplo1();
        ejemplos[1] = new Ejemplo2();
        ejemplos[2] = new Ejemplo3();
        ejemplos[3] = new Ejemplo4();

        int iteraciones = 1;

        do{
            if(iteraciones == 1){
                xn_1 = valorInicial1;
                xn = valorInicial2;
                fxn_1 = ejemplos[n].calcularValorFuncion(xn_1);
                fxn = 0;
                tablaCompleta.add(new double[]{xn_1,fxn_1});
                iteraciones++;
                continue;
            } else if (iteraciones == 2) {
                fxn = ejemplos[n].calcularValorFuncion(xn);
                tablaCompleta.add(new double[]{xn,fxn});
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

            tablaCompleta.add(new double[]{xn,fxn});

            iteraciones++;
        }while((Math.abs(ejemplos[n].calcularValorFuncion(xn)) > Funcion.TOLERANCIA) && (iteraciones < MAX_ITERACIONES));

        return tablaCompleta;
    }

    public double calcularXn_1(double xn,double xn_1,double fxn, double fxn_1){
        return xn - (fxn * (xn - xn_1)/ (fxn - fxn_1));
    }

    public double getXn() {
        return xn;
    }
}
