public class Ejemplo3 extends Funcion{
    private String funcion1= "f(x)= 3x-e^x";
    private String derivada = "f'(x)=2-e^x";
    @Override
    public String getFuncionStr() {
        return funcion1;
    }
    @Override
    public String getDerivadaStr(){
        return derivada;
    }
    @Override
    public double calcularValorFuncion(double a) {
        return 3* a - Math.exp(a);
    }
    @Override
    public  double calcularValorDerivada(double a){
        return 2-Math.exp(a);
    }

}

