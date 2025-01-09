#include <stdio.h>
int main(){
	int base10 = 0;
  	string binary = "";
  	scanf("%d",&base10);
  	while(base10>0){
      if (base10 % 2 == 0) {
            binary += "0";
        } else {
            binary += "1";
        }
        base10 /= 2;
      
    }
  	
}