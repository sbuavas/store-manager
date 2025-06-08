public class Cosmetico extends Loja {
    private double taxaComercializacao;

    // Atributos da loja e taxa de comercialização (Construtor atualizado para Etapa4)
    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, int tamanhoEstoque,
                     double taxaComercializacao) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoque);
        this.taxaComercializacao = taxaComercializacao;
    }

    // --- Métodos Getters e Setters ---
    public double getTaxaComercializacao() { return taxaComercializacao; }
    public void setTaxaComercializacao(double taxaComercializacao) { this.taxaComercializacao = taxaComercializacao; }

    // Inclui informações da loja de cosméticos
    @Override
    public String toString() {
        return super.toString() +
                "\nTipo de Loja: Cosméticos" +
                "\nTaxa de Comercialização: " + String.format("%.2f%%", taxaComercializacao);
    }
}