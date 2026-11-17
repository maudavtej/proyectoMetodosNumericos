package Unidad4;

import javax.swing.*;

public class Crout {
    private double[][] L;
    private double[][] U;
    private String[] vectorSolucionStr;

    public String[] crout(double[][] matrizInput,double[] terminosIndependientes) {
        //Copia de valores en otra variable
        int n = matrizInput.length;
        double[] vectorY = new double[n];
        double[] vectorSolucion = new double[n];
        L = new double[n][n];
        U = new double[n][n];

        for (int i = 0; i < n; i++) {
            U[i][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            // Calcular los elementos de la fila i de U
            for (int j = i; j < n; j++) {
                double suma = 0;

                for (int k = 0; k < i; k++) {
                    suma += L[j][k] * U[k][i];
                }

                L[j][i] = matrizInput[j][i] - suma;
            }

            if (Math.abs(L[i][i]) < 1e-12) {
                JOptionPane.showMessageDialog(null,
                        "Pivote cero o demasiado pequeño, intente de nuevo.");
                return null;
            }

            for (int j = i + 1; j < n; j++) {
                double suma = 0;

                for (int k = 0; k < i; k++) {
                    suma += L[i][k] * U[k][j];
                }

                U[i][j] = (matrizInput[i][j] - suma) / L[i][i];
            }
        }

        // Sustitución progresiva L
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < i; j++) {
                suma += L[i][j] * vectorY[j];
            }
            vectorY[i] = (terminosIndependientes[i] - suma) / L[i][i];
        }
        // Sustitución regresiva U
        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < n; j++) {
                suma += U[i][j] * vectorSolucion[j];
            }
            vectorSolucion[i] = (vectorY[i] - suma) / U[i][i];
        }

        vectorSolucionStr = new String[n];
        for (int i = 0; i < n; i++) {
            vectorSolucionStr[i] = String.format("%.4f",vectorSolucion[i]);
        }
        return vectorSolucionStr;
    }

    //Getters
    public double[][] getL() {
        return L;
    }
    public double[][] getU() {
        return U;
    }
}