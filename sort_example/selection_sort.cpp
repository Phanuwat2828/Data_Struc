#include <stdio.h>

void printArray(int array[], int size) {  
    for (int i = 0; i < size; ++i) {  
        printf("%d ", array[i]);  
    }  
    printf("\n"); 
}



void selectionSort(int arr[], int n) {  
    // {64, 34, 25, 12, 22, 90, 11};
    for (int i = 0; i < n - 1; i++) {  
        int minIndex = i;  
        for (int j = i + 1; j < n; j++) {
            printf("index[%d] [%d] < index[%d] [%d]",j,arr[j],minIndex,arr[minIndex]);
            if (arr[j] < arr[minIndex]) {  
                minIndex = j;  
                printf("true\n");
            }else{
                printf("false\n");
            }
        }
        int temp = arr[minIndex];  
        arr[minIndex] = arr[i];  
        arr[i] = temp;  
        printArray(arr,7);
        printf("\n");
    }  
}




int main(){
    int number[] = {64, 34, 25, 12, 22, 90, 11};
    selectionSort(number,7);
    printArray(number,7);
}


