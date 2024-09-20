import java.util.Scanner;
public class Questao2 {
    public static void main(String[] args) {
        /*2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores 
        (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número,
        ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência. */

        Scanner tec = new Scanner(System.in); // Declaração do objeto tec para entrada de dados via console
        int numero; // Variavel que contém o valor a ser pesquisado

        System.out.print("Informe o valor a ser pesquisado na sequencia de Fibonacci: ");
        numero = tec.nextInt();

        if (fibonacci(numero)) { // Faz a chamada da função para verificar se o número pertence ou não a sequencia
            System.out.println("O número "+numero+" está na sequencia de Fibonacci!");
        } else{
            System.out.println("O número "+numero+ " não está na sequencia de Fibonacci!");
        }
        tec.close();
    }
    private static boolean fibonacci(int numero){ // Função que verifica se o número pertence ou não a Fibonacci
        
        int x = 0, y = 1; // Variaveis que em primeiro momento irão assumir os primeiros números da sequencia de fibonacci
        
        if (numero <= 1){ // Verifica se o número é igual a 0 ou 1
            return true;
        }
        while (y < numero) { // Realiza o calculo da sequencia até o ponto que y seja maior que o número fornecido
            int temp = x + y; // Variavel temporaria para armazenar o valor da soma de x e y
            x = y;
            y = temp;
        }
        return y == numero; // Retorna True se y for igual ao numero, ou false se for diferentes
    } 
}
