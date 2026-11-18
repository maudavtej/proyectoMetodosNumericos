
package Unidad5;

import Matrices.Gauss;

import javax.swing.*;

public class PotenciaInversa {

    private final Gauss gauss;
    private static final int MAS_ITERACIONES = 100;
    private static final double TOLERANCIA = 0.0001;

    private double[] x;
    private double lambdaAnterior;
    private double lambdaActual;
    private int iteraciones;
    private double error;
    private boolean convergio;

    public PotenciaInversa() {
        this.gauss = new Gauss();
    }

    public String[] potenciaInversa(double[][] A, double[] vectorInicial) {
        int n = A.length;

        // Copiamos el vector inicial
        x = vectorInicial.clone();
        // Normalizamos el vector inicial
        normalizar(x);

        lambdaAnterior = 0;
        lambdaActual = 0;
        error = Double.POSITIVE_INFINITY;

        convergio = false;
        iteraciones = 0;

        for (int k = 0; k < MAS_ITERACIONES; k++) {
            //Construir el sistema aumentado A*y = x
            double[][] matrizAumentada = new double[n][n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrizAumentada[i][j] = A[i][j];
                }
                matrizAumentada[i][n] = x[i];
            }

            //Resolver el sistema utilizando Gauss
            String[] solucionStr = gauss.gauss(matrizAumentada);
            double[] y = new double[n];

            for (int i = 0; i < n; i++) {
                y[i] = Double.parseDouble(solucionStr[i]);
                if (!Double.isFinite(y[i])) {
                    JOptionPane.showMessageDialog(null,"Gauss produjo una solución no válida.");
                    return null;
                }
            }

            //Normalizar el vector obtenido
            double norma = normaInfinito(y);
            if (norma == 0 || !Double.isFinite(norma)) {
                JOptionPane.showMessageDialog(null,"No se puede normalizar el vector.");
                return null;
            }

            double[] xNuevo = new double[n];
            for (int i = 0; i < n; i++) {
                xNuevo[i] = y[i] / norma;
            }

            //Calcular una aproximación del valor propio.
            double[] Ax = multiplicarMatrizVector(A, xNuevo);
            int indiceMayor = 0;

            for (int i = 1; i < n; i++) {
                if (Math.abs(xNuevo[i]) > Math.abs(xNuevo[indiceMayor])) {
                    indiceMayor = i;
                }
            }

            lambdaActual = Ax[indiceMayor] / xNuevo[indiceMayor];

            //Calcular el error
            if (k > 0) {
                error = Math.abs(lambdaActual - lambdaAnterior);
                if (error < TOLERANCIA) {
                    convergio = true;
                    iteraciones = k + 1;
                    x = xNuevo;
                    break;
                }
            }

            //Actualizamos valores para la siguiente iteración
            lambdaAnterior = lambdaActual;
            x = xNuevo;
            iteraciones = k + 1;
        }

        String vectorInicialStr[] = new String[n];
        for(int i = 0; i < n; i++){
            vectorInicialStr[i] = String.format("%.4f",x[i]);
        }

        return vectorInicialStr;
    }

    // Normalización con norma infinito
    private void normalizar(double[] vector) {
        double norma = normaInfinito(vector);
        if (norma == 0 || !Double.isFinite(norma)) {
            JOptionPane.showMessageDialog(null,"El vector inicial no puede ser cero.");
            return;
        }
        for (int i = 0; i < vector.length; i++) {
            vector[i] /= norma;
        }
    }

    // Norma infinito máximo valor absoluto
    private double normaInfinito(double[] vector) {
        double mayor = 0;
        for (double valor : vector) {
            mayor = Math.max(mayor, Math.abs(valor));
        }
        return mayor;
    }

    // Multiplicación de matriz por vector
    private double[] multiplicarMatrizVector(double[][] A,double[] x) {
        int n = x.length;
        double[] resultado = new double[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i] += A[i][j] * x[j];
            }
        }
        return resultado;
    }



    public double getLambdaActual() {
        return lambdaActual;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public boolean isConvergio() {
        return convergio;
    }
}

