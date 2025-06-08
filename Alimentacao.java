public class Alimentacao extends Loja {
    private Data dataAlvara;
    // Atributos da loja e data do alvará (Construtor atualizado para Etapa4)
    public Alimentacao(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                       Endereco endereco, Data dataFundacao,
                       Data dataAlvara, int tamanhoEstoque) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoque);
        this.dataAlvara = dataAlvara;
    }

    // --- Métodos Getters e Setters ---
    public Data getDataAlvara() {
        return dataAlvara;
    }
    public void setDataAlvara(Data dataAlvara) {
        this.dataAlvara = dataAlvara;
    }

    // Inclui informações da loja de alimentação
    @Override
    public String toString() {
        String infoDataAlvara = (this.dataAlvara != null ? this.dataAlvara.toString() : "Não informada");
        return super.toString() +
                "\nTipo de Loja: Alimentação" +
                "\nData do Alvará: " + infoDataAlvara;
    }
}