package Matrices;

import java.util.Scanner;

public class Gauss {

    private String[] vectorSolucionStr;

    public String[] gauss(double[][] matrizInput) {

        //Copia de valores en otra variable
        int n = matrizInput.length;
        Matriz matriz = new Matriz(n,matrizInput);
        Matriz matrizOriginal = new Matriz(n,matrizInput);

        for(int i = 0; i < n; i++){
            matriz.llenarMatriz(matrizInput[i],i);
            matrizOriginal.llenarMatriz(matrizInput[i],i);
        }

        double[][] matrizAux = matriz.getMatriz();
        double[] vectorSolucion = new double[n];

        for (int contador = 0; contador < n; contador++){
            matriz.pivoteoParcial(contador);
            for (int fila = contador + 1; fila < n; fila++) {
                matriz.restaFilas(fila, contador, matrizAux[fila][contador]);
            }
        }

        //Sustitucion
        for (int fila = n - 1; fila >= 0; fila--) {
            for (int columna = 0; columna < n; columna++) {
                //Asigna el primer valor del vector solucion
                if (fila == columna && fila == n - 1) {
                    vectorSolucion[n - 1] = matrizAux[fila][columna + 1];
                }
                if (fila < columna) {
                    //Multuplicamos el valor por la incognita
                    matrizAux[fila][columna] *= vectorSolucion[columna];
                    //La pasamos del otro lado de la igualdad y la operamos con el valor que este ahi
                    matrizAux[fila][n] += matrizAux[fila][columna] * -1;
                }
                vectorSolucion[fila] = matrizAux[fila][n];
            }
        }

        //Resultado
        vectorSolucionStr = new String[n];
        for (int i = 0; i < n; i++) {
            vectorSolucionStr[i] = String.format(String.valueOf(vectorSolucion[i]));
        }

        return vectorSolucionStr;
    }
}