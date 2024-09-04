import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe principal que inicia a aplicação de visualização de algoritmos de ordenação.
 */
public class Main {
    /**
     * Método principal que inicia a aplicação.
     * @param args Argumentos da linha de comando. Deve incluir:
     *             - t=<algoritmo>: tipo de algoritmo ('b' para Bubble Sort, 'i' para Insertion Sort, 's' para Selection Sort)
     *             - v=<valores>: valores separados por vírgula a serem ordenados
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso incorreto! Utilize: java Main t=<b/i/s> v=<valores separados por vírgula>");
            return;
        }

        // Obtendo os parâmetros
        String tipoOrdenacao = args[0].substring(2).toLowerCase();  // 'b', 'i' ou 's'
        String valoresEntrada = args[1].substring(2);  // Valores separados por vírgula

        // Validando os números de entrada
        List<Integer> numeros = validarNumeros(valoresEntrada);
        if (numeros.isEmpty()) {
            System.out.println("Os valores de entrada são inválidos.");
            return;
        }

        // Pedindo ao usuário o delay de tempo
        String delayStr = JOptionPane.showInputDialog("Digite a velocidade de ordenação em milissegundos:");
        int delay = 100;  // Valor padrão de 100ms
        try {
            delay = Integer.parseInt(delayStr);
        } catch (NumberFormatException e) {
            System.out.println("Valor de delay inválido, utilizando 100ms.");
        }

        // Criando a janela principal de visualização
        JFrame frame = new JFrame("Visualizador de Ordenação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = null;

        // Selecionando o método de ordenação com base na entrada
        switch (tipoOrdenacao) {
            case "b":  // Bubble Sort
                panel = new BubbleSortVisualizer(numeros, delay);
                break;
            case "i":  // Insertion Sort
                panel = new InsertionSortVisualizer(numeros, delay);
                break;
            case "s":  // Selection Sort
                panel = new SelectionSortVisualizer(numeros, delay);
                break;
            default:
                System.out.println("Tipo de ordenação inválido! Use 'b' para Bubble Sort, 'i' para Insertion Sort, ou 's' para Selection Sort.");
                return;
        }

        frame.add(panel);
        frame.setVisible(true);

        // Iniciando a ordenação
        if (panel instanceof BubbleSortVisualizer) {
            ((BubbleSortVisualizer) panel).ordenarNumeros();
        } else if (panel instanceof InsertionSortVisualizer) {
            ((InsertionSortVisualizer) panel).ordenarNumeros();
        } else if (panel instanceof SelectionSortVisualizer) {
            ((SelectionSortVisualizer) panel).ordenarNumeros();
        }
    }

    /**
     * Valida e converte os números de entrada fornecidos pelo usuário.
     * @param valoresEntrada String de valores separados por vírgula.
     * @return Lista de inteiros validada.
     */
    private static List<Integer> validarNumeros(String valoresEntrada) {
        List<Integer> numeros = new ArrayList<>();
        try {
            String[] valores = valoresEntrada.split(",");
            for (String valor : valores) {
                numeros.add(Integer.parseInt(valor.trim()));
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter valores para números. Certifique-se de que todos os valores são inteiros.");
        }
        return numeros;
    }
}
