Sorting Algorithm Viewer (SAV)
Descrição
O Sorting Algorithm Viewer (SAV) é uma aplicação em Java que visualiza algoritmos de ordenação através de uma interface gráfica. O projeto permite a visualização de três algoritmos de ordenação: Bubble Sort, Insertion Sort e Selection Sort. O usuário pode escolher o algoritmo e a velocidade da ordenação, além de fornecer uma lista de números inteiros para serem ordenados.
Funcionalidades
Visualização dos algoritmos de ordenação Bubble Sort, Insertion Sort e Selection Sort.
Escolha do algoritmo de ordenação por meio de parâmetros da linha de comando.
Configuração da velocidade de ordenação em milissegundos.
Entrada de números inteiros via parâmetros da linha de comando.
Visualização gráfica das barras representando os números, com ajuste automático da largura e altura das barras.
Requisitos
Java 8 ou superior.
Biblioteca Swing (inclusa no JDK).
Execução
Para executar o projeto, siga estas etapas:
Compile o código-fonte:
sh
Copiar código
javac Main.java BubbleSortVisualizer.java InsertionSortVisualizer.java SelectionSortVisualizer.java


Execute a aplicação com os parâmetros apropriados:
sh
Copiar código
java Main t=<algoritmo> v=<valores separados por vírgula>


t=<algoritmo>: Especifica o tipo de algoritmo de ordenação. Pode ser:
b para Bubble Sort
i para Insertion Sort
s para Selection Sort
v=<valores separados por vírgula>: Lista de números inteiros a serem ordenados, separados por vírgula. Pode incluir números negativos.
Exemplo de comando:
sh
Copiar código
java Main t=b v=9,2,5,-1
Onde t=b indica o uso do algoritmo Bubble Sort e v=9,2,5,-1 são os valores a serem ordenados.
Configuração da velocidade: Após iniciar a aplicação, será solicitado um valor para a velocidade de ordenação em milissegundos. Digite o valor desejado e clique em OK, ou pressione ENTER.
Estrutura do Projeto
Main.java: Classe principal que configura e inicia a aplicação, processa os parâmetros da linha de comando e seleciona o visualizador de ordenação.
BubbleSortVisualizer.java: Visualizador para o algoritmo Bubble Sort.
InsertionSortVisualizer.java: Visualizador para o algoritmo Insertion Sort.
SelectionSortVisualizer.java: Visualizador para o algoritmo Selection Sort.
Exemplo de Diagrama de Classes
O diagrama de classes do projeto está disponível no formato Mermaid e ilustra a estrutura e interação entre as principais classes do projeto.
Documentação
O projeto está devidamente documentado e segue boas práticas de programação, incluindo o uso de conceitos de Orientação a Objetos (OOP) e um diagrama de classes UML para facilitar o entendimento da estrutura do código.
Exemplo do SA