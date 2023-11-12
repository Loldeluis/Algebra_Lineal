import java.util.Scanner;

public class Primero {
    static Scanner entrada = new Scanner(System.in);
    // toda variable necesaria
    static int filas, columnas;
    static double[][] matriz1, matriz2, resultado, inversa1, inversa2;

    public static void main(String[] args) {

        // Ingresar dimensiones de las matrices
        System.out.print("Ingrese el número de filas (entre 2 y 5): ");
        filas = entrada.nextInt();

        System.out.print("Ingrese el número de columnas (entre 2 y 5): ");
        columnas = entrada.nextInt();

        // Ingresar la primera matriz
        System.out.println("Ingrese la primera matriz:");
        matriz1 = ingresarMatriz(filas, columnas);

        // Ingresar la segunda matriz
        System.out.println("Ingrese la segunda matriz:");
        matriz2 = ingresarMatriz(filas, columnas);

        // Sumar las matrices
        resultado = sumarMatrices(matriz1, matriz2);
        // calcular inversa de la matriz 1
        inversa1 = calcularInversaMatriz(filas, columnas, matriz1);

        // calcular inversa de la matriz 2
        inversa2 = calcularInversaMatriz(filas, columnas, matriz2);

        // Imprimir las matrices y el resultado
        System.out.println("\nMatriz 1:");
        imprimirMatriz(matriz1);

        System.out.println("\nMatriz 2:");
        imprimirMatriz(matriz2);

        System.out.println("\nResultado de la suma:");
        imprimirMatriz(resultado);

        if (inversa1 != null) {
            System.out.println("\nInversa de la matriz 1:");
            imprimirMatriz(inversa1);
        }

        if (inversa2 != null) {
            System.out.println("\nInversa de la matriz 2:");
            imprimirMatriz(inversa2);
        }

    }

    public static double[][] ingresarMatriz(int filas, int columnas) {
        double[][] matriz = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el valor en la posición (" + (i + 1) + ", " + (j + 1) + "): ");
                matriz[i][j] = entrada.nextInt();
            }
        }
        return matriz;
    }

    public static void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static double[][] sumarMatrices(double[][] matriz1, double[][] matriz2) {
        double[][] resultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return resultado;
    }

    public static double[][] calcularInversaMatriz(int filas, int columnas, double[][] matriz) {
        // Verificar si la matriz es cuadrada
        if (filas != columnas) {
            System.out.println("La matriz no es cuadrada. No se puede calcular la inversa.");
            return null;
        }

        // Crear una matriz extendida [matriz | matrizIdentidad]
        double[][] matrizExtendida = new double[filas][2 * columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizExtendida[i][j] = matriz[i][j];
                matrizExtendida[i][j + columnas] = (i == j) ? 1 : 0; // Matriz identidad
            }
        }

        // Aplicar eliminación de Gauss-Jordan
        for (int k = 0; k < filas; k++) {
            double pivot = matrizExtendida[k][k];

            // Dividir la fila por el pivote
            for (int j = 0; j < 2 * columnas; j++) {
                matrizExtendida[k][j] /= pivot;
            }

            // Eliminación hacia adelante y hacia atrás
            for (int i = 0; i < filas; i++) {
                if (i != k) {
                    double factor = matrizExtendida[i][k];
                    for (int j = 0; j < 2 * columnas; j++) {
                        matrizExtendida[i][j] -= factor * matrizExtendida[k][j];
                    }
                }
            }
        }

        // Extraer la matriz inversa de la parte derecha de la matriz extendida
        double[][] inversa = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                inversa[i][j] = matrizExtendida[i][j + columnas];
            }
        }

        return inversa;
    }

}
