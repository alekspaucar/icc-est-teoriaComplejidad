import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static int[] tamanos = {10, 100, 1000, 5000, 10000, 30000};
    private static int[][] arreglosAleatorios = new int[tamanos.length][];
    private static Random rand = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Generar Arreglos aleatorios con diferente tamaño");
            System.out.println("2. Ordenar por los 3 métodos");
            System.out.println("3. Buscar valores con búsqueda binaria normal y recursiva");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    generarArreglosAleatorios();
                    System.out.println("Arreglos generados.");
                    break;
                case 2:
                    ordenarArreglos();
                    break;
                case 3:
                    buscarValores();
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void generarArreglosAleatorios() {
        int[] baseArray = rand.ints(30000, 1, 30001).toArray();
        
        for (int i = 0; i < tamanos.length; i++) {
            arreglosAleatorios[i] = Arrays.copyOf(baseArray, tamanos[i]);
        }
    }
    private static void ordenarArreglos() {
        for (int i = 0; i < tamanos.length; i++) {
            int[] arr = arreglosAleatorios[i];

            System.out.println("\nTamaño del arreglo: " + tamanos[i]);

            // Burbuja con ajuste
            int[] copiaBurbuja = arr.clone();
            long inicio = System.nanoTime();
            MetodoOrdenamientoComplejo.burbujaConAjuste(copiaBurbuja);
            long fin = System.nanoTime();
            System.out.println("Burbuja con ajuste: " + (fin - inicio) / 1e6 + " ms");

            // Selección
            int[] copiaSeleccion = arr.clone();
            inicio = System.nanoTime();
            MetodoOrdenamientoComplejo.seleccion(copiaSeleccion);
            fin = System.nanoTime();
            System.out.println("Selección: " + (fin - inicio) / 1e6 + " ms");

            // Inserción
            int[] copiaInsercion = arr.clone();
            inicio = System.nanoTime();
            MetodoOrdenamientoComplejo.insercion(copiaInsercion);
            fin = System.nanoTime();
            System.out.println("Inserción: " + (fin - inicio) / 1e6 + " ms");
        }
    }
    private static void buscarValores() {
        int[] indicesBusqueda = {9, 98, 957, 4000, 9876, 29475};
        
        for (int i = 0; i < tamanos.length; i++) {
            int[] arr = arreglosAleatorios[i].clone();
            Arrays.sort(arr); // Aseguramos por la búsqueda binaria

            int valor = arr[indicesBusqueda[i]];
            System.out.println("\nBúsqueda en arreglo de tamaño " + tamanos[i] + " (valor: " + valor + ")");

            // Búsqueda binaria normal
            long inicio = System.nanoTime();
            int resultadoNormal = busquedaBinaria(arr, valor);
            long fin = System.nanoTime();
            System.out.println("Búsqueda binaria normal: " + (fin - inicio) / 1e6 + " ms (resultado: " + resultadoNormal + ")");

            // Búsqueda binaria recursiva
            inicio = System.nanoTime();
            int resultadoRecursiva = busquedaBinariaRecursiva(arr, valor, 0, arr.length - 1);
            fin = System.nanoTime();
            System.out.println("Búsqueda binaria recursiva: " + (fin - inicio) / 1e6 + " ms (resultado: " + resultadoRecursiva + ")");
        }
    }

    // Implementación de búsqueda binaria normal
    private static int busquedaBinaria(int[] arr, int valor) {
        int inicio = 0, fin = arr.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (arr[medio] == valor) return medio;
            else if (arr[medio] < valor) inicio = medio + 1;
            else fin = medio - 1;
        }
        return -1;
    }

    // Implementación de búsqueda binaria recursiva
    private static int busquedaBinariaRecursiva(int[] arr, int valor, int inicio, int fin) {
        if (inicio > fin) return -1;
        int medio = (inicio + fin) / 2;
        if (arr[medio] == valor) return medio;
        else if (arr[medio] < valor) return busquedaBinariaRecursiva(arr, valor, medio + 1, fin);
        else return busquedaBinariaRecursiva(arr, valor, inicio, medio - 1);
    }

}