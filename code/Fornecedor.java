import java.util.ArrayList;
import java.util.List;

public class Fornecedor implements Validador, Calculavel {
    //Atributos
    private String cnpj;
    private boolean dadosCompletos;
    private String nome;
    private List<ContratoPublico> contratos;

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
        if (contratos == null || contratos.isEmpty()) {
            throw new NullPointerException("Sem contratos");
        }

        double risco = 0;

        for (ContratoPublico c : contratos) {
            try {
                if (!c.validar()) {
                    risco += 1; // contrato problemático aumenta risco
                }
            } catch (Exception e) {
                System.out.println("Erro ao avaliar contrato");
                risco += 1;
            }
        }

        return risco / contratos.size();

    } catch (NullPointerException e) {
        System.out.println("Erro no cálculo de risco: " + e.getMessage());
        return 0;

    } finally {
        System.out.println("Cálculo de risco finalizado.");
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
