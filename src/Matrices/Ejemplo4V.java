package Matrices;
 public class Ejemplo4V {
        private Matriz m;

        public Ejemplo4V(){
            // 10x + y -z +w= 11
            // x + 12y + z -2w = 24
            //-x +2y +15z+w = 34
            //2x -y +z+10 = 23

            double[] ec1 = {10, 1, -1,1,11};
            double[] ec2 = {1, 12,  1,-2, 13};
            double[] ec3 = {-1, 2, 15, 1,34};
            double[] ec4 = {2, -1, 1, 10,23};

            m = new Matriz(0);
            m.definirTamanioMatriz(2);
            m.llenarMatriz(ec1, 0);
            m.llenarMatriz(ec2, 1);
            m.llenarMatriz(ec3,2);
            m.llenarMatriz(ec4,3);
        }

        public Matriz getMatriz(){ return m; }
    }



