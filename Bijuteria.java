public class Bijuteria extends Loja {
    private double metaVendas;

    // Atributos da loja e meta de vendas (Construtor atualizado para Etapa4)
    public Bijuteria(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, int tamanhoEstoque,
                     double metaVendas) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoque);
        this.metaVendas = metaVendas;
    }

    // --- Métodos Getters e Setters ---
    public double getMetaVendas() { return metaVendas; }
    public void setMetaVendas(double metaVendas) { this.metaVendas = metaVendas; }

    // Inlcui informações da loja de bijuterias
    @Override
    public String toString() {
        return super.toString() +
                "\nTipo de Loja: Bijuteria" +
                "\nMeta de Vendas Mensais: R$ " + String.format("%.2f", metaVendas);
    }
}