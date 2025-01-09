#include <stdio.h>


void printArray(int array[], int size) {  
    for (int i = 0; i < size; ++i) {  
        printf("%d ", array[i]);  
    }
    printf("\n"); 
}

void bubble_sort(int data[],int size){
    for (int step = 0; step < size - 1; ++step) {  
        int swapped = 0;  
        for (int i = 0; i < size - step - 1; ++i) {  
            if (data[i] > data[i + 1]) {  
                int temp = data[i];  
                data[i] = data[i + 1];  
                data[i + 1] = temp;  
                swapped = 1;  
            }  
         }  
  
        if (swapped == 0) {  
             break;  
        }  
     } 
     printArray(data,size);
}

int main(){
    int number[] = {64, 34, 25, 12, 22, 11, 90};
    bubble_sort(number,7);
    printf("Hello World");
}