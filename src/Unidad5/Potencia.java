package Unidad5;

import Matrices.Matriz;

public class Potencia {

    public void potencia(double[][] matrizInput){
        //Copia de valores en otra variable
        int n = matrizInput.length;
        Matriz matriz = new Matriz(n,matrizInput);
        Matriz matrizOriginal = new Matriz(n,matrizInput);

        for(int i = 0; i < n; i++){
            matriz.llenarMatriz(matrizInput[i],i);
            matrizOriginal.llenarMatriz(matrizInput[i],i);
        }

        double[][] matrizAux = matriz.getMatriz();

    }
}
