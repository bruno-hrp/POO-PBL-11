public class NotaFiscal implements Validador {
    //Atributos
    private double valor;
    private boolean consistente;

    //Métodos
    @Override
    public boolean validar() {

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
