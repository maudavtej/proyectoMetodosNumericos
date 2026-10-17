public class Ej1Biseccion extends FuncionBisec {
    private String funcion1= "f(x)= 3x-e^x";
    @Override
    public String getFuncionStr() {
        return funcion1;
    }
    @Override
    public double calcularValorFuncion(double a) {
        return 3* a - Math.exp(a);
    }

}
