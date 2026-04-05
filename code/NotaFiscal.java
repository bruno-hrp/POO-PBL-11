public class NotaFiscal implements Validador {
    //Atributos
    private double valor;
    private boolean consistente;

    //Métodos
    @Override
    public boolean validar() {
        try {
            if (Double.isNaN(valor)) {
                throw new Exception("Valor inválido (NaN)");
        }

            if (valor < 0) {
                throw new ArithmeticException("Valor negativo");
        }

            if (valor == 0) {
                throw new ArithmeticException("Valor inexistente");
        }

            if (!consistente) {
                throw new Exception("Nota fiscal inconsistente");
        }

        return true;

    } catch (ArithmeticException e) {
        System.out.println("Erro nota fiscal: " + e.getMessage());
        return false;

    } catch (Exception e) {
        System.out.println("Erro geral nota fiscal: " + e.getMessage());
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
