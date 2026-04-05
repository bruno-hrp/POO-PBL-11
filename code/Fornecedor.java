import java.util.ArrayList;
import java.util.List;

public class Fornecedor implements Validador, Calculavel {
    //Atributos
    private String cnpj;
    private boolean dadosCompletos;
    private String nome;
    private List<ContratoPublico> contratos;

    public Fornecedor() {
    }

    //Métodos
    @Override
public boolean validar() {
    try {

        if (cnpj == null || cnpj.isEmpty()) {
            throw new NullPointerException("CNPJ inválido");
        }

        if (nome == null || nome.isEmpty()) {
            throw new NullPointerException("Nome inválido");
        }

        if (!dadosCompletos) {
            throw new Exception("Dados incompletos");
        }

        return true;

    } catch (NullPointerException e) {
        System.out.println("Erro fornecedor: " + e.getMessage());
        return false;

    } catch (Exception e) {
        System.out.println("Erro geral fornecedor: " + e.getMessage());
        return false;

    } finally {
        System.out.println("Validação fornecedor finalizada.");
    }
}

@Override
public double calcular() {
    try {
        if (contratos == null) {
            throw new NullPointerException("Lista de contratos nula");
        }

        if (contratos.isEmpty()) {
            throw new ArithmeticException("Sem contratos para calcular risco");
        }

        double risco = 0;

        for (ContratoPublico c : contratos) {
            try {
                if (!c.validar()) {
                    risco += 1;
                }
            } catch (Exception e) {
                System.out.println("Erro ao avaliar contrato: " + e.getMessage());
                risco += 1;
            }
        }

        return risco / contratos.size();

    } catch (ArithmeticException e) {
        System.out.println("Erro matemático: " + e.getMessage());
        return 0;

    } catch (NullPointerException e) {
        System.out.println("Erro no cálculo de risco: " + e.getMessage());
        return 0;

    } catch (Exception e) {
        System.out.println("Erro inesperado no cálculo: " + e.getMessage());
        return 0;

    } finally {
        System.out.println("Cálculo de risco finalizado.");
    }
}
    public void adicionarContrato(ContratoPublico contrato) {
    try {
        contratos.add(contrato);
    } catch (Exception e) {
        System.out.println("Erro ao adicionar contrato: " + e.getMessage());
    }
}

    //Construtor
    public Fornecedor(String cnpj, boolean dadosCompletos, String nome) {
        this.cnpj = cnpj;
        this.dadosCompletos = dadosCompletos;
        this.nome = nome;
        this.contratos = new ArrayList<>();
    }

    //Getters e setters
    public String getCnpj() {
        return cnpj;
    }

    public List<ContratoPublico> getContratos() {
    return contratos;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isDadosCompletos() {
        return dadosCompletos;
    }

    public void setDadosCompletos(boolean dadosCompletos) {
        this.dadosCompletos = dadosCompletos;
    }

}
