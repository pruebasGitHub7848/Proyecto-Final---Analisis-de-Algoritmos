package NaviOnArray;

public class Caso5_Matriz512x512 {

	public static void main(String[] args) {
		// Rutas de los archivos de las matrices
		String rutaMatrizA = "Resources/Matrices/Matriz 512x512/MatrizA.txt";
		String rutaMatrizB = "Resources/Matrices/Matriz 512x512/MatrizB.txt";

		// Llama al método main de ClaseMultiplicadora pasándole las rutas de las matrices
		ClaseMultiplicadoraNaviOnArray.main(new String[]{}, ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizA), 
				ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizB), "Caso 5 Matriz 512x512");
	}
}

