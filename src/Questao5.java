import java.util.Scanner;
public class Questao5 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        String caracteres, caracteresInvertidos;
        System.out.print("Informe uma palavra ou frase para ser invertida: ");
        caracteres = tec.nextLine();

        caracteresInvertidos = inverterString(caracteres); // Chamada da função para inverter String

        System.out.println("Palavra/Frase invertida: "+caracteresInvertidos);

        tec.close();
    }
    private static String inverterString(String caracteres){ // Função que irá inverter a string desejada
        
        String caracteresInvertidos = "";
        
        for(int i = caracteres.length() - 1; i >= 0; i--){ // Percorre a string de tras para frente
            caracteresInvertidos += caracteres.charAt(i); // Concatena caracter
        }
        return caracteresInvertidos;
    }
}
