#include <stdio.h>
void swap_array(int data[],int swap1,int swap2){
    int temp = data[swap1];
    data[swap1] = data[swap2];
    data[swap2] = temp;
}
void data_show(int data[],int start,int end){
    for(int i=start;i<=end;i++){
        printf("%d,",data[i]);
   
    }
    printf("\n");
}
int* quick_sort(int data[],int start,int end){
    int f = start; 
    int r = end; 
    printf("\n========================================================\n");
    printf("Start : %d\nEnd : %d\nF : %d\nR : %d\n",start,end,f,r);
    if(end > start){
        int pivot = data[start];
        printf("Pivot : %d",pivot);
        printf("\n========================================================\n");
        
        while(r > f){
            printf("\n====================== loop F ==================================\n\n");
            while(data[f] <= pivot && f<= end && r>f){
                printf("%d<=%d and %d <= %d and %d > %d \n",data[f],pivot,f,end,r,f);
                f++;
            }
            printf("%d<=%d and %d <= %d and %d > %d False\n",data[f],pivot,f,end,r,f);
            printf("\n======================== loop R ================================\n\n");
            while(data[r] > pivot && r >= start && r>=f){
                printf("%d > %d and %d >= %d and %d >= %d \n",data[r],pivot,r,start,r,f);
                r--;
            }
            printf("%d > %d and %d >= %d and %d >= %d False\n",data[r],pivot,r,start,r,f);
            printf("\n======================== END R&F ================================\n\n");

            printf("F : [ %d ] and R : [ %d ]\n",f,r);
            data_show(data,start,end);
            if(r>f){
                swap_array(data,f,r);
                printf("swap = ");
                data_show(data,start,end);
            }
        }
        printf("End Real\n");
        swap_array(data,start,r);
        printf("swap = ");
        data_show(data,start,end);
        // ================= Recursive
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