package Raices;

public class Ejemplo1 extends Funcion {

    private String funcionStr = "f(x) = (x^2)-(e^x)-3x+2";
    private String derivadaStr = "f´(x) = 2x-(e^x)-3";

    @Override
    public String getFuncionStr() {
        return funcionStr;
    }
    @Override
    public String getDerivadaStr() {
        return derivadaStr;
    }
    @Override
    public double calcularValorFuncion(double a){
        return Math.pow(a,2) - Math.exp(a) - (3 * a) + 2;
    }
    @Override
    public double calcularValorDerivada(double a){
        return (2 * a) - Math.exp(a) - 3;
    }
}
