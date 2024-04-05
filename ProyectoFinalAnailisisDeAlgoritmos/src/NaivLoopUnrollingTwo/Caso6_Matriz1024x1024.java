package NaivLoopUnrollingTwo;

import NaviOnArray.ClaseMultiplicadoraNaviOnArray;

public class Caso6_Matriz1024x1024 {

    public static void main(String[] args) {
        // Rutas de los archivos de las matrices
        String rutaMatrizA = "Resources/Matrices/Matriz 1024x1024/MatrizA.txt";
        String rutaMatrizB = "Resources/Matrices/Matriz 1024x1024/MatrizB.txt";

        // Llama al método main de ClaseMultiplicadora pasándole las rutas de las matrices
        ClaseMultiplicadoraNaivLoopUnrollingTwo.main(new String[]{}, ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizA), 
				ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizB), "Caso 6 Matriz 1024x1024");      }
}

