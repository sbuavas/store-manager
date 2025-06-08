public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas; // Novo array para Loja

    // Construtor: Nome, Endereco e capaidade do aray de lojas
    public Shopping(String nome, Endereco endereco, int quantidadeMaximaLojas) {
        this.nome = nome;
        this.endereco = endereco;
        if (quantidadeMaximaLojas >= 0) {
            this.lojas = new Loja[quantidadeMaximaLojas];
        } else {
            this.lojas = new Loja[0]; // Caso o valor seja negativo
        }
    }

    // --- Métodos Getters e Setters ---
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public Loja[] getLojas() { return lojas; }
    public void setLojas(Loja[] lojas) { this.lojas = lojas; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shopping: ").append(this.nome);
        if (this.endereco != null) sb.append("\nEndereço:\n").append(this.endereco.toString());
        else sb.append("\nEndereço: Não informado");

        sb.append("\n\n--- Informações das Lojas no Shopping ---");
        if (this.lojas != null) {
            sb.append("\nCapacidade Máxima: ").append(this.lojas.length).append(" lojas.");
            int lojasRegistradas = 0;
            for (Loja l : this.lojas) {
                if (l != null) lojasRegistradas++;
            }
            sb.append("\nLojas Registradas: ").append(lojasRegistradas);
        } else {
            sb.append("\nArray de lojas não inicializado.");
        }
        return sb.toString();
    }

    // Novo método para inserir uma loja no primeiro espaço livre do array
    public boolean insereLoja(Loja lojaParaInserir) {
        if (lojaParaInserir == null || this.lojas == null) return false;
        for (int i = 0; i < this.lojas.length; i++) {
            if (this.lojas[i] == null) {
                this.lojas[i] = lojaParaInserir;
                return true;
            }
        }
        return false; // Cheio
    }

    // Novo método para remover uma loja do array pelo nome
    public boolean removeLoja(String nomeDaLojaParaRemover) {
        if (nomeDaLojaParaRemover == null || this.lojas == null) return false;
        for (int i = 0; i < this.lojas.length; i++) {
            if (this.lojas[i] != null && this.lojas[i].getNome().equals(nomeDaLojaParaRemover)) {
                this.lojas[i] = null;
                return true;
            }
        }
        return false; // Não encontrada
    }

    // Novo método para retornar a quantidade de lojas no shopping
    public int quantidadeLojasPorTipo(String tipoLoja) {
        if (tipoLoja == null || this.lojas == null) return -1; // Retorna -1 para entrada nula
        int contador = 0;

        // Verifica se o tipo de loja é válido
        boolean tipoValido = false;
        String[] tiposConhecidos = {"Cosmetico", "Vestuario", "Bijuteria", "Alimentacao", "Informatica"};
        for (String conhecido : tiposConhecidos) {
            if (conhecido.equalsIgnoreCase(tipoLoja)) {
                tipoValido = true;
                break;
            }
        }
        if (!tipoValido) return -1; // Retorna -1 se o tipo de string não é reconhecido

        // Conta as lojas de um certo tipo
        for (Loja loja : this.lojas) {
            if (loja != null) {
                if (tipoLoja.equalsIgnoreCase("Cosmetico") && loja instanceof Cosmetico) contador++;
                else if (tipoLoja.equalsIgnoreCase("Vestuario") && loja instanceof Vestuario) contador++;
                else if (tipoLoja.equalsIgnoreCase("Bijuteria") && loja instanceof Bijuteria) contador++;
                else if (tipoLoja.equalsIgnoreCase("Alimentacao") && loja instanceof Alimentacao) contador++;
                else if (tipoLoja.equalsIgnoreCase("Informatica") && loja instanceof Informatica) contador++;
            }
        }
        return contador;
    }

    // Novo método para retornar a loja de informática com o seguro mais caro
    public Informatica lojaSeguroMaisCaro() {
        if (this.lojas == null) return null;
        Informatica lojaMaisCara = null;
        double maiorSeguro = -1.0;

        for (Loja loja : this.lojas) {
            if (loja instanceof Informatica) {
                Informatica lojaInfo = (Informatica) loja;
                if (lojaInfo.getSeguroEletronicos() > maiorSeguro) {
                    maiorSeguro = lojaInfo.getSeguroEletronicos();
                    lojaMaisCara = lojaInfo;
                }
            }
        }
        return lojaMaisCara;
    }
}