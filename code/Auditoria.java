import java.util.List;

public class Auditoria implements Auditavel {
    //Atributos
    private List<ContratoPublico> contratos;

    //Métodos
    @Override
    public void auditar() {
        System.out.println("- Iniciando auditoria...");
        System.out.println("Total de contratos a analisar: " + contratos.size());

        for(ContratoPublico contrato : contratos) {
           try {
                if (contratos == null) {
                    throw new NullPointerException("Lista de contratos nula");
    }

    System.out.println("- Iniciando auditoria...");
    System.out.println("Total de contratos a analisar: " + contratos.size());

                System.out.println("\n - Analisando contrato: " + contrato.getDescricao() + ".");

                boolean isValido = contrato.validar();
                double percentual = contrato.calcular();

                if(isValido && percentual != -1.0) {
                    System.out.println("Auditoria concluída.");
                } else {
                    System.out.println("Auditoria apontou irregularidades neste contrato.");
                }
            } catch (NullPointerException e) {
                System.out.println("Falha de acesso." + e.getMessage());  
            } catch (Exception e) {
                System.out.println("Falha inesperada." + e.getMessage());
            } finally {
                System.out.println("- Item analisado. Avançando...");
            }
        }

        System.out.println("- Auditoria encerrada.");
    }

    //Construtor
    public Auditoria(List<ContratoPublico> contratos) {
        this.contratos = contratos;
    }

    //Getters e setters
    public List<ContratoPublico> getContratos() {
        return contratos;
    }

    public void setContratos(List<ContratoPublico> contratos) {
        this.contratos = contratos;
    }
}
