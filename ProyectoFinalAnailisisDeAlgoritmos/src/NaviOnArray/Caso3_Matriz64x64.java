package NaviOnArray;

public class Caso3_Matriz64x64 {

	public static void main(String[] args) {
		// Rutas de los archivos de las matrices
		String rutaMatrizA = "Resources/Matrices/Matriz 64x64/MatrizA.txt";
		String rutaMatrizB = "Resources/Matrices/Matriz 64x64/MatrizB.txt";

		// Llama al método main de ClaseMultiplicadora pasándole las rutas de las matrices
		ClaseMultiplicadoraNaviOnArray.main(new String[]{}, ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizA), 
				ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizB), "Caso 3 Matriz 64x64");   
		}
}

