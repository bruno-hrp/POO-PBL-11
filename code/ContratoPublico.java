import java.util.List;

public class ContratoPublico implements Validador, Calculavel {
    
    //Atributos
    private String descricao;
    private double valorTotal;
    private double valorPago;
    private Fornecedor fornecedor;
    private List<NotaFiscal> notasFiscais;

    //Métodos
    @Override
    public boolean validar() {
        try {
            //Verifica se o fornecedor foi inicializado
            if(this.fornecedor == null) {
                throw new NullPointerException("Falha: Contrato sem fornecedor associado.");
            }
            //Verifica se os valores são válidos
            if(this.valorTotal < 0 || this.valorPago < 0) {
                throw new IllegalArgumentException("Falha: Valores financeiros negativos.");
            }

            return true; //Se não, os dados são validados.
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Erro na validação do contrato (" + this.descricao + "): " + e.getMessage());
            return false; 
        } finally {
            System.out.println("- Auditoria de validação concluída para o contrato " + this.descricao);
        }
    }

    @Override
    public double calcular() {
        try {
            if(this.valorTotal == 0) {
                throw new ArithmeticException("Divisão por zero: O valor total do contrato é 0.");
            }

            double percentual = (this.valorPago/this.valorTotal)*100;
            return percentual;

        } catch (ArithmeticException e) { //Erro matemático
            System.out.println("Erro matemático no contrato (" + this.descricao + "): " + e.getMessage());
            return -1.0;
        } catch (Exception e) {
            System.out.println("Erro inesperado ao calcular execução: " + e.getMessage());
            return -1.0;    
        } finally {
            System.out.println("- Cálculo de percentual de execução finalizado.");
        }
    }    

    //Construtor
    public ContratoPublico(String descricao, double valorTotal, double valorPago, Fornecedor fornecedor, List<NotaFiscal> notasFiscais) {
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.fornecedor = fornecedor;
        this.notasFiscais = notasFiscais;
    }

    //Getters e setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    public void setNotasFiscais(List<NotaFiscal> notasFiscais) {
        this.notasFiscais = notasFiscais;
    }
}