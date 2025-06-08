import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = null;
        Produto produto = null;
        int opcao;

        do {
            System.out.println("\nMENU PRINCIPAL:");
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            System.out.print("Digite sua opção: ");

            // Scanner e validação da opção do menu
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                System.out.println("Opção inválida. Por favor, digite um número.");
                scanner.next();
                opcao = 0;
            }
            scanner.nextLine();

            switch (opcao) {
                case 1: // Criação da loja, agora com cadastro (Etapa4)
                    System.out.println("--- Cadastro de Nova Loja ---");
                    loja = null;

                    System.out.println("\nQual tipo de loja deseja criar?");
                    System.out.println("(1) Cosmético");
                    System.out.println("(2) Vestuário");
                    System.out.println("(3) Bijuteria");
                    System.out.println("(4) Alimentação");
                    System.out.println("(5) Informática");
                    System.out.print("Digite o tipo da loja (1-5): ");
                    int tipoLojaOpcao = -1;
                    if (scanner.hasNextInt()) {
                        tipoLojaOpcao = scanner.nextInt();
                    } else {
                        scanner.next();
                        System.out.println("Entrada inválida para tipo de loja. Nenhuma loja será criada.");
                        break;
                    }
                    scanner.nextLine();

                    if (tipoLojaOpcao < 1 || tipoLojaOpcao > 5) {
                        System.out.println("Tipo de loja selecionado inválido. Nenhuma loja será criada.");
                        break;
                    }

                    // Coleta os dados da loja
                    System.out.print("Nome da loja: "); String nomeLoja = scanner.nextLine();
                    System.out.print("Quantidade de funcionários: "); int qtdFuncionarios = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Salário base dos funcionários: "); double salarioBase = scanner.nextDouble(); scanner.nextLine();

                    System.out.println("-- Endereço da Loja --");
                    System.out.print("Rua: "); String nomeRua = scanner.nextLine();
                    System.out.print("Cidade: "); String cidade = scanner.nextLine();
                    System.out.print("Estado: "); String estado = scanner.nextLine();
                    System.out.print("País: "); String pais = scanner.nextLine();
                    System.out.print("CEP: "); String cep = scanner.nextLine();
                    System.out.print("Número: "); String numero = scanner.nextLine();
                    System.out.print("Complemento: "); String complemento = scanner.nextLine();
                    Endereco enderecoLoja = new Endereco(nomeRua, cidade, estado, pais, cep, numero, complemento);

                    System.out.println("-- Data de Fundação --");
                    System.out.print("Dia (DD): "); int diaFund = scanner.nextInt();
                    System.out.print("Mês (MM): "); int mesFund = scanner.nextInt();
                    System.out.print("Ano (AAAA): "); int anoFund = scanner.nextInt(); scanner.nextLine();
                    Data dataFundacaoLoja = new Data(diaFund, mesFund, anoFund);

                    // Pede o tamanhoEstoque (Etapa4)
                    System.out.print("Capacidade do estoque de produtos: ");
                    int tamanhoEstoqueLoja = scanner.nextInt(); scanner.nextLine();

                    // Coleta os dados e instancia o tipo de loja correto
                    switch (tipoLojaOpcao) {
                        case 1: // Cosmético
                            System.out.print("Taxa de comercialização (%): "); double taxa = scanner.nextDouble(); scanner.nextLine();
                            loja = new Cosmetico(nomeLoja, qtdFuncionarios, salarioBase, enderecoLoja, dataFundacaoLoja, tamanhoEstoqueLoja, taxa);
                            break;
                        case 2: // Vestuário
                            System.out.print("Vende produtos importados? (true/false): "); boolean imp = scanner.nextBoolean(); scanner.nextLine();
                            loja = new Vestuario(nomeLoja, qtdFuncionarios, salarioBase, enderecoLoja, dataFundacaoLoja, imp, tamanhoEstoqueLoja);
                            break;
                        case 3: // Bijuteria
                            System.out.print("Meta de vendas (R$): "); double meta = scanner.nextDouble(); scanner.nextLine();
                            loja = new Bijuteria(nomeLoja, qtdFuncionarios, salarioBase, enderecoLoja, dataFundacaoLoja, tamanhoEstoqueLoja, meta);
                            break;
                        case 4: // Alimentação
                            System.out.println("-- Data do Alvará --");
                            System.out.print("Dia (DD): "); int diaAlv = scanner.nextInt();
                            System.out.print("Mês (MM): "); int mesAlv = scanner.nextInt();
                            System.out.print("Ano (AAAA): "); int anoAlv = scanner.nextInt(); scanner.nextLine();
                            Data dataAlvara = new Data(diaAlv, mesAlv, anoAlv);
                            loja = new Alimentacao(nomeLoja, qtdFuncionarios, salarioBase, enderecoLoja, dataFundacaoLoja, dataAlvara, tamanhoEstoqueLoja);
                            break;
                        case 5: // Informática
                            System.out.print("Seguro de eletrônicos (R$): "); double seguro = scanner.nextDouble(); scanner.nextLine();
                            loja = new Informatica(nomeLoja, qtdFuncionarios, salarioBase, enderecoLoja, dataFundacaoLoja, tamanhoEstoqueLoja, seguro);
                            break;
                    }
                    if (loja != null) System.out.println("Loja '" + loja.getNome() + "' do tipo especificado criada com sucesso!");
                    break;

                case 2: // Criação do Produto
                    System.out.println("--- Cadastro de Novo Produto ---");
                    produto = null;
                    System.out.print("Nome do produto: "); String nomeProd = scanner.nextLine();
                    System.out.print("Preço: "); double precoProd = scanner.nextDouble(); scanner.nextLine();
                    System.out.println("-- Data de Validade --");
                    System.out.print("Dia (DD): "); int diaVal = scanner.nextInt();
                    System.out.print("Mês (MM): "); int mesVal = scanner.nextInt();
                    System.out.print("Ano (AAAA): "); int anoVal = scanner.nextInt(); scanner.nextLine();
                    Data dataValidadeProd = new Data(diaVal, mesVal, anoVal);
                    produto = new Produto(nomeProd, precoProd, dataValidadeProd);
                    if (produto.getNome() != null) {
                        System.out.println("Produto '" + produto.getNome() + "' criado com sucesso!");
                    }
                    break;

                case 3:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    if (opcao != 0) System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            // Verificação depois da criação dos objetos
            if (loja != null && produto != null) {
                System.out.println("\n--- Verificações  ---");
                Data dataReferencia = new Data(20, 10, 2023);
                if (produto.estaVencido(dataReferencia)) {
                    System.out.println("STATUS DO PRODUTO: VENCIDO (em relação a 20/10/2023)");
                } else {
                    System.out.println("STATUS DO PRODUTO: NÃO VENCIDO (em relação a 20/10/2023)");
                }
                System.out.println("\nInformações da Loja Criada:");
                System.out.println(loja.toString());  // Usa o toString da etapa1
            }

        } while (opcao != 3);

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}