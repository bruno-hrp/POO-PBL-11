public class RelatorioIrregularidade implements Relatavel {
    //Atributos
    private List<String> falhas;

    //Métodos
    @Override
    public void gerarRelatorio() {

    }

    //Construtor
    public RelatorioIrregularidade(List<String> falhas) {
        this.falhas = falhas;
    }

    //Getters e setters
    public List<String> getFalhas() {
        return falhas;
    }

    public void setFalhas(List<String> falhas) {
        this.falhas = falhas;
    }
}