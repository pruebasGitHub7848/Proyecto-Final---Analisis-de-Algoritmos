package NaviOnArray;

public class Caso1_Matriz16x16 {

	public static void main(String[] args) {
		// Rutas de los archivos de las matrices
		String rutaMatrizA = "Resources/Matrices/Matriz 16x16/MatrizA.txt";
		String rutaMatrizB = "Resources/Matrices/Matriz 16x16/MatrizB.txt";

		// Llama al método main de ClaseMultiplicadora pasándole las rutas de las matrices
		ClaseMultiplicadoraNaviOnArray.main(new String[]{}, ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizA), 
				ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizB), "Caso 1 Matriz 16x16");
	}
}
