package Resources;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		// Definir el tamaño de la matriz
		int n = 16; // Tamaño 2x2

		// Generar y guardar la primera matriz
		int[][] matrizA = generarMatriz(n);
		guardarMatriz(matrizA, "C:\\Users\\manu7\\Desktop\\Analisis\\Proyecto Final\\Matrices\\Matriz 16x16\\MatrizA.txt");

		// Generar y guardar la segunda matriz
		int[][] matrizB = generarMatriz(n);
		guardarMatriz(matrizB, "C:\\Users\\manu7\\Desktop\\Analisis\\Proyecto Final\\Matrices\\Matriz 16x16\\MatrizB.txt");
	}

	// Método para generar una matriz de tamaño n*n con números aleatorios de 6 dígitos
	public static int[][] generarMatriz(int n) {
		Random rand = new Random();
		int[][] matriz = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matriz[i][j] = rand.nextInt(900000) + 100000; // Generar números de 6 dígitos
			}
		}
		return matriz;
	}

	// Método para guardar una matriz en un archivo de texto
	public static void guardarMatriz(int[][] matriz, String ruta) {
		try {
			FileWriter writer = new FileWriter(ruta);
			for (int[] fila : matriz) {
				for (int num : fila) {
					writer.write(num + " ");
				}
				writer.write("\n");
			}
			writer.close();
			System.out.println("Matriz guardada en " + ruta);
		} catch (IOException e) {
			System.out.println("Error al guardar la matriz: " + e.getMessage());
		}
	}
}

