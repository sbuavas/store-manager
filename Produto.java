public class Produto {
    private String nome;
    private double preco;
    private Data dataValidade; // Atributo novo (Etapa2)

    // Verifica se o produto está vencido (Etapa2)
    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    // --- Métodos Getters e Setters ---
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public Data getDataValidade() { return dataValidade; }
    public void setDataValidade(Data dataValidade) { this.dataValidade = dataValidade; }

    // toString [Incluido dataDeValidade (Etapa3)]
    @Override
    public String toString() {
        String infoDataValidade = (this.dataValidade != null ? this.dataValidade.toString() : "Não informada");
        return "Produto: " + nome +
                ", Preço: R$ " + String.format("%.2f", preco) +
                ", Data de Validade: " + infoDataValidade;
    }

    // Verifica se o produto está vencido (Etapa2 mas já com if e else)
    public boolean estaVencido(Data dataReferencia) {
        if (this.dataValidade == null || dataReferencia == null) {
            return false;
        }
        if (this.dataValidade.getAno() < dataReferencia.getAno()) return true;
        if (this.dataValidade.getAno() > dataReferencia.getAno()) return false;
        if (this.dataValidade.getMes() < dataReferencia.getMes()) return true;
        if (this.dataValidade.getMes() > dataReferencia.getMes()) return false;
        return this.dataValidade.getDia() < dataReferencia.getDia();
    }
}