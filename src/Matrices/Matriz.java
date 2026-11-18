package Matrices;

import javax.swing.*;
import java.awt.*;

public class Matriz{
    //Variables
    private int n;
    private double[][] matriz;
    public static final String[] INCOGNITAS = {"x","y","z","w","g"};


    //=====================================================
    //CONSTRUCTOR
    public Matriz(int n, double[][]matriz){
        this.n=n;
        this.matriz=matriz;
    }
    public Matriz(int n){
        this.n=n;
        this.matriz=new double[n][n+1];
    }

    //=====================================================
    //GETTERS
    public int getN() {
        return n;
    }
    public double[][] getMatriz() {
        return matriz;
    }

    //=====================================================
    //Define tamaño de la matriz
    public void definirTamanioMatriz(int tamanioMatriz){
        if(tamanioMatriz >= 2 && tamanioMatriz <= 5){
            n = tamanioMatriz;
            matriz = new double[n][n+1];
        }else{
            throw new IllegalArgumentException("Tamaño fuera de rango");
        }
    }
    public void llenarMatriz(double numeros[], int numeroFila){
        for(int columna = 0; columna <= n; columna++){
            matriz[numeroFila][columna] = numeros[columna];
        }
    }

    //=====================================================
    public void pivoteoParcial(int columnaEvaluada){
        double pivote = Math.abs(matriz[columnaEvaluada][columnaEvaluada]);
        int filaDelPivote = columnaEvaluada;

        for(int fila = columnaEvaluada + 1; fila < matriz.length; fila++){
            if(Math.abs(matriz[fila][columnaEvaluada]) > pivote){
                pivote = Math.abs(matriz[fila][columnaEvaluada]);
                filaDelPivote = fila;
            }
        }

        if(pivote < 1e-12){
            JOptionPane.showMessageDialog(null,"Pivoteo cero, no se puede implementar metodo");
            return;
        }

        multiplicarFila(filaDelPivote, 1 / matriz[filaDelPivote][columnaEvaluada]);

        if(filaDelPivote != columnaEvaluada){
            intercambiarFila(filaDelPivote, columnaEvaluada);
        }
    }
    public void intercambiarFila(int filaOrigen,int filaDestino){
        double[] filaAux = new double[n + 1];

        //Guardamos los valores de la fila que se va a replazar
        for(int columna = 0; columna <= n; columna++){
            filaAux[columna] = matriz[filaDestino][columna];
        }

        //Cambiamos los valores de la fila destino
        for(int columna = 0; columna <= n; columna++){
            matriz[filaDestino][columna] = matriz[filaOrigen][columna];
        }

        //Asignamos los valores de la fila remplazada a la fila origen
        llenarMatriz(filaAux,filaOrigen);
    }
    public void multiplicarFila(int filaEvaluada,double factor){
        for(int columna = 0; columna <= n; columna++){
            matriz[filaEvaluada][columna] = factor * matriz[filaEvaluada][columna];
        }
    }
    public void restaFilas(int filaOrigen,int filaRestada,double factor){
        double[] filaAux =  new double[n + 1];

        for(int columna = 0; columna <= n; columna++){
            filaAux[columna] = matriz[filaOrigen][columna] - factor * matriz[filaRestada][columna];
        }

        llenarMatriz(filaAux,filaOrigen);
    }
    //Método para obtener los valores independientes (vector solución)
    public double[]getTerminosIndep(){
        double[] b = new double[n];
        for(int i=0;i<n;i++){
            b[i]=matriz[i][n];
        }
        return b;
    }

    @Override
    public String toString(){
        java.text.DecimalFormat df = new java.text.DecimalFormat("0.####");
        StringBuilder matrizStr = new StringBuilder();

        for (int fila = 0; fila < matriz.length; fila++){
            for (int columna = 0; columna <= n; columna++){
                String valor = df.format(matriz[fila][columna]);

                if(columna != n){
                    if (matriz[fila][columna] > 0 && columna > 0) {
                        matrizStr.append(" + ");
                    } else if (matriz[fila][columna] < 0 && columna > 0) {
                        matrizStr.append(" - ");
                    } else if (columna > 0) {
                        matrizStr.append(" ");
                    }

                    matrizStr.append(valor).append(INCOGNITAS[columna]);
                } else {
                    matrizStr.append(" = ").append(valor);
                }
            }
            matrizStr.append("\n");
        }
        return matrizStr.toString();
    }
    public String toStringMatrizAumentada(){
        String matrizStr = "";
        for (int fila  = 0; fila < matriz.length; fila++){
            for (int columna = 0; columna <= n; columna++){
                if(columna != n){
                    matrizStr += " "+matriz[fila][columna];
                }else{
                    matrizStr += "| "+matriz[fila][columna];
                }
            }
            matrizStr += "\n";
        }
        return matrizStr;
    }
    public String toStringDesp(){
        String s = "";
        for(int fila=0;fila<n;fila++){
            s+=INCOGNITAS[fila]+"= (" +matriz[fila][n];
            for(int columna=0;columna<n;columna++){
                if(columna==fila)continue;
                double coef=-matriz[fila][columna];
                s+=(coef>=0 ?"+":"-")+Math.abs(coef)+INCOGNITAS[columna];
            }
            s+=")/"+matriz[fila][fila]+"\n";
        }
        return s;
    }
}