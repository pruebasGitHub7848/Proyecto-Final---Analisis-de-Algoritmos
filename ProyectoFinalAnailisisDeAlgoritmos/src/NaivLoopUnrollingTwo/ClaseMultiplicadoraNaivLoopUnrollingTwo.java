package NaivLoopUnrollingTwo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ClaseMultiplicadoraNaivLoopUnrollingTwo {
	
	// Ruta del archivo donde se guardará el tiempo de ejecución
    private static final String RUTA_ARCHIVO = "src\\Resources\\TiemposDeEjecucion\\TiempoDeEjecucionNaivLoolUnrollingTwo.txt";

	public static void main(String[] args, long[][] matrizA, long[][] matrizB, String nombreCaso) {

		// Comenzar a medir el tiempo en milisegundos y nanosegundos
		long startTimeMillis = System.currentTimeMillis();
		long startTimeNano = System.nanoTime();

		// Multiplicar las matrices usando el algoritmo Naive con bucles desenrollados dos veces
		long[][] resultado = multiplicarMatricesNaiveLoopUnrollingTwo(matrizA, matrizB);

		// Mostrar el resultado
		System.out.println("Resultado de la multiplicación:");
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
		// Guardar el tiempo transcurrido en el archivo
		guardarTiempo(elapsedTimeMillis, elapsedTimeNano, nombreCaso);
	}


	// Método para guardar el tiempo de ejecución en un archivo
	private static void guardarTiempo(long elapsedTimeMillis, long elapsedTimeNano, String caso) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
			bw.write(caso + "\n");
			bw.write("Tiempo transcurrido en milisegundos: " + elapsedTimeMillis);
			bw.newLine();
			bw.write("Tiempo transcurrido en nanosegundos: " + elapsedTimeNano);
			bw.newLine();
			bw.newLine();  // Línea en blanco para separar los casos
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para cargar una matriz desde un archivo de texto
	public static long[][] cargarMatriz(String ruta) {
		long[][] matriz = null;
		try {
			InputStream inputStream = Caso1_Matri16x16.class.getClassLoader().getResourceAsStream(ruta);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
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

	// Método para multiplicar dos matrices usando el algoritmo Naive con bucles desenrollados dos veces
	public static long[][] multiplicarMatricesNaiveLoopUnrollingTwo(long[][] matrizA, long[][] matrizB) {
		int filasA = matrizA.length;
		int columnasA = matrizA[0].length;
		int columnasB = matrizB[0].length;

		long[][] resultado = new long[filasA][columnasB];

		for (int i = 0; i < filasA; i++) {
			for (int j = 0; j < columnasB; j++) {
				long sum1 = 0;
				long sum2 = 0;
				for (int k = 0; k < columnasA; k += 2) {
					sum1 += matrizA[i][k] * matrizB[k][j];
					sum2 += matrizA[i][k + 1] * matrizB[k + 1][j];
				}
				resultado[i][j] = sum1 + sum2;
			}
		}

		return resultado;
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