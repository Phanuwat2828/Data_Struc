#include <stdio.h>
int Factorial(int n){
    if(n==0){
        return 1;
    }else{
        return n*Factorial(n-1);
    }
}
int main(){
    int num = 5;
    int sum = 1;
    printf("%d",Factorial(5));
}