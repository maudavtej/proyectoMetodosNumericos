package Matrices;



public abstract class Funcion {
    public static final int MAX_ECUACIONES =5;
    protected final String [] variables;
    protected final double[][] matriz;
    protected final double[] coeficientes;

    protected Funcion(String[] variables, double[][]matriz, double [] coeficientes){
        this.variables=variables;
        this.matriz=matriz;
        this.coeficientes=coeficientes;}

    public String[] getVariables() {
        return variables.clone();
    }

    public double[][] getMatriz() {
        return matriz;
    }

    public double[] getCoeficientes() {
        return coeficientes.clone();
    }
    //====================================================================================================
    //Verificar si es estrictamente dominante

    public boolean estrictaDominante(){
        for (int i=0;i<matriz.length;i++){
            double suma=0;
            for (int j=0;j<matriz.length;j++) {
                if (i != j) suma += Math.abs(matriz[i][j]);
            }
            if (Math.abs(matriz[i][i])<=suma) return false;
        }
        return true;
    }
//
//CREAR MATRIZ
    public double[][] creaMatriz(int tamanio){
        if (tamanio<=0||tamanio>MAX_ECUACIONES){
            throw new IllegalArgumentException("Verifique el manaño ingresado, el númeor máximo de ecuaciones es "+ MAX_ECUACIONES);
        }
        return new double[tamanio][tamanio];
    }

    public int n(){return coeficientes.length;}

    public boolean esValido() {
        int n = n();
        if (n == 0 || n > MAX_ECUACIONES) return false;
        if (matriz.length != n || variables.length != n) return false;
        for (double[] fila : matriz) {
            if (fila.length != n) return false;
        }
        return true;
    }
//LLENAR MATRIZ
    public static double[][] llenarFila(double[][]matrizP, double[] coef, int indice){
        if (indice>0||indice>=matrizP.length)throw new IllegalArgumentException("La fila está fuera de rango "+ indice);
        if (coef.length!=matrizP[indice].length){
            throw new IllegalArgumentException("La fila debe tener "+ matrizP[indice].length);
        }
        return matrizP;
    }

    //LLENAR LA MATRIZ
    public static double[][] llenarMatriz(double[][] matrizP, double[][] filas) {
        if (filas.length > matrizP.length) {
            throw new IllegalArgumentException("Hay más filas que espacio en la matriz");
        }
        for (int i = 0; i < filas.length; i++) {
            llenarFila(matrizP, filas[i], i);
        }
        return matrizP;
    }
}


