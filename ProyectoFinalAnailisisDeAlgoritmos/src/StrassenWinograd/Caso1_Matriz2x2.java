package StrassenWinograd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Caso1_Matriz2x2 {
	
	static StrassenWinogradMatrixMultiplication acceso = new StrassenWinogradMatrixMultiplication();
	
	
    public static void main(String[] args) {
    
        // Rutas de los archivos de las matrices
        String rutaMatrizA = "C:\\Users\\manu7\\Desktop\\Analisis\\Proyecto Final\\Matrices\\Matriz 256x256\\matrizA.txt";
        String rutaMatrizB = "C:\\Users\\manu7\\Desktop\\Analisis\\Proyecto Final\\Matrices\\Matriz 256x256\\matrizB.txt";

        // Cargar las matrices desde los archivos
        long[][] matrizA = cargarMatriz(rutaMatrizA);
        long[][] matrizB = cargarMatriz(rutaMatrizB);

        // Comenzar a medir el tiempo en milisegundos y nanosegundos
        long startTimeMillis = System.currentTimeMillis();
        long startTimeNano = System.nanoTime();

        // Multiplicar las matrices usando el algoritmo Strassen-Winograd
        long[][] resultado = multiplicarMatricesStrassenWinograd(matrizA, matrizB);

        // Mostrar el resultado
        System.out.println("Resultado de la multiplicación Strassen:");
        imprimirMatriz(resultado);

        // Terminar de medir el tiempo en milisegundos y nanosegundos
        long endTimeMillis = System.currentTimeMillis();
        long endTimeNano = System.nanoTime();

        // Calcular el tiempo transcurrido en milisegundos y nanosegundos
        long elapsedTimeMillis = endTimeMillis - startTimeMillis;
        long elapsedTimeNano = endTimeNano - startTimeNano;

        // Mostrar el tiempo transcurrido
        System.out.println("Tiempo transcurrido en milisegundos: " + elapsedTimeMillis);
        System.out.println("Tiempo transcurrido en nanosegundos: " + elapsedTimeNano);
    }

    // Método para cargar una matriz desde un archivo de texto
    public static long[][] cargarMatriz(String ruta) {
        long[][] matriz = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;
            int filas = 0;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(" ");
                if (matriz == null) {
                    matriz = new long[valores.length][valores.length];
                }
                for (int j = 0; j < valores.length; j++) {
                    matriz[filas][j] = Long.parseLong(valores[j]);
                }
                filas++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matriz;
    }

    // Método para multiplicar dos matrices usando el algoritmo Strassen-Winograd
    public static long[][] multiplicarMatricesStrassenWinograd(long[][] matrizA, long[][] matrizB) {
    	int n = matrizA.length;

        // Verifica si el tamaño de la matriz es potencia de 2
        if (!acceso.isPowerOfTwo(n)) {
            // Encuentra la potencia de 2 más cercana al tamaño de la matriz
            int newSize = Integer.highestOneBit(n) << 1;

            // Crea nuevas matrices con el tamaño ajustado
            long[][] newA = acceso.resizeMatrix(matrizA, newSize);
            long[][] newB = acceso.resizeMatrix(matrizB, newSize);

            // Multiplica las matrices con el nuevo tamaño
            long[][] result = StrassenWinogradMatrixMultiplication.multiply(newA, newB);

            // Elimina las filas y columnas agregadas
            return Arrays.copyOfRange(result, 0, n);
        }

        return StrassenWinogradMatrixMultiplication.multiply(matrizA, matrizB);
    }

    // Método para imprimir una matriz
    private static void imprimirMatriz(long[][] matriz) {
        for (long[] fila : matriz) {
            for (long valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }
}
