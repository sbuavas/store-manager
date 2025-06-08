public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construtor para validação
    public Data(int dia, int mes, int ano) {
        if (validaData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Erro: Data inválida (" + dia + "/" + mes + "/" + ano + "). Atribuindo data padrão: 1/1/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    // Validação da data
    private boolean validaData(int dia, int mes, int ano) {
        if (ano <= 0) return false;
        if (mes < 1 || mes > 12) return false;
        if (dia < 1) return false;
        int ultimoDiaDoMes;
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) ultimoDiaDoMes = 30;
        else if (mes == 2) ultimoDiaDoMes = ehAnoBissextoInterno(ano) ? 29 : 28;
        else ultimoDiaDoMes = 31;
        return dia <= ultimoDiaDoMes;
    }

    private boolean ehAnoBissextoInterno(int anoVerificar) {
        return (anoVerificar % 4 == 0 && anoVerificar % 100 != 0) || (anoVerificar % 400 == 0);
    }

    // --- Métodos Getters e Setters ---
    public int getDia() { return dia; }
    public void setDia(int dia) { this.dia = dia; }
    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    // Verifica se o ano é bissexto
    public boolean verificaAnoBissexto() {
        return ehAnoBissextoInterno(this.ano);
    }
}
