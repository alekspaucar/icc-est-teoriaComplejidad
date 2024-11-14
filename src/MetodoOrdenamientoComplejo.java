
public class MetodoOrdenamientoComplejo {
    public static void burbujaConAjuste(int[] arr ){
        int n = arr.length;
        //metodo burbuja con ajuste
        for (int i = 0 ; i < n - 1; i ++){
            for (int j = 0 ; j< n - i - 1 ; i++){
                if (arr[j] > arr[ j + 1 ]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[ j + 1] = temp;

                }
            }
        }

    }
    //metodo de seleccion
    public static void seleccion (int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1 ;i++){
            int minIndex = i;
            for (int j = i+1 ; j < n; j++) {
              if(arr[j]<arr[minIndex]){
                minIndex=j;
              }  
            }
        }
        
    }
    //metodo de insercion
    public static void insercion(int[] arr) {
        int n=arr.length;
        for (int i = 1 ; i < n ; i++){
            int llave=arr[i];
            int j = i - 1;
            while ( j >= 0 && arr[j] > llave ){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=llave;
        }
    }

}
