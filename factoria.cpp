#include <stdio.h>
int Factorial(int n){
    if(n==0){
        return 1;
    }else{
        return n*Factorial(n-1);
    }
}
int main(){
    int sum = 1;
    int num1 = -1;
    while (num1 < 0)
    {
       scanf("%d",&num1);
    }
    printf("%d",Factorial(num1));
}