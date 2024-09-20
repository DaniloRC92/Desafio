// Classe para representar o faturamento em cada estado
class Estado{
    // Declarando os atributos da classe
    private String nome;
    private double faturamento;
    
    // Construtor para instanciar os objetos
    public Estado(String nome, double faturamento) {
        this.nome = nome;
        this.faturamento = faturamento;
    }

    // Metodos para retornar o valor de cada atributo
    public String getNome() {
        return nome;
    }
    public double getFaturamento() {
        return faturamento;
    }

    public double calcularPercentual(double faturamentoTotal){ // Calcula o faturamento do estado em relação ao total
        return (this.faturamento / faturamentoTotal) * 100;
    }
}
public class Questao4 {
    public static void main(String[] args) {
        /*4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
        • SP – R$67.836,43
        • RJ – R$36.678,66
        • MG – R$29.229,88
        • ES – R$27.165,48
        • Outros – R$19.849,53
        Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora. */

        double faturamentoTotal; // Declaração da varivel que irá receber o valor do faturamento total 

        // Criação dos Estados(objetos) e seus respectivos faturamentos
        Estado sp = new Estado("São Paulo", 67836.43);
        Estado rj = new Estado("Rio de Janeiro", 36678.66);
        Estado mg = new Estado("Minas Gerais", 29229.88);
        Estado es = new Estado("Espírito Santo", 27165.48);
        Estado outros = new Estado("Outros", 19849.53);

        Estado[] estados = {sp, rj, mg, es, outros}; // Inserindo os estados em um array

        faturamentoTotal = calcularFatoramentoTotal(estados); // Chamada da função que irá calcular o faturamento total

        for (Estado estado : estados) {
            exibirPercentual(estado, faturamentoTotal); // Chamada da função para a exibição dos percentuais
        }
    }
    private static double calcularFatoramentoTotal(Estado[] estados){ // Metodo que calcula o faturamento total recebendo como parametro um vetor com todas as filiais
        double total = 0; // varivael que irá armazenar o valor do faturamento total 
        for (Estado estado : estados) { // Percorre o vetor para o incremento do valor total
            total += estado.getFaturamento();
        }
        return total;
    }
    private static void exibirPercentual(Estado estado, double faturamentoTotal){ // Metodo para exibição do percentual 
        double percentual = estado.calcularPercentual(faturamentoTotal); // chamada da função para calcular o percentual de cada estado
        System.out.printf("Percentual de %s: %.2f%%\n", estado.getNome(), percentual);
    }
}
