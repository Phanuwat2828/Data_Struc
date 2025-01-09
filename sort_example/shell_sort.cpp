#include <stdio.h>



void printArray(int array[], int size) {  
    for (int i = 0; i < size; ++i) {  
        printf("%d ", array[i]);  
    }  
    printf("\n"); 
}



int* shell_sort(int data[],int N){
    int K = N/2;
    // {34, 10, 39, 49, 24, 42, 9, 0, 99, 1};
    while(K>=1){
        int i=K;
        printf("================= %d =================\n",K);
        while (i<=N-1){
           int temp = data[i]; 
           int j=i; 
           printf("\n****************************** %d => %d **********************************\n",i,j-K);
           printf("J[%d] > K-1[%d] and data[%d] > temp[%d]\n",j,K-1,data[j-K],temp);
           while(j>K-1 && data[j-K] > temp){
                printf("true\n");
                printf("data[%d] = datajk[%d]\n",data[j],data[j-K]); 
                data[j] = data[j-K];
                j = j-K ;
                printf("j[%d]\n",j);
                printf("data[%d] = temp[%d]\n",data[j],temp); 
                data[j] = temp;
           }
           printf("\n");
            printf("\n****************************************************************\n");
           i++;
        }
        K=K/2;
    }
    return data;
}



int main(){
    int number[] = {34, 10, 39, 49, 24, 42, 9,0,99,1};
    int* data = shell_sort(number,10);
    printArray(number,10);
}