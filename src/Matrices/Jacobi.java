package Matrices;

import Matrices.Matriz;

import java.util.ArrayList;

public class Jacobi {

    private static final int MAX_ITERACIONES = 100;
    private static double[] vectorX;
    private static double[][] coeficientesDesp;
    private static double[] x_Anterior;
    private static double[] x_Siguiente;

    public boolean estrictaDominante(Matriz m){
        double [][]matriz = m.getMatriz();
        int n = m.getN();
        for (int i=0;i<n;i++){
            double suma=0;
            for (int j=0;j<n;j++) {
                if (i != j) suma += Math.abs(matriz[i][j]);
            }
            if (Math.abs(matriz[i][i])<=suma) return false;
        }
        return true;
    }

    public ArrayList<double[]> funcionJacobi(Matriz m) {
        if (!estrictaDominante(m))
            throw new IllegalArgumentException("La matriz no es estrictamente dominante");

        double[][] A = m.getMatriz();
        int n = m.getN();

        vectorX = new double[n];
        coeficientesDesp = new double[n][n];

        for (int i = 0; i < n; i++) {
            vectorX[i] = A[i][n] / A[i][i];
            for (int j = 0; j < n; j++) {
                if(i!=j){
                    coeficientesDesp[i][j] =-A[i][j] / A[i][i];
                }else{
                    coeficientesDesp[i][j]=0;
                }

            }
        }

        x_Anterior  = new double[n];
        x_Siguiente = new double[n];

        ArrayList<double[]> tabla = new ArrayList<>();

        int iteraciones = 0;
        boolean converge = false;
        double tolerancia = 1e-9;

        while (iteraciones < MAX_ITERACIONES && !converge) {

            for (int i = 0; i < n; i++) {
                double suma = vectorX[i];
                for (int j = 0; j < n; j++) {
                    suma += coeficientesDesp[i][j] * x_Anterior[j];
                }
                x_Siguiente[i] = suma;
            }
            // criterio de parada ===== me lo dió chat

            double errorMax = 0.0;
            for (int i = 0; i < n; i++) {
                errorMax = Math.max(errorMax, Math.abs(x_Siguiente[i] - x_Anterior[i]));
            }

            double[] fila = new double[n + 1];
            System.arraycopy(x_Siguiente, 0, fila, 0, n);
            fila[n] = errorMax;
            tabla.add(fila);

            if (errorMax < tolerancia) {
                converge = true;
            } else {
                System.arraycopy(x_Siguiente, 0, x_Anterior, 0, n);
            }
            iteraciones++;
        }

        if (!converge) {
            throw new IllegalArgumentException("No convergió en " + MAX_ITERACIONES + " iteraciones");
        }

        return tabla;
    }
}






