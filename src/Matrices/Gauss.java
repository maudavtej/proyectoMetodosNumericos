package Matrices;

import java.util.Scanner;

public class Gauss {

    public static void gauss(double[][] matrizInput) {

        //Copia de valores en otra variable
        Matriz matriz = new Matriz();
        Matriz matrizOriginal = new Matriz();
        int n = matrizInput.length;
        matriz.definirTamanioMatriz(n);
        matrizOriginal.definirTamanioMatriz(n);

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
        for (int fila = n- 1; fila >= 0; fila--) {
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

        String sistemaStr = "";
        String matrizAumentadaStr = "";
        sistemaStr = matrizOriginal.toString();
        matrizAumentadaStr = matrizOriginal.toStringMatrizAumentada();

        //Sistema de ecucacioens
        System.out.println("Sistema de ecuaciones: \n"+sistemaStr);
        //Matriz aumentada:
        System.out.println("Matriz aumentada: \n"+matrizAumentadaStr);

        //Resultado
        System.out.println("Vector solucion: ");
        for (int i = 0; i < n; i++) {
            System.out.println(Matriz.INCOGNITAS[i] + " = " + vectorSolucion[i]);
        }
    }

    public static void main(){
        Scanner leer = new Scanner(System.in);

        int n;
        double[][] matriz;

        //Se define tamaño matriz
        System.out.print("Ingrese tamaño matriz: ");
        n = leer.nextInt();

        matriz = new double[n][n + 1];;

        //Llenado matriz
        for (int i = 0; i < n; i++){
            for(int j = 0; j <= n; j++){
                if(j < n){
                    System.out.print("Ingrese a"+i+","+j+": ");
                    matriz[i][j] = leer.nextFloat();
                }else{
                    System.out.print("Ingrese b"+i+": ");
                    matriz[i][j] = leer.nextFloat();
                }
            }
        }

        gauss(matriz);
    }
}
