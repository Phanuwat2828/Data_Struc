#include <stdio.h>

int size = 5;
int top = -1;
int arrayS[5];

void push(int x);
int pop();
void show();


int main(){
    int number = 55;
    int base5 = 5;
    while (number>0)
    {
        push(number%base5);
        number = number/base5;       
    }]
    show();
    printf("\n\n");
    while (top>=0)
    {
      printf("%d\n",pop());
    }
    printf("\ntop \t%d\n",top);
}

void push(int x){
    if(top == size-1){
        printf("Stack is full\n");
    }else{
        top=top+1;
        arrayS[top] = x;
    }
}

int pop(){
    int x=0;
    if(top == -1){
        printf("Stack is empty\n");
        return 0;
    }else{
        x = arrayS[top];
        top = top-1;
        return x;
    }
}

void show(){
    for(int i=top;i>=0;i--){
        printf("%d\t",arrayS[i]);
    }
}