public class Ej2Biseccion extends FuncionBisec {
    private String funcion2 = "f(x)= x^3-xe^x^2+3";
    @Override
    public String getFuncionStr(){
        return  funcion2;
    }
    @Override

    public double calcularValorFuncion(double a){
        return Math.pow(a,3)-a*Math.exp(Math.pow(a,2))+3;
    }

}
