import java.io.*;
import java.util.*;

// Classe para representar o faturamento diário
class FaturamentoDiario {
    private int dia;
    private double faturamento;

    public FaturamentoDiario(int dia, double faturamento) {
        this.dia = dia;
        this.faturamento = faturamento;
    }

    public double getFaturamento() {
        return faturamento;
    }
    public int getDia(){
        return dia;
    }
}
public class Questao3 implements Serializable{
    public static void main(String[] args) {
        List<FaturamentoDiario> faturamentos = carregarDados("faturamento.json");

        if (faturamentos == null || faturamentos.isEmpty()) {
            System.out.println("Não foi possível carregar os dados.");
            return;
        }

        double menorFaturamento = calcularMenorFaturamento(faturamentos);
        double maiorFaturamento = calcularMaiorFaturamento(faturamentos);
        double media = calcularMedia(faturamentos);
        int diasAcimaMedia = contarDiasAcimaMedia(faturamentos, media);

        System.out.printf("Menor faturamento: %.2f\n", menorFaturamento);
        System.out.printf("Maior faturamento: %.2f\n", maiorFaturamento);
        System.out.printf("Número de dias com faturamento acima da média: %d\n", diasAcimaMedia);
    }

    // Método para carregar os dados de um arquivo JSON
    public static List<FaturamentoDiario> carregarDados(String caminhoArquivo) {
        List<FaturamentoDiario> faturamentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            // Ignora o primeiro e o último caractere do JSON (os colchetes)
            StringBuilder jsonBuilder = new StringBuilder();
            while ((linha = reader.readLine()) != null) {
                jsonBuilder.append(linha.trim());
            }
            String json = jsonBuilder.toString();
            json = json.substring(1, json.length() - 1); // Remove colchetes

            // Divide a string em objetos JSON
            String[] objetos = json.split("\\},\\s*\\{");

            for (String objeto : objetos) {
                objeto = objeto.replaceAll("[\\{\\}]", ""); // Remove chaves
                String[] pares = objeto.split(",\\s*");
                int dia = 0;
                double faturamento = 0.0;

                for (String par : pares) {
                    String[] chaveValor = par.split(":\\s*");
                    if (chaveValor[0].trim().equals("\"dia\"")) {
                        dia = Integer.parseInt(chaveValor[1].trim());
                    } else if (chaveValor[0].trim().equals("\"faturamento\"")) {
                        faturamento = Double.parseDouble(chaveValor[1].trim());
                    }
                }

                faturamentos.add(new FaturamentoDiario(dia, faturamento));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return faturamentos;
    }

    // Método para calcular o menor faturamento
    public static double calcularMenorFaturamento(List<FaturamentoDiario> faturamentos) {
        return faturamentos.stream()
                .filter(f -> f.getFaturamento() > 0)
                .mapToDouble(FaturamentoDiario::getFaturamento)
                .min()
                .orElse(0);
    }

    // Método para calcular o maior faturamento
    public static double calcularMaiorFaturamento(List<FaturamentoDiario> faturamentos) {
        return faturamentos.stream()
                .mapToDouble(FaturamentoDiario::getFaturamento)
                .max()
                .orElse(0);
    }

    // Método para calcular a média dos faturamentos, ignorando dias sem faturamento
    public static double calcularMedia(List<FaturamentoDiario> faturamentos) {
        return faturamentos.stream()
                .filter(f -> f.getFaturamento() > 0)
                .mapToDouble(FaturamentoDiario::getFaturamento)
                .average()
                .orElse(0);
    }

    // Método para contar quantos dias tiveram faturamento acima da média
    public static int contarDiasAcimaMedia(List<FaturamentoDiario> faturamentos, double media) {
        return (int) faturamentos.stream()
                .filter(f -> f.getFaturamento() > media)
                .count();
    }
}
