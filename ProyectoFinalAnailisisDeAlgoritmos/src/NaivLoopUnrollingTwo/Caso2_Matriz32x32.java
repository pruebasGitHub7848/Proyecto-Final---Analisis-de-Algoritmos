package NaivLoopUnrollingTwo;

import NaviOnArray.ClaseMultiplicadoraNaviOnArray;

public class Caso2_Matriz32x32 {

	public static void main(String[] args) {
		// Rutas de los archivos de las matrices
		String rutaMatrizA = "Resources/Matrices/Matriz 32x32/MatrizA.txt";
		String rutaMatrizB = "Resources/Matrices/Matriz 32x32/MatrizB.txt";

		// Llama al método main de ClaseMultiplicadora pasándole las rutas de las matrices
		ClaseMultiplicadoraNaivLoopUnrollingTwo.main(new String[]{}, ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizA), 
				ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizB), "Caso 2 Matriz 32x32");   
		}
}

