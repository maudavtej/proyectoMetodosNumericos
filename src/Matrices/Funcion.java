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
    public String variables(){
        return String.join(", ", variables);
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


}
