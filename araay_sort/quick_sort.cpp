#include <stdio.h>


void swap_array(int data[],int swap1,int swap2){
    int temp = data[swap1];
    data[swap1] = data[swap2];
    data[swap2] = temp;
}

// 34, 10, 39, 49, 24, 42, 9,0,99
int* quick_sort(int data[],int start,int end){

    // f = 0
    // r = 9-1 =8
    int f = start; 
    int r = end; 
    // 8 > 0
    if(end > start){
        // pivot = 34
        int pivot = data[start];
        // 8 > 0 
        while(r > f){
            // 34 <= 34 && 0 <= 8 && 8 > 0
            while(data[f] <= pivot && f<= end && r>f){
                f++;
            }
            while(data[r] > pivot && r >= start && r>=f){
                r--;
            }
            if(r>f){
                swap_array(data,f,r);
            }
        }
        swap_array(data,start,r);
        quick_sort(data,start,r-1);
        quick_sort(data,r+1,end);
        
    }
    return data;
    
}

int main(){
    int number[] = {34, 10, 39, 49, 24, 42, 9,0,99};
    int* data = quick_sort(number,0,9-1);
    for(int i=0;i<9;i++){
        printf("%d\n",data[i]);
    }
}