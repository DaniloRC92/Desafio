public class Questao1 {
    public static void main(String[] args) {
        /*1) Observe o trecho de código abaixo: int INDICE = 13, SOMA = 0, K = 0;
        Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
        Imprimir(SOMA);
        Ao final do processamento, qual será o valor da variável SOMA? */
        
        // Instanciando as variaveis
        int indice = 13, soma = 0, k = 0;

        // While para inteirar o valor de k e de soma
        while (k < indice) {
            k++;
            soma += k;
        }

        // Imprimindo o valor de soma
        System.out.println("O valor final de soma é: "+soma);
    }
}
