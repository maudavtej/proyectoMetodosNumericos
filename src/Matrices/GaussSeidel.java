package Matrices;

import java.util.ArrayList;

public class GaussSeidel {

    private static final int MAX_ITERACIONES = 100;
    private static final double TOLERANCIA = 1e-4;

    private double[] solucionFinal;
    private int iteracionesUsadas;

    public boolean estrictaDominante(Matriz m) {
        double[][] matriz = m.getMatriz();
        int n = m.getN();
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) suma += Math.abs(matriz[i][j]);
            }
            if (Math.abs(matriz[i][i]) <= suma) return false;
        }
        return true;
    }

    public ArrayList<double[]> funcionGaussSeidel(Matriz m) {
        if (!estrictaDominante(m))
            throw new IllegalArgumentException("La matriz no es estrictamente dominante");

        double[][] A = m.getMatriz();
        int n = m.getN();

        double[] x = new double[n];

        for (int i = 0; i < n; i++) {
            x[i] = A[i][n] / A[i][i];
        }

        ArrayList<double[]> tabla = new ArrayList<>();
        boolean converge = false;
        int iter = 0;
        double errorMax;

        do {
            iter++;
            errorMax = 0.0;

            for (int i = 0; i < n; i++) {
                double suma = A[i][n];
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma -= A[i][j] * x[j];
                    }
                }
                double nuevo = suma / A[i][i];
                errorMax = Math.max(errorMax, Math.abs(nuevo - x[i]));
                x[i] = nuevo;
            }

            double[] fila = new double[n + 1];
            System.arraycopy(x, 0, fila, 0, n);
            fila[n] = errorMax;
            tabla.add(fila);

            if (errorMax < TOLERANCIA) {
                converge = true;
            }

        } while (!converge && iter < MAX_ITERACIONES);

        if (!converge) {
            throw new IllegalArgumentException("No convergió en " + MAX_ITERACIONES + " iteraciones");
        }

        this.solucionFinal = x.clone();
        this.iteracionesUsadas = iter;
        return tabla;
    }

    public double[] getSolucionFinal() { return solucionFinal; }
    public int getIteracionesUsadas()  { return iteracionesUsadas; }
}