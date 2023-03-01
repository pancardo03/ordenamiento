import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Ingrese la longitud del arreglo: ");
        int n = input.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Ingrese los " + n + " elementos del arreglo: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        System.out.println("\nElija el algoritmo de ordenamiento:\n1. Quicksort\n2. Bubble Sort");
        int choice = input.nextInt();
        
        if (choice == 1) {
            quicksort(arr, 0, n-1);
            System.out.println("\nArreglo ordenado por Quicksort: ");
            printArray(arr);
        }
        else if (choice == 2) {
            bubbleSort(arr);
            System.out.println("\nArreglo ordenado por Bubble Sort: ");
            printArray(arr);
        }
        else {
            System.out.println("Opción inválida. Intente de nuevo.");
        }
        
        input.close();
    }
    
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot-1);
            quicksort(arr, pivot+1, high);
        }
    }
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
