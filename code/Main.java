import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            // Fornecedores
            Fornecedor f1 = new Fornecedor("123", true, "Empresa Boa");
            Fornecedor f2 = new Fornecedor(null, false, null);

            // Contratos
            ContratoPublico c1 = new ContratoPublico("Contrato 1", 1000, 500, f1);
            ContratoPublico c2 = new ContratoPublico("Contrato 2", 0, 300, f1);
            ContratoPublico c3 = new ContratoPublico("Contrato 3", 1000, 1500, f2);
            ContratoPublico c4 = null;
            ContratoPublico c5 = new ContratoPublico("Contrato 4", 500, 200, null);
            

            // Notas fiscais
            NotaFiscal nf1 = new NotaFiscal(500, true);
            NotaFiscal nf2 = new NotaFiscal(-100, true); // erro
            NotaFiscal nf3 = null; // erro proposital
            NotaFiscal nf4 = new NotaFiscal(300, true);
            NotaFiscal nf5 = new NotaFiscal(1500, false); // inconsistente

            c1.adicionarNotaFiscal(nf1);
            c1.adicionarNotaFiscal(nf2);
            c1.adicionarNotaFiscal(nf3);
            c2.adicionarNotaFiscal(nf4);
            c3.adicionarNotaFiscal(nf5);

            // Associação
            f1.adicionarContrato(c1);
            f1.adicionarContrato(c2);
            f2.adicionarContrato(c3);
            

            // Lista
            List<ContratoPublico> contratos = new ArrayList<>();
            contratos.add(c1);
            contratos.add(c2);
            contratos.add(c3);
            contratos.add(c4);
            contratos.add(c5);


            // Auditoria
            Auditoria auditoria = new Auditoria(contratos);

            auditoria.auditar();

        } catch (Exception e) {
            System.out.println("Erro geral na main: " + e.getMessage());

        } finally {
            System.out.println("Sistema encerrado.");
        }
    }
}