#include <stdio.h>

void printArray(int array[], int size) {  
    for (int i = 0; i < size; ++i) {  
        printf("%d ", array[i]);  
    }  
    printf("\n"); 
}


void insertionSort(int arr[], int n) { 
    // {64, 34, 25, 12, 22, 90, 11};
    for (int i = 1; i < n; i++) {  
         int key = arr[i]; //ตัวเปรียบเทียบ 
         int j = i - 1; //index
         int round = 0 ;
        while (j >= 0 && arr[j] > key) {  
            round+=1;
            printf("[round %d] [%d]index[%d]>%d\n",round,arr[j],j,key);

            arr[j + 1] = arr[j];  

            printArray(arr,7);

            j--;  
         }  
        arr[j + 1] = key;  
        printArray(arr,7);
        printf("\n");
     } 
}


int main(){
    int number[] = {64, 34, 25, 12, 22, 90, 11};
    insertionSort(number,7);
    printArray(number,7);
}