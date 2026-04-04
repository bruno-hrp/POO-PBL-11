public class NotaFiscal implements Validador {
    //Atributos
    private double valor;
    private boolean consistente;

    //Métodos
    @Override
    public boolean validar() {

        try {
        if (valorTotal == null) {
            throw new NullPointerException("Valor total nulo");
        }

        if (valorTotal <= 0) {
            throw new ArithmeticException("Valor total inválido");
        }

        return true;

    } catch (NullPointerException e) {
        System.out.println("Erro: " + e.getMessage());
        return false;

    } catch (ArithmeticException e) {
        System.out.println("Erro: " + e.getMessage());
        return false;

    } finally {
        System.out.println("Validação do contrato finalizada.");
    }
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
