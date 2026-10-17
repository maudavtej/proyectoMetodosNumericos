public class Ejemplo2 extends Funcion{
    private final String funcionStr = "f(x) = Ln(x) + (e^-x) - 0.5";
    private final String derivadaStr = "f´(x) = (1/x) - (e^-x)";

    @Override
    //Getters
    public String getFuncionStr() {
        return funcionStr;
    }
    @Override
    public String getDerivadaStr() {
        return derivadaStr;
    }
    @Override
    public double calcularValorFuncion(double a){
        return Math.log(a) + Math.exp(-a) - 0.5;
    }
    @Override
    public double calcularValorDerivada(double a){
        return (1.0/a) - Math.exp(-a);
    }
}
