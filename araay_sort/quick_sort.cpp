#include <stdio.h>
void swap_array(int data[],int swap1,int swap2){
    int temp = data[swap1];
    data[swap1] = data[swap2];
    data[swap2] = temp;
}
int* quick_sort(int data[],int start,int end){
    int f = start; 
    int r = end; 
    if(end > start){
        int pivot = data[start];
        while(r > f){
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
        // =========== Recursive function ============
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