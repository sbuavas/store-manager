public class Vestuario extends Loja {
    private boolean produtosImportados;

    // Atributos da loja e se vende produtos importados (Construtor atualizado para Etapa4)
    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao,
                     boolean produtosImportados, int tamanhoEstoque) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoque);
        this.produtosImportados = produtosImportados;
    }

    // --- Métodos Getters e Setters ---
    public boolean getProdutosImportados() {
        return produtosImportados;
    }

    public void setProdutosImportados(boolean produtosImportados) {
        this.produtosImportados = produtosImportados;
    }

    // Inclui informações da loja de vestuário
    @Override
    public String toString() {
        return super.toString() +
                "\nTipo de Loja: Vestuário" +
                "\nVende Produtos Importados: " + (produtosImportados ? "Sim" : "Não");
    }
}