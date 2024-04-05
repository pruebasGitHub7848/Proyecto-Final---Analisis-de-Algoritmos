package StrassenWinograd;

import java.util.Arrays;

public class StrassenWinogradMatrixMultiplication {

    public static long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        // Verifica si el tamaño de la matriz es una potencia de 2
        if (!isPowerOfTwo(n)) {
            // Encuentra la potencia de 2 más cercana al tamaño de la matriz
            int newSize = Integer.highestOneBit(n) << 1;

            // Crea nuevas matrices con el tamaño ajustado
            long[][] newA = resizeMatrix(A, newSize);
            long[][] newB = resizeMatrix(B, newSize);

            // Multiplica las matrices con el nuevo tamaño
            long[][] result = multiply(newA, newB);

            // Elimina las filas y columnas agregadas
            return Arrays.copyOfRange(result, 0, n);
        }

        long[][] result = new long[n][n];

        if (n == 1) {
            result[0][0] = A[0][0] * B[0][0];
        } else {
            // Divide las matrices en submatrices
            long[][] A11 = subMatrix(A, 0, 0);
            long[][] A12 = subMatrix(A, 0, n / 2);
            long[][] A21 = subMatrix(A, n / 2, 0);
            long[][] A22 = subMatrix(A, n / 2, n / 2);

            long[][] B11 = subMatrix(B, 0, 0);
            long[][] B12 = subMatrix(B, 0, n / 2);
            long[][] B21 = subMatrix(B, n / 2, 0);
            long[][] B22 = subMatrix(B, n / 2, n / 2);

            // Calcula las siete matrices auxiliares
            long[][] M1 = multiply(sum(A11, A22), sum(B11, B22));
            long[][] M2 = multiply(sum(A21, A22), B11);
            long[][] M3 = multiply(A11, subtract(B12, B22));
            long[][] M4 = multiply(A22, subtract(B21, B11));
            long[][] M5 = multiply(sum(A11, A12), B22);
            long[][] M6 = multiply(subtract(A21, A11), sum(B11, B12));
            long[][] M7 = multiply(subtract(A12, A22), sum(B21, B22));

            // Calcula los elementos de la matriz resultante
            long[][] C11 = sum(subtract(sum(M1, M4), M5), M7);
            long[][] C12 = sum(M3, M5);
            long[][] C21 = sum(M2, M4);
            long[][] C22 = sum(subtract(sum(M1, M3), M2), M6);

            // Combina las submatrices en la matriz resultante
            join(C11, result, 0, 0);
            join(C12, result, 0, n / 2);
            join(C21, result, n / 2, 0);
            join(C22, result, n / 2, n / 2);
        }
        return result;
    }

    private static long[][] subMatrix(long[][] matrix, int startRow, int startCol) {
        int size = matrix.length / 2;
        long[][] sub = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sub[i][j] = matrix[startRow + i][startCol + j];
            }
        }
        return sub;
    }

    private static void join(long[][] sub, long[][] result, int startRow, int startCol) {
        int size = sub.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[startRow + i][startCol + j] = sub[i][j];
            }
        }
    }

    private static long[][] sum(long[][] A, long[][] B) {
        int n = A.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    private static long[][] subtract(long[][] A, long[][] B) {
        int n = A.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

     static long[][] resizeMatrix(long[][] matrix, int newSize) {
        int n = matrix.length;
        long[][] newMatrix = new long[newSize][newSize];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, n);
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        // Example usage
        int n = 256; // Tamaño de las matrices
        long[][] A = new long[n][n];
        long[][] B = new long[n][n];
        // Inicializar las matrices A y B

        // Llama a la función multiply para multiplicar las matrices
        long[][] result = multiply(A, B);
        // Imprime el resultado o realiza otras operaciones con él
    }
}
