package Matrices;

public class Ejemplo2V {

    private Matriz m;

    public Ejemplo2V(){
        // 6x +  y = 16
        // 3x + 2y = 8
        double[] ec1 = {6, 1, 16};
        double[] ec2 = {3, 2,  7};

        m = new Matriz(0);
        m.definirTamanioMatriz(2);
        m.llenarMatriz(ec1, 0);
        m.llenarMatriz(ec2, 1);
    }

    public Matriz getMatriz(){ return m; }
}