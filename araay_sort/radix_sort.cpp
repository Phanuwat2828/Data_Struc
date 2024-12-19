#include <stdio.h>
void radix_sort(int data[],int N){
    int data_all[10][9] ;
    for(int i=0;i<10;i++){
        
        for(int j=0;j<N;j++){
            if(data[j]%10 == i){
                int length = sizeof(data_all[i]) / sizeof(data_all[i][0]);
                data_all[i][length] = data[j];
                // printf("%d\n",data[j]);
            }
        }
    }
    
    for(int i=0;i<10;i++){
        
        for(int j=0;j<N;j++){
            if((int)data[j]/10 == i){
                int length = sizeof(data_all[i]) / sizeof(data_all[i][0]);
                data_all[i][length] = data[j];
                printf("%d\n",data[j]);
            }
        }
    }
}
int main(){
    int number[] = {34, 10, 39, 49, 24, 42, 9,0,99};
    radix_sort(number,9);
}