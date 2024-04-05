package NaivLoopUnrollingTwo;

import NaviOnArray.ClaseMultiplicadoraNaviOnArray;

public class Caso8_Matriz4096x4096 {

	public static void main(String[] args) {
		// Rutas de los archivos de las matrices
		String rutaMatrizA = "Resources/Matrices/Matriz 4096x4096/MatrizA.txt";
		String rutaMatrizB = "Resources/Matrices/Matriz 4096x4096/MatrizB.txt";

		// Llama al método main de ClaseMultiplicadora pasándole las rutas de las matrices
		ClaseMultiplicadoraNaivLoopUnrollingTwo.main(new String[]{}, ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizA), 
				ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizB), "Caso 8 Matriz 4096x4096");  
	}
}

