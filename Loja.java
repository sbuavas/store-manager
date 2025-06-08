public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos; // Atributo novo (Etapa4)

    // Incluido Endereço e Data e TamanhoEstoque (Etapa4)
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                Endereco endereco, Data dataFundacao, int tamanhoEstoque) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        // Inicia estoqueProdutos de acordo com o tamanho fornecido (Etapa4)
        if (tamanhoEstoque >= 0) {
            this.estoqueProdutos = new Produto[tamanhoEstoque];
        } else {
            this.estoqueProdutos = new Produto[0]; // Segurança para tamanho inválido
        }
    }

    // Incluido Endereço e Data, salárioBase -1 e tamanhoEstoque (Etapa4)
    public Loja(String nome, int quantidadeFuncionarios,
                Endereco endereco, Data dataFundacao, int tamanhoEstoque) {
        this(nome, quantidadeFuncionarios, -1, endereco, dataFundacao, tamanhoEstoque);
    }

    // --- Métodos Getters e Setters ---
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getQuantidadeFuncionarios() { return quantidadeFuncionarios; }
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) { this.quantidadeFuncionarios = quantidadeFuncionarios; }
    public double getSalarioBaseFuncionario() { return salarioBaseFuncionario; }
    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) { this.salarioBaseFuncionario = salarioBaseFuncionario; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public Data getDataFundacao() { return dataFundacao; }
    public void setDataFundacao(Data dataFundacao) { this.dataFundacao = dataFundacao; }
    // --- Novos métodos Getters e Setters --- (Etapa 4)
    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }
    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    // toString [Incluido Endereco, Data e tamanhoEstoque (Etapa3 e 4)]
    @Override
    public String toString() {
        String infoEndereco = (this.endereco != null ? "\n" + this.endereco.toString() : "\nEndereço: Não informado");
        String infoDataFundacao = (this.dataFundacao != null ? this.dataFundacao.toString() : "Não informada");

        StringBuilder sb = new StringBuilder();
        sb.append("Loja: ").append(nome)
                .append("\nQuantidade de Funcionários: ").append(quantidadeFuncionarios)
                .append("\nSalário Base dos Funcionários: R$ ").append(String.format("%.2f", salarioBaseFuncionario))
                .append("\nData de Fundação: ").append(infoDataFundacao)
                .append(infoEndereco);

        // Adição da informação do estoque
        sb.append("\n--- Estoque de Produtos ---");
        if (this.estoqueProdutos != null) {
            sb.append("\nCapacidade do Estoque: ").append(this.estoqueProdutos.length).append(" produtos");
            int produtosAtuais = 0;
            for (Produto p : this.estoqueProdutos) {
                if (p != null) produtosAtuais++;
            }
            sb.append("\nProdutos Atuais no Estoque: ").append(produtosAtuais);
        } else {
            sb.append("\nEstoque não configurado.");
        }
        return sb.toString();
    }

    // Gasto total com salários ou -1 se não tiver definido
    public double gastosComSalario() {
        if (this.salarioBaseFuncionario == -1) return -1;
        return this.quantidadeFuncionarios * this.salarioBaseFuncionario;
    }
    // Verificação P, M e G com base na qtd de funcionários
    public char tamanhoDaLoja() {
        if (this.quantidadeFuncionarios < 10) return 'P';
        if (this.quantidadeFuncionarios <= 30) return 'M';
        return 'G';
    }

    // Novo método para imprimir os produtos do estoque (Etapa4)
    public void imprimeProdutos() {
        System.out.println("\n--- Produtos da Loja: " + this.getNome() + " ---");
        if (this.estoqueProdutos == null || this.estoqueProdutos.length == 0) {
            System.out.println("Estoque não configurado ou vazio.");
            return;
        }
        boolean encontrou = false;
        for (Produto produto : this.estoqueProdutos) {
            if (produto != null) {
                System.out.println(produto.toString()); // Usa o toString() de Produto
                System.out.println("----------");
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum produto no estoque.");
    }

    // Novo método para inserir um produto no primeiro espaço livre de estoque (Etapa4)
    public boolean insereProduto(Produto produtoParaInserir) {
        if (produtoParaInserir == null || this.estoqueProdutos == null) return false;
        for (int i = 0; i < this.estoqueProdutos.length; i++) {
            if (this.estoqueProdutos[i] == null) {
                this.estoqueProdutos[i] = produtoParaInserir;
                return true;
            }
        }
        return false; // Retorna false caso o estoque esteja cheio
    }

    // Novo método para remover um produto do estoque pelo nome
    public boolean removeProduto(String nomeDoProdutoParaRemover) {
        if (nomeDoProdutoParaRemover == null || this.estoqueProdutos == null) return false;
        for (int i = 0; i < this.estoqueProdutos.length; i++) {
            if (this.estoqueProdutos[i] != null && this.estoqueProdutos[i].getNome().equals(nomeDoProdutoParaRemover)) {
                this.estoqueProdutos[i] = null;
                return true;
            }
        }
        return false; // Retorna false caso o produto não seja encontrado
    }
}