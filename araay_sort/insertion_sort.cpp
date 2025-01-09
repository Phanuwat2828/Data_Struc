#include <stdio.h>

void printArray(int array[], int size) {  
    for (int i = 0; i < size; ++i) {  
        printf("%d ", array[i]);  
    }  
    printf("\n"); 
}


void insertionSort(int arr[], int n) {  
     for (int i = 1; i < n; i++) {  
         int key = arr[i];
         int j = i - 1;
         int round
         while (j >= 0 && arr[j] > key) {  
            printf("[round %d][%d]>%d\n",key,arr[i]);
             arr[j + 1] = arr[j];  
             j--;  
        }
        arr[j + 1] = key;  
    }
}


int main(){
    int number[] = {64, 34, 25, 12, 22, 90, 11};
    insertionSort(number,7);
    printArray(number,7);
}