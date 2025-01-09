#include <stdio.h>
int main(){
	int base10 = 0;
  	scanf("%d",&base10);
  	while(base10>0){
      if (base10 % 2 == 0) {
            binary += "0";
        } else {
            binary += "1";
        }
        base10 /= 2;
      
    }
  	
    int num1;
    int num2;
    int num3;
    scanf("%d", &num1);
    scanf("%d", &num2);
    scanf("%d", &num3);
    int sum=num1+num2+num3;
    printf("%d\n", sum);
}