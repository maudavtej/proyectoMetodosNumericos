package Matrices;

public abstract class Funcion {
    public abstract String [] getVariables();
    public abstract double[][] getMatriz();
    public abstract double [] getCoeficientes();

    //====================================================================================================
    //Verificar si es estrictamente dominante

    public boolean estrictaDominante(){
        double [][]matriz = getMatriz();
        for (int i=0;i<matriz.length;i++){
            double suma=0;
            for (int j=0;j<matriz.length;j++) {
                if (i != j) suma += Math.abs(matriz[i][j]);
            }
            if (Math.abs(matriz[i][i])<suma) return false;
        }
        return true;
    }
}
