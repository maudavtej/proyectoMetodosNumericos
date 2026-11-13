package Matrices;

    public class Ejemplo5V {
        private Matriz m;

        public Ejemplo5V(){
            // 20x - 2y +z -w+g= 35
            // x + 15y -2z +w-g = 43
            //-x +3y +25z-2w+g = 81
            //2x -y -z+18w-3g = 56
            //x +2y -z+ 2w+ 16g = 76

            double[] ec1 = {20, -2, 1,-1,1,35};
            double[] ec2 = {1, 15,  -2,1, -1,43};
            double[] ec3 = {-1, 3, 25, -2,1,81};
            double[] ec4 = {2, -1, -1, 18,-3,56};
            double[] ec5 = {1, 2, -1, 2,16,76};

            m = new Matriz(0);
            m.definirTamanioMatriz(2);
            m.llenarMatriz(ec1, 0);
            m.llenarMatriz(ec2, 1);
            m.llenarMatriz(ec3,2);
            m.llenarMatriz(ec4,3);
            m.llenarMatriz(ec5,4);
        }

        public Matriz getMatriz(){ return m; }
    }




