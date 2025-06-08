public class Informatica extends Loja {
    private double seguroEletronicos;

    // Atributos da loja e seguro de Eletrônicos (Construtor atualizado para Etapa4)
    public Informatica(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                       Endereco endereco, Data dataFundacao, int tamanhoEstoque,
                       double seguroEletronicos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoque);
        this.seguroEletronicos = seguroEletronicos;
    }

    // --- Métodos Getters e Setters ---
    public double getSeguroEletronicos() { return seguroEletronicos; }
    public void setSeguroEletronicos(double seguroEletronicos) { this.seguroEletronicos = seguroEletronicos; }

    // Inlcui informações da loja de informática
    @Override
    public String toString() {
        return super.toString() +
                "\nTipo de Loja: Informática" +
                "\nSeguro Eletrônicos (mensal): R$ " + String.format("%.2f", this.seguroEletronicos);
    }
}