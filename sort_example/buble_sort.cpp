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
                printf("befor swap ");
                printArray(data,size); 
                int temp = data[i]; 
                printf("swap_now [%d] => [%d]\n",data[i],data[i+1]); 
                data[i] = data[i + 1];  
                data[i + 1] = temp;  
                swapped = 1;
                printf("after swap ");
                printArray(data,size); 
            }
        }
        printf("\n");
        if (swapped == 0) {  
            break;  
        }  
    } 
    printArray(data,size);
}

int main(){
    int number1[] = {64, 34, 25, 12, 22, 11, 90};
     int number2[] = {1, 2, 4, 3, 5, 6, 7};
    bubble_sort(number1,7);
    printf("Hello World");

}