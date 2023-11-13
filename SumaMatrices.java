
    import java.util.Scanner;

public class SumaMatrices {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Ingresar dimensiones de la primera matriz
        System.out.print("Ingrese el número de filas para la primera matriz (entre 2 y 5): ");
        int filasMatriz1 = entrada.nextInt();

        System.out.print("Ingrese el número de columnas para la primera matriz (entre 2 y 5): ");
        int columnasMatriz1 = entrada.nextInt();

        // Ingresar la primera matriz
        System.out.println("Ingrese la primera matriz:");
        int[][] matriz1 = ingresarMatriz(filasMatriz1, columnasMatriz1);

        // Ingresar dimensiones de la segunda matriz
        System.out.print("Ingrese el número de filas para la segunda matriz (entre 2 y 5): ");
        int filasMatriz2 = entrada.nextInt();

        System.out.print("Ingrese el número de columnas para la segunda matriz (entre 2 y 5): ");
        int columnasMatriz2 = entrada.nextInt();

        // Ingresar la segunda matriz
        System.out.println("Ingrese la segunda matriz:");
        int[][] matriz2 = ingresarMatriz(filasMatriz2, columnasMatriz2);

        // Verificar si las matrices son compatibles para la suma
        if (filasMatriz1 != filasMatriz2 || columnasMatriz1 != columnasMatriz2) {
            System.out.println("Las matrices no son compatibles para la suma.");
        } else {
            // Sumar las matrices
            int[][] resultado = sumarMatrices(matriz1, matriz2);

            // Imprimir las matrices y el resultado
            System.out.println("\nMatriz 1:");
            imprimirMatriz(matriz1);

            System.out.println("\nMatriz 2:");
            imprimirMatriz(matriz2);

            System.out.println("\nResultado de la suma:");
            imprimirMatriz(resultado);
        }
    }
    public static int[][] ingresarMatriz(int filas, int columnas) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el valor en la posición (" + (i + 1) + ", " + (j + 1) + "): ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        return matriz;
    }

    public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return resultado;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}

