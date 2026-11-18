package Unidad5;

import Matrices.Matriz;

import javax.swing.*;

public class Potencia {

    private static final double TOLERANCIA = 0.0001;
    private static final int MAXIMO_ITERACIONES = 100;
    private double[] vectorX;
    private double[] vectorY;
    private double lambda;
    private double lambdaAnterior;
    private double c;
    private int contador;

    public String[] potencia(double[][] matrizInput, double[] vectorInicial){
        int n = matrizInput.length;
        contador = 0;
        lambdaAnterior = 0;
        lambda = 0;
        vectorY = new double[n];
        vectorX = vectorInicial;

        do {
            contador++;
            lambdaAnterior = lambda;
            //Multiplicamos la matriz por el vector inicial para obtener vectorY
            for(int i = 0; i < n; i++){
                vectorY[i] = 0;
                for(int j = 0; j < n; j++){
                    vectorY[i] += matrizInput[i][j] * vectorX[j];
                }
            }
            //Encontramos el elemento de mayor valor absoluto
            c = 0;
            for(int i = 0; i < n; i++){
                if(c < Math.abs(vectorY[i])){
                    c = Math.abs(vectorY[i]);
                }
            }

            if(c == 0){
                JOptionPane.showMessageDialog(null,"Vector resultante nulo, intente de nuevo.");
            }

            double numerador = 0;
            double denominador = 0;

            for(int i = 0; i < n; i++){
                numerador += vectorX[i] * vectorY[i];
                denominador += vectorX[i] * vectorX[i];
            }

            lambda = numerador / denominador;

            for(int i = 0; i < n; i++){
                vectorX[i] = vectorY[i] / c;
            }

        }while(contador == 1 || Math.abs(lambda - lambdaAnterior) >= TOLERANCIA && contador < MAXIMO_ITERACIONES);

        String vectorInicialStr[] = new String[n];
        for(int i = 0; i < n; i++){
            vectorInicialStr[i] = String.format("%.4f",vectorX[i]);
        }
        return vectorInicialStr;
    }

    public double getLambda() {
        return lambda;
    }
    public int getContador() {
        return contador;
    }
}
