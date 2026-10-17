public class MetodoBiseccion {
    public static final int MAX_ITERACIONES=100;//================================================================================================
    //DESCRIPCION
    public static void descripcion(){
        System.out.println("========== MÉTODO DE BISECCIÓN =========\n");
        System.out.println("El método de bisección es un método numérico utilizado para encontrar aproximaciones de las raíces (o ceros) de una función continua dentro de un intervalo [a,b].\n");
        System.out.println("Se basa en el teorema del valor medio, el cuál establece que si una función continua cambia de signo en los extremos de un intervalo");
        System.out.println(" Si (f(a) *f(b)<0), existe al menos una raíz en ese intervalo\n");
        System.out.println("El orden de convergencia de este método es lineal, cerrado y gráfico");
    }
    //============================================================================================
    public void biseccion(int n,double a, double b){
        FuncionBisec[] ejemplos = new FuncionBisec[2];
        ejemplos[0]=new Ej1Biseccion();
        ejemplos[1]=new Ej2Biseccion();
        if (n<0||n>=ejemplos.length){
            throw new IllegalArgumentException("Elige un ejemplo válido");
        }
        if (a>=b){
            throw new IllegalArgumentException("El extremo a debe ser menor que el extremo b");
        }
        FuncionBisec f = ejemplos[n];
        double f_a = f.calcularValorFuncion(a);
        double f_b = f.calcularValorFuncion(b);

        if (f_a*f_b>0){
            throw new IllegalArgumentException("No existe cambio de signo en este intervalo. Intente con otro");
        }

        int iteraciones=0;
        double f_c;
        do {
            double c = (a+b)/2;
            f_c = f.calcularValorFuncion(c);
            iteraciones++;
            a = (f_a * f_c > 0) ? c : a;//si el signo es el mismo, sustituimos por c ese valor, si no sigue siendo el mismo
            f_a = (f_a * f_c > 0) ? f_c : f_a;
            b = (f_b * f_c > 0) ? c : b;
            f_b = (f_b * f_c > 0) ? f_c : f_b;
        }while (Math.abs(f_c)> FuncionBisec.TOLERANCIA&& iteraciones<MAX_ITERACIONES);









}}
