import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static int filas, columnas, filasMatriz1, filasMatriz2, columnasMatriz1, columnasMatriz2;
    static double[][] matriz, matriz1, matriz2, resultado, inversa1;
    static byte op;
    public static void main(String[] args) {

        System.out.print("¿Desea ingresar una o dos matrices? (1 o 2): ");
        int opcion = entrada.nextInt();
        
        if (opcion == 1) {
             // Ingresar dimensiones de las matrices
            System.out.print("Ingrese el número de filas (entre 2 y 5): ");
            int filas = entrada.nextInt();

            System.out.print("Ingrese el número de columnas (entre 2 y 5): ");
            int columnas = entrada.nextInt();

            // Ingresar la matriz
            System.out.println("Ingrese la matriz:");
            matriz = ingresarMatriz(filas, columnas);

            System.out.println("\nMatriz ingresada:");
            imprimirMatriz(matriz);
            menu1();
            op = entrada.nextByte();

            switch (op) {
            case 1:
            inversa1 = calcularInversaMatriz(filas, columnas, matriz);       
            
            System.out.println("\nInversa de la matriz: ");
            imprimirMatriz(inversa1);
            
            break;
            
            case 2:
                    
            break;
            case 3:
                    
            break;
            case 4:

            break;

            default:
              
            break;
            }
        }   else if (opcion == 2) {
        // Ingresar dimensiones de la primera matriz
        System.out.print("Ingrese el número de filas para la primera matriz (entre 2 y 5): ");
        filasMatriz1 = entrada.nextInt();

        System.out.print("Ingrese el número de columnas para la primera matriz (entre 2 y 5): ");
      columnasMatriz1 = entrada.nextInt();

        // Ingresar la primera matriz
        System.out.println("Ingrese la primera matriz:");
     matriz1 = ingresarMatriz(filasMatriz1, columnasMatriz1);

        // Ingresar dimensiones de la segunda matriz
        System.out.print("Ingrese el número de filas para la segunda matriz (entre 2 y 5): ");
        int filasMatriz2 = entrada.nextInt();

        System.out.print("Ingrese el número de columnas para la segunda matriz (entre 2 y 5): ");
        int columnasMatriz2 = entrada.nextInt();

        // Ingresar la segunda matriz
        System.out.println("Ingrese la segunda matriz:");
         matriz2 = ingresarMatriz(filasMatriz2, columnasMatriz2);

        
        System.out.println("\nMatriz 1:");
            imprimirMatriz(matriz1);

            System.out.println("\nMatriz 2:");
            imprimirMatriz(matriz2);
        menu2();
        op = entrada.nextByte();
        switch (op) {
            case 1:
            // Sumar las matrices
            double[][] resultado = sumarMatrices(matriz1, matriz2);

            // Imprimir las matrices y el resultado
           

            System.out.println("\nResultado de la suma:");
            imprimirMatriz(resultado);
            
            
         break;
        
        }    
    } } 

      
 
  
    //Metodo para el ingreso de las matrices
    public static double[][] ingresarMatriz(int filas, int columnas) {
        double[][] matriz = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el valor en la posición (" + (i + 1) + ", " + (j + 1) + "): ");
                matriz[i][j] = entrada.nextDouble();
            }
        }
        return matriz;
    }
    //Método para imprimir las matrices
    public static void imprimirMatriz(double[][] matriz ) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }
    //Método para sumar las matrices
    public static double[][] sumarMatrices(double[][] matriz11, double[][] matriz22) {
        double[][] resultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return resultado;
    }
    //Método para calcular la inversa de una matriz
    public static double[][] calcularInversaMatriz(int filas, int columnas, double[][] matriz3) {
        // Verificar si la matriz es cuadrada
        if (filas != columnas) {
            System.out.println("La matriz no es cuadrada. No se puede calcular la inversa.");
            return null;
        }

        // Crear una matriz extendida [matriz | matrizIdentidad]
        double[][] matrizExtendida = new double[filas][2 * columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizExtendida[i][j] = matriz3[i][j];
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
                inversa[i][j] = (int) matrizExtendida[i][j + columnas];
            }
        }

        return inversa;
    }
    public static void menu1(){
    System.out.println("1. Inversa.");
    System.out.println("2. Producto escalar.");
    System.out.println("3. Gauss Jordan.");
}
   public static void menu2(){
    System.out.println("1. Suma.");
    System.out.println("2. Resta.");
    System.out.println("3. Producto matricial.");
}

}
  