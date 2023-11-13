import java.util.Scanner;

public class Matriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int filas, columnas;

        do {
            System.out.print("Ingrese el número de filas ");
            filas = scanner.nextInt();
			System.out.print("Ingrese el número de Columnas(Debe ser igual al numero de filas) ");
            columnas = scanner.nextInt();

            if (filas != columnas) {
                System.out.println("El número de filas y columnas debe ser igual. Inténtelo de nuevo.");
            }
        } while (filas != columnas);

        double[][] matriz = new double[filas][columnas];

        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento (" + (i + 1) + "," + (j + 1) + "): ");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Matriz ingresada:");
        imprimirMatriz(matriz);

        resolverGaussJordan(matriz);

        System.out.println("Matriz en forma escalonada:");
        imprimirMatriz(matriz);

        scanner.close();
    }

    public static void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
	public static void resolverGaussJordan(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int k = 0; k < filas; k++) {
            // Pivoteo parcial
			//Pivoteo parcial: Encuentra la fila con el máximo valor absoluto en la columna actual y la intercambia con la fila actual.
            int maxRow = k;
            for (int i = k + 1; i < filas; i++) {
				 // Encuentra la fila con el máximo valor absoluto en la columna actual
                if (Math.abs(matriz[i][k]) > Math.abs(matriz[maxRow][k])) {
                    maxRow = i;
                }   
            } 
			 // Intercambia la fila actual con la fila con el máximo valor absoluto
            double[] temp = matriz[k];
            matriz[k] = matriz[maxRow];
            matriz[maxRow] = temp;

            // Hacer la primer pivote igual a 1: Divide toda la fila actual por el valor del pivote, para hacer que el pivote sea igual a 1.
            double pivot = matriz[k][k];
            for (int j = k; j < columnas; j++) {
				 // Divide toda la fila actual por el valor del pivote
                matriz[k][j] /= pivot;
            }

            // Eliminación hacia adelante
            for (int i = 0; i < filas; i++) {
                if (i != k) {
                    double factor = matriz[i][k];
                    for (int j = k; j < columnas; j++) {
						  // Resta múltiplos adecuados de la fila actual de otras filas
                        matriz[i][j] -= factor * matriz[k][j];
                    }
                }
            }
        }
    }
}





