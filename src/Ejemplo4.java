public class Ejemplo4 extends Funcion {
    private String funcion2 = "f(x)= x^3-xe^x^2+3";
    private String derivada2 = "f'(x)=3x^2-e^x^2+2xe^x";
    @Override
    public String getFuncionStr(){
        return  funcion2;
    }
    @Override
    public String getDerivadaStr(){
        return derivada2;
    }
    @Override

    public double calcularValorFuncion(double a){
        return Math.pow(a,3)-a*Math.exp(Math.pow(a,2))+3;
    }

    @Override
    public double calcularValorDerivada(double a){
        return 3*Math.pow(a,2)-Math.exp(Math.pow(a,2))+2*a*Math.exp(a);
    }

}
