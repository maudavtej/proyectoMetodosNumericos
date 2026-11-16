package Matrices;

import Raices.Ejemplo2;

public class Jacobi {

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
    public Matriz obtenerEjemplo(int n){
        switch (n){
            case 0: return new Ejemplo2V().getMatriz();
            case 1: return new Ejemplo3V().getMatriz();
            case 2: return new Ejemplo4V().getMatriz();
            case 3: return new Ejemplo5V().getMatriz();
            default: throw new IllegalArgumentException("Elige un ejemplo válido (0-4)");
        }
    }

}
