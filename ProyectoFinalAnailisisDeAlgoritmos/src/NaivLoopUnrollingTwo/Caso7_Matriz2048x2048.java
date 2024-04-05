package NaivLoopUnrollingTwo;

import NaviOnArray.ClaseMultiplicadoraNaviOnArray;

public class Caso7_Matriz2048x2048 {

    public static void main(String[] args) {
        // Rutas de los archivos de las matrices
        String rutaMatrizA = "Resources/Matrices/Matriz 2048x2048/MatrizA.txt";
        String rutaMatrizB = "Resources/Matrices/Matriz 2048x2048/MatrizB.txt";

        // Llama al método main de ClaseMultiplicadora pasándole las rutas de las matrices
        ClaseMultiplicadoraNaivLoopUnrollingTwo.main(new String[]{}, ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizA), 
				ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizB), "Caso 7 Matriz 2048x2048");      }
}

