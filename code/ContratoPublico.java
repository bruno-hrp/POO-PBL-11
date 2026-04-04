import java.util.List;

public class ContratoPublico implements Validr, Calculavel {
    
    //Atributos
    private String descricao;
    private double valorTotal;
    private double valorPago;
    private Fornecedor fornecedor;
    private List<NotaFiscal> notasFiscais;

    //Métodos
    @Override
    public boolean validar() {
        
    }

    @Override
    public double calcular() {
        
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