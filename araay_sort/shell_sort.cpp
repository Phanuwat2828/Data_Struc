#include <stdio.h>
int* shell_sort(int data[],int N){
    int k = N/2;
    while(k>=1){
        int i=k;
        while (i<=N-1){
           int temp = data[i];
           int j=i;
           while(j>k-1 && data[j-k] > temp){
                data[j] = data[j-k];
                j = j-k ;
                data[j] = temp;
           }
           i++;
        }
        k=k/2;
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