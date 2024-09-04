classDiagram
class Main {
+main(String[] args)
-validarNumeros(String valoresEntrada) : List<Integer>
}

    class BubbleSortVisualizer {
        -numeros : List<Integer>
        -delay : int
        +BubbleSortVisualizer(List<Integer> numeros, int delay)
        +paintComponent(Graphics g)
        +ordenarNumeros()
    }
    
    class InsertionSortVisualizer {
        -numeros : List<Integer>
        -delay : int
        +InsertionSortVisualizer(List<Integer> numeros, int delay)
        +paintComponent(Graphics g)
        +ordenarNumeros()
    }
    
    class SelectionSortVisualizer {
        -numeros : List<Integer>
        -delay : int
        +SelectionSortVisualizer(List<Integer> numeros, int delay)
        +paintComponent(Graphics g)
        +ordenarNumeros()
    }

    Main --> BubbleSortVisualizer : utiliza
    Main --> InsertionSortVisualizer : utiliza
    Main --> SelectionSortVisualizer : utiliza
