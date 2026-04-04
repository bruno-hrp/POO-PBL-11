public class Fornecedor implements Validador, Calculavel {
    //Atributos
    private String cnpj;
    private boolean dadosCompletos;

    //Métodos
    @Override
    public boolean validar() {
        cnpj;
    }

    @Override
    public double calcular() {

    }

    //Construtor
    public Fornecedor(String cnpj, boolean dadosCompletos) {
        this.cnpj = cnpj;
        this.dadosCompletos = dadosCompletos;
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
