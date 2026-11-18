package Raices;

public class Ejemplo2 extends Funcion {

    // Cambiamos los textos de la función y la derivada
    private final String funcionStr = "f(x) = cos(x) - x";
    private final String derivadaStr = "f'(x) = -sen(x) - 1";

    @Override
    public String getFuncionStr() { return funcionStr; }

    @Override
    public String getDerivadaStr() { return derivadaStr; }

    @Override
    public double calcularValorFuncion(double a){
        // En Java, Math.cos() recibe radianes
        return Math.cos(a) - a;
    }

    @Override
    public double calcularValorDerivada(double a){
        return -Math.sin(a) - 1;
    }

    public static String toStringFunc(){
        return "f(x) = cos(x) - x";
    }

    public static String toStringDer(){
        return "f′(x) = -sen(x) - 1";
    }
}