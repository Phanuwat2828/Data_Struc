#include <stdio.h>
int* shell_sort(int data[],int N){
    int K = N/2;
    while(K>=1){
        int i=K;
        while (i<=N-1){
           int temp = data[i];
           int j=i;
           while(j>K-1 && data[j-K] > temp){
                data[j] = data[j-K];
                j = j-K ;
                data[j] = temp;
           }
           i++;
        }
        K=K/2;
    }
    return data;
}
int main(){
    int number[] = {34, 10, 39, 49, 24, 42, 9,0,99,1};
    int* data = shell_sort(number,10);
    for(int i=0;i<10;i++){
        printf("%d\n",data[i]);
    }
}