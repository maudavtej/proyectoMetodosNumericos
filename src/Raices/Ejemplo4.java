package Raices;

public class Ejemplo4 extends Funcion {

    private String funcion2 = "f(x)= x^3 - xe^x^2 + 3";
    private String derivada2 = "f'(x) = 3x² - e^(x²) - 2x²·e^(x²)";

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
        double x2 = a*a;
        return 3*x2 - Math.exp(x2) - 2*x2*Math.exp(x2);
    }

    public static String toStringFunc(){
        return "f(x) = x<sup>3</sup> - xe<sup>x<sup>2</sup></sup> + 3";
    }
    public static String toStringDer(){
        return "f′(x) = 3x<sup>2</sup> - e<sup>x<sup>2</sup></sup> + 2xe<sup>x</sup>";
    }

}
