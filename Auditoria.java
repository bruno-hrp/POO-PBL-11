public class Auditoria implements Auditavel {
    //Atributos
    private List<ContratoPublico> contratos;

    //Métodos
    @Override
    public void auditar() {

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
