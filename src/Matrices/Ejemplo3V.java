package Matrices;

public class Ejemplo3V {
    private Matriz m;

    public Ejemplo3V(){
        // 11x -3y-2z = 18
        // 5x - 2y -8z = 13
        //4x -7y +2z = 2
        double[] ec1 = {11, -3, 2,18};
        double[] ec3 = {5, -2,  -8, 13};
        double[] ec2 = {4, -7, 2, 2};

        m = new Matriz(0);
        m.definirTamanioMatriz(2);
        m.llenarMatriz(ec1, 0);
        m.llenarMatriz(ec2, 1);
        m.llenarMatriz(ec3,2);
    }

    public Matriz getMatriz(){ return m; }
}

