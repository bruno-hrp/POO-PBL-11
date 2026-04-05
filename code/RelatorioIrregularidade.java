import java.util.ArrayList;
import java.util.List;

public class RelatorioIrregularidade implements Relatavel {

    // Atributos
    private List<String> falhas;

    // Construtor
    public RelatorioIrregularidade() {
        this.falhas = new ArrayList<>();
    }

    public void registrarFalha(String descricaoFalha) {
        try {
            if (descricaoFalha == null || descricaoFalha.trim().isEmpty()) {
                throw new IllegalArgumentException("Tentativa de registrar uma falha vazia.");
            }
            this.falhas.add(descricaoFalha);
            
        } catch (Exception e) {
            System.out.println("[Erro no Relatório] Não foi possível registrar a falha: " + e.getMessage());
        }
    }

    @Override
    public void gerarRelatorio() {
        try {
            System.out.println("\n===========================================");
            System.out.println("      RELATÓRIO OFICIAL DE AUDITORIA       ");
            System.out.println("===========================================");

            
            if (this.falhas == null) {
                throw new NullPointerException("A lista de falhas foi destruída ou não inicializada.");
            }

            if (this.falhas.isEmpty()) {
                System.out.println("[OK] EXCELENTE! Nenhuma irregularidade foi encontrada nos contratos.");
            } else {
                System.out.println("[ALERTA] Foram encontradas " + this.falhas.size() + " irregularidade(s):");
                

                for (String falha : this.falhas) {
                    System.out.println(" - " + falha);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro crítico ao gerar o relatório consolidado: " + e.getMessage());
            
        } finally {
            System.out.println("===========================================");
            System.out.println("-> Fim do documento.");
            System.out.println("===========================================\n");
        }
    }

    // Getters e Setters
    public List<String> getFalhas() {
        return falhas;
    }

    public void setFalhas(List<String> falhas) {
        this.falhas = falhas;
    }
}