public class NotaFiscal implements Validador {
    //Atributos
    private double valor;
    private boolean consistente;

    //Métodos
    @Override
    public boolean validar() {
    try {
        if (valor < 0) {
            throw new ArithmeticException("Valor negativo");
        }

        if (valor == 0) {
            throw new ArithmeticException("Valor inexistente");
        }

        return true;

    } catch (ArithmeticException e) {
        System.out.println("Erro nota fiscal: " + e.getMessage());
        return false;

    } finally {
        System.out.println("Validação NF finalizada.");
    }
}

    //Construtor
    public NotaFiscal(double valor, boolean consistente) {
        this.valor = valor;
        this.consistente = consistente;
    }

    //Getters e setters
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isConsistente() {
        return consistente;
    }

    public void setConsistente(boolean consistente) {
        this.consistente = consistente;
    }

}
