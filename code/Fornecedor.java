public class Fornecedor implements Validador, Calculavel {
    //Atributos
    private String cnpj;
    private boolean dadosCompletos;

    //Métodos
    @Override
    public boolean validar() {
        public boolean validar() {
    try {
        if (nome == null) {
            throw new NullPointerException("Nome inválido");
        }

        return true;

    } catch (Exception e) {
        System.out.println("Erro fornecedor: " + e.getMessage());
        return false;

    } finally {
        System.out.println("Validação fornecedor finalizada.");
    }
}
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
