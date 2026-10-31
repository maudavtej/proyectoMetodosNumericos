package Matrices;

public class Gauss {

    public static void pivotearFilas(double[][] m, double[] b) {
        int n = m.length;
        for (int k = 0; k < n; k++) {
            int max = k;
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(m[i][k]) > Math.abs(m[max][k])) max = i;
            }
            if (max != k) {
                double[] tmpFila = m[k];
                m[k] = m[max];
                m[max] = tmpFila;

                double tmpB = b[k];
                b[k] = b[max];
                b[max] = tmpB;
            }
        }
    }

    public static void pivotearColumnas(double[][] m, String[] vars) {
        int n = m.length;
        for (int k = 0; k < n; k++) {
            int max = k;
            for (int j = k + 1; j < n; j++) {
                if (Math.abs(m[k][j]) > Math.abs(m[k][max])) max = j;
            }
            if (max != k) {
                for (int i = 0; i < n; i++) {   // intercambia la columna en todas las filas
                    double t = m[i][k];
                    m[i][k] = m[i][max];
                    m[i][max] = t;
                }
                String tv = vars[k];
                vars[k] = vars[max];
                vars[max] = tv;
            }
        }
    }

    public static double[][] resolucion(Funcion f) {
        double[][] matrizG = f.getMatriz();
        double[] coefG = f.getCoeficientes();
        pivotearFilas(matrizG, coefG);
        return matrizG;
    }

}
