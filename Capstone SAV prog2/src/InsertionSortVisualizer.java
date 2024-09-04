import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Classe que visualiza o algoritmo Insertion Sort.
 * Responsável por ordenar uma lista de números inteiros e
 * visualizá-la graficamente em um painel.
 */
public class InsertionSortVisualizer extends JPanel {
    private final List<Integer> numeros;  // Lista de números a serem ordenados
    private final int delay;  // Tempo de delay entre os passos da ordenação, em milissegundos

    /**
     * Construtor para o visualizador de Insertion Sort.
     * @param numeros Lista de números a serem ordenados.
     * @param delay Tempo de delay entre os passos da ordenação.
     */
    public InsertionSortVisualizer(List<Integer> numeros, int delay) {
        this.numeros = numeros;
        this.delay = delay;
    }

    /**
     * Método que desenha o componente gráfico no painel.
     * @param g Objeto Graphics usado para desenhar no componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Limpa o painel antes de desenhar
        int width = getWidth();   // Largura do painel
        int height = getHeight(); // Altura do painel

        // Obtém o valor absoluto máximo para escalar as barras proporcionalmente
        int maxNumber = numeros.stream().mapToInt(Math::abs).max().orElse(1);
        // Calcula a largura de cada barra, ajustando ao tamanho do painel
        int barWidth = Math.max(1, width / numeros.size());

        // Calcula a linha central do eixo X para desenhar a linha de base das barras
        int middleY = height / 2; // Corrigido de "height / 0" para evitar divisão por zero

        // Desenha a linha central que divide os números positivos e negativos
        g.setColor(Color.BLACK);
        g.drawLine(0, middleY, width, middleY);

        // Desenha cada barra correspondente aos números na lista
        for (int i = 0; i < numeros.size(); i++) {
            int valor = numeros.get(i); // Valor do número na lista
            // Calcula a altura da barra de acordo com o valor do número e o valor máximo
            int barHeight = (int) (((double) Math.abs(valor) / maxNumber) * (height / 2));
            int x = i * barWidth; // Posição X da barra
            int y = middleY - (valor >= 0 ? barHeight : 0); // Ajusta a posição da barra no eixo Y

            // Se o valor for negativo, desenha a barra abaixo da linha central
            if (valor < 0) {
                g.setColor(Color.RED);
                g.fillRect(x, middleY, barWidth - 2, barHeight); // Barra para números negativos
            } else { // Caso contrário, desenha a barra acima da linha central
                g.setColor(Color.BLUE);
                g.fillRect(x, y, barWidth - 2, barHeight); // Barra para números positivos
            }
        }
    }

    /**
     * Método para ordenar os números usando o algoritmo Insertion Sort.
     * O método atualiza o gráfico em cada iteração para mostrar o progresso da ordenação.
     */
    public void ordenarNumeros() {
        for (int i = 1; i < numeros.size(); i++) {
            int key = numeros.get(i); // Elemento a ser inserido na posição correta
            int j = i - 1;

            // Move os elementos que são maiores que a chave para uma posição à frente
            while (j >= 0 && numeros.get(j) > key) {
                numeros.set(j + 1, numeros.get(j)); // Desloca o elemento para a direita
                j--;
                repaint(); // Redesenha o painel para mostrar a troca
                try {
                    Thread.sleep(delay); // Espera para visualizar o passo atual
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            numeros.set(j + 1, key); // Insere o elemento na posição correta
            repaint(); // Redesenha o painel para mostrar a inserção
            try {
                Thread.sleep(delay); // Espera para visualizar o passo atual
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Exibe mensagem indicando que a ordenação terminou
        JOptionPane.showMessageDialog(this, "Fim da ordenação em Insertion!");
    }
}
