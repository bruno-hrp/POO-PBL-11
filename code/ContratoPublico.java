import java.util.ArrayList;
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

            for (NotaFiscal nf : notasFiscais) {
                if (notasFiscais == null) {
                    throw new NullPointerException("Lista de notas fiscais nula");
                }
                
                try {
                    if (!nf.validar()) {
                        System.out.println("Nota fiscal inválida");
             }
            } catch (Exception e) {
                System.out.println("Erro ao validar nota fiscal: " + e.getMessage());
                }
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
    @SuppressWarnings("UseSpecificCatch")
public double calcular() {
    try {
        if (this.valorTotal == 0) {
            throw new ArithmeticException("Divisão por zero: valor total é 0.");
        }

        if (notasFiscais == null) {
            throw new NullPointerException("Lista de notas fiscais nula");
        }

        double somaNotas = 0;

        for (NotaFiscal nf : notasFiscais) {
            try {
                if (nf == null) {
                    throw new NullPointerException("Nota fiscal nula");
                }

                somaNotas += nf.getValor();

            } catch (Exception e) {
                System.out.println("Erro ao processar nota: " + e.getMessage());
            }
        }

        if (Math.abs(somaNotas - valorPago) > 0.01) {
            System.out.println("Aviso: soma das notas diferente do valor pago");
        }

        double percentual = (valorPago / valorTotal) * 100;
        return percentual;

    } catch (ArithmeticException e) {
        System.out.println("Erro matemático: " + e.getMessage());
        return -1.0;

    } catch (Exception e) {
        System.out.println("Erro geral: " + e.getMessage());
        return -1.0;

    } finally {
        System.out.println("- Cálculo finalizado para contrato " + descricao);
    }
}
    
    public void adicionarNotaFiscal(NotaFiscal nota) {
    try {
        if (nota == null) {
            throw new NullPointerException("Nota fiscal nula");
        }

        notasFiscais.add(nota);

    } catch (NullPointerException e) {
        System.out.println("Erro ao adicionar nota: " + e.getMessage());
    }
}

    //Construtor
    public ContratoPublico(String descricao, double valorTotal, double valorPago, Fornecedor fornecedor) {
    this.descricao = descricao;
    this.valorTotal = valorTotal;
    this.valorPago = valorPago;
    this.fornecedor = fornecedor;
    this.notasFiscais = new ArrayList<>();
}
    public ContratoPublico(String descricao2, int valorTotal2, int valorPago2, Fornecedor f1, NotaFiscal nf1) {
        //TODO Auto-generated constructor stub
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