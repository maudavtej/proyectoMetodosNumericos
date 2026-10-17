public abstract class Funcion extends FuncionBisec {
    //Variables
    protected static final double TOLERANCIA = 0.0001;

    //Funciones:
    public abstract String getFuncionStr();
    public abstract String getDerivadaStr();
    public abstract double calcularValorFuncion(double a);
    public abstract double calcularValorDerivada(double a);

}