#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    int Data;
    struct Node *Link;
}node;
node *head = NULL;
node *last = NULL;
node *temp = NULL;
void AddOrder(int num);
void print();

int main(){
    int num[3];
    for(int i = 0; i < 3; i++) {
        scanf("%d", &num[i]);
    }

    for(int i=0;i<3;i++){
        AddOrder(num[i]);
        print();
    }
    return 0;
}
void AddOrder(int num){
    node *p = malloc(sizeof(node));
    p -> Data = num;
    p -> Link = NULL;
    if (head == NULL || p -> Data <= head -> Data){
        p -> Link = head;
        head = p;
        return;
    }
    temp = head;
    while(temp -> Link != NULL && temp -> Link -> Data <= p -> Data){
        temp = temp -> Link;
    }
    if(temp -> Link != NULL){
        p -> Link = temp -> Link;
    }
    temp -> Link = p;
    
}
void print(){
    node *p = head;
    while(p != NULL){
        if(p->Link==NULL){
            printf("%d",p -> Data);
        }else{
            printf("%d ",p -> Data);
        }
        p = p -> Link;
       
    }
    printf("\n");
}
