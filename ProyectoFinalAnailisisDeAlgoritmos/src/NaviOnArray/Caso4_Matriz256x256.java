package NaviOnArray;

public class Caso4_Matriz256x256 {

    public static void main(String[] args) {
        // Rutas de los archivos de las matrices
        String rutaMatrizA = "Resources/Matrices/Matriz 256x256/MatrizA.txt";
        String rutaMatrizB = "Resources/Matrices/Matriz 256x256/MatrizB.txt";

        // Llama al método main de ClaseMultiplicadora pasándole las rutas de las matrices
        ClaseMultiplicadoraNaviOnArray.main(new String[]{}, ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizA), 
				ClaseMultiplicadoraNaviOnArray.cargarMatriz(rutaMatrizB), "Caso 4 Matriz 256x256");
        }
}

